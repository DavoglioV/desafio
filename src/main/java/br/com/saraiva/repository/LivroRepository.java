package br.com.saraiva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.saraiva.model.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{
	
	Livro findBySku(String sku);
	
	@Query(nativeQuery = true, value = "SELECT * FROM livro WHERE preco= ?1 LIMIT ?2")
	List<Livro> findAllByPreco(String price, int maxresult);
}
