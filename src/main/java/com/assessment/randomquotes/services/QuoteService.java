/**
 * 
 */
package com.assessment.randomquotes.services;

import java.util.List;

import com.assessment.randomquotes.model.Quote;
import com.assessment.randomquotes.model.QuoteDTO;

/**
 * @author matias.terracciano
 *
 */
public interface QuoteService {

	Quote findById(long id);

	Long createQuote(QuoteDTO quote);

	void updateQuote(QuoteDTO quote);

	void deleteQuoteById(long id);

	List<QuoteDTO> findAllQuotes();

}
