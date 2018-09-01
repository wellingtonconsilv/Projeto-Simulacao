package br.net.smi.lancamento.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Empresa{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@NotBlank
	private String nome;
	@Column(length = 14)
	@NotNull
	@NotBlank
	private String cnpj;
	private String nomeResponsavel;
	private String contato;
	@OneToMany(mappedBy= "empresa")
	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	
	
	
	
}