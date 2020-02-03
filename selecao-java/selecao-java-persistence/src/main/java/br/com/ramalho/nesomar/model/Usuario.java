package br.com.ramalho.nesomar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"nome", "email", "senha"}, callSuper = false)
public class Usuario extends EntidadeBase<Long> {
	
	private static final long serialVersionUID = 8885058799023293096L;

	@Id
	@Column(name = "id_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "nome")
	@Getter @Setter
	private String nome;
	
	@NotNull
	@Column(name = "email")
	@Getter @Setter
	private String email;
	
	@NotNull
	@Column(name = "documento")
	@Getter @Setter
	private String documento;
	
	@NotNull
	@Column(name = "senha")
	@Getter @Setter
	private String senha;

	@Override
	public Long getId() {
		return id;
	}
}
