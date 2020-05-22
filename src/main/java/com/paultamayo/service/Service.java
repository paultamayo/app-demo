package com.paultamayo.service;

import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.metamodel.SingularAttribute;

import org.jboss.logging.Logger;

import com.paultamayo.exception.DataBaseException;
import com.paultamayo.repository.Repository;

import lombok.Getter;

public abstract class Service<K, T> {

	@Inject
	@Getter
	private Logger logger;

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Long count() {
		return getRepository().count();
	}

	public void delete(final K primaryKey) throws DataBaseException {
		try {
			getRepository().remove(primaryKey);
		} catch (Exception ex) {
			getLogger().error(ex.getMessage(), ex);
			throw new DataBaseException(ex);
		}
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<T> findAll() throws DataBaseException {
		try {
			return getRepository().findAll();
		} catch (Exception ex) {
			getLogger().error(ex.getMessage(), ex);
			throw new DataBaseException(ex);
		}
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public <X> List<T> findAllByIds(SingularAttribute<T, X> attribute, List<X> ids) throws DataBaseException {
		try {
			return getRepository().findAllByIds(attribute, ids);
		} catch (Exception ex) {
			getLogger().error(ex.getMessage(), ex);
			throw new DataBaseException(ex);
		}
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public T findBy(final K primaryKey) throws DataBaseException {
		try {
			return getRepository().findById(primaryKey);
		} catch (Exception ex) {
			getLogger().error(ex.getMessage(), ex);
			throw new DataBaseException(ex);
		}
	}

	protected abstract Repository<K, T> getRepository();

	public void modify(final T entity) throws DataBaseException {
		try {
			getRepository().update(entity);
		} catch (Exception ex) {
			getLogger().error(ex.getMessage(), ex);
			throw new DataBaseException(ex);
		}
	}

	public void save(final T entity) throws DataBaseException {
		try {
			getRepository().create(entity);
		} catch (Exception ex) {
			getLogger().error(ex.getMessage(), ex);
			throw new DataBaseException(ex);
		}
	}
}
