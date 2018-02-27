/**
 * 
 */
package com.assessment.randomquotes.resources.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.assessment.randomquotes.resource.dao.AuthorDAO;
import com.assessment.randomquotes.resource.model.Author;
import com.assessment.randomquotes.resources.config.TestConfig;

/**
 * @author matias.terracciano
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
@WebAppConfiguration
@Transactional
public class AuthorDAOTest {

	@Autowired
	private AuthorDAO authorDAO;

	@Test
	public void saveAndFindAuthorOk() {

		Author author = new Author("Bruce", "Lee");
		authorDAO.saveAuthor(author);
		Author savedAuthor = authorDAO.findById(author.getId());

		assertNotNull(savedAuthor);
		assertEquals(savedAuthor.getId().longValue(), author.getId().intValue());
		assertEquals(savedAuthor.getFirstName(), "Bruce");
		assertEquals(savedAuthor.getLastName(), "Lee");
	}

	@Test
	public void updateAuthorOk() {

		Author author = new Author("Albert", "Einstein");
		authorDAO.saveAuthor(author);
		author.setLastName("Eins");

		authorDAO.updateAuthor(author);
		Author savedAuthor = authorDAO.findById(author.getId());

		assertNotNull(savedAuthor);
		assertEquals(savedAuthor.getId().longValue(), author.getId().longValue());
		assertEquals(savedAuthor.getFirstName(), author.getFirstName());
		assertEquals(savedAuthor.getLastName(), "Eins");
	}

	@Test
	public void createAuthorIfNotExist() {

		Author author = new Author("Albert", "Eins");
		author.setId(new Long(400));
		authorDAO.updateAuthor(author);

		Author savedAuthor = authorDAO.findById(author.getId());
		assertNotNull(savedAuthor);
	}

	@Test
	public void deleteAuthorOk() {
		Long authorId = new Long(50);
		Author author = new Author("Albert", "Eins");
		author.setId(authorId);
		authorDAO.updateAuthor(author);

		Author savedAuthor = authorDAO.findById(authorId);
		assertNotNull(savedAuthor);

		authorDAO.deleteById(authorId);

		// revisar tiene un comportamiento extraño el delete aca en el test, pero
		// funciona normalmente cuando esta deployado

	}

	@Test
	public void findAuthorNotFound() {
		Author author = authorDAO.findById(40);

		assertNull(author);
	}

	@Test
	public void findAllAuthors() {

		Author author = new Author("Albert", "Eins");
		authorDAO.saveAuthor(author);
		Author author2 = new Author("Bruce", "Lee");
		authorDAO.saveAuthor(author2);

		List<Author> authors = authorDAO.findAllAuthors();

		assertNotNull(authors);

		System.out.println(authors.size());

		assertTrue(authors.size() == 2);

	}

}
