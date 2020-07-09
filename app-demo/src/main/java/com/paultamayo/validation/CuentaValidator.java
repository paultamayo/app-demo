package com.paultamayo.validation;

import java.util.List;

import javax.naming.InitialContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.paultamayo.domain.Cuenta_;
import com.paultamayo.service.impl.CuentaService;

public class CuentaValidator implements ConstraintValidator<CuentaConstraint, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		try {
			InitialContext c = new InitialContext();
			CuentaService service = (CuentaService) c.lookup("java:app/app-demo/CuentaService");

			service.findAllByIds(Cuenta_.nombre, List.of(value));
		} catch (Exception ex) {
			return false;
		}

		return true;
	}

	@Override
	public void initialize(CuentaConstraint constraintAnnotation) {
	}
}
