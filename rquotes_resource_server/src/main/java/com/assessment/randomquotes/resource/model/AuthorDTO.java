/**
 * 
 */
package com.assessment.randomquotes.resource.model;

import java.util.List;

/**
 * @author mterraciano
 *
 */
public class AuthorDTO {

	private Long id;

	private String firstName;

	private String lastName;

	private List<QuoteDTO> quotes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<QuoteDTO> getQuotes() {
		return quotes;
	}

	public void setQuotes(List<QuoteDTO> quotes) {
		this.quotes = quotes;
	}

	public AuthorDTO(Long id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public AuthorDTO() {
		// TODO Auto-generated constructor stub
	}

}