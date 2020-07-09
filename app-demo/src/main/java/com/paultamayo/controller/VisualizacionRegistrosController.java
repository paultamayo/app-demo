package com.paultamayo.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.paultamayo.domain.Registro;
import com.paultamayo.exception.DataBaseException;
import com.paultamayo.service.impl.RegistroService;

import lombok.Getter;
import lombok.extern.jbosslog.JBossLog;

@JBossLog
@Model
public class VisualizacionRegistrosController {

	@Inject
	private RegistroService service;

	@Getter
	private List<Registro> cuentas;

	@PostConstruct
	public void init() {
		try {
			cuentas = service.findAll();
		} catch (DataBaseException e) {
			log.error(e.getMessage(), e);
		}
	}
}
