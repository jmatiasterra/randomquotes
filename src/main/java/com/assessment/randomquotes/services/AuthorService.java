/**
 * 
 */
package com.assessment.randomquotes.services;

import java.util.List;

import com.assessment.randomquotes.model.Author;

/**
 * @author jm
 *
 */
public interface AuthorService {
	
	Author findById(long id);
	void saveAuthor(Author author);
	void updateAuthor(Author author);
	void deleteAuthorById(long id);
	List<Author> findAllAuthors();

}
