package com.paultamayo.repository.impl;

import javax.ejb.Stateless;

import com.paultamayo.domain.Empresa;
import com.paultamayo.repository.Repository;

@Stateless
public class EmpresaRepository extends Repository<Long, Empresa> {

	@Override
	public Class<Empresa> getEntityClass() {
		return Empresa.class;
	}

}
