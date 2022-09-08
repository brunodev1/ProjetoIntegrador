package com.generation.refugiodamoda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_categorias")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min = 5, max = 100)
	private String tipo;//
	
	private Boolean denuncia;
	

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public String getTipo() 
	{
		return tipo;
	}

	public void setTipo(String tipo) 
	{
		this.tipo = tipo;
	}

	public Boolean getDenuncia() 
	{
		return denuncia;
	}

	public void setDenuncia(Boolean denuncia) 
	{
		this.denuncia = denuncia;
	}
}
