package review_site;

import java.util.Scanner;

public class Visiteur extends Utilisateur {

	public String genre ;  
	
	public Visiteur(String nom, String genre) {
		super(nom);
		this.genre = genre;
	}
	
	@Override
	public String toString() {
		return "  ↪ Nom : " + getNom() + " | ↪ Id : " + getId() + " | ↪ genre : " + genre + " |\n";
	}

	public Visiteur() {
		super();
		this.genre = "";
	}
	
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public void identifiervisiteur() {
		Scanner s =  new Scanner(System.in); 
		System.out.println("Donner votre nom : ");
		setNom(s.next()); 
		
	
		}
	}


