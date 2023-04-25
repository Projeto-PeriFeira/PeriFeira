package org.generation.perifeira.controller;

import java.util.List;

import org.generation.perifeira.model.Produtos;
import org.generation.perifeira.repository.CategoriasRepository;
import org.generation.perifeira.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutosController {
	
	@Autowired
	private ProdutosRepository produtosRepository;
	
	@Autowired
	private CategoriasRepository categoriasRepository;
	
	@GetMapping
	public ResponseEntity<List<Produtos>> getAll(){
		return ResponseEntity.ok(produtosRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produtos> getById(@PathVariable Long id){
		return produtosRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produtos>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(produtosRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	
	@PostMapping
	public ResponseEntity<Produtos> post(@Valid @RequestBody Produtos produtos){
		if(categoriasRepository.existsById(produtos.getCategorias().getId()))
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(produtosRepository.save(produtos));
		
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoria não existe!", null);
		
		
	}
	
	
	@PutMapping
	public ResponseEntity<Produtos> put(@Valid @RequestBody Produtos produtos){
		if (produtosRepository.existsById(produtos.getId())) {
			
			if(categoriasRepository.existsById(produtos.getCategorias().getId()))
				return ResponseEntity.status(HttpStatus.OK)
						.body(produtosRepository.save(produtos));
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "categoria não existe!", null);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	
	@DeleteMapping ("/{id}")
	   public ResponseEntity<?> deleteProdutos (@PathVariable Long id){
		   return produtosRepository.findById(id)
				   .map(resposta -> {
					   produtosRepository.deleteById(id);
					   return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				   })
				   .orElse(ResponseEntity.notFound().build());
				   
	   } 

}
