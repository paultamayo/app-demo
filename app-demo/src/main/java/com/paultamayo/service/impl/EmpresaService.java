package com.paultamayo.service.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.paultamayo.domain.Empresa;
import com.paultamayo.repository.Repository;
import com.paultamayo.repository.impl.EmpresaRepository;
import com.paultamayo.service.Service;

@Stateless
public class EmpresaService extends Service<Long, Empresa> {

	@Inject
	private EmpresaRepository repository;

	@Override
	protected Repository<Long, Empresa> getRepository() {
		return repository;
	}

}
