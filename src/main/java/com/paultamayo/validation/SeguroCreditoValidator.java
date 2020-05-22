package com.paultamayo.validation;

import java.util.List;

import javax.naming.InitialContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.paultamayo.domain.SeguroCredito_;
import com.paultamayo.service.impl.SeguroCreditoService;

public class SeguroCreditoValidator implements ConstraintValidator<SeguroCreditoConstraint, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		try {
			InitialContext c = new InitialContext();
			SeguroCreditoService service = (SeguroCreditoService) c.lookup("java:app/app-demo/SeguroCreditoService");

			service.findAllByIds(SeguroCredito_.nombre, List.of(value));
		} catch (Exception ex) {
			return false;
		}

		return true;
	}
}
