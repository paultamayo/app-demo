package com.paultamayo.repository.impl;

import javax.ejb.Stateless;

import com.paultamayo.domain.Moneda;
import com.paultamayo.repository.Repository;

@Stateless
public class MonedaRepository extends Repository<Long, Moneda> {

	@Override
	public Class<Moneda> getEntityClass() {
		return Moneda.class;
	}

}
