package review_site;

import java.util.Scanner;

public class Produit {
	private String categorie ; 
	private String nom ; 
	private String marque ;
	
	public Produit(String categorie, String nom, String marque) {
		super();
		this.categorie = categorie;
		this.nom = nom;
		this.marque = marque;
	}
	
	public Produit() {
		this.categorie = "";
		this.nom = "";
		this.marque = "";
	}

	@Override
	public String toString() {
		return "\t|▽Produit▽ 👉 categorie : " + categorie + " | 👉 nom : " + nom + " | 👉 marque : " + marque; }

	public String getCategorie(){
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getNom_complet() {
		return nom;
	}

	public void setNom_complet(String nom) {
		this.nom = nom;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}
	
	public void saisirprod()
	{	
		Scanner s =  new Scanner(System.in); 
		System.out.println("Donner le nom du produit : ");
		nom  = s.next(); 
		System.out.println("Saisir la categorie : ");
		categorie = s.next(); 
		System.out.println("Donner la marque : ");
		marque = s.next(); 
		
	}

}
