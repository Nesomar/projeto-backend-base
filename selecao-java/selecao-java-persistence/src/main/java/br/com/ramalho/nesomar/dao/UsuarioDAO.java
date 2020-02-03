package br.com.ramalho.nesomar.dao;

import javax.ejb.Local;

import br.com.ramalho.nesomar.model.Usuario;

@Local
public interface UsuarioDAO extends GenericoDAO<Long, Usuario> {

}
