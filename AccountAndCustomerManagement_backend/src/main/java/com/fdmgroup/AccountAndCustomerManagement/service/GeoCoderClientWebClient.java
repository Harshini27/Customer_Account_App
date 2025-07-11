package com.fdmgroup.AccountAndCustomerManagement.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import com.fdmgroup.AccountAndCustomerManagement.model.GeoCoderDTO;

import reactor.core.publisher.Mono;

@Service
public class GeoCoderClientWebClient implements IGeoCoderClient{
	
	
    
   private WebClient geocoderWebClient;
   
   
	@Autowired
	public GeoCoderClientWebClient(WebClient geocoderWebClient) {
	super();
	this.geocoderWebClient = geocoderWebClient;
}

	@Override
	public GeoCoderDTO getLocationByPostalCode(String postalcode) {

	    if (postalcode == null || postalcode.trim().isEmpty()) {
	        throw new InvalidPostalCodeException("Postal code cannot be empty");
	    }
	    
		return geocoderWebClient.get()
				.uri(uriBuilder -> uriBuilder
						.queryParam("postal",postalcode)
						.queryParam("json","1")
						.build())
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.onStatus(HttpStatusCode::isError, response -> 
				response.bodyToMono(String.class)
				.flatMap(body ->{
					System.err.println("geocoder error");
				return Mono.error(new InvalidPostalCodeException("Invalid postal code: " + postalcode));
				})
				)
				.bodyToMono(String.class)
				.map(response -> {
					JSONObject json = new JSONObject(response);
					if (!json.has("standard")) {
				        throw new InvalidPostalCodeException("Invalid postal code"+postalcode);
				    }

					String city = json.getJSONObject("standard").getString("city");
					String province = json.getJSONObject("standard").getString("prov");
					return new GeoCoderDTO(city, province);
				})
				.block();
	}

}
