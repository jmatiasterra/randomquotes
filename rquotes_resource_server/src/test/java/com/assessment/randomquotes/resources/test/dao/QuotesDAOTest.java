/**
 * 
 */
package com.assessment.randomquotes.resources.test.dao;

import static org.junit.Assert.assertEquals;

import org.hibernate.PropertyValueException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import com.assessment.randomquotes.resource.dao.AuthorDAO;
import com.assessment.randomquotes.resource.dao.QuoteDAO;
import com.assessment.randomquotes.resource.model.Author;
import com.assessment.randomquotes.resource.model.Quote;
import com.assessment.randomquotes.resources.config.HibernateTestConfig;

/**
 * @author matias.terracciano
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { HibernateTestConfig.class }, loader = AnnotationConfigContextLoader.class)
@Transactional
@ActiveProfiles("test")
public class QuotesDAOTest {

	@Autowired
	private QuoteDAO quotesDAO;
	@Autowired
	private AuthorDAO authorDAO;

	private boolean setUpIsDone = false;

	@Before
	public void setUp() {
		if (setUpIsDone) {
			return;
		}
		Author author1 = new Author("Albert", "Einstein");
		authorDAO.saveAuthor(author1);

		Quote quote = new Quote();
		quote.setText("Existen dos formas de ver la vi");
		quote.setAuthor(author1);
		quotesDAO.saveQuote(quote);

		quote = new Quote();
		quote.setText("¡Triste época es la nuestra! Es más fácil desintegrar un átomo que un prejuicio");
		quote.setAuthor(author1);
		quotesDAO.saveQuote(quote);
		setUpIsDone = true;
	}

	@Test
	public void saveQuoteOK() {
		String text = "Los ideales que iluminan mi camino y una y otra vez me han dado coraje para enfrentar la vida con alegría han sido: la amabilidad, la belleza y la verdad";

		Author author = new Author("Bruce", "Lee");
		authorDAO.saveAuthor(author);
		author = authorDAO.findById(author.getId());

		Quote quote = new Quote();
		quote.setText(text);
		quote.setAuthor(author);
		quotesDAO.saveQuote(quote);

		Long quoteId = quote.getId();

		Quote saveQuote = quotesDAO.findById(quoteId);

		assertEquals(saveQuote.getId(), quote.getId());
		assertEquals(saveQuote.getText(), quote.getText());
		assertEquals(saveQuote.getAuthor(), quote.getAuthor());
	}

	@Test(expected = PropertyValueException.class)
	public void saveQuoteFailsMissingAuthor() {
		String text = "Los ideales que iluminan mi camino y una y otra vez me han dado coraje para enfrentar la vida con alegría han sido: la amabilidad, la belleza y la verdad";

		Quote quote = new Quote();
		quote.setText(text);
		quotesDAO.saveQuote(quote);
	}

	@Test
	public void updateQuoteOK() {

		String text = "Nueva quote";

		Quote quote = quotesDAO.findAllQuotes().get(0);

		Long quoteId = quote.getId();

		quote.setText(text);

		quotesDAO.saveQuote(quote);

		Quote saveQuote = quotesDAO.findById(quoteId);

		assertEquals(saveQuote.getId(), quote.getId());
		assertEquals(saveQuote.getText(), quote.getText());
		assertEquals(saveQuote.getAuthor(), quote.getAuthor());

	}

	@Test
	public void listQuotes() {

		assertEquals(quotesDAO.findAllQuotes().size(),2);
		
		String text = "Alguna idea loca es algo loco";

		Author author = new Author("Peter", "Lee");
		authorDAO.saveAuthor(author);
		author = authorDAO.findById(author.getId());

		Quote quote = new Quote();
		quote.setText(text);
		quote.setAuthor(author);
		quotesDAO.saveQuote(quote);
		
		assertEquals(quotesDAO.findAllQuotes().size(),3);
		
		
	}

}