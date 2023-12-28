package com.example.jdev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.jdev.model.usuario;

@Repository 
public interface UsuarioRepository extends JpaRepository<usuario, Long> {
	
	@Query(value="select u from usuario u where u.nome like %?1%")
   List<usuario> buscarPorNome(String nome);
}
