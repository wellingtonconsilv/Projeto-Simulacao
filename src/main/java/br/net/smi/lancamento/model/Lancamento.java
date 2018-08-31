package br.net.smi.lancamento.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Lancamento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tipo;
	private LocalDate vencimento;
	private BigDecimal valor;
	@ManyToOne
	@JoinColumn(name = "empresa_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "empresa_fk"))
	private Empresa empresa = new Empresa();
	@ManyToOne
	@JoinColumn(name = "categoria_id", nullable= false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "categoria_fk"))
	private Categoria categoria = new Categoria();
	
}
