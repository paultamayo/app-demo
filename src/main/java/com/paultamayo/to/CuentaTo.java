package com.paultamayo.to;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.math.NumberUtils;
import org.hibernate.validator.constraints.Length;

import com.paultamayo.validation.RucValidation;

import lombok.Data;

@Data
public class CuentaTo {

	private int registro;

	@Length(min = 13, max = 13, message = "No cumple con el formato de 13 digitos.")
	@NotNull(message = "No puede dejar el campo cliente en blanco")
	@RucValidation
	private String cliente;

	@NotNull(message = "No puede dejar el campo seguro de crédito en blanco")
	@Size(min = 1, message = "No puede tener un campo vacio")
	private String seguroCredito;

	@NotNull(message = "No puede dejar el campo banco en blanco")
	@Size(min = 1, message = "No puede tener un campo vacio")
	private String banco;

	@NotNull(message = "No puede dejar el campo cuenta en blanco")
	@Size(min = 1, message = "No puede tener un campo vacio")
	private String cuenta;

	@NotNull(message = "No puede dejar el campo numero cheque en blanco")
	@Size(min = 1, message = "No puede tener un campo vacio")
	private String numeroCheque;

	@NotNull(message = "No puede dejar el campo monto vacio")
	@Pattern(message = "No cumple con el formato adecuado.", regexp = "\\d+(\\.\\d{1,2})")
	@Size(min = 1, message = "No puede tener un campo vacio")
	private String montoString;

	@NotNull(message = "No puede dejar el campo moneda vacio")
	@Size(min = 1, message = "No puede tener un campo vacio")
	private String moneda;

	@NotNull(message = "No puede dejar el campo fecha cobro vacio")
	@Pattern(regexp = "^\\d{1,2}/\\d{1,2}/\\d{4}$", message = "No cumple el formato de cobro Ejemplo: dd/MM/yyyy")
	private String fechaCobroString;

	@NotNull(message = "No puede dejar el campo fecha vence vacio")
	@Pattern(regexp = "^\\d{1,2}/\\d{1,2}/\\d{4}$", message = "No cumple el formato vence Ejemplo: dd/MM/yyyy")
	private String fechaVenceString;

	private List<String> errores;

	public LocalDate convertir(String formato) {
		String[] fecha = formato.split("/");

		int year = NumberUtils.createInteger(fecha[2]);
		int month = NumberUtils.createInteger(fecha[1]);
		int dayOfMonth = NumberUtils.createInteger(fecha[0]);

		return LocalDate.of(year, month, dayOfMonth);
	}

	public CuentaTo() {
		this.errores = new ArrayList<>();
	}

	public void addErrores(String error) {
		errores.add(error);
	}

	public boolean hasError() {
		return errores.isEmpty();
	}

	public LocalDate getFechaCobro() {
		return convertir(fechaCobroString);
	}

	public LocalDate getFechaVence() {
		return convertir(fechaVenceString);
	}

	public BigDecimal getMonto() {
		return new BigDecimal(montoString);
	}

}
