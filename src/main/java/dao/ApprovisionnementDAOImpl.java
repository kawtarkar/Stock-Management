package dao;

import java.util.List;

import entities.Articles_Approvisionnement;
import entities.Articles_Stock;
public interface ApprovisionnementDAOImpl {

	public List<Articles_Stock> getAll1();
	public Articles_Approvisionnement getById(int id);
	
	public void save(Articles_Approvisionnement produit);
	public void save1(Articles_Stock produit);
	
	 public List getStudentById(int studentId) ;
	 public void deleteStudentInDb(int delStudentId);
	
	 public void updateStudentRecord(Articles_Stock updateStudentObj);
	 public void deleteProductInDb(int del_Id);
	 public List getProductById(int Id);
	 public void updateProduit1(Articles_Approvisionnement updateObj);
	 public List<Articles_Approvisionnement> getAll();
	

}
