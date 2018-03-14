package br.com.saraiva.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mashape.unirest.http.exceptions.UnirestException;

import br.com.saraiva.integration.SaraivaDelivery;
import br.com.saraiva.model.entity.Livro;
import br.com.saraiva.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	public LivroRepository livroRepository;
	
	@Autowired
	public SaraivaDelivery saraivaDelivery;

	public ResponseEntity<Livro> incluir(String sku) {
		HttpStatus status;
		try {
			Livro livro = saraivaDelivery.buscar(sku);
			
			livroRepository.save(livro);
			status = HttpStatus.CREATED;
			
		} catch (UnirestException e) {
			e.printStackTrace();
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		ResponseEntity<Livro> resp = new ResponseEntity<>(status);
		return resp;
	}

	public ResponseEntity<Livro> excluir(String sku) {
		Livro livro = livroRepository.findBySku(sku);
		HttpStatus status;
		if(null == livro) {
			status = HttpStatus.BAD_REQUEST;
		}else {
			livroRepository.delete(livro);
			status = HttpStatus.NO_CONTENT;
		}
		
		ResponseEntity<Livro> resp = new ResponseEntity<>(status);
		return resp;
	}

	public ResponseEntity<Livro> consultar(String sku) {
		
		HttpStatus status;
		Livro livro = livroRepository.findBySku(sku);
		
		if(null == livro) {
			status = HttpStatus.NOT_FOUND;
		}else {
			status = HttpStatus.OK;
		}
		ResponseEntity<Livro> resp = new ResponseEntity<Livro>(livro, status);
		return resp;
	}

	public ResponseEntity<List<Livro>> listar(String price, int limit) {
		HttpStatus status;
		List<Livro> livros = livroRepository.findAllByPreco(price, limit);
		
		if(null == livros) {
			status = HttpStatus.NOT_FOUND;
		}else {
			status = HttpStatus.OK;
		}
		ResponseEntity<List<Livro>> resp = new ResponseEntity<List<Livro>>(livros, status);
		return resp;
	}
}
