package com.gl.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	int id;
	String title;
	String description;
	String content;
	String createdDate;

}
