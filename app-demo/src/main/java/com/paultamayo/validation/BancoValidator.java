package com.paultamayo.validation;

import java.util.List;

import javax.naming.InitialContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.paultamayo.domain.Banco_;
import com.paultamayo.service.impl.BancoService;

public class BancoValidator implements ConstraintValidator<BancoConstraint, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		try {
			InitialContext c = new InitialContext();
			BancoService service = (BancoService) c.lookup("java:app/app-demo/BancoService");

			service.findAllByIds(Banco_.nombre, List.of(value));
		} catch (Exception ex) {
			return false;
		}

		return true;
	}
}
