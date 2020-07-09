package com.paultamayo.service.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.paultamayo.domain.Cliente;
import com.paultamayo.repository.Repository;
import com.paultamayo.repository.impl.ClienteRepository;
import com.paultamayo.service.Service;

@Stateless
public class ClienteService extends Service<Long, Cliente> {

	@Inject
	private ClienteRepository repository;

	@Override
	protected Repository<Long, Cliente> getRepository() {
		return repository;
	}

}
