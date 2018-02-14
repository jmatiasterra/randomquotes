/**
 * 
 */
package com.assessment.randomquotes.services;

import java.util.List;

import com.assessment.randomquotes.model.AuthorDTO;

/**
 * @author jm
 *
 */
public interface AuthorService {

	AuthorDTO findById(long id);

	Long createAuthor(AuthorDTO authorDTO);

	void updateAuthor(AuthorDTO authorDTO);

	void deleteAuthorById(long id);

	List<AuthorDTO> findAllAuthors();

}
