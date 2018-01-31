/**
 * 
 */
package com.assessment.randomquotes.config;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.assessment.randomquotes.config.AppConfig;
import com.assessment.randomquotes.model.Author;
import com.assessment.randomquotes.model.AuthorDTO;
import com.assessment.randomquotes.model.Quote;
import com.assessment.randomquotes.model.QuoteDTO;
import com.assessment.randomquotes.utils.DTOFactory;

/**
 * @author mterraciano
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class DTOFactoryTest {

	@Autowired
	private DTOFactory dtoFactory;

	private static Author author;
	private static Set<Quote> quotes = new HashSet<Quote>();

	// this could be a factory
	private static void createAuthor() {
		author = new Author();
		author.setId(new Long(1));
		author.setFirstName("Albert");
		author.setLastName("Eistein");
	}

	// this could be a factory
	private static void createQuote() {
		Quote quote = new Quote();
		quote.setId(new Long(1));
		quote.setText("Todos somos muy ignorantes, lo que ocurre es que no todos ignoramos las mismas cosas");
		quotes.add(quote);
	}

	@BeforeClass
	public static void init() {
		createAuthor();
		createQuote();
	}

	@Test
	public void createAuthorDTO() {
		AuthorDTO authorDTO = dtoFactory.createAuthorDTO(author);
		assertEquals(author.getId(), authorDTO.getId());
		assertEquals(author.getFirstName(), authorDTO.getFirstName());
		assertEquals(author.getLastName(), authorDTO.getLastName());
	}

	@Test
	public void createQuoteDTO() {

		Quote quote = new Quote();
		quote.setAuthor(author);
		quote.setId(new Long(1));
		quote.setText("This is a quote");
		QuoteDTO quoteDTO = dtoFactory.createQuoteDTO(quote);

		assertEquals(quote.getId(), quoteDTO.getId());
		assertEquals(quote.getText(), quoteDTO.getText());
		assertEquals(quote.getAuthor().getId(), quoteDTO.getId());

		String authorFullName = quote.getAuthor().getFirstName() + " " + quote.getAuthor().getLastName();
		assertEquals(authorFullName, quoteDTO.getAuthorName());

	}
}
