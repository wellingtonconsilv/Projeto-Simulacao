package br.net.smi.lancamento.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LancamentoDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long empresaId;
	private Long categoriaId;
	private String tipo;
	private LocalDate vencimento;
	private BigDecimal valor;
}
