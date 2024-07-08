package review_site;

import java.util.Scanner;

public class Utilisateur {
	private String nom  ;
	private int  id ;  

	
	public Utilisateur(String nom2) {
		super();
		this.nom = nom2;
		}
	
	public Utilisateur() {
		super();
		nom = "";
		id= 0 ; 
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int  getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	@Override
	public String toString() {
		return "Utilisateur [nom=" + nom + ", id=" + id + "]";
	}

	public void sasirutilisateur() {
		
		Scanner s  =  new Scanner(System.in); 
		System.out.println("Donner le nom : ");
		nom= s.next() ; 
		
		
		}
	}

