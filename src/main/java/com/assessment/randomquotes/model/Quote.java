/**
 * 
 */
package com.assessment.randomquotes.model;

import java.util.List;

/**
 * @author matias.terracciano
 *
 */
public class Quote {

	private Long id;

	private String text;

	private String author;

	private List<String> tags;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the tags
	 */
	public List<String> getTags() {
		return tags;
	}

	/**
	 * @param tags
	 *            the tags to set
	 */
	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	/**
	 * @param text
	 * @param author
	 * @param tags
	 */
	public Quote(String text, String author, List<String> tags) {
		super();
		this.text = text;
		this.author = author;
		this.tags = tags;
	}

	/**
	 * @param id
	 * @param text
	 * @param author
	 * @param tags
	 */
	public Quote(Long id, String text, String author, List<String> tags) {
		super();
		this.id = id;
		this.text = text;
		this.author = author;
		this.tags = tags;
	}

	public Quote() {

	}

}
