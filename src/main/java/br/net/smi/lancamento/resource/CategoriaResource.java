package br.net.smi.lancamento.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.net.smi.lancamento.model.Categoria;
import br.net.smi.lancamento.service.CategoriaService;

@RestController
public class CategoriaResource {
	@Autowired
	private CategoriaService categoriaService;
	
	@PostMapping("/categoria")
	public ResponseEntity<Categoria> cadastrar(@RequestBody Categoria categoria){
		return new ResponseEntity<>(categoriaService.cadastrar(categoria), HttpStatus.CREATED);
	}
	
	@GetMapping("/categoria")
	public ResponseEntity<List<Categoria>> listarTodasCategorias(){
		return new ResponseEntity<>(categoriaService.listarTodasCategorias(), HttpStatus.OK);
	}
	
	@GetMapping("/categoria/{id}")
	public ResponseEntity<Categoria> listarPorId(@PathVariable Long id){
		return new ResponseEntity<>(categoriaService.listarPorId(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Categoria> atualizar(@RequestBody Categoria categoria){
		return new ResponseEntity<>(categoriaService.atualizar(categoria), HttpStatus.OK);		
	}
	
	@DeleteMapping("/categoria/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id){
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
 }
