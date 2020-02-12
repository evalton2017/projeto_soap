package com.soap.projetosoap.endpoints;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.exemplo.wsdlservidor.assets.GetPaisRequest;
import com.exemplo.wsdlservidor.assets.GetPaisResponse;
import com.soap.projetosoap.repository.PaisRepository;

@Endpoint
public class PaisEndpoint {

	private static final String NAMESPACE_URI= "http://com.exemplo.wsdlservidor.assets";
	
	private final PaisRepository paisRep;
	
	public PaisEndpoint(PaisRepository paisRep) {this.paisRep = paisRep;}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart="getPaisRequest")
	@ResponsePayload
	public GetPaisResponse getCountry(@RequestPayload GetPaisRequest request) {
			GetPaisResponse response = new GetPaisResponse();
			response.setPais(paisRep.buscarPorPais(request.getNome()));
			
			return response;
	}
	
	
}
