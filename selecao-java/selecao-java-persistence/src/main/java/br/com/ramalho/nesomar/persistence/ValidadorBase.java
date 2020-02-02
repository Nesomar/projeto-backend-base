package br.com.ramalho.nesomar.persistence;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import br.com.ramalho.nesomar.util.ConstanteSistemaUtil;

public final class ValidadorBase {

	private ValidadorBase() {
		throw new IllegalStateException(ConstanteSistemaUtil.CLASSE_UTILITARIA);
	}

	private static Validator getValidator() {
		return Validation.buildDefaultValidatorFactory().getValidator();
	}

	public static <T> void validate(T objeto) {
		Set<ConstraintViolation<T>> violations = getValidator().validate(objeto);
		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
		}
	}
	
	public static <T> Boolean isValid(T operadorInfoDTO) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<T>> constraintViolations = validator.validate(operadorInfoDTO);
		
		return constraintViolations != null && constraintViolations.isEmpty();
	}
}
