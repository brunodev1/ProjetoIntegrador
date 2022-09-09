package com.generation.refugiodamoda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.refugiodamoda.model.Produto;
import com.generation.refugiodamoda.repository.CategoriaRepository;
import com.generation.refugiodamoda.repository.ProdutoRepository;
import com.generation.refugiodamoda.repository.UsuarioRepository;

@RestController
@RequestMapping("/produtos")
//CrossOrigin(origin = "*", allowedHeaders = "*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public ResponseEntity <List<Produto>> getAll(){
		return ResponseEntity.ok(produtoRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <Produto> getById(@PathVariable Long id) {
		return produtoRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity <List<Produto>> getByNome(@PathVariable String nome) {
		return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@GetMapping("/preco_inicial/{inicio}/preco_final/{fim}")
	public ResponseEntity <List<Produto>> getByPreco(@PathVariable Double inicio, @PathVariable Double fim) {
		return ResponseEntity.ok(produtoRepository.findByPrecoBetween(inicio, fim));
	}
	
	/*@PostMapping
	public ResponseEntity <Produto> post(@Valid @RequestBody Produto produto) {
		
	}*/
}
