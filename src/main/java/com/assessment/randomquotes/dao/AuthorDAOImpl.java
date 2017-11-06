/**
 * 
 */
package com.assessment.randomquotes.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.assessment.randomquotes.model.Author;

/**
 * @author jm
 *
 */
@Repository("authorDAO")
public class AuthorDAOImpl extends AbstractDAO<Long, Author> implements AuthorDAO {

	/* (non-Javadoc)
	 * @see com.assessment.randomquotes.dao.AuthorDAO#findById(int)
	 */
	@Override
	public Author findById(long id) {
		
		return getByKey(id);
	}

	/* (non-Javadoc)
	 * @see com.assessment.randomquotes.dao.AuthorDAO#saveAuthor(com.assessment.randomquotes.model.Author)
	 */
	@Override
	public void saveAuthor(Author author) {
		persist(author);

	}
	
	@Override
	public void updateAuthor(Author author) {
		update(author);

	}

	/* (non-Javadoc)
	 * @see com.assessment.randomquotes.dao.AuthorDAO#deleteById(int)
	 */
	@Override
	public void deleteById(long id) {
		Query query = getSession().createSQLQuery("delete from author where id = :id");
		query.setLong("id", id);
		query.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see com.assessment.randomquotes.dao.AuthorDAO#findAllAuthors()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Author> findAllAuthors() {
		Criteria criteria = createEntityCriteria().setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (List<Author>) criteria.list();
	}

}
