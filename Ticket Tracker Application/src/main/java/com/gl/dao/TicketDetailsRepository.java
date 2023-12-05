package com.gl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gl.model.TicketDetails;

public interface TicketDetailsRepository extends JpaRepository<TicketDetails, Integer> {

	// public List<TicketDetails> findAllByTitle(String title);
	@Query("SELECT p FROM TicketDetails  p WHERE CONCAT(p.id,p.title, p.description) LIKE %?1%")
	public List<TicketDetails> search(String keyword);

	// reference
	// https://www.codejava.net/frameworks/spring-boot/spring-data-jpa-filter-search-examples
}
