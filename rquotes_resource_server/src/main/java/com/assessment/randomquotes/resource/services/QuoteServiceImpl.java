/**
 * 
 */
package com.assessment.randomquotes.resource.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assessment.randomquotes.resource.dao.AuthorDAO;
import com.assessment.randomquotes.resource.dao.QuoteDAO;
import com.assessment.randomquotes.resource.model.Author;
import com.assessment.randomquotes.resource.model.AuthorDTO;
import com.assessment.randomquotes.resource.model.Quote;
import com.assessment.randomquotes.resource.model.QuoteDTO;
import com.assessment.randomquotes.resource.utils.DTOFactory;

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
	private AuthorDAO authorDao;

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
		Author savedAuthor = authorDao.findById(q.getAuthorId());
		quote.setAuthor(savedAuthor);
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

	@Override
	public List<QuoteDTO> findAllQuotes() {
		List<Quote> quotes = quoteDao.findAllQuotes();
		return dtoFactory.createQuotesDTO(quotes);
	}

	@Override
	public List<QuoteDTO> findQuotesByAuthorId(Long id) {
		AuthorDTO author = dtoFactory.createAuthorDTO(authorDao.findById(id));
		if (author == null) {
			return new ArrayList<QuoteDTO>();
		}
		return author.getQuotes();
	}

}
