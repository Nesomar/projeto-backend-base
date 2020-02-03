package br.com.ramalho.nesomar.dao.impl;

import javax.ejb.Stateless;

import br.com.ramalho.nesomar.dao.UsuarioDAO;
import br.com.ramalho.nesomar.model.Usuario;

@Stateless
public class UsuarioDAOImpl extends GenericoDAOImpl<Long, Usuario> implements UsuarioDAO {

}
