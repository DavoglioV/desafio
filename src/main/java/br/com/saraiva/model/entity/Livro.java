package br.com.saraiva.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="livro")
@SequenceGenerator(sequenceName = "S_LIVRO", name = "S_LIVRO")
public class Livro implements Serializable{
	
	private static final long serialVersionUID = 5023432365336069790L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "S_LIVRO")
	Long id;
	
	@Column(name="sku")
	String sku;
	
	@Column(name="nome")
	String nome;
	
	@Column(name="marca")
	String marca;
	
	@Column(name="preco")
	String preco;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}

	
	
	
}
