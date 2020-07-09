package com.paultamayo.service.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.paultamayo.domain.Registro;
import com.paultamayo.repository.Repository;
import com.paultamayo.repository.impl.RegistroRepository;
import com.paultamayo.service.Service;

@Stateless
public class RegistroService extends Service<Long, Registro> {

	@Inject
	private RegistroRepository repository;

	@Override
	protected Repository<Long, Registro> getRepository() {
		return repository;
	}

}
