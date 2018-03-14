package br.com.saraiva.integration;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import br.com.saraiva.LivroMapper;
import br.com.saraiva.model.entity.Livro;

@Component
public class SaraivaDelivery {

	@Value("${url.saraivaApi}")
	private String urlSaraiva;
	
	@Value("${url.saraivaApi.params}")
	private String urlSaraivaParam;

	public Livro buscar(String sku) throws UnirestException {
		JSONObject t = new JSONObject(sku);
		
		HttpResponse<JsonNode> response = Unirest.get(urlSaraiva + t.getString("sku") + urlSaraivaParam).header("Accept", "application/json;charset=UTF-8").asJson();
		
		JSONObject jasonResponse = response.getBody().getObject();
		
		Livro livro = LivroMapper.convertToLivro(jasonResponse);
		return livro;
	}
}
