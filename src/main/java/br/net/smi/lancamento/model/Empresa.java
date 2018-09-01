package br.net.smi.lancamento.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Entity
@NoArgsConstructor
public class Empresa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@NotBlank
	private String nome;
	
	@NotNull
	@NotBlank
	@Column(length = 14)
	private String cnpj;
	private String nomeResponsavel;
	private String contato;
	@OneToMany(mappedBy= "empresa", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	
	
	
	
}
