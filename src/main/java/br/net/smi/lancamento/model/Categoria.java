package br.net.smi.lancamento.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Entity
@NoArgsConstructor
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String descricao;
	@OneToMany(mappedBy = "categoria")
	List<Lancamento> lancamentos = new ArrayList<Lancamento>();
}
