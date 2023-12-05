package com.gl.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.dao.TicketDetailsRepository;
import com.gl.model.TicketDetails;

@Service
public class TicketDetailsServiceImpl implements TicketDetailsService {

	@Autowired
	TicketDetailsRepository dao;

	@Override
	public List<TicketDetails> getAllTicketDetails() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void saveTicketDetail(TicketDetails ticketDetails) {
		// TODO Auto-generated method stub
		if (ticketDetails.getCreatedDate() == null) {
			LocalDate date = LocalDate.now();

			String createdDate = date.getDayOfMonth() + " " + date.getMonthValue() + " " + date.getYear();
			ticketDetails.setCreatedDate(createdDate);
		}

		dao.save(ticketDetails);
	}

	@Override
	public void deleteTicketById(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public TicketDetails getTicketById(int id) {
		// TODO Auto-generated method stub
		Optional<TicketDetails> result = dao.findById(id);
		if (result.isPresent()) {
			return result.get();
		} else {
			throw new RuntimeException("Ticket does not exists for Id : " + id);
		}
	}

//	public List<TicketDetails> getAllTicketDetailsBySearch(String title) {
//		
//		return dao.findAllByTitle(title);
//	}
	@Override
	public List<TicketDetails> getAllTicketDetailsBySearch(String keyword) {
		if (keyword != null) {
			return dao.search(keyword);
		}
		return dao.findAll();
	}
}
