package com.paultamayo.repository.impl;

import javax.ejb.Stateless;

import com.paultamayo.domain.Registro;
import com.paultamayo.repository.Repository;

@Stateless
public class RegistroRepository extends Repository<Long, Registro> {

	@Override
	public Class<Registro> getEntityClass() {
		return Registro.class;
	}

}
