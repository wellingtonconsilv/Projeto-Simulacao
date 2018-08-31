package br.net.smi.lancamento.service;

import java.util.List;

import br.net.smi.lancamento.model.Categoria;
import br.net.smi.lancamento.repository.CategoriaRepository;

public class CategoriaService {
	
private CategoriaRepository categoriaRepository;
	
	public Categoria cadastrar(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public List<Categoria> listarTodasCategorias(){
		return categoriaRepository.findAll();
	}
	
	public Categoria listarPorId(Long id) {
		return categoriaRepository.findById(id).get();
	}
	
	public void remover(Long id) {
		categoriaRepository.deleteById(id);
	}
	
	public Categoria atualizar(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
}
