package br.com.ramalho.nesomar.util;

import java.util.Locale;
import java.util.ResourceBundle;

public final class ConstanteSistemaUtil {

	private ConstanteSistemaUtil() {
	}
	
	public static final String CLASSE_UTILITARIA = "Classe utilitária";
	public static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("messages", Locale.getDefault());

}
