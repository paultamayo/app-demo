package com.paultamayo.to;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;

import com.paultamayo.validation.RucValidation;

import lombok.Data;

@Data
public class CuentaTo {

	private Long registro;

	@Length(min = 13, max = 13, message = "No cumple con el formato de 13 digitos.")
	@NotBlank(message = "No puede dejar el campo cliente en blanco")
	@RucValidation
	private String cliente;

	@NotBlank(message = "No puede dejar el campo seguro de crédito en blanco")
	private String seguroCredito;

	@NotBlank(message = "No puede dejar el campo banco en blanco")
	private String banco;

	@NotBlank(message = "No puede dejar el campo cuenta en blanco")
	private String cuenta;

	@NotBlank(message = "No puede dejar el campo numero cheque en blanco")
	private String numeroCheque;

	@NotNull(message = "No puede dejar el campo monto vacio")
	private BigDecimal monto;

	@Past(message = "No puede ser menor a la fecha actual")
	@NotNull(message = "No puede dejar el campo fecha cobro vacio")
	private LocalDate fechaCobro;

	@Past(message = "No puede ser menor a la fecha actual")
	@NotNull(message = "No puede dejar el campo fecha vence vacio")
	private LocalDate fechaVence;

	private List<String> errores;

	public CuentaTo() {
		this.errores = new ArrayList<>();
	}

	public void addErrores(String error) {
		errores.add(error);
	}

}
