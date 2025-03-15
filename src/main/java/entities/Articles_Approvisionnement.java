package entities;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="articles_approvisionnement")
public class Articles_Approvisionnement implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int codeArt;
	@Column(name="qteCommandé")
	private int qteCommandé;
	@Column(name="datePrevueLivraison")
	private String datePrevueLivraison;
	public Articles_Approvisionnement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Articles_Approvisionnement(int codeArt, int qteCommandé, String datePrevueLivraison) {
		super();
		this.codeArt = codeArt;
		this.qteCommandé = qteCommandé;
		this.datePrevueLivraison = datePrevueLivraison;
	}
	public int getCodeArt() {
		return codeArt;
	}
	public void setCodeArt(int codeArt) {
		this.codeArt = codeArt;
	}
	public int getQteCommandé() {
		return qteCommandé;
	}
	public void setQteCommandé(int qteCommandé) {
		this.qteCommandé = qteCommandé;
	}
	public String getDatePrevueLivraison() {
		return datePrevueLivraison;
	}
	public void setDatePrevueLivraison(String datePrevueLivraison) {
		this.datePrevueLivraison = datePrevueLivraison;
	}
	
}

