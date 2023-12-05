package com.gl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.model.TicketDetails;
import com.gl.service.TicketDetailsService;

@Controller
@RequestMapping("/admin")
public class HomeController {
	@Autowired
	TicketDetailsService service;

	@RequestMapping("/")
	public String home() {
		return "welcome";
	}

	@RequestMapping("/tickets")
	public String getAllTicketDetails(Model model) {
		model.addAttribute("ticketLists", service.getAllTicketDetails());
		return "ticket-list";
	}

	@GetMapping("/tickets/newTicket")
	public String showFormAdd(Model model) {
		model.addAttribute("ticket", new TicketDetails());
		model.addAttribute("heading","Create Ticket");
		return "form-ticket";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("ticket") TicketDetails newTicket) {
		service.saveTicketDetail(newTicket);
		return "redirect:/admin/tickets";
	}

	@PostMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		service.deleteTicketById(id);
		return "redirect:/admin/tickets";
	}

	@RequestMapping("/{id}/edit")
	public String update(@PathVariable("id") int id, Model model) {
		TicketDetails ticket = service.getTicketById(id);
		model.addAttribute("ticket", ticket);
		model.addAttribute("heading","Edit Ticket");
		return "form-ticket";
	}

	@PostMapping("/showFormForView")
	public String view(@RequestParam("id") int id, Model model) {
		TicketDetails ticket = service.getTicketById(id);
		model.addAttribute("ticket", ticket);
		return "view-list";
	}

	@RequestMapping("/tickets/search")
	public String search(Model model, @Param("query") String query) {
		System.out.println("search keyword: " + query);
		model.addAttribute("ticketLists", service.getAllTicketDetailsBySearch(query));
		return "ticket-list";
	}
}
