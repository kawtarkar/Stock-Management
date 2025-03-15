package Beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dao.ApprovisionnementDAO;
import entities.Articles_Stock;
@ManagedBean(name="modifier")
@RequestScoped()
public class Modifier {
    private String nom;
    private int id;
    private int prix;
    private String des;
    private int quantité;
    public static ApprovisionnementDAO dbObj;
    private List<Articles_Stock> Prod;
    private static final long serialVersionUID = 1L;
 
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getQuantité() {
        return quantité;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }
    // Method To Fetch Particular Student Details From The Database
    public List getStudentDetailsById() {
        System.out.println("Calling getStudentDetailsById() Method Details For Student Id?= " + id);
        dbObj = new ApprovisionnementDAO();       
        Prod = dbObj.getStudentById(id);
        for(Articles_Stock selectedStud : Prod) {
            nom= selectedStud.getNomArt();
            des= selectedStud.getDescArt();
            quantité= selectedStud.getQteArt();
            prix= selectedStud.getPrixArt();
        }
        System.out.println("Fetched Id? " + id + " Details Are: Name=" + nom + ", Department=" + prix);
        return Prod;
    }
	// Method To Delete A Particular Student Record From The Database
    public String delete() {
        try {
            // Créer une instance d'ApprovisionnementDAO pour effectuer l'opération de suppression
            ApprovisionnementDAO dao = new ApprovisionnementDAO();
            dao.deleteStudentInDb(id);
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
            Articles_Stock p = new Articles_Stock();
            p.setCodeArt(id); // Si l'ID est modifiable, sinon ne le définissez pas ici
            p.setNomArt(nom);
            p.setDescArt(des);
            p.setPrixArt(prix);
            p.setQteArt(quantité);
           
            // Définir les autres attributs en conséquence
            
            // Créer une instance d'ApprovisionnementDAO pour effectuer l'opération de mise à jour
            ApprovisionnementDAO dao = new ApprovisionnementDAO();
            dao.updateStudentRecord(p);
            
            // La mise à jour du produit a été effectuée avec succès
            return "succes";
        } catch (Exception e) {
            e.printStackTrace();
            // En cas d'erreur, afficher le message d'erreur et renvoyer un message d'erreur
            return "erreur";
        }
    }

}