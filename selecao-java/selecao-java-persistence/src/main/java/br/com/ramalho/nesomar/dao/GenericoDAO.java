package br.com.ramalho.nesomar.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import br.com.ramalho.nesomar.model.EntidadeBase;

public interface GenericoDAO<K extends Serializable, T extends EntidadeBase<K>> {
	
	/**
	 * Método responsável por listar todas as entidades na base para uma determinado T Entidade
	 * 
	 * @return Lista com todas as entidades cadastradas para uma determinado T Entidade
	 */
	List<T> listar();

	/**
	 * Recupera a entidade de acordo com o tipo e com o id.
	 * 
	 * @param tipo tipo da entidade
	 * @param id   identificador
	 * @return entidade encontrada, <code>null</code> caso não seja encontrada
	 */
	T consultarPorId(K id);

	/**
	 * Realiza a persistência de uma entidade, caso ela tenha um id será chamado o
	 * método {@link javax.persistence.EntityManager#persist(Object)} caso exista
	 * será chamado o método {@link javax.persistence.EntityManager#merge(Object)}
	 * do {@link javax.persistence.EntityManager}
	 * 
	 * @param objeto objeto que será persistido
	 * @return retorna o objeto persistido, caso seja um novo objeto ele terá o id
	 *         configurado
	 */
	T gravar(T objeto);

	/**
	 * Realiza o update de uma entidade
	 * 
	 * @param objeto objeto que será atualizado
	 * @return retorna o objeto atualizado
	 */
	T merge(T objeto);

	/**
	 * Realiza o update de uma lista de entidades
	 * 
	 * @param objetos - lista de objeto que serão atualizados
	 * @return retorna a lista de objetos atualizados
	 */
	Set<T> merge(Set<T> objetos);

	/**
	 * Exclui uma entidade de acordo com o tipo e o id.
	 * 
	 * @param tipo tipo da entidae
	 * @param id   identificador
	 */
	void excluir(K id);

	/**
	 * Exclui uma entidade.
	 * 
	 * @param objeto entidade que será excluída
	 */
	void excluir(T objeto);
}
