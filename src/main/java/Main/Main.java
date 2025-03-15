package Main;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import dao.articleStockDaolmp;
import entities.Articles_Approvisionnement;
import entities.Articles_Stock;


public class Main {
	
	public static void main(String[] args) {
		
		articleStockDaolmp dao = new articleStockDaolmp();

		
		Articles_Approvisionnement p = new Articles_Approvisionnement();
		
		 List<Articles_Stock> Products = dao.getAll();
//		 for (Articles_Stock prodVar : Products) {
//				
//				System.out.println("ProductName Est : "+prodVar.nomArt);
//
//
//			 }
			
	
//		p1 = dao.getArticleStockById(69);
//		dao.getById(1);
//		dao.save1(p1);//		dao.delete(p)
//		ProductInfo productIn = new ProductInfo(p1,category);;
//		System.out.println("Les Tables et ajoute par succse");
//		System.out.println("Category Est : "+productIn.categories.CategorieName);
//		System.out.println("ProductName Est : "+productIn.articles_stock.codeArt);
		

//		for (Articles_Stock prodVar : Products) {
//			Categories categorie = new Categories();
//			categorie = dao.getCategorieById(1);
//			System.out.println("Category Est : "+categorie.CategorieName);
//			System.out.println("ProductName Est : "+prodVar.nomArt);
//
//			Result.add(new ProductInfo(prodVar,categorie));
//		 }
//		
		
	}
}