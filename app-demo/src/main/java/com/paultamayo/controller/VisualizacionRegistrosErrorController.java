package com.paultamayo.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.paultamayo.domain.RegistroError;
import com.paultamayo.exception.DataBaseException;
import com.paultamayo.service.impl.RegistroErrorService;

import lombok.Getter;
import lombok.extern.jbosslog.JBossLog;

@JBossLog
@Named
@ViewScoped
public class VisualizacionRegistrosErrorController implements Serializable {

	private static final long serialVersionUID = -1568345083365002449L;

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
