package entities;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="articles_stock")
public class Articles_Stock implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int codeArt;
	@Column(name="qteArt")
	private int qteArt;
	@Column(name="nomArt")
	private String nomArt;
	@Column(name="descArt")
	private String descArt;
	@Column(name="prixArt")
	private int prixArt;

	public Articles_Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Articles_Stock(int codeArt, int qteArt, String nomArt, String descArt, int prixArt) {
		super();
		this.codeArt = codeArt;
		this.qteArt = qteArt;
		this.nomArt = nomArt;
		this.descArt = descArt;
		this.prixArt = prixArt;
	}
	
	public int getCodeArt() {
		return codeArt;
	}
	public void setCodeArt(int codeArt) {
		this.codeArt = codeArt;
	}
	public int getQteArt() {
		return qteArt;
	}
	public void setQteArt(int qteArt) {
		this.qteArt = qteArt;
	}
	public String getNomArt() {
		return nomArt;
	}
	public void setNomArt(String nomArt) {
		this.nomArt = nomArt;
	}
	public String getDescArt() {
		return descArt;
	}
	public void setDescArt(String descArt) {
		this.descArt = descArt;
	}
	public int getPrixArt() {
		return prixArt;
	}
	public void setPrixArt(int prixArt) {
		this.prixArt = prixArt;
	}

}


