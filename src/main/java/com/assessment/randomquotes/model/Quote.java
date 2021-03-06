/**
 * 
 */
package com.assessment.randomquotes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author matias.terracciano
 *
 */
@Entity
@Table(name = "quote")
public class Quote {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "TEXT", nullable = false)
	private String text;
	@ManyToOne
	@JoinColumn(name = "author_id", nullable = false)
	private Author author;

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
	public Author getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(Author author) {
		this.author = author;
	}

	/**
	 * 
	 */
	public Quote() {
		super();
	}

	/**
	 * 
	 * @param id
	 * @param text
	 * @param author
	 */
	public Quote(Long id, String text, Author author) {
		super();
		this.id = id;
		this.text = text;
		this.author = author;
	}

	@Override
	public String toString() {
		return "Quote [id=" + id + ", text=" + text + ", author=" + author + "]";
	}
	
}
