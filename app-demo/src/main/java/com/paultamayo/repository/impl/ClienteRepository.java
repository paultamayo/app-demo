package com.paultamayo.repository.impl;

import javax.ejb.Stateless;

import com.paultamayo.domain.Cliente;
import com.paultamayo.repository.Repository;

@Stateless
public class ClienteRepository extends Repository<Long, Cliente> {

	@Override
	public Class<Cliente> getEntityClass() {
		return Cliente.class;
	}

}
