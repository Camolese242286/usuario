package com.example.jdev.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seq_usuario" ,sequenceName ="seq_usuario" ,allocationSize = 1 )
public class usuario implements Serializable {

	private static final long serialVersionUID = 1L;
   
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "seq_usuario")
	
	private long id;
	
	private String nome;

	private int idade;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
}
