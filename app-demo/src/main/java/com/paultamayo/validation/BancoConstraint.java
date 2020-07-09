package com.paultamayo.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BancoValidator.class)
@Documented
public @interface BancoConstraint {

	String message() default "No se tiene registrado este banco en base de datos";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
