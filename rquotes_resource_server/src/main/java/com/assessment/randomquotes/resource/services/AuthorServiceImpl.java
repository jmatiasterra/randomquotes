/**
 * 
 */
package com.assessment.randomquotes.resource.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assessment.randomquotes.resource.dao.AuthorDAO;
import com.assessment.randomquotes.resource.model.Author;
import com.assessment.randomquotes.resource.model.AuthorDTO;
import com.assessment.randomquotes.resource.utils.DTOFactory;

/**
 * @author jm
 *
 */
@Service("authorService")
@Transactional
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorDAO authorDao;

	@Autowired
	private DTOFactory dtoFactory;

	@Override
	public AuthorDTO findById(long id) {
		AuthorDTO author = dtoFactory.createAuthorDTO(authorDao.findById(id));
		return author;
	}

	@Override
	public Long createAuthor(AuthorDTO authorDTO) {
		Author author = dtoFactory.createAuthor(authorDTO);
		authorDao.saveAuthor(author);
		return author.getId();
	}

	@Override
	public void updateAuthor(AuthorDTO authorDTO) {
		Author author = dtoFactory.createAuthor(authorDTO);
		authorDao.updateAuthor(author);
	}

	@Override
	public void deleteAuthorById(long id) {
		authorDao.deleteById(id);
	}

	@Override
	public List<AuthorDTO> findAllAuthors() {
		List<AuthorDTO> authors = dtoFactory.createAuthorsDTO(authorDao.findAllAuthors());
		return authors;
	}

}
