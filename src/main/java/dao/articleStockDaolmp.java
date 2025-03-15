package dao;

import java.util.List;

import org.hibernate.Session ;
import org.hibernate.Transaction;

import configuration.configuration;
import entities.Articles_Approvisionnement;
import entities.Articles_Stock;
import entities.User;

public class articleStockDaolmp implements articleStockDao{

	
	@Override
	public List<Articles_Stock> getAll() {
		 Session session = new configuration().getSessionFactory().getCurrentSession();
		 Transaction transaction = session.beginTransaction();
		 List<Articles_Stock> users  = session.createQuery("from Articles_Stock").getResultList();
		 
		 transaction.commit();
		 session.close();
		 return users;
		 
	}
	@Override
	public Articles_Stock getById(int id) {
		Session session = new configuration().getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Articles_Stock produit  = session.get(Articles_Stock.class,id);
		 
		 transaction.commit();
		 session.close();
		 return produit;
	}
	



	@Override
	public void delete(Articles_Stock produit) {
		Session session = new configuration().getSessionFactory().getCurrentSession();
		 Transaction transaction = session.beginTransaction();
		 session.delete(produit);
		 transaction.commit();
		 session.close();
		
	}

	@Override
	public void update(Articles_Approvisionnement produit) {
		Session session = new configuration().getSessionFactory().getCurrentSession();
		 Transaction transaction = session.beginTransaction();
		 session.update(produit);
		 transaction.commit();
		 session.close();
		
	}

	@Override
	public void save(Articles_Approvisionnement produit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save1(Articles_Stock produit) {
		// TODO Auto-generated method stub
		Session session = new configuration().getSessionFactory().getCurrentSession();
		 Transaction transaction = session.beginTransaction();
		 session.save(produit);
		 
		 transaction.commit();
		 session.close();
		
	}
}
