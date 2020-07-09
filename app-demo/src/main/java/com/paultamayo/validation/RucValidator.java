package com.paultamayo.validation;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.paultamayo.domain.Cliente_;
import com.paultamayo.exception.DataBaseException;
import com.paultamayo.service.impl.ClienteService;

public class RucValidator implements ConstraintValidator<RucConstraint, String> {

	@Override
	public boolean isValid(String numero, ConstraintValidatorContext context) {
		try {
			validarInicial(numero, 13);
			validarCodigoProvincia(numero.substring(0, 2));
			validarCodigoEstablecimiento(numero.substring(10, 13));
			validarBase(numero);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	private void validarBase(String numero) throws DataBaseException, NamingException {
		InitialContext context = new InitialContext();
		ClienteService service = (ClienteService) context.lookup("java:app/app-demo/ClienteService");

		service.findAllByIds(Cliente_.identificador, List.of(numero));
	}

	protected boolean validarInicial(String numero, int caracteres) throws Exception {
		if (StringUtils.isEmpty(numero)) {
			throw new Exception("Valor no puede estar vacio");
		}

		if (!NumberUtils.isDigits(numero)) {
			throw new Exception("Valor ingresado solo puede tener dígitos");
		}

		if (numero.length() != caracteres) {
			throw new Exception("Valor ingresado debe tener " + caracteres + " caracteres");
		}

		return true;
	}

	protected boolean validarTercerDigito(String numero, Integer tipo) throws Exception {
		switch (tipo) {
		case 1:
		case 2:

			if (Integer.parseInt(numero) < 0 || Integer.parseInt(numero) > 5) {
				throw new Exception(
						"Tercer dígito debe ser mayor o igual a 0 y menor a 6 para cédulas y RUC de persona natural ... permitidos de 0 a 5");
			}
			break;
		case 3:
			if (Integer.parseInt(numero) != 9) {
				throw new Exception("Tercer dígito debe ser igual a 9 para sociedades privadas");
			}
			break;

		case 4:
			if (Integer.parseInt(numero) != 6) {
				throw new Exception("Tercer dígito debe ser igual a 6 para sociedades públicas");
			}
			break;
		default:
			throw new Exception("Tipo de Identificacion no existe.");
		}

		return true;
	}

	protected boolean validarCodigoProvincia(String numero) throws Exception {
		if (Integer.parseInt(numero) < 0 || Integer.parseInt(numero) > 24) {
			throw new Exception("Codigo de Provincia (dos primeros dígitos) no deben ser mayor a 24 ni menores a 0");
		}

		return true;
	}

	protected boolean validarCodigoEstablecimiento(String numero) throws Exception {
		if (Integer.parseInt(numero) < 1) {
			throw new Exception("Código de establecimiento no puede ser 0");
		}
		return true;
	}

	@Override
	public void initialize(RucConstraint constraintAnnotation) {
	}

}
