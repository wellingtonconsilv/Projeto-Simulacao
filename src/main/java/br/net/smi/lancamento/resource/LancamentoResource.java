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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.net.smi.lancamento.model.Categoria;
import br.net.smi.lancamento.model.Empresa;
import br.net.smi.lancamento.model.Lancamento;
import br.net.smi.lancamento.service.CategoriaService;
import br.net.smi.lancamento.service.EmpresaService;
import br.net.smi.lancamento.service.LancamentoService;

@RestController
public class LancamentoResource {
	
	@Autowired
	private LancamentoService lancamentoService;

	private Lancamento lancamento = new Lancamento();
	
	private Categoria categoria = new Categoria();
	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private EmpresaService empresaService;
	private Empresa empresa = new Empresa();
	
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
		lancamentoService.remover(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping("/lancamento/incluirEmCategoria")
	public ResponseEntity<Lancamento> incluirEmCategoria(@RequestParam Long lancamentoId, @RequestParam Long categoriaId){
		categoria = categoriaService.listarPorId(categoriaId);
		lancamento = lancamentoService.listarPorId(lancamentoId);
		lancamento.setCategoria(categoria);
		lancamentoService.atualizar(lancamento);
		return new ResponseEntity<>(lancamento, HttpStatus.OK);
		
	}
	
	@RequestMapping("/lancamento/incluirEmEmpresa")
	public ResponseEntity<Lancamento> incluirEmEmpresa(@RequestParam Long lancamentoId, @RequestParam Long empresaId){
		empresa = empresaService.listarPorId(empresaId);
		lancamento = lancamentoService.listarPorId(lancamentoId);
		lancamento.setEmpresa(empresa);
		lancamentoService.atualizar(lancamento);
		return new ResponseEntity<>(lancamento, HttpStatus.OK);
		
	}
}
