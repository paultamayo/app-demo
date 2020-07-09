package com.paultamayo.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class RegistroBase implements Serializable {

	private static final long serialVersionUID = 3464546974448920363L;

	@Column(name = "NUMERO_CHEQUE")
	private String numeroCheque;

	@Column(name = "EMRESA_ID")
	private Long empresaId;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id", name = "EMRESA_ID", updatable = false, insertable = false)
	private Empresa empresa;

	private String ejercicio;

	private String usuario;

	private LocalDateTime fechaCreacion;

	public abstract Long getId();

	public abstract void setId(Long id);
}
