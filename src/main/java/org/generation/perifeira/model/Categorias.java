package org.generation.perifeira.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_categorias")
public class Categorias {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;

	
	@NotBlank(message = "A descrição do produto é obirgatória!") 
	@Size(min = 5, max = 255, message = "A descrição deve conter no mínimo 05 e no máximo 255 caracteres")
	private String descricao;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="categorias", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("categorias")
	private List<Produtos> produtos;
	
	public String getDescricao() {
		return descricao;
	}

	public List<Produtos> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produtos> produtos) {
		this.produtos = produtos;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
}
