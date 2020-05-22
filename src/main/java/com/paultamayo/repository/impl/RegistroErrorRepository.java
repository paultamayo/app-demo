package com.paultamayo.repository.impl;

import javax.ejb.Stateless;

import com.paultamayo.domain.RegistroError;
import com.paultamayo.repository.Repository;

@Stateless
public class RegistroErrorRepository extends Repository<Long, RegistroError> {

	@Override
	public Class<RegistroError> getEntityClass() {
		return RegistroError.class;
	}

}
