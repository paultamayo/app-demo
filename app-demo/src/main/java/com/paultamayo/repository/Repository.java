package com.paultamayo.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

import lombok.AccessLevel;
import lombok.Getter;

public abstract class Repository<K, T> {

	@Inject
	@Getter(value = AccessLevel.PROTECTED)
	private EntityManager entityManager;

	public Long count() {
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();

		CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
		Root<T> root = criteriaQuery.from(getEntityClass());
		criteriaQuery.select(builder.count(root));

		TypedQuery<Long> query = getEntityManager().createQuery(criteriaQuery);

		return query.getSingleResult();
	}

	public void create(final T entity) {
		getEntityManager().persist(entity);
	}

	public List<T> findAll() {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<T> criteria = cb.createQuery(getEntityClass());
		Root<T> root = criteria.from(getEntityClass());
		criteria.select(root);

		return getEntityManager().createQuery(criteria).getResultList();
	}

	public <X> List<T> findAllByIds(SingularAttribute<T, X> attribute, List<X> ids) {
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();

		CriteriaQuery<T> criteria = builder.createQuery(getEntityClass());
		Root<T> root = criteria.from(getEntityClass());
		criteria.select(root).where(root.get(attribute).in(ids));

		TypedQuery<T> query = getEntityManager().createQuery(criteria);

		return query.getResultList();
	}

	public T findById(final K primaryKey) {
		return getEntityManager().find(getEntityClass(), primaryKey);
	}

	public abstract Class<T> getEntityClass();

	public void remove(final K primaryKey) {
		T entity = findById(primaryKey);

		getEntityManager().remove(entity);
	}

	public void update(final T entity) {
		getEntityManager().merge(entity);
	}

}
