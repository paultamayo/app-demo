package com.paultamayo.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.paultamayo.domain.Banco;
import com.paultamayo.domain.Banco_;
import com.paultamayo.domain.Cliente;
import com.paultamayo.domain.Cliente_;
import com.paultamayo.domain.Cuenta;
import com.paultamayo.domain.Cuenta_;
import com.paultamayo.domain.DetalleRegistroError;
import com.paultamayo.domain.Moneda;
import com.paultamayo.domain.Moneda_;
import com.paultamayo.domain.Registro;
import com.paultamayo.domain.RegistroError;
import com.paultamayo.domain.SeguroCredito;
import com.paultamayo.domain.SeguroCredito_;
import com.paultamayo.exception.DataBaseException;
import com.paultamayo.to.CuentaTo;

@Stateless
public class CargarArchivoService {

	@Inject
	private BancoService bancoService;

	@Inject
	private ClienteService clienteService;

	@Inject
	private CuentaService cuentaService;

	@Inject
	private MonedaService monedaService;

	@Inject
	private SeguroCreditoService seguroCreditoService;

	@Inject
	private RegistroErrorService errorService;

	@Inject
	private RegistroService registroService;

	public void guardar(List<CuentaTo> cuentasTo, String ejercicio, Long empresaId) throws DataBaseException {

		for (CuentaTo cuentaTo : cuentasTo) {
			List<Banco> bancos = bancoService.findAllByIds(Banco_.nombre, List.of(cuentaTo.getBanco()));
			List<Cliente> clientes = clienteService.findAllByIds(Cliente_.identificador,
					List.of(cuentaTo.getCliente()));
			List<Moneda> monedas = monedaService.findAllByIds(Moneda_.nombre, List.of(cuentaTo.getMoneda()));
			List<SeguroCredito> seguros = seguroCreditoService.findAllByIds(SeguroCredito_.nombre,
					List.of(cuentaTo.getSeguroCredito()));
			List<Cuenta> cuentas = cuentaService.findAllByIds(Cuenta_.nombre, List.of(cuentaTo.getCuenta()));

			if (!cuentaTo.hasError()) {
				RegistroError registro = new RegistroError();
				registro.setBanco(cuentaTo.getBanco());
				registro.setCliente(cuentaTo.getCliente());
				registro.setCuenta(cuentaTo.getCuenta());
				registro.setFechaCobro(cuentaTo.getFechaCobroString());
				registro.setFechaVence(cuentaTo.getFechaVenceString());
				registro.setMoneda(cuentaTo.getMoneda());
				registro.setMonto(cuentaTo.getMontoString());
				registro.setNumeroCheque(cuentaTo.getNumeroCheque());
				registro.setSeguroCredito(cuentaTo.getSeguroCredito());
				registro.setEjercicio(ejercicio);
				registro.setEmpresaId(empresaId);
				registro.setFechaCreacion(LocalDateTime.now());
				registro.setDetalles(new ArrayList<>());

				for (String error : cuentaTo.getErrores()) {
					DetalleRegistroError detalle = new DetalleRegistroError();
					detalle.setRegistroError(registro);
					detalle.setDetalle(error);

					registro.getDetalles().add(detalle);
				}

				errorService.save(registro);
			} else {
				Registro registro = new Registro();
				registro.setBancoId(bancos.get(0).getId());
				registro.setClienteId(clientes.get(0).getId());
				registro.setFechaCobro(cuentaTo.getFechaCobro());
				registro.setFechaVence(cuentaTo.getFechaVence());
				registro.setMonedaId(monedas.get(0).getId());
				registro.setCuentaId(cuentas.get(0).getId());
				registro.setMonto(cuentaTo.getMonto());
				registro.setNumeroCheque(cuentaTo.getNumeroCheque());
				registro.setSeguroCreditoId(seguros.get(0).getId());
				registro.setEjercicio(ejercicio);
				registro.setEmpresaId(empresaId);
				registro.setFechaCreacion(LocalDateTime.now());

				registroService.save(registro);
			}
		}
	}
}
