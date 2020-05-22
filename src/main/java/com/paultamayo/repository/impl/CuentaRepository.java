package com.paultamayo.repository.impl;

import javax.ejb.Stateless;

import com.paultamayo.domain.Cuenta;
import com.paultamayo.repository.Repository;

@Stateless
public class CuentaRepository extends Repository<Long, Cuenta> {

	@Override
	public Class<Cuenta> getEntityClass() {
		return Cuenta.class;
	}

}
