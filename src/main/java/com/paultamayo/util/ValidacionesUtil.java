package com.paultamayo.util;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.paultamayo.to.CuentaTo;

public class ValidacionesUtil {

	private static void validacionEstatica(CuentaTo cuenta) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<CuentaTo>> validaciones = validator.validate(cuenta);

		if (!validaciones.isEmpty()) {
			validaciones.forEach(v -> {
				String error = "Campo=" + v.getPropertyPath().toString().toUpperCase() + ": " + v.getMessage() + ".";
				cuenta.addErrores(error);
			});
		}

		if (cuenta.hasError()) {
			if (cuenta.getFechaVence().isBefore(cuenta.getFechaCobro())) {
				String error = "Campo= FECHAVENCE: No puede ser la fecha vence menor a la fecha de cobro.";

				cuenta.addErrores(error);
			}

			if (cuenta.getFechaCobro().isBefore(LocalDate.now())) {
				String error = "Campo= FECHACOBRO: No puede ser la fecha cobro menor a la actual.";

				cuenta.addErrores(error);
			}

			if (cuenta.getFechaVence().isBefore(LocalDate.now())) {
				String error = "Campo= FECHAVENCE: No puede ser la fecha vence menor a la actual.";

				cuenta.addErrores(error);
			}
		}

	}

	public static List<CuentaTo> getCuentasTo(InputStream inputStream) throws IOException {
		List<CuentaTo> cuentas = new ArrayList<>();

		DataFormatter dataFormatter = new DataFormatter();

		try (Workbook workBook = WorkbookFactory.create(inputStream)) {
			Sheet sheet = workBook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				int i = row.getRowNum();

				if (i > 0) {
					String cliente = dataFormatter.formatCellValue(row.getCell(0));
					String seguroCredito = dataFormatter.formatCellValue(row.getCell(1));
					String banco = dataFormatter.formatCellValue(row.getCell(2));
					String cuenta = dataFormatter.formatCellValue(row.getCell(3));
					String numeroCheque = dataFormatter.formatCellValue(row.getCell(4));
					String montoString = dataFormatter.formatCellValue(row.getCell(5));
					String moneda = dataFormatter.formatCellValue(row.getCell(6));
					String fechaCobroString = dataFormatter.formatCellValue(row.getCell(7));
					String fechaVenceString = dataFormatter.formatCellValue(row.getCell(8));

					CuentaTo cuentaTo = new CuentaTo();
					cuentaTo.setRegistro(i);
					cuentaTo.setBanco(banco);
					cuentaTo.setCliente(cliente);
					cuentaTo.setMoneda(moneda);
					cuentaTo.setNumeroCheque(numeroCheque);
					cuentaTo.setCuenta(cuenta);
					cuentaTo.setSeguroCredito(seguroCredito);
					cuentaTo.setMontoString(montoString);
					cuentaTo.setFechaCobroString(fechaCobroString);
					cuentaTo.setFechaVenceString(fechaVenceString);

					validacionEstatica(cuentaTo);

					cuentas.add(cuentaTo);
				}

			}
		}

		return cuentas;
	}

}
