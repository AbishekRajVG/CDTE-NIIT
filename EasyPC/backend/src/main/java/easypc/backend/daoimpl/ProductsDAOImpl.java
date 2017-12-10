package easypc.backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import easypc.backend.dao.ProductsDAO;
import easypc.backend.dto.Products;

@Repository("prodDAO")
@Transactional
public class ProductsDAOImpl implements ProductsDAO {

	@Autowired
	private SessionFactory sessFac;

	// single
	@Override
	public Products get(int id) {

		try {
			return sessFac.getCurrentSession().get(Products.class, Integer.valueOf(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// multiple
	@Override
	public List<Products> list() {
		return sessFac.getCurrentSession().createQuery("FROM Products", Products.class).getResultList();
	}

	@Override
	public boolean add(Products prod) {

		try {
			sessFac.getCurrentSession().persist(prod);
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean update(Products prod) {

		try {
			sessFac.getCurrentSession().update(prod);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean delete(Products prod) {

		try {
			prod.setActive(false);
			return this.update(prod);

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Products> listActiveProducts() {
		String selectActiveProducts = "FROM Products WHERE active= :active";
		return sessFac.getCurrentSession().createQuery(selectActiveProducts, Products.class)
				.setParameter("active", true).getResultList();

	}

	@Override
	public List<Products> listActiveProductsByCategory(int category_id) {
		String selectActiveProductsByCategory = "FROM Products WHERE active= :active AND category_id= :category_id";
		return sessFac.getCurrentSession().createQuery(selectActiveProductsByCategory, Products.class)
				.setParameter("active", true).setParameter("category_id", category_id).getResultList();
	}

	@Override
	public List<Products> getLatestActiveProducts(int count) {
		
		
		return sessFac.getCurrentSession().createQuery("FROM Products WHERE active= :active ORDER BY  id", Products.class)
				.setParameter("active", true).setFirstResult(0).setMaxResults(count).getResultList();
		
	}

}
