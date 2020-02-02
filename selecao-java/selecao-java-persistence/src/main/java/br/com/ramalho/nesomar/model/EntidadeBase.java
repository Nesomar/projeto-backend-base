package br.com.ramalho.nesomar.model;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Entidade persistente base. Todas as entidades devem herdar diretamente ou
 * indiretamente dessa classe.
 * 
 * @author Nesomar
 */
@MappedSuperclass
public abstract class EntidadeBase<K extends Serializable> implements Serializable {

	private static final long serialVersionUID = 6311772781384924884L;

	/**
	 * Retorno o identificador da entidade.
	 * 
	 * @return identificador
	 */
	public abstract K getId();

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {

			return true;
		}

		if (obj == null) {

			return false;
		}

		if (getClass() != obj.getClass()) {

			return false;
		}

		EntidadeBase<?> other = (EntidadeBase<?>) obj;

		EqualsBuilder eb = new EqualsBuilder();

		eb.append(getId(), other.getId());

		return eb.isEquals();
	}

	@Override
	public int hashCode() {

		return new HashCodeBuilder().append(getId()).toHashCode();
	}

}
