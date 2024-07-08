package review_site;
import java.util.ArrayList;

import javax.swing.JOptionPane; 


public class EnsembleAvisP {

	ArrayList<Avis> tab = new ArrayList<Avis>();
	
	public void ajouteravis(Avis a)
	{
			tab.add(a);
	}
	
	public void afficheravisproduits()
	{
		if(!tab.isEmpty()) {
		for(int i = 0 ;  i< tab.size(); i++)
		tab.get(i).afficheravisp();
		}
		else 
			System.out.println("Desolé ! Pas d'avis ");
	}
	
	public void findcat(String cat) {
	    if (!tab.isEmpty()) {
	        for (int i = 0; i < tab.size(); i++) {
	            Produit p = (Produit) tab.get(i).getObjetev();
	            if (cat.equals(p.getCategorie())) { 
	                tab.get(i).afficheravisp();
	            }
	        }
	    } else {
	        System.out.println("Desolé ! Pas d'avis");
	    }
	}

	
	public int nbcat(String cat) {
		int test = 0 ; 
		if(!tab.isEmpty()) {	
			for(int i = 0 ;  i<tab.size();i++)
			{
				Produit p = (Produit) tab.get(i).getObjetev();
				if(cat.equals(p.getCategorie()))
				{
					test++;
				}
			}
		}
		return test ; 
	}
	
	public void findnom(String nom) {
		if(!tab.isEmpty()) {
			for(int i = 0 ; i<tab.size();i++)
			{
				Produit p = (Produit) tab.get(i).getObjetev();
				if(nom.equals(p.getNom_complet())) {
					tab.get(i).afficheravisp();
				}
			}
		}
		else 
			System.out.println("Desolé ! Pas d'avis");
	}
	
	public int  nbnom(String nom) {
		int test = 0 ; 
		if(!tab.isEmpty()) {
			for(int i = 0 ; i<tab.size();i++)
			{
				Produit p = (Produit) tab.get(i).getObjetev();
				if(nom.equals(p.getNom_complet())) {
					test++ ; 
					}
			}
		}
		return test ; 
	}
	
	public void findmarque(String marque) { 
		if(!tab.isEmpty()) {
			for(int i = 0 ; i<tab.size();i++) 
			{
				Produit p = (Produit) tab.get(i).getObjetev();
				if(marque.equals(p.getMarque())) {
					tab.get(i).afficheravisp();
				}
			}
		}
		else 
			System.out.println("Désolé ! pas d'avis");
		
	}
	
	public int nbmarque(String marque) { 
		int test = 0 ;
		if(!tab.isEmpty()) {
			for(int i = 0 ; i<tab.size();i++) 
			{
				Produit p = (Produit) tab.get(i).getObjetev();
				if(marque.equals(p.getMarque())) {
					test++ ; 
					}
				}
			}
		return test ; 
		}
	
	public void supprimeravp(String username, String prodname) 
	{
	    int i = 0;
	    boolean trouve = false;
	    if (tab.isEmpty()) {
	    	System.out.println("Il n'existe aucun avis !"); 	
	    	return ;  
	    	}
	    	
	    while (i < tab.size()) {
	        Avis avisProduit = tab.get(i);
	        Produit pr = (Produit) avisProduit.getObjetev();

	        if (username.equals(avisProduit.getNom()) && prodname.equals(pr.getNom_complet())) {
	            tab.remove(i);
	            trouve = true;
	            System.out.println("Avis supprimé avec succès");
	            break; 
	        }

	        i++;
	    }

	    if (!trouve) {
	        System.out.println("Avis n'existe pas dans la liste des avis");
	    }
	}
	
	public int getsize()
	{
		return tab.size(); 
	}
	
	public void sort()
	{
		tab.sort(null);
	}
	
	public void classemnt_cat(String cat )
	{
		if(!tab.isEmpty())
		{
			if(nbcat(cat)>0)
			{
				ArrayList <Avis> ordre = new ArrayList<Avis>(); 
				int i , j  ; 
				System.out.println("il existe " +nbcat(cat)+" avis de categorie "+cat+" voici leur classement selon les etoiles :");
				for(i = 0 ; i<tab.size();i++)
				{
					Produit p = (Produit)tab.get(i).getObjetev(); 
					if(cat.equals(p.getCategorie()))
					{
						ordre.add(tab.get(i)); 
					}
				}
				ordre.sort(null);
				for(j=0;j<ordre.size();j++)
				{
					ordre.get(j).afficheravisp();
				}
				
			}
			else 
			{
				System.out.println("Le produit n'existe pas ");
			}
		}
		else 
		{
			System.out.println("Il n'existe aucun avis  ");
		}
	}
	
	public void avg_marque(String marqueprod) {
	    if (!tab.isEmpty()) {
	        if (nbmarque(marqueprod) > 0) {
	            double somme = 0;
	            
	            int i;
	            for (i = 0; i < tab.size(); i++) {
	                Produit p = (Produit) tab.get(i).getObjetev();
	                if (marqueprod.equals(p.getMarque())) 
	                {
	                    somme = somme + tab.get(i).getNote();
	                }
	            }

	            if (nbmarque(marqueprod) > 0) {
	                somme = somme / nbmarque(marqueprod);
	                System.out.println("\nla moyenne des notes des produit de marque " + marqueprod + " est " + somme+"★");
	            } else {
	                System.out.println("Aucun avis trouvé pour le produit de marque " + marqueprod);
	            }
	        } else {
	            System.out.println("Le nom de la marque n'existe pas");
	        }
	    } else {
	        System.out.println("Il n'existe aucun avis !");
	    }
	}

}
	


