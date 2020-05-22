package com.paultamayo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class RucValidator implements ConstraintValidator<RucValidation, String> {

	@Override
	public void initialize(RucValidation constraintAnnotation) {

	}

	@Override
	public boolean isValid(String numero, ConstraintValidatorContext context) {
		try {
			validarInicial(numero, 13);
			validarCodigoProvincia(numero.substring(0, 2));
			//validarTercerDigito(String.valueOf(numero.charAt(2)), 3);
			validarCodigoEstablecimiento(numero.substring(10, 13));
			//algoritmoModulo11(numero.substring(0, 9), Integer.parseInt(String.valueOf(numero.charAt(9))), 3);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	protected boolean validarInicial(String numero, int caracteres) throws Exception {
		if (StringUtils.isEmpty(numero)) {
			throw new Exception("Valor no puede estar vacio");
		}

		if (!NumberUtils.isDigits(numero)) {
			throw new Exception("Valor ingresado solo puede tener dígitos");
		}

		if (numero.length() != caracteres) {
			throw new Exception("Valor ingresado debe tener " + caracteres + " caracteres");
		}

		return true;
	}

	protected boolean validarTercerDigito(String numero, Integer tipo) throws Exception {
		switch (tipo) {
		case 1:
		case 2:

			if (Integer.parseInt(numero) < 0 || Integer.parseInt(numero) > 5) {
				throw new Exception(
						"Tercer dígito debe ser mayor o igual a 0 y menor a 6 para cédulas y RUC de persona natural ... permitidos de 0 a 5");
			}
			break;
		case 3:
			if (Integer.parseInt(numero) != 9) {
				throw new Exception("Tercer dígito debe ser igual a 9 para sociedades privadas");
			}
			break;

		case 4:
			if (Integer.parseInt(numero) != 6) {
				throw new Exception("Tercer dígito debe ser igual a 6 para sociedades públicas");
			}
			break;
		default:
			throw new Exception("Tipo de Identificacion no existe.");
		}

		return true;
	}

	protected boolean validarCodigoProvincia(String numero) throws Exception {
		if (Integer.parseInt(numero) < 0 || Integer.parseInt(numero) > 24) {
			throw new Exception("Codigo de Provincia (dos primeros dígitos) no deben ser mayor a 24 ni menores a 0");
		}

		return true;
	}

	protected boolean validarCodigoEstablecimiento(String numero) throws Exception {
		if (Integer.parseInt(numero) < 1) {
			throw new Exception("Código de establecimiento no puede ser 0");
		}
		return true;
	}

	
}
