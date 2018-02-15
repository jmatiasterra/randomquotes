/**
 * 
 */
package com.assessment.randomquotes.resource.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.assessment.randomquotes.resource.model.Quote;

/**
 * @author mterraciano
 *
 */
@Repository("quoteDAO")
public class QuoteDAOImpl extends AbstractDAO<Long, Quote> implements QuoteDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.assessment.randomquotes.dao.QuoteDAO#findById(long)
	 */
	@Override
	public Quote findById(long id) {

		return getByKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.assessment.randomquotes.dao.QuoteDAO#saveQuote(com.assessment.
	 * randomquotes.model.Quote)
	 */
	@Override
	public void saveQuote(Quote quote) {
		persist(quote);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.assessment.randomquotes.dao.QuoteDAO#deleteById(long)
	 */
	@Override
	public void deleteById(long id) {
		Query query = getSession().createSQLQuery("delete from quote where id = :id");
		query.setLong("id", id);
		query.executeUpdate();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.assessment.randomquotes.dao.QuoteDAO#findAllQuotes()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Quote> findAllQuotes() {
		Criteria criteria = createEntityCriteria();
		return (List<Quote>) criteria.list();
	}

	@Override
	public Quote findByAuthorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
