package com.paultamayo.service.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.paultamayo.domain.RegistroError;
import com.paultamayo.repository.Repository;
import com.paultamayo.repository.impl.RegistroErrorRepository;
import com.paultamayo.service.Service;

@Stateless
public class RegistroErrorService extends Service<Long, RegistroError> {

	@Inject
	private RegistroErrorRepository repository;

	@Override
	protected Repository<Long, RegistroError> getRepository() {
		return repository;
	}

}
