package org.generation.perifeira.controller;

import java.util.List;

import org.generation.perifeira.model.Categorias;
import org.generation.perifeira.repository.CategoriasRepository;
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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins ="*", allowedHeaders = "*")

public class CategoriasController {
	
@Autowired
private CategoriasRepository categoriasRepository;

@GetMapping 

public ResponseEntity<List <Categorias>>getAll(){
	return ResponseEntity.ok(categoriasRepository.findAll());
	
}
	@GetMapping("/{id}")
	public ResponseEntity<Categorias> getById(@PathVariable Long id){
		return categoriasRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
   @GetMapping("/descricao/{descricao}")
   public ResponseEntity<List<Categorias>> getByCategoria(@PathVariable String descricao){
	    return ResponseEntity.ok(categoriasRepository.findAllByDescricaoContainingIgnoreCase(descricao));
   }
   @PostMapping
   public ResponseEntity<Categorias> postCategoria (@Valid @RequestBody Categorias categorias){
	   return ResponseEntity.status(HttpStatus.CREATED).body(categoriasRepository.save(categorias));
   }
   @PutMapping
   public ResponseEntity<Categorias> putCategoria(@Valid @RequestBody Categorias categorias){
	   return categoriasRepository.findById(categorias.getId())
			   .map(resposta -> ResponseEntity.ok().body(categoriasRepository.save(categorias)))
			   .orElse(ResponseEntity.notFound().build());
   }
   @DeleteMapping ("/{id}")
   public ResponseEntity<?> deleteCategorias (@PathVariable Long id){
	   return categoriasRepository.findById(id)
			   .map(resposta -> {
				   categoriasRepository.deleteById(id);
				   return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			   })
			   .orElse(ResponseEntity.notFound().build());
			   
   }
}
