package com.paultamayo.service.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.paultamayo.domain.Banco;
import com.paultamayo.repository.Repository;
import com.paultamayo.repository.impl.BancoRepository;
import com.paultamayo.service.Service;

@Stateless
public class BancoService extends Service<Long, Banco> {

	@Inject
	private BancoRepository repository;

	@Override
	protected Repository<Long, Banco> getRepository() {
		return repository;
	}

}
