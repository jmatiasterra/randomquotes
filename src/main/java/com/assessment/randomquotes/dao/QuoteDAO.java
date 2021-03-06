/**
 * 
 */
package com.assessment.randomquotes.dao;

import java.util.List;

import com.assessment.randomquotes.model.Quote;

/**
 * @author mterraciano
 *
 */
public interface QuoteDAO {
	Quote findById(long id);
	void saveQuote(Quote quote);
	void deleteById(long id);
	List<Quote> findAllQuotes();
	Quote findByAuthorId(long id);
}
