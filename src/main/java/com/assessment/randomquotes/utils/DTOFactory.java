/**
 * 
 */
package com.assessment.randomquotes.utils;

import java.util.ArrayList;
import java.util.List;

import com.assessment.randomquotes.model.Author;
import com.assessment.randomquotes.model.AuthorDTO;
import com.assessment.randomquotes.model.Quote;
import com.assessment.randomquotes.model.QuoteDTO;

/**
 * @author mterraciano
 *
 */
public class DTOFactory {

	@SuppressWarnings("unchecked")
	/**
	 * 
	 * @param a
	 * @return
	 */
	public AuthorDTO createAuthorDTO(Author a) {
		AuthorDTO author = new AuthorDTO();
		author.setId(a.getId());
		author.setFirstName(a.getFirstName());
		author.setLastName(a.getLastName());
		author.setQuotes(createQuotesDTO((List<Quote>) a.getQuotes()));
		return author;
	}
	/**
	 * 
	 * @param q
	 * @return
	 */
	public QuoteDTO createQuoteDTO(Quote q) {
		QuoteDTO quote = new QuoteDTO();
		quote.setText(q.getText());
		quote.setId(q.getId());
		String authorFullName = q.getAuthor().getFirstName();
		if (q.getAuthor().getLastName() != null) {
			authorFullName += " " + q.getAuthor().getLastName();
		}
		quote.setAuthorName(authorFullName);
		return quote;
	}

	/**
	 * 
	 * @param quotesP
	 * @return
	 */
	public List<QuoteDTO> createQuotesDTO(List<Quote> quotesP) {
		List<QuoteDTO> quotes = new ArrayList<QuoteDTO>();
		for (Quote q : quotesP) {
			quotes.add(createQuoteDTO(q));
		}

		return quotes;
	}

	/**
	 * 
	 * @param authorsP
	 * @return
	 */
	public List<AuthorDTO> createAuthorsDTO(List<Author> authorsP) {
		List<AuthorDTO> authors = new ArrayList<AuthorDTO>();
		for (Author a : authorsP) {
			AuthorDTO author = createAuthorDTO(a);
			authors.add(author);
		}
		return authors;
	}

}
