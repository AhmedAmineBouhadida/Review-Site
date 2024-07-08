package review_site;

import java.util.Scanner;

public class Avis implements Comparable {


	private String nom  ;  
	private Object objetev ; 
	private int note ; 
	private String commentaire ;
	
	@Override
	public String toString() {
		return "Avis [nom=" + nom + ", categorie=" + objetev + ", note=" + note +"★ , commentaire = " + commentaire+ "]";
	}
	
	public Avis(String nom, Object objet, int note, String commentaire) {
		super();
		this.nom = nom;
		this.objetev = objet;
		this.note = note;
		this.commentaire = commentaire;
	}
	
	public Avis() {
		this.nom = ""; 
		this.objetev = "";
		this.note = -1;
		this.commentaire = "";
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	
	public Object getObjetev() {
		return objetev;
	}

	public void setObjetev(Object objetev) {
		this.objetev = objetev;
	}

	public int getNote() {
		return note;
	}
	
	public void setNote(int note) {
		this.note = note;
	}
	
	public String getCommentaire() {
		return commentaire;
	}
	
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	public void saisiravis(String esmvs)
	{	
		Scanner s = new Scanner(System.in); 
		
			
		nom = esmvs ; 
		int categorie = -1 ; 
		 do
	        {
	            System.out.println("\n~saisir l'objet a evaluer: ");
	            System.out.println("\t1-->Produit");
	            System.out.println("\t2-->Site de loisir");
	            categorie=s.nextInt();
	        }while((categorie<1) || (categorie>2));
		
	        if(categorie==1)
	        {
	            Produit p = new Produit();
	            p.saisirprod();
	            objetev=p;
	        }
	        else
	        {
	            Sdl d = new Sdl();
	            d.saisirsdl();
	            objetev=d;
	        }
		
		do {
			System.out.println("donner votre note : ");
			note= s.nextInt();
			}while(note<0 || note>5); 
		
	    s.nextLine();
	    
		System.out.println("Donner votre commentaire : ");
		commentaire= s.nextLine();
		
		
	}
	
	public void afficheravisp() {
		if(objetev instanceof Produit == true ) {
			Produit p = (Produit) objetev ; 
			System.out.println("\n");
			System.out.println(p);
			System.out.println("\t|▽Avis▽ 👉 nom de l'aviseur : "+nom+" | 👉 note : "+note+"★ | 👉 Commentaire : "+commentaire);
			System.out.println("\n");
		}
		}
	
	public void afficheravisdl() {
		if(objetev instanceof Sdl == true ) {
			Sdl sdl = (Sdl) objetev ; 
			System.out.println("\n");
			System.out.println(sdl);
			System.out.println("\t|▽Avis▽ 👉 nom de l'aviseur : "+nom+" | 👉 note : "+note+"★ | 👉 Commentaire : "+commentaire);
			System.out.println("\n");
		}
		
		}

	@Override
	public int compareTo(Object e) 
	{
		Avis o = (Avis) e ; 
		if(note>o.note)
		{
			return -1 ; 
		}
		else 
		{
			if(note<o.note)
				return 1 ; 
			else 
				return 0 ; 
		}
	}
	
	
	
}
	

	

