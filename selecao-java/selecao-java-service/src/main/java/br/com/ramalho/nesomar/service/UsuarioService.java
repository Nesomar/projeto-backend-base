package br.com.ramalho.nesomar.service;

import javax.ejb.Local;

import br.com.ramalho.nesomar.model.Usuario;

@Local
public interface UsuarioService extends GenericoService<Long, Usuario> {

}
