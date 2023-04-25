package org.generation.perifeira.repository;

import java.util.List;

import org.generation.perifeira.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ProdutosRepository extends JpaRepository<Produtos, Long>{
	
	public List <Produtos> findAllByNomeContainingIgnoreCase(@Param("Nome") String nome);
}
