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
	
	private String authorName;

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

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public QuoteDTO(Long id, String text, String authorName) {
		super();
		this.id = id;
		this.text = text;
		this.authorName = authorName;
	}

	public QuoteDTO() {
		// TODO Auto-generated constructor stub
	}

	
}
