package org.generation.perifeira.repository;

import java.util.List;

import org.generation.perifeira.model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface CategoriasRepository extends JpaRepository<Categorias, Long>{
	
	public List <Categorias> findAllByDescricaoContainingIgnoreCase(@Param("descricao")String descricao);
	

}
