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
import com.assessment.randomquotes.model.QuoteDTO;
import com.assessment.randomquotes.utils.DTOFactory;

/**
 * @author mterraciano
 *
 */
@Service("quoteService")
@Transactional
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteDAO quoteDao;

	@Autowired
	private DTOFactory dtoFactory;

	@Override
	public QuoteDTO findById(long id) {
		Quote quote = quoteDao.findById(id);
		return dtoFactory.createQuoteDTO(quote);
	}

	@Override
	public Long createQuote(QuoteDTO q) {
		Quote quote = dtoFactory.createQuote(q);
		quoteDao.saveQuote(quote);
		return quote.getId();
	}

	@Override
	public void updateQuote(Long id, QuoteDTO quote) {
		Quote entity = quoteDao.findById(id);
		if (entity != null) {
			entity.setText(quote.getText());
		}

	}

	@Override
	public void deleteQuoteById(long id) {
		quoteDao.deleteById(id);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<QuoteDTO> findAllQuotes() {
		List<Quote> quotes = quoteDao.findAllQuotes();
		return dtoFactory.createQuotesDTO(quotes);
	}

}
