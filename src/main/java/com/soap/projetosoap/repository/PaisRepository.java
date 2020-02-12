package com.soap.projetosoap.repository;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.exemplo.wsdlservidor.assets.Moeda;
import com.exemplo.wsdlservidor.assets.Pais;

@Component
public class PaisRepository {
	
	private static final Map<String,Pais> paises = new HashMap<>();
	
	@PostConstruct
	public void initData() {
		Pais brasil = new Pais();
		brasil.setNome("Brasil");
		brasil.setCapital("Brasilia");
		brasil.setMoeda(Moeda.BRL);
		brasil.setPopulacao(2000000);
		paises.put(brasil.getNome(), brasil);
		
		Pais usa = new Pais();
		usa.setNome("Estados Unidos");
		usa.setCapital("Woshigton");
		usa.setMoeda(Moeda.DOLAR);
		usa.setPopulacao(3000000);
		paises.put(usa.getNome(), usa);
		
	}
	
	public Pais buscarPorPais(String nome) {
		Assert.notNull(nome, "O pais não pode ser nulo");
		return paises.get(nome);
	}

}
