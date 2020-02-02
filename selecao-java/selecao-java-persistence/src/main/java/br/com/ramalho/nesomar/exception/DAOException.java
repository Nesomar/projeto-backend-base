package br.com.ramalho.nesomar.exception;

import br.com.ramalho.nesomar.enumeration.MensagemSistemaEnum;
import br.com.ramalho.nesomar.util.MensagemUtil;

/**
 * Classe de exerção padrão da camada de repositorio
 * 
 * @author Nesomar
 *
 */
public class DAOException extends Exception {

	private static final long serialVersionUID = 4141330711416148618L;
	
	public DAOException() {
		super(MensagemUtil.getMessage(MensagemSistemaEnum.ME001));
	}

	public DAOException(String message) {
		super(message);
	}
}
