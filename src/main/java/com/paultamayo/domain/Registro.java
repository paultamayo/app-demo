package com.paultamayo.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "registro")
public class Registro extends RegistroBase {

	private static final long serialVersionUID = 7543003601373785629L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "BANCO_ID")
	private Long bancoId;

	@Column(name = "CLIENTE_ID")
	private Long clienteId;

	@Column(name = "CUENTA_ID")
	private Long cuentaId;

	@Column(name = "SEGURO_CREDITO_ID")
	private Long seguroCreditoId;

	@Column(name = "MONEDA_ID")
	private Long monedaId;
	
	@Column(name = "FECHA_COBRO")
	private LocalDate fechaCobro;

	@Column(name = "FECHA_VENCE")
	private LocalDate fechaVence;
	
	private BigDecimal monto;

}