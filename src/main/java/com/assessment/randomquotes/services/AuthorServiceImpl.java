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

/**
 * @author jm
 *
 */
@Service("authorService")
@Transactional
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorDAO dao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.assessment.randomquotes.services.AuthorService#findById(long)
	 */
	@Override
	public Author findById(long id) {
		return dao.findById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.assessment.randomquotes.services.AuthorService#saveAuthor(com.
	 * assessment.randomquotes.model.Author)
	 */
	@Override
	public Long createAuthor(Author author) {
		dao.saveAuthor(author);
		return author.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.assessment.randomquotes.services.AuthorService#updateAuthor(com.
	 * assessment.randomquotes.model.Author)
	 */
	@Override
	public void updateAuthor(Author author) {
		Author entity = dao.findById(author.getId());
		if (entity != null) {
			entity.setFirstName(author.getFirstName());
			entity.setLastName(author.getLastName());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.assessment.randomquotes.services.AuthorService#deleteAuthorById(long)
	 */
	@Override
	public void deleteAuthorById(long id) {
		dao.deleteById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.assessment.randomquotes.services.AuthorService#findAllAuthors()
	 */
	@Override
	public List<Author> findAllAuthors() {
		return dao.findAllAuthors();
	}

}
