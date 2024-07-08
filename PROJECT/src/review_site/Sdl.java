package review_site;

import java.util.Scanner;

public class Sdl {
	private String nom;  
	private Lieu lieu ;  
	private String type ;
	
	public Sdl(String nom, Lieu lieu, String type) {
		super();
		this.nom = nom;
		this.lieu = lieu;
		this.type = type;
	}
	
	public Sdl() {
		
		this.nom = "";
		this.lieu = new Lieu();
		this.type = "";
	}
	
	public String getNom_complet() {
		return nom;
	}
	public void setNom_complet(String nom) {
		this.nom = nom;
	}
	
	public Lieu getLieu() {
		return lieu;
	}
	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "\t|▽Site de loisir▽ 👉nom : " + nom + "| 👉lieu=" + lieu + "| 👉type : " + type ;
	}
	
	public void saisirsdl()
	{
		Scanner s =  new Scanner(System.in);
		
		System.out.println("Saisir le nom  de site de loisir");
		nom  =  s.nextLine(); 
		
		System.out.println("Donner la ville du site de loisir :");
		lieu.setVille(s.nextLine());
		System.out.println("Donner le Pays du site de loisir : ");
		lieu.setPays(s.nextLine());
	
		System.out.println("Donner le type de site de loisir : ");
		type = s.next(); 
		
		
	}

}
