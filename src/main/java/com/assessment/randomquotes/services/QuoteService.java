/**
 * 
 */
package com.assessment.randomquotes.services;

import java.util.List;

import com.assessment.randomquotes.model.Quote;

/**
 * @author matias.terracciano
 *
 */
public interface QuoteService {
	
	Quote findById(long id);
	Long createQuote(Quote quote);
	void updateQuote(Quote quote);
	void deleteQuoteById(long id);
	List<Quote> findAllQuotes();

}
