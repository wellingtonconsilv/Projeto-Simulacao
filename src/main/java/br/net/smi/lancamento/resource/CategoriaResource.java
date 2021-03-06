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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.net.smi.lancamento.model.Categoria;
import br.net.smi.lancamento.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaResource {
	@Autowired
	private CategoriaService categoriaService;

	@PostMapping
	public ResponseEntity<Categoria> cadastrar(@RequestBody Categoria categoria) {
		return new ResponseEntity<>(categoriaService.cadastrar(categoria), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Categoria>> listarTodasCategorias() {
		return new ResponseEntity<>(categoriaService.listarTodasCategorias(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> listarPorId(@PathVariable Long id) {
		return new ResponseEntity<>(categoriaService.listarPorId(id), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Categoria> atualizar(@RequestBody Categoria categoria) {
		return new ResponseEntity<>(categoriaService.atualizar(categoria), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
