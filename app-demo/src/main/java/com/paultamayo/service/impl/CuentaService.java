package com.paultamayo.service.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.paultamayo.domain.Cuenta;
import com.paultamayo.repository.Repository;
import com.paultamayo.repository.impl.CuentaRepository;
import com.paultamayo.service.Service;

@Stateless
public class CuentaService extends Service<Long, Cuenta> {

	@Inject
	private CuentaRepository repository;

	@Override
	protected Repository<Long, Cuenta> getRepository() {
		return repository;
	}

}
