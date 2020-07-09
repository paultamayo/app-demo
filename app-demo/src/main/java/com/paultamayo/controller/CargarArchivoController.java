package com.paultamayo.controller;

import java.io.IOException;
import java.io.Serializable;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.poi.EncryptedDocumentException;
import org.omnifaces.util.Messages;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import com.paultamayo.domain.Empresa;
import com.paultamayo.exception.DataBaseException;
import com.paultamayo.service.impl.CargarArchivoService;
import com.paultamayo.service.impl.EmpresaService;
import com.paultamayo.to.CuentaTo;
import com.paultamayo.util.ValidacionesUtil;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.jbosslog.JBossLog;

@JBossLog
@Named
@ViewScoped
public class CargarArchivoController implements Serializable {

	private static final long serialVersionUID = -4761834076178132671L;

	@Inject
	private CargarArchivoService service;

	@Inject
	private EmpresaService empresaService;

	@Getter
	@Setter
	private String ejercicio;

	@Getter
	@Setter
	private Long empresaId;

	@Getter
	private List<SelectItem> empresasSelectItems;

	@Getter
	private List<CuentaTo> cuentas;

	@PostConstruct
	public void init() {
		try {
			this.ejercicio = Year.now().toString();
			empresasSelectItems = new ArrayList<>();
			List<Empresa> empresas = empresaService.findAll();
			empresas.forEach(e -> empresasSelectItems.add(new SelectItem(e.getId(), e.getNombre())));
		} catch (DataBaseException e) {
			log.error(e.getMessage(), e);
		}
	}

	public void handleFileUpload(FileUploadEvent event) {
		UploadedFile file = event.getFile();
		try {
			cuentas = ValidacionesUtil.getCuentasTo(file.getInputStream());			
		} catch (EncryptedDocumentException | IOException e) {
			log.error(e.getMessage(), e);
		}
	}

	public void guardar() {
		try {
			service.guardar(cuentas, ejercicio, empresaId);
			cuentas = List.of();
			empresaId = null;
			Messages.addInfo("messages", "Se ha guardado correctamente la cuenta");
		} catch (DataBaseException e) {
			Messages.addError("messages", "Error al momento de guardar: " + e.getMessage());
		}
	}

}
