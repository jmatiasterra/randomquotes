/**
 * 
 */
package com.assessment.randomquotes.resources.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.assessment.randomquotes.resource.model.Author;
import com.assessment.randomquotes.resource.model.AuthorDTO;
import com.assessment.randomquotes.resource.model.Quote;
import com.assessment.randomquotes.resource.model.QuoteDTO;
import com.assessment.randomquotes.resource.utils.DTOFactory;
import com.assessment.randomquotes.resources.config.TestConfig;

/**
 * @author matias.terracciano
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@WebAppConfiguration
public class DTOFactoryTest {

	@Autowired
	private DTOFactory dtoFactory;

	@Test
	public void createAuthorDTOOK() {
		Author author = new Author("Albert", "Einstein");
		author.setId(new Long(1));

		AuthorDTO authorDTO = dtoFactory.createAuthorDTO(author);
		assertEquals(author.getFirstName(), authorDTO.getFirstName());
		assertEquals(author.getLastName(), authorDTO.getLastName());
		assertEquals(author.getId(), authorDTO.getId());
	}

	@Test
	public void createAuthorDTONullAuthor() {

		AuthorDTO authorDTO = dtoFactory.createAuthorDTO(null);
		assertNull(authorDTO);
	}

	@Test
	public void createAuthorDTOWithQuotesOK() {

		Author author = new Author("Albert", "Einstein");
		author.setId(new Long(1));
		Quote quote = new Quote(new Long(1),
				"Todos somos muy ignorantes, lo que ocurre es que no todos ignoramos las mismas cosas");
		quote.setAuthor(author);

		HashSet<Quote> quotes = new HashSet<Quote>();
		quotes.add(quote);

		author.setQuotes(quotes);

		AuthorDTO authorDTO = dtoFactory.createAuthorDTO(author);
		assertEquals(author.getFirstName(), authorDTO.getFirstName());
		assertEquals(author.getLastName(), authorDTO.getLastName());
		assertEquals(author.getId(), authorDTO.getId());

		assertEquals(quotes.size(), authorDTO.getQuotes().size());

	}

	@Test
	public void createQuotesDTOOk() {
		List<Quote> quotes = new ArrayList<Quote>();
		Quote quote = new Quote(new Long(1),
				"Todos somos muy ignorantes, lo que ocurre es que no todos ignoramos las mismas cosas");
		Author author = new Author("Albert", "Einstein");
		author.setId(new Long(1));
		quote.setAuthor(author);
		quotes.add(quote);

		List<QuoteDTO> quotesDTO = dtoFactory.createQuotesDTO(quotes);

		assertEquals(quotes.size(), quotesDTO.size());

	}

	@Test
	public void createAuthorsDTOsOK() {

		List<Author> authors = new ArrayList<Author>();
		authors.add(new Author(1, "Albert", "Einstein"));
		authors.add(new Author(2, "Bruce", "Lee"));

		List<AuthorDTO> authorsDTO = dtoFactory.createAuthorsDTO(authors);
		assertEquals(authors.size(), authorsDTO.size());
	}

	@Test
	public void createAuthorOK() {
		AuthorDTO authorDTO = new AuthorDTO(new Long(1), "Albert", "Einstein");

		Author author = dtoFactory.createAuthor(authorDTO);
		assertEquals(author.getFirstName(), authorDTO.getFirstName());
		assertEquals(author.getLastName(), authorDTO.getLastName());
		assertEquals(author.getId(), authorDTO.getId());
	}

	@Test
	public void createQuoteOK() {
		QuoteDTO quoteDTO = new QuoteDTO(new Long(1),
				"Todos somos muy ignorantes, lo que ocurre es que no todos ignoramos las mismas cosas",
				"Albert Einstein");

		Quote quote = dtoFactory.createQuote(quoteDTO);
		assertNotNull(quote);
		assertEquals(quoteDTO.getId(), quote.getId());
		assertEquals(quoteDTO.getText(), quote.getText());
	}

}
