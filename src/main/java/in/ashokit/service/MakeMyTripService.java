package in.ashokit.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.ashokit.bindingforms.passenger;
import in.ashokit.bindingforms.ticket;

@Service
public class MakeMyTripService {

	public ticket bookticket(passenger p) {
		
		String apiurl = "http://43.205.144.253:8080/ticket";
		
		RestTemplate rt = new RestTemplate();
		ResponseEntity<ticket> tckt= rt.postForEntity(apiurl, p, ticket.class);
		ticket body = tckt.getBody();
		
		return body;
	}
	
	public List<ticket> getalltickets(){
		
		String apiurl = "http://43.205.144.253:8080/tickets";
		
		RestTemplate rt = new RestTemplate();
		ResponseEntity<ticket[]> tckts = rt.getForEntity(apiurl, ticket[].class);
		ticket[] body = tckts.getBody();
		List<ticket> tickets = Arrays.asList(body);
		
		return tickets;
	}
}
