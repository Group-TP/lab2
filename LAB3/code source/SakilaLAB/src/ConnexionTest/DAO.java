package ConnexionTest;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import Model.Category;
import Model.Film;
import Util.RangeStrategy;
import Util.ShardSelectionStrategy;
import Util.ShardingStrategy;

public class DAO {

	ShardingStrategy strategy ;

	public DAO (ShardingStrategy strategy) {
		this.strategy = strategy;
	}
	
	public Category select (int category) {
		Transaction tx = null;
		Session session = null;
		session = Util.HibernateUtil.getShardDbSession(0);
		tx = session.beginTransaction();
		System.out.println("START");
		long startTime = System.nanoTime();
		Criteria c = session.createCriteria(Category.class)
				.add(Restrictions.eq("categoryId", category));

		Category cat = (Category) c.list().get(0);

		tx.commit();
		session.close();
		long endTime = System.nanoTime();
		long duration = (endTime - startTime)/ 1000000;

		System.out.println("read done " + duration);
		
		return cat;
	}
	
	public void insert (Category c) {

		Transaction tx = null;
		Session session = null;

		try {

			long startTime = System.nanoTime();
			
			session = Util.HibernateUtil.getShardDbSession(strategy.getShardId(c));
			tx = session.beginTransaction();
			session.save(c);
			tx.commit();
			

			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			
			System.out.println("DURANTION WRITE : " + duration);
			
		} catch (Exception e ) {
			tx.rollback();
		} finally {
			if (session != null) 
				session.close();
		}

	}
	
	public void delete (Category c) {

		Transaction tx = null;
		Session session = null;

		try {

			long startTime = System.nanoTime();
			
			session = Util.HibernateUtil.getShardDbSession(strategy.getShardId(c));
			tx = session.beginTransaction();
			session.delete(c);
			tx.commit();
			

			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			
			System.out.println("DURANTION Delete : " + duration);
			
		} catch (Exception e ) {
			tx.rollback();
		} finally {
			if (session != null) 
				session.close();
		}

	}

}
