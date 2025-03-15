package dao;

import java.util.List;

import entities.Articles_Approvisionnement;
import entities.Articles_Stock;
import entities.User;

public interface articleStockDao {
	
	public List<Articles_Stock> getAll();
	
	//public Articles_Approvisionnement getById(int id);
	
	public Articles_Stock getById(int id);

	public void save(Articles_Approvisionnement produit);
	
	public void save1(Articles_Stock produit);
	
	public void delete(Articles_Stock produit);
	
	public void update(Articles_Approvisionnement produit);
	
//public Articles_Stock update(Articles_Stock produit);
	
	
}
