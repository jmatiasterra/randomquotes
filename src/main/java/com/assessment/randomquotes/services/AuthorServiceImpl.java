/**
 * 
 */
package com.assessment.randomquotes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assessment.randomquotes.dao.AuthorDAO;
import com.assessment.randomquotes.model.Author;
import com.assessment.randomquotes.model.AuthorDTO;
import com.assessment.randomquotes.utils.DTOFactory;

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
		Author author = authorDao.findById(id);
		return dtoFactory.createAuthorDTO(author);
	}

	@Override
	public Long createAuthor(AuthorDTO authorDTO) {
		Author author = dtoFactory.createAuthor(authorDTO);
		authorDao.saveAuthor(author);
		return author.getId();
	}

	@Override
	public void updateAuthor(Long id, AuthorDTO authorDTO) {
		Author author = dtoFactory.createAuthor(authorDTO);
		authorDao.saveAuthor(author);
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
