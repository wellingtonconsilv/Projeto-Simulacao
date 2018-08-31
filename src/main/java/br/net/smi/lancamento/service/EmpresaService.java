package br.net.smi.lancamento.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.net.smi.lancamento.model.Categoria;
import br.net.smi.lancamento.model.Empresa;
import br.net.smi.lancamento.repository.EmpresaRepository;

@Service
public class EmpresaService{
	@Autowired
	private EmpresaRepository empresaRepository;
	
	public Empresa cadastrar(Empresa empresa) {
		
		return empresaRepository.save(empresa);
	}
	
	public Optional<Empresa> filtrarPorCnpjENome(String cnpj, String nome) {
		return empresaRepository.findByCnpjAndNome(cnpj, nome);
	}


	
	public List<Empresa> filtrarTodasEmpresas() {
		return empresaRepository.findAll();
	}
	
	public void remover(Long id) {
		empresaRepository.deleteById(id);
	}
	
	public Empresa atualizar(Empresa empresa) {
		return empresaRepository.save(empresa);
	}
	

}



