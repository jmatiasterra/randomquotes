/**
 * 
 */
package com.assessment.randomquotes.resource.services;

import java.util.List;

import com.assessment.randomquotes.resource.model.AuthorDTO;

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
