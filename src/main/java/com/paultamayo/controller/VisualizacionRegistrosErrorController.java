package com.paultamayo.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.paultamayo.domain.RegistroError;
import com.paultamayo.exception.DataBaseException;
import com.paultamayo.service.impl.RegistroErrorService;

import lombok.Getter;
import lombok.extern.jbosslog.JBossLog;

@JBossLog
@Model
public class VisualizacionRegistrosErrorController {

	@Inject
	private RegistroErrorService service;

	@Getter
	private List<RegistroError> cuentas;

	@PostConstruct
	public void init() {
		try {
			cuentas = service.findAll();
		} catch (DataBaseException e) {
			log.error(e.getMessage(), e);
		}
	}
}
