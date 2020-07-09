package com.paultamayo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "registro_error")
@ToString(exclude = "detalles")
public class RegistroError extends RegistroBase {

	private static final long serialVersionUID = -1730527238795001054L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "BANCO")
	private String banco;

	@Column(name = "CLIENTE")
	private String cliente;

	@Column(name = "CUENTA")
	private String cuenta;

	@Column(name = "SEGURO_CREDITO")
	private String seguroCredito;

	@Column(name = "MONEDA")
	private String moneda;

	@Column(name = "FECHA_COBRO")
	private String fechaCobro;

	@Column(name = "FECHA_VENCE")
	private String fechaVence;

	private String monto;

	@OneToMany(mappedBy = "registroError", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<DetalleRegistroError> detalles;

}
