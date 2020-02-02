package br.com.ramalho.nesomar.util;

import java.text.MessageFormat;

import br.com.ramalho.nesomar.enumeration.MensagemSistemaEnum;

/**
 * Classe repsonsável por recuperar as mensagens que serão exbidas na aplicação do Resource Bundle
 * 
 * @author Nesomar
 *
 */
public final class MensagemUtil {

	private MensagemUtil() {
		super();
	}

	public static String getMessage(MensagemSistemaEnum mensagemEnum) {
		return new String(ConstanteSistemaUtil.RESOURCE_BUNDLE.getString(mensagemEnum.toString()).getBytes());
	}

	public static String getMessage(MensagemSistemaEnum mensagemEnum, Object... args) {
		String mensagem = getMessage(mensagemEnum);
		if (args.length > 0) {
			mensagem = MessageFormat.format(mensagem, args);
		}
		return mensagem;
	}
}
