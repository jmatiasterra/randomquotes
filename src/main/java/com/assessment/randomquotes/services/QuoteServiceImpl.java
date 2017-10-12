/**
 * 
 */
package com.assessment.randomquotes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assessment.randomquotes.dao.QuoteDAO;
import com.assessment.randomquotes.model.Quote;

/**
 * @author mterraciano
 *
 */
@Service("quoteService")
@Transactional
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteDAO dao;

	@Override
	public Quote findById(long id) {
		return dao.findById(id);
	}

	@Override
	public Long createQuote(Quote quote) {
		dao.saveQuote(quote);
		return quote.getId();
	}

	@Override
	public void updateQuote(Quote quote) {
		Quote entity = dao.findById(quote.getId());
		if (entity != null) {
			entity.setText(quote.getText());
		}

	}

	@Override
	public void deleteQuoteById(long id) {
		dao.deleteById(id);

	}

	@Override
	public List<Quote> findAllQuotes() {
		return dao.findAllQuotes();
	}

}
