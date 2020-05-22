package com.paultamayo.repository.impl;

import javax.ejb.Stateless;

import com.paultamayo.domain.Banco;
import com.paultamayo.repository.Repository;

@Stateless
public class BancoRepository extends Repository<Long, Banco> {

	@Override
	public Class<Banco> getEntityClass() {
		return Banco.class;
	}

}
