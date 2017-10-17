/**
 * 
 */
package com.assessment.randomquotes.model;

/**
 * @author mterraciano
 *
 */
public class QuoteDTO {

	private Long id;

	private String text;

	private AuthorDTO author;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

	public QuoteDTO(Long id, String text, AuthorDTO author) {
		super();
		this.id = id;
		this.text = text;
		this.author = author;
	}

}
