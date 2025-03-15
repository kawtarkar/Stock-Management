package Beans;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.ApprovisionnementDAO;
import entities.Articles_Approvisionnement;
@ManagedBean(name="modifier_apro")
@RequestScoped()
public class modifier_apro {
	private int id;
	 public String datePrevueLivraison;
	 public int qteCommandé;
	  public static ApprovisionnementDAO dbObj;
	   private List<Articles_Approvisionnement> Prod;
	   private static final long serialVersionUID = 1L;
	public String getDatePrevueLivraison() {
		return datePrevueLivraison;
	}
	public void setDatePrevueLivraison(String datePrevueLivraison) {
		this.datePrevueLivraison = datePrevueLivraison;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getQteCommandé() {
		return qteCommandé;
	}
	public void setQteCommandé(int qteCommandé) {
		this.qteCommandé = qteCommandé;
	}
	  public List getStudentDetailsById() {
	        System.out.println("Calling getStudentDetailsById() Method Details For Student Id?= " + id);
	        dbObj = new ApprovisionnementDAO();       
	        Prod = dbObj.getProductById(id);
	        for(Articles_Approvisionnement selectedStud : Prod) {
	        	datePrevueLivraison = selectedStud.getDatePrevueLivraison() ;
	        	qteCommandé= selectedStud.getQteCommandé();
	        }
	        System.out.println("Fetched Id? " + id + " Details Are: Name=" + datePrevueLivraison + ", Department=" + qteCommandé);
	        return Prod;
	    }
		// Method To Delete A Particular Student Record From The Database
	    public String delete() {
	        try {
	            // Créer une instance d'ApprovisionnementDAO pour effectuer l'opération de suppression
	            ApprovisionnementDAO dao = new ApprovisionnementDAO();
	            dao.deleteProductInDb(id);
	            //FacesContext.getCurrentInstance().getExternalContext().redirect("Delete.xhtml"); 
	            // Le produit a été supprimé avec succès
	            return "succes";
	        } catch (Exception e) {
	            e.printStackTrace();
	            // En cas d'erreur, afficher le message d'erreur et renvoyer un message d'erreur
	            return "erreur";
	        }
	       
	       
	    }
	   
	   
	    public String update() {
	        try {
	            // Créer une instance de la classe Articles_Stock et définir ses attributs
	        	Articles_Approvisionnement p = new Articles_Approvisionnement();
	            p.setCodeArt(id); // Si l'ID est modifiable, sinon ne le définissez pas ici
	            p.setDatePrevueLivraison(datePrevueLivraison);
	            p.setQteCommandé(qteCommandé);
	            
	            // Définir les autres attributs en conséquence
	            
	            // Créer une instance d'ApprovisionnementDAO pour effectuer l'opération de mise à jour
	            ApprovisionnementDAO dao = new ApprovisionnementDAO();
	            dao.updateProduit1(p);
	            
	            // La mise à jour du produit a été effectuée avec succès
	            return "succes";
	        } catch (Exception e) {
	            e.printStackTrace();
	            // En cas d'erreur, afficher le message d'erreur et renvoyer un message d'erreur
	            return "erreur";
	        }
	    }


}