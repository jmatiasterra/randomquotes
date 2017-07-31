/**
 * 
 */
package com.assessment.randomquotes.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	/*@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "quote_tags", joinColumns = {
			@JoinColumn(name = "QUOTE_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "TAG_ID", table = "tag", nullable = false, updatable = false) })
	private Set<Tag> tags = new HashSet<Tag>(0);*/

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
	 * @return the tags
	 */
	/*public Set<Tag> getTags() {
		return tags;
	}

	/**
	 * @param tags
	 *            the tags to set
	 */
	/*public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}*/

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

	/**
	 * @param id
	 * @param text
	 * @param author
	 * @param tags
	 */
	/*public Quote(Long id, String text, Author author, Set<Tag> tags) {
		super();
		this.id = id;
		this.text = text;
		this.author = author;
		this.tags = tags;
	}
	*/

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Quote [id=" + id + ", text=" + text + ", author=" + author + "]";
	}

}
