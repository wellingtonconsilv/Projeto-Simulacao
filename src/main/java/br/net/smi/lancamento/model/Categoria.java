package br.net.smi.lancamento.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Categoria implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String descricao;
	@OneToMany(mappedBy = "categoria", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<Lancamento> lancamentos = new ArrayList<Lancamento>();
}