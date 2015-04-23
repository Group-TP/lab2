package ConnexionTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;

import Model.Category;
import Model.Country;
import Model.Film;
import Model.Payment;
import Util.RangeStrategy;




public class TestTest {

	public static void main(String[] args) {

		try {
			/*
			 * Creation of object that we will use to insert, select, or update data
			 * By giving as parameter the strategy that the sharding will implement
			 * 
			 * The strategies are in the package Util:
			 * - RangeStrategy
			 * - LookupStrategy
			 * - HashStrategy
			 * 
			 */
			DAO dao = new DAO(new RangeStrategy());

			dao.select(2);

			/*
			 * The following code source is used to split data from the 
			 * server node 0, which contains the whole sakila database,
			 * to the shards using one sharding strategy, which is instantiated 
			 * in the parametre of a previous instruction:
			 * 
			 * DAO dao = new DAO(new RangeStrategy());
			 * 
			 */

			/*
			 * 
			for ( int i = 1 ; i < 17 ; i++) {
			
			// Selection from the shard 0 , which contains everything.
				Transaction tx = null;
				Session session = null;
				session = Util.HibernateUtil.getShardDbSession(0);
				tx = session.beginTransaction();
				long startTime = System.nanoTime();
				Criteria c = session.createCriteria(Category.class)
						.add(Restrictions.eq("categoryId", i));


				Category category = (Category) c.list().get(0);

				tx.commit();
				session.close();

				long endTime = System.nanoTime();
				long duration = (endTime - startTime);

				System.out.println("read done " + duration);

			// Insert a category in the right shard
				dao.insert(category);


			}

			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
