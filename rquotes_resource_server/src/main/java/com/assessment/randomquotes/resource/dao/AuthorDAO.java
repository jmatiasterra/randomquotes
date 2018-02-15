/**
 * 
 */
package com.assessment.randomquotes.resource.dao;

import java.util.List;

import com.assessment.randomquotes.resource.model.Author;

/**
 * @author jm
 *
 */
public interface AuthorDAO {
	Author findById(long id);
	void saveAuthor(Author author);
	void updateAuthor(Author author);
	void deleteById(long id);
	List<Author> findAllAuthors();	

}
