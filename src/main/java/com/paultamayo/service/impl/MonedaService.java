package com.paultamayo.service.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.paultamayo.domain.Moneda;
import com.paultamayo.repository.Repository;
import com.paultamayo.repository.impl.MonedaRepository;
import com.paultamayo.service.Service;

@Stateless
public class MonedaService extends Service<Long, Moneda> {

	@Inject
	private MonedaRepository repository;

	@Override
	protected Repository<Long, Moneda> getRepository() {
		return repository;
	}

}
