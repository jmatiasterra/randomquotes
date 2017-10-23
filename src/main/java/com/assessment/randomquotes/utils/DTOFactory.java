/**
 * 
 */
package com.assessment.randomquotes.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.assessment.randomquotes.model.Author;
import com.assessment.randomquotes.model.AuthorDTO;
import com.assessment.randomquotes.model.Quote;
import com.assessment.randomquotes.model.QuoteDTO;

/**
 * @author mterraciano
 *
 */
@Component
public class DTOFactory {

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
		author.setQuotes(createQuotesDTO(a.getQuotes()));
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
	 * @param set
	 * @return
	 */
	public List<QuoteDTO> createQuotesDTO(Set<Quote> set) {
		List<QuoteDTO> quotes = new ArrayList<QuoteDTO>();
		for (Quote q : set) {
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
	
	public Author createAuthor(AuthorDTO a) {
		Author author = new Author();		
		author.setId(a.getId());
		author.setFirstName(a.getFirstName());
		author.setLastName(a.getLastName());
		author.setQuotes(createQuotes(a.getQuotes()));
		return author;		
	}
	
	public Quote createQuote(QuoteDTO q) {
		Quote quote = new Quote();
		quote.setId(q.getId());
		quote.setText(q.getText());
		return quote;
	}
	
	public Set<Quote> createQuotes(List<QuoteDTO> quotesDTO){
		Set<Quote> quotes = new HashSet<Quote>();
		for (QuoteDTO q : quotesDTO) {			
			Quote quote = createQuote(q);
			quotes.add(quote);			
		}
		return quotes;
	}

}