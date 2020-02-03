package br.com.ramalho.nesomar.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import br.com.ramalho.nesomar.dao.GenericoDAO;
import br.com.ramalho.nesomar.model.EntidadeBase;
import br.com.ramalho.nesomar.service.GenericoService;


public class GenericoServiceImpl<K extends Serializable, T extends EntidadeBase<K>> implements GenericoService<K, T> {

	private static final long serialVersionUID = 6097459728216907838L;
	
	@Inject
	private GenericoDAO<K, T> dao;

	@Override
	public List<T> listar() {
		return dao.listar();
	}

	@Override
	public T consultarPorId(K id) {
		return dao.consultarPorId(id);
	}

	@Override
	public T gravar(T objeto) {
		return dao.gravar(objeto);
	}

	@Override
	public T atualizar(T objeto) {
		return dao.merge(objeto);
	}

	@Override
	public Set<T> atualizar(Set<T> objetos) {
		return dao.merge(objetos);
	}

	@Override
	public void excluir(K id) {
		dao.excluir(id);
	}

	@Override
	public void excluir(T objeto) {
		dao.excluir(objeto);
	}
	
	public void setDao(GenericoDAO<K, T> dao) {
		this.dao = dao;
	}

}
