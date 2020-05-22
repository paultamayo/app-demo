package com.paultamayo.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.paultamayo.domain.Moneda;
import com.paultamayo.exception.DataBaseException;
import com.paultamayo.service.impl.MonedaService;

import lombok.extern.jbosslog.JBossLog;

@JBossLog
@Named
@ViewScoped
public class MonedaController implements Serializable {

	private static final long serialVersionUID = -4761834076178132671L;

	@Inject
	private MonedaService service;

	@PostConstruct
	public void init() {
		try {
			List<Moneda> monedas = service.findAll();
			monedas.forEach(log::info);
		} catch (DataBaseException e) {
			log.error(e.getMessage(), e);
		}
	}

	public String getHelloWorld() {
		return "Hola Mundo";
	}

}
