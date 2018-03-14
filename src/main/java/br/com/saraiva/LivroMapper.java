package br.com.saraiva;

import org.json.JSONObject;

import br.com.saraiva.model.entity.Livro;

public class LivroMapper {

	public static Livro convertToLivro(JSONObject json) {
		Livro livro = new Livro();
		
		livro.setSku(json.getString("sku"));
		livro.setNome(json.getString("name"));
		livro.setMarca(json.getString("brand"));
		livro.setPreco(json.getJSONObject("price").getJSONObject("bestPrice").getString("value"));
		return livro;
		
	}
}
