package Beans;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.ApprovisionnementDAO;
import entities.Articles_Approvisionnement;
@ManagedBean(name="ajout")
@RequestScoped()

public class ajoute_apro {
	//public int codeArt;
    public String datePrevueLivraison;
    public int qteCommandé;

	public String getDatePrevueLivraison() {
		return datePrevueLivraison;
	}
	public void setDatePrevueLivraison(String datePrevueLivraison) {
		this.datePrevueLivraison = datePrevueLivraison;
	}
	public int getQteCommandé() {
		return qteCommandé;
	}
	public void setQteCommandé(int qteCommandé) {
		this.qteCommandé = qteCommandé;
	}
	 public String add() {
	        try {
	            // Créer une instance de la classe Articles_Stock et définir ses attributs
	            Articles_Approvisionnement p = new Articles_Approvisionnement();
	            
	           
	            p.setDatePrevueLivraison(datePrevueLivraison);
	            p.setQteCommandé(qteCommandé);

	            // Créer une instance d'ApprovisionnementDAO pour effectuer l'opération d'ajout
	            ApprovisionnementDAO dao = new ApprovisionnementDAO();
	            dao.save(p);

	            // Le produit a été ajouté avec succès
	            return "succes";
	        } catch (Exception e) {
	            e.printStackTrace();
	            // En cas d'erreur, afficher le message d'erreur et renvoyer un message d'erreur
	            return "erreur";
	        }
	    }
    
}