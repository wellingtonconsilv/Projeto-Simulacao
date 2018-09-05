package br.net.smi.lancamento.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.net.smi.lancamento.model.Empresa;
import br.net.smi.lancamento.service.EmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresaResource {
	@Autowired
	private EmpresaService empresaService;

	@PostMapping
	public ResponseEntity<Empresa> cadastrar(@Valid @RequestBody Empresa empresa) {
		return new ResponseEntity<>(empresaService.cadastrar(empresa), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Empresa>> listarTodasEmpresas() {
		return new ResponseEntity<>(empresaService.listarTodasEmpresas(), HttpStatus.OK);
	}

	@GetMapping("/buscarPorNomeCnpj")
	public ResponseEntity<?> filtrarPorCnpjENome(@RequestParam(name = "nome", required = false) String nome ,@RequestParam(name = "cnpj", required = false) String cnpj) {
		return new ResponseEntity<>(empresaService.listarPorCnpjENome(nome, cnpj), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Empresa> listarPorId(@PathVariable Long id) {
		return new ResponseEntity<>(empresaService.listarPorId(id), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Empresa> atualizar(@Valid @RequestBody Empresa empresa) {
		return new ResponseEntity<>(empresaService.atualizar(empresa), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		empresaService.remover(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
