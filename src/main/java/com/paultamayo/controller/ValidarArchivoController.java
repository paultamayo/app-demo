package com.paultamayo.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.paultamayo.to.CuentaTo;

public class ValidarArchivoController {
	protected static final String MENSAJE = "Mensaje: ";

	public void validacionEstatica(CuentaTo cuenta) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<CuentaTo>> validaciones = validator.validate(cuenta);

		final StringBuilder builder = new StringBuilder();
		if (!validaciones.isEmpty()) {
			builder.append(cuenta + "\n" + MENSAJE);
			validaciones.forEach(v -> builder.append("Campo=").append(v.getPropertyPath().toString().toUpperCase())
					.append("->").append(v.getMessage()).append(". "));
			cuenta.addErrores(builder.toString());
		}

	}

}
