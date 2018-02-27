/**
 * 
 */
package com.assessment.randomquotes.resources.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.assessment.randomquotes.resource.dao.QuoteDAO;
import com.assessment.randomquotes.resource.model.Author;
import com.assessment.randomquotes.resource.model.Quote;
import com.assessment.randomquotes.resources.config.TestConfig;

/**
 * @author matias.terracciano
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
@WebAppConfiguration
public class QuotesDAOTest {

	@Autowired
	private QuoteDAO quotesDAO;

	@Test
	public void saveQuoteOK() {
		Author author = new Author(1, "Albert", "Einstein");

		Quote quote = new Quote(new Long(1),
				"Todos somos muy ignorantes, lo que ocurre es que no todos ignoramos las mismas cosas");
		quote.setAuthor(author);
		
		assertNotNull(quotesDAO);
		
		System.out.println("Anduvo==");

		Quote saveQuote = quotesDAO.findById(quote.getId());
		System.out.println(saveQuote.getText());
		System.out.println(quote.getText());

	}

}