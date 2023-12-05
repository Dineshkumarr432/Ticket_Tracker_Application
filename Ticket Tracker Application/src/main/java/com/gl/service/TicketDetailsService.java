package com.gl.service;

import java.util.List;

import com.gl.model.TicketDetails;

public interface TicketDetailsService {

	List<TicketDetails> getAllTicketDetails();

	void saveTicketDetail(TicketDetails ticketDetails);

	void deleteTicketById(int id);

	TicketDetails getTicketById(int id);

	// public List<TicketDetails> getAllTicketDetailsBySearch(String title);

	public List<TicketDetails> getAllTicketDetailsBySearch(String keyword);
}