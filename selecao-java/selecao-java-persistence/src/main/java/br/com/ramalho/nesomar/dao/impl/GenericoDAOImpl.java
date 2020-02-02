package br.com.ramalho.nesomar.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.ramalho.nesomar.dao.GenericoDAO;
import br.com.ramalho.nesomar.model.EntidadeBase;
import br.com.ramalho.nesomar.persistence.ValidadorBase;

public abstract class GenericoDAOImpl<K extends Serializable, T extends EntidadeBase<K>> implements GenericoDAO<K, T> {
	
	@PersistenceContext(unitName = "br.com.ramalho.nesomar.SelecaoJavaDS")
	private EntityManager em;

	private Class<T> clazz;
	
	@Override
	public List<T> listar() {
		CriteriaQuery<T> query = getCriteriaBuilder().createQuery(clazz);
		Root<T> variableRoot = query.from(clazz);
		query.select(variableRoot);

		return em.createQuery(query).getResultList();
	}

	@Override
	public T consultarPorId(K id) {
		return em.find(clazz, id);
	}

	@Override
	public T gravar(T objeto) {
		ValidadorBase.validate(objeto);

		if (objeto.getId() == null) {
			em.persist(objeto);
			return objeto;
		}

		return em.merge(objeto);
	}

	@Override
	public T merge(T objeto) {
		return em.merge(objeto);
	}

	@Override
	public Set<T> merge(Set<T> objetos) {
		return objetos.stream().map(objeto -> em.merge(objeto)).collect(Collectors.toSet());
	}

	@Override
	public void excluir(K id) {
		T objeto = consultarPorId(id);
		excluir(objeto);
		
	}

	@Override
	public void excluir(T objeto) {
		em.remove(objeto);
	}
	
	private Class<?> getTypeClass() {
		return (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}

	protected CriteriaBuilder getCriteriaBuilder() {
		return em.getCriteriaBuilder();
	}

	public EntityManager getEntityManager() {
		return em;
	}

}
