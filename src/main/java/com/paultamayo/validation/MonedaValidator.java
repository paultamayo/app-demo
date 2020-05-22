package com.paultamayo.validation;

import java.util.List;

import javax.naming.InitialContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.paultamayo.domain.Moneda_;
import com.paultamayo.service.impl.MonedaService;

public class MonedaValidator implements ConstraintValidator<MonedaConstraint, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		try {
			InitialContext c = new InitialContext();
			MonedaService service = (MonedaService) c.lookup("java:app/app-demo/MonedaService");

			service.findAllByIds(Moneda_.nombre, List.of(value));
		} catch (Exception ex) {
			return false;
		}

		return true;
	}
}
