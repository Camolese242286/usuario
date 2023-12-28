package com.example.jdev.controler;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.jdev.model.usuario;
import com.example.jdev.repository.UsuarioRepository;

@RestController
public class cotroler {
	
	
	@Autowired
	private UsuarioRepository usuarioRepositoy;
	
	
	@RequestMapping(value="mostrarnome/{nome}",method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String greetingText(@PathVariable String nome) {
		
		
		usuario usuario = new usuario();
		usuario.setNome(nome);
		
		usuarioRepositoy.save(usuario);
		
		return "nome " + nome ;
	}


	@GetMapping(value= "listtatodos")
	@ResponseBody
	public ResponseEntity< java.util.List<usuario> > listaUsuario(){
		
	java.util.List<usuario> usuarios=	usuarioRepositoy.findAll();
	
	return new ResponseEntity<java.util.List<usuario>>(usuarios, HttpStatus.OK);
	}


	@PostMapping(value= "salvar")
	@ResponseBody
	public ResponseEntity<usuario> salvar (@RequestBody usuario usuario){
		
	usuario user=usuarioRepositoy.save(usuario);
	
	return  new ResponseEntity<usuario>(user, HttpStatus.OK);
	}
	
	@DeleteMapping(value= "delete")
	@ResponseBody
	public ResponseEntity<String> deletar (@RequestParam long iduser){
		
      usuarioRepositoy.deleteById(iduser);
	
	return  new ResponseEntity<String>("user deletado com suceso ", HttpStatus.OK);
	}
	
	
	
	@GetMapping(value= "atualizar")
	@ResponseBody
	public ResponseEntity<usuario> atualizar (@RequestParam usuario usuario){
		
    usuario user =  usuarioRepositoy.save(usuario);
	
	return  new ResponseEntity<usuario>(user, HttpStatus.OK);
	}	

	
	@PutMapping(value= "buscaruserid")
	@ResponseBody
	public ResponseEntity<usuario> buscaruserid (@RequestParam(name="iduser") long iduser){
		
    usuario usuario =  usuarioRepositoy.findById(iduser).get();
	
	return  new ResponseEntity<usuario>(usuario, HttpStatus.OK);
	}
	
	
	@PutMapping(value= "buscarPorNome")
	@ResponseBody
	public ResponseEntity<java.util.List<usuario>> buscarPorNome (@RequestParam(name="nome") String nome){
		
    java.util.List<usuario> usuario =  usuarioRepositoy.buscarPorNome(nome);
	
	return  new ResponseEntity<java.util.List<usuario>>(usuario, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	public UsuarioRepository getUsuarioRepositoy() {
		return usuarioRepositoy;
	}


	public void setUsuarioRepositoy(UsuarioRepository usuarioRepositoy) {
		this.usuarioRepositoy = usuarioRepositoy;
	}

}
