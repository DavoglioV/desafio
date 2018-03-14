package br.com.saraiva.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.saraiva.model.entity.Livro;
import br.com.saraiva.service.LivroService;

@RestController
@RequestMapping("/book")
public class RestfullController {

	@Autowired
	private LivroService livroService;
	
	@PostMapping
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity<Livro> incluir(@RequestBody String sku) {
		return livroService.incluir(sku);
	}
	@DeleteMapping
	@RequestMapping("/{sku}")
	public ResponseEntity<Livro> excluir(@PathVariable("sku") String sku){
		return livroService.excluir(sku);
	}
	
	@GetMapping
	@RequestMapping(value="/{sku}", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<Livro> consultar(@PathVariable("sku") String sku){
		return livroService.consultar(sku);
	}
	
	@GetMapping
	@RequestMapping(method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<List<Livro>> listar(@Param("price") String price,
			@Param("limit") int limit ){
		return livroService.listar(price, limit);
	}
	

	

}
