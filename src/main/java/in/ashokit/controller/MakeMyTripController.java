package in.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.bindingforms.passenger;
import in.ashokit.bindingforms.ticket;
import in.ashokit.service.MakeMyTripService;

@Controller
public class MakeMyTripController {
  
	@Autowired
	 private MakeMyTripService service;
	
	@GetMapping("/")
	public String index(Model model) {
		
		List<ticket> alltickets = service.getalltickets();
		
		model.addAttribute("tickets",alltickets);
		
		return "index";
	}
	@GetMapping("/book-ticket")
	public String bookticket(Model model) {
		
		model.addAttribute("p", new passenger());
		
		return "bookticket";
	}
	@PostMapping("/ticket") 
	public String ticketbook(@ModelAttribute("p") passenger p,Model model) {
	ticket	tckt= service.bookticket(p);
	model.addAttribute("msg","your ticket is confirmed, Id:"+ tckt.getTicketNum());
	return "bookticket";
	}
}
