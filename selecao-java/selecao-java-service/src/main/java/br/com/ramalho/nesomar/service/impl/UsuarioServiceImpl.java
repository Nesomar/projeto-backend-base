package br.com.ramalho.nesomar.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import br.com.ramalho.nesomar.dao.UsuarioDAO;
import br.com.ramalho.nesomar.model.Usuario;
import br.com.ramalho.nesomar.service.UsuarioService;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class UsuarioServiceImpl extends GenericoServiceImpl<Long, Usuario> implements UsuarioService {

	private static final long serialVersionUID = -2524598971932435708L;
	
	@EJB
	private UsuarioDAO dao;


}
