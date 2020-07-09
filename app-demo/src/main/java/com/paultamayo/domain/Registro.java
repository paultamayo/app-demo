package com.paultamayo.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@ManyToOne
	@JoinColumn(referencedColumnName = "id", name = "BANCO_ID", updatable = false, insertable = false)
	private Banco banco;

	@Column(name = "CLIENTE_ID")
	private Long clienteId;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id", name = "CLIENTE_ID", updatable = false, insertable = false)
	private Cliente cliente;

	@Column(name = "CUENTA_ID")
	private Long cuentaId;

	@Column(name = "SEGURO_CREDITO_ID")
	private Long seguroCreditoId;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id", name = "SEGURO_CREDITO_ID", updatable = false, insertable = false)
	private SeguroCredito seguroCredito;

	@Column(name = "MONEDA_ID")
	private Long monedaId;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id", name = "MONEDA_ID", updatable = false, insertable = false)
	private Moneda moneda;

	@Column(name = "FECHA_COBRO")
	private LocalDate fechaCobro;

	@Column(name = "FECHA_VENCE")
	private LocalDate fechaVence;

	private BigDecimal monto;

}
