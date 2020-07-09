package com.paultamayo.resource;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

public class Resources {

	@Default
	@Produces
	@PersistenceContext(name = "AdministrationPU")
	private EntityManager em;

	@Default
	@Produces
	public Logger getLogger(final InjectionPoint injectionPoint) {
		return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}
}
