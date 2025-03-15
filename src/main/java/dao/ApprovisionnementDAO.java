package dao;

import entities.Articles_Approvisionnement;
import entities.Articles_Stock;
import configuration.configuration;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;




public class ApprovisionnementDAO implements ApprovisionnementDAOImpl {
	@Override
	public List<Articles_Stock> getAll1() {
		Session session = configuration.getSessionFactory().getCurrentSession();
		 Transaction transaction = session.beginTransaction();
		 List<Articles_Stock> produit  = session.createQuery("from Articles_Stock").getResultList();
		 
		 transaction.commit();
		 session.close();
		 return produit;
		 
	}
	@Override
	public List<Articles_Approvisionnement> getAll() {
		Session session = configuration.getSessionFactory().getCurrentSession();
		 Transaction transaction = session.beginTransaction();
		 List<Articles_Approvisionnement> produit  = session.createQuery("from Articles_Approvisionnement").getResultList();
		 
		 transaction.commit();
		 session.close();
		 return produit;
		 
	}
	@Override
	public Articles_Approvisionnement getById(int id) {
		Session session = configuration.getSessionFactory().getCurrentSession();

		Transaction transaction = session.beginTransaction();
		Articles_Approvisionnement produit  = session.get(Articles_Approvisionnement.class,id);
		 
		 transaction.commit();
		 session.close();
		 return produit;
	}
	

	 // Method To Fetch Particular Student Details From The Database
	@Override
    @SuppressWarnings({ "unchecked", "unused" })
    public List getStudentById(int produitId) { 
    	Session session = configuration.getSessionFactory().getCurrentSession();
        Articles_Stock particularStuDObj = new  Articles_Stock();
        List particularStudentList = new ArrayList();            
        
        	 Transaction transaction = session.beginTransaction();
            Query queryObj = session.createQuery("from  Articles_Stock where id= :student_id").setInteger("student_id", produitId);          
            particularStuDObj = ( Articles_Stock)queryObj.uniqueResult();
            particularStudentList = queryObj.list();            
            System.out.println("Student Record With Id: " +produitId + " Is Fetched Successfully From Database");
 
            // XHTML Response Text
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("findStudentById",  produitId);
       
        	transaction.commit();
        
        return particularStudentList;
    }
    @Override
    public void deleteStudentInDb(int delproduitId) {
        Session session = configuration.getSessionFactory().getCurrentSession();
        Transaction transObj = session.beginTransaction();
        Articles_Stock studId = session.get(Articles_Stock.class, delproduitId);
        session.delete(studId);
        System.out.println("Student Record With Id: " +  delproduitId + " Is Successfully Deleted From Database");

        transObj.commit();
    }

  
 
    // Method To 

	@Override
	public void save(Articles_Approvisionnement produit) {
	    new configuration();
	    Session session = configuration.getSessionFactory().getCurrentSession();

	    Transaction transaction = session.beginTransaction();
	    session.save(produit);
	    transaction.commit();
	    session.close();
	}

	@Override
	public void save1(Articles_Stock produit) {
		// TODO Auto-generated method stub
		Session session = configuration.getSessionFactory().getCurrentSession();

		 Transaction transaction = session.beginTransaction();
		 session.save(produit);
		 
		 transaction.commit();
		 session.close();
		
	}

	 @Override
	 public void updateStudentRecord(Articles_Stock updateStudentObj) {
		 Session session =configuration.getSessionFactory().getCurrentSession();
	        Transaction transObj = session.beginTransaction();
				session.update(updateStudentObj);		
				System.out.println("Student Record With Id: " + updateStudentObj.getCodeArt() + " Is Successfully Updated In Database");	

		
				transObj.commit();
			}
	 
	 @Override
	    @SuppressWarnings({ "unchecked", "unused" })
	    public List getProductById(int Id) { 
	    	Session session = configuration.getSessionFactory().getCurrentSession();
	    	Articles_Approvisionnement particularStuDObj = new  Articles_Approvisionnement();
	        List particularStudentList = new ArrayList();            
	        
	        	 Transaction transaction = session.beginTransaction();
	            Query queryObj = session.createQuery("from  Articles_Approvisionnement where id= :student_id").setInteger("student_id", Id);          
	            particularStuDObj = ( Articles_Approvisionnement)queryObj.uniqueResult();
	            particularStudentList = queryObj.list();            
	            System.out.println("Student Record With Id: " +Id + " Is Fetched Successfully From Database");
	 
	            // XHTML Response Text
	            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("findStudentById",  Id);
	       
	        	transaction.commit();
	        
	        return particularStudentList;
	    }
	 
	 @Override
	    public void deleteProductInDb(int del_Id) {
	        Session session = configuration.getSessionFactory().getCurrentSession();
	        Transaction transObj = session.beginTransaction();
	        Articles_Approvisionnement studId = session.get( Articles_Approvisionnement.class, del_Id);
	        session.delete(studId);
	        System.out.println("Student Record With Id: " +  del_Id + " Is Successfully Deleted From Database");

	        transObj.commit();
	    }
	 
	 @Override
	 public void updateProduit1(Articles_Approvisionnement updateObj) {
		 Session session = configuration.getSessionFactory().getCurrentSession();
	        Transaction transObj = session.beginTransaction();
				session.update(updateObj);		
				System.out.println("Student Record With Id: " + updateObj.getCodeArt() + " Is Successfully Updated In Database");	

		
				transObj.commit();
			}
	 
		}
	
	







