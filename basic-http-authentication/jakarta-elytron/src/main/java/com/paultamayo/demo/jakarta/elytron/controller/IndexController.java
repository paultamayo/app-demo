package com.paultamayo.demo.jakarta.elytron.controller;

import java.io.Serializable;
import java.security.Principal;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class IndexController implements Serializable {

	private static final long serialVersionUID = 5628857443808500882L;
	
	private Principal principal;
	
	
	
	public String getHello() {
		principal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
		
		System.out.println(principal);
		
		return principal.getName();
	}

}
