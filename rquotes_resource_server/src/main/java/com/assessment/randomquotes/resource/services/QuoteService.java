/**
 * 
 */
package com.assessment.randomquotes.resource.services;

import java.util.List;

import com.assessment.randomquotes.resource.model.QuoteDTO;

/**
 * @author matias.terracciano
 *
 */
public interface QuoteService {

	QuoteDTO findById(long id);

	Long createQuote(QuoteDTO quote);

	void updateQuote(Long id,QuoteDTO quote);

	void deleteQuoteById(long id);

	List<QuoteDTO> findAllQuotes();
	
	List<QuoteDTO> findQuotesByAuthorId(Long id);

}
