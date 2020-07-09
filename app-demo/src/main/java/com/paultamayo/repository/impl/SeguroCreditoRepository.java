package com.paultamayo.repository.impl;

import javax.ejb.Stateless;

import com.paultamayo.domain.SeguroCredito;
import com.paultamayo.repository.Repository;

@Stateless
public class SeguroCreditoRepository extends Repository<Long, SeguroCredito> {

	@Override
	public Class<SeguroCredito> getEntityClass() {
		return SeguroCredito.class;
	}

}
