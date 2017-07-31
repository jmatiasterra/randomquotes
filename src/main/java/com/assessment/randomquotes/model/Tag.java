/**
 * 
 */
package com.assessment.randomquotes.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author jm
 *
 */
@Entity
@Table(name = "tag")
public class Tag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "TEXT", nullable = false)
	private String text;
	/*@ManyToMany(fetch = FetchType.LAZY, mappedBy = "tags")
	private Set<Quote> quotes = new HashSet<Quote>(0);*/

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
	 * @return the quotes
	 */
	/*public Set<Quote> getQuotes() {
		return quotes;
	}*/

	/**
	 * @param quotes
	 *            the quotes to set
	 */
	/*public void setQuotes(Set<Quote> quotes) {
		this.quotes = quotes;
	}*/

	/**
	 * @param id
	 * @param text
	 * @param quotes
	 */
	public Tag(Long id, String text/*, Set<Quote> quotes*/) {
		super();
		this.id = id;
		this.text = text;
		//this.quotes = quotes;
	}

	/**
	 * 
	 */
	public Tag() {
		super();
	}

}
