package com.paultamayo.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.paultamayo.domain.SeguroCredito;
import com.paultamayo.exception.DataBaseException;
import com.paultamayo.service.impl.SeguroCreditoService;

import lombok.Getter;
import lombok.extern.jbosslog.JBossLog;

@JBossLog
@Named
@ViewScoped
public class AdministracionSeguroCredito implements Serializable {

	private static final long serialVersionUID = 5028403211915584613L;

	@Inject
	private SeguroCreditoService service;

	@Getter
	private List<SeguroCredito> seguros;

	@PostConstruct
	public void init() {
		try {
			seguros = service.findAll();
		} catch (DataBaseException e) {
			log.error(e.getMessage(), e);
		}
	}
}
