package br.com.ramalho.nesomar.endpoint.impl;

import javax.ejb.EJB;
import javax.ws.rs.core.Response;

import br.com.ramalho.nesomar.endpoint.UsuarioEndPoint;
import br.com.ramalho.nesomar.service.UsuarioService;

public class UsuarioEndPointImp implements UsuarioEndPoint {

	private static final long serialVersionUID = -7103270789736124800L;

	@EJB
	private UsuarioService service;
	
	@Override
	public Response listarTodos() {
		return Response.status(Response.Status.OK).entity(service.listar()).build();
	}

}
