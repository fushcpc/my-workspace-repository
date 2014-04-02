package com.happycoding.utils;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author DavidChen(陈基明) 电话：13480721426 Email: cjmiou@gmail.com
 * @version 2010-4-23 下午10:45:02
 */
@SuppressWarnings("unchecked")
public abstract class GenericDao<T> extends HibernateDaoSupport {

	protected void removeObj(Class<T> clazz, long id) {
		T obj = (T) this.getHibernateTemplate().get(clazz, id);
		this.getHibernateTemplate().delete(obj);
	}

	protected void removeObjs(Class<T> clazz, List<Long> ids) {
		for (Long id : ids) {
			this.removeObj(clazz, id);
		}
	}

	protected void updateObj(T obj) {
		getHibernateTemplate().saveOrUpdate(obj);
	}

	protected void updateObjs(List<T> objs) {
		getHibernateTemplate().saveOrUpdateAll(objs);
	}

	protected T retrieveObj(Class<T> clazz, long id) {
		return (T) getHibernateTemplate().get(clazz, id);
	}

	protected List<T> retrieveObjs(String queryString) {
		return (List<T>) getHibernateTemplate().find(queryString);
	}

	protected List<T> retrieveObjs(String queryString, String value) {
		return (List<T>) getHibernateTemplate().find(queryString, value);
	}

	protected List<T> retrieveObjs(String queryString, String... values) {
		return (List<T>) getHibernateTemplate().find(queryString, values);
	}

	protected List<T> retrieveObjs(final String queryString, final String[] value, final int first, final int max) {
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(queryString);
				for (int i = 0; i < value.length; ++i) {
					query.setString(i, value[i]);
				}
				query.setFirstResult(first);
				query.setMaxResults(max);
				return (List<T>) query.list();
			}
		});
	}

	protected List<T> retrieveObjs(final String queryString, final String value, final int first, final int max) {
		String[] array = new String[] { value };
		return this.retrieveObjs(queryString, array, first, max);
	}

	protected T retrieveObj(String queryString) {
		return (T) getHibernateTemplate().find(queryString);
	}

	protected T retrieveObj(String queryString, String... value) {
		List<T> objs = this.retrieveObjs(queryString, value);
		if (objs != null && objs.size() != 0) {
			return objs.get(0);
		}
		return null;
	}

	protected void storeObj(T obj) {
		this.getHibernateTemplate().saveOrUpdate(obj);
	}

	protected void storeObjs(List<T> objs) {
		this.getHibernateTemplate().saveOrUpdateAll(objs);
	}

	protected Long retrieveObjsCount(final String queryString, final String... value) {
		return (Long) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("select count(*) " + queryString);
				for (int i = 0; i < value.length; ++i) {
					query.setString(i, value[i]);
				}
				return query.iterate().next();
			}
		});
	}

	protected Long retrieveObjsCount(final String queryString) {
		String[] value = new String[0];
		return this.retrieveObjsCount(queryString, value);
	}
}
