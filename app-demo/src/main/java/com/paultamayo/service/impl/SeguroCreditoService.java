package com.paultamayo.service.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.paultamayo.domain.SeguroCredito;
import com.paultamayo.repository.Repository;
import com.paultamayo.repository.impl.SeguroCreditoRepository;
import com.paultamayo.service.Service;

@Stateless
public class SeguroCreditoService extends Service<Long, SeguroCredito> {

	@Inject
	private SeguroCreditoRepository repository;

	@Override
	protected Repository<Long, SeguroCredito> getRepository() {
		return repository;
	}

}
