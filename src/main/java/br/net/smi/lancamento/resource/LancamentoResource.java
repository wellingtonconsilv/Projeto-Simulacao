package br.net.smi.lancamento.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import br.net.smi.lancamento.model.Lancamento;
import br.net.smi.lancamento.service.LancamentoService;

@RestController
public class LancamentoResource {
	
	@Autowired
	private LancamentoService lancamentoService;
	
	@GetMapping("/lancamento")
	public ResponseEntity<List<Lancamento>> listar(){
		return new ResponseEntity<>(lancamentoService.listar(), HttpStatus.OK);
	}
	
	@PostMapping("/lancamento")
	public ResponseEntity<Lancamento> cadastrar(@RequestBody Lancamento lancamento){
		return new ResponseEntity<>(lancamentoService.cadastrar(lancamento), HttpStatus.CREATED);
	}
	
	@PutMapping("/lancamento")
	public ResponseEntity<Lancamento> atualizar(@RequestBody Lancamento lancamento){
		return new ResponseEntity<>(lancamentoService.atualizar(lancamento), HttpStatus.OK);
	}
	
	@DeleteMapping("/lancamento/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id){
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
