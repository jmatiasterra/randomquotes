/**
 * 
 */
package com.assessment.randomquotes.services;

import java.util.List;

import com.assessment.randomquotes.model.Author;
import com.assessment.randomquotes.model.AuthorDTO;

/**
 * @author jm
 *
 */
public interface AuthorService {

	AuthorDTO findById(long id);

	Long createAuthor(Author author);

	void updateAuthor(Author author);

	void deleteAuthorById(long id);

	List<Author> findAllAuthors();

}
