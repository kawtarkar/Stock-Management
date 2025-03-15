package Beans;



import entities.Articles_Stock;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.ApprovisionnementDAO;

@ManagedBean(name="ajoute")
@RequestScoped()
public class ajoute {
	//public Logger log=Logger.getLogger(ajoute.class);
	public String Nom ;
    public int Prix;
    public String Des;
    public int Quantité;
    static {
    	
    System.out.println("cccc");
    }
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public int getPrix() {
		return Prix;
	}
	public void setPrix(int prix) {
		Prix = prix;
	}
	public String getDes() {
		return Des;
	}
	public void setDes(String des) {
		Des = des;
	}
	public int getQuantité() {
		return Quantité;
	}
	public void setQuantité(int quantité) {
		Quantité = quantité;
	}
	private ApprovisionnementDAO dao;

    public ajoute() {
        dao = new ApprovisionnementDAO();
    }
  
    public String add() {
        try {
            // Créer une instance de la classe Articles_Stock et définir ses attributs
            Articles_Stock p = new Articles_Stock();
            p.setNomArt(Nom);
            p.setPrixArt(Prix);
            p.setDescArt(Des);
            p.setQteArt(Quantité);

            // Créer une instance d'ApprovisionnementDAO pour effectuer l'opération d'ajout
            ApprovisionnementDAO dao = new ApprovisionnementDAO();
            dao.save1(p);

            // Le produit a été ajouté avec succès
            return "succes";
        } catch (Exception e) {
            e.printStackTrace();
            // En cas d'erreur, afficher le message d'erreur et renvoyer un message d'erreur
            return "erreur";
        }
    }

}
