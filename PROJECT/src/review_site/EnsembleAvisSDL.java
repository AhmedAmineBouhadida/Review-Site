package review_site;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class EnsembleAvisSDL {
	
	ArrayList <Avis> tab  =  new ArrayList<Avis>();  
	
	public void ajouteravis(Avis a ) {
		tab.add(a) ; 
	}
	
	public void afficheravisSDL() {
		
		if(!tab.isEmpty()) {	
		for(int i =  0 ;  i< tab.size(); i++)
			tab.get(i).afficheravisdl();
		}
		else 
			 System.out.println("Desolé ! Pas de avis ");
	}
	
	public void supprimeravsdl(String username, String sdlname) {
	    int i = 0;
	    boolean trouve = false;
	    if (tab.isEmpty()) {
	    	System.out.println("Il n'existe aucun avis !");
	    	return ;  
	    	}

	    while (i < tab.size()) {
	        Avis avisProduit = tab.get(i);
	        Sdl sdl1 = (Sdl) avisProduit.getObjetev();

	        if (username.equals(avisProduit.getNom()) && sdlname.equals(sdl1.getNom_complet())) {
	            tab.remove(i);
	            trouve = true;
	            System.out.println("cet avis a eté supprimé avec succès");
	            break; 
	        }

	        i++;
	    }

	    if (!trouve) {
	        System.out.println("Avis n'existe pas dans la liste des avis");
	    }
	}
	
	public void findname(String namesdl) {
		if(!tab.isEmpty()) {
			for(int i = 0 ;  i<tab.size();i++)
			{
				Sdl n = (Sdl) tab.get(i).getObjetev(); 
				if(n.getNom_complet().equals(namesdl))
				{
					tab.get(i).afficheravisdl();
				}
			}
		}
		 	else 
				System.out.println("Desolé ! Pas d'avis");
	}
	
	public int nbnamesdl(String n) {
		int test = 0 ; 
		if(!tab.isEmpty()) {	
			for(int i = 0 ;  i<tab.size();i++)
			{
				Sdl v = (Sdl) tab.get(i).getObjetev(); 
				if(v.getNom_complet().equals(n))
				{
					test++; 
				}
			}
		}
		 	return test ; 
	}
	
	public void findville(String v) {
		if(!tab.isEmpty()) {	
			int i = 0 ; 
			while(i<tab.size()) {
				Sdl x = (Sdl) tab.get(i).getObjetev(); 
				if(v.equals(x.getLieu().getVille())) {
					tab.get(i).afficheravisdl();
				}
				i++ ;
			}
		}
		 	else 
				System.out.println("Desolé ! Pas d'avis");
	}
	
	public int nbville(String v) {
		int test = 0 ; 
		if(!tab.isEmpty()) {	
			int i = 0 ; 
			while(i<tab.size()) {
				Sdl x = (Sdl) tab.get(i).getObjetev(); 
				if(v.equals(x.getLieu().getVille())) {
					test++ ;
				}
					i++ ;  
			}
		}
		return test ; 
	}
	
	public void findpays(String p) {
		if(!tab.isEmpty()) {	
			int i = 0 ; 
			while(i<tab.size()) {
				Sdl c = (Sdl) tab.get(i).getObjetev(); 
				if(p.equals(c.getLieu().getPays())) {
					tab.get(i).afficheravisdl();
				}
				i++ ; 
			}
			
		}
		 	else 
				System.out.println("Desolé ! Pas d'avis");
	}
	
	public int nbpays(String p) {
		int test = 0 ; 
		if(!tab.isEmpty()) {	
			int i = 0 ; 
			while(i<tab.size()) {
				Sdl x = (Sdl) tab.get(i).getObjetev(); 
				if(p.equals(x.getLieu().getPays())) {
					test++ ;
				}
				i++ ; 
			}
			
		}
		return test ; 
	}
	
	public void findtype(String ty )
	{
		if(!tab.isEmpty()) {	
			for(int i = 0 ; i<tab.size();i++)
			{
				Sdl t = (Sdl) tab.get(i).getObjetev();
				if(t.getType().equals(ty))
				{
					tab.get(i).afficheravisdl();
				}
			}
				
		}
		else 
			System.out.println("Desolé ! Pas d'avis");
	}
	
	public int nbtypes(String tps)
	{	
		int test = 0 ; 
		if(!tab.isEmpty())
		{
			for(int i = 0 ; i<tab.size();i++)
			{
				Sdl tpe = (Sdl) tab.get(i).getObjetev(); 
				if(tpe.getType().equals(tps))
				{
				test++ ;
				}
			}
		}
		return test ; 
	}
	
	public int getsize()
	{
		return tab.size(); 
	}
	
	public void classemnt_catsdl(String namesdl )
	{
		if(!tab.isEmpty())
		{
			if(nbnamesdl(namesdl)>0)
			{
				ArrayList <Avis> ordre = new ArrayList<Avis>(); 
				int i , j  ; 
				System.out.println("il existe " +nbnamesdl(namesdl)+" sites de loisirs de nom "+namesdl+" boici leur classement : ");
				for(i = 0 ; i<tab.size();i++)
				{
					Sdl sdl = (Sdl)tab.get(i).getObjetev(); 
					if(namesdl.equals(sdl.getNom_complet()))
					{
						ordre.add(tab.get(i)); 
					}
				}
				ordre.sort(null);
				
				for(j=0;j<ordre.size();j++)
				{
					ordre.get(j).afficheravisdl();
				}
				
			}
			else 
			{
				System.out.println("Le nom de ce site de loisir n'existe pas ");
			}
		}
		else 
		{
			System.out.println("Il n'existe aucun avis  ");
		}
	}
	
	public void avg_name(String nomsite) {
	    if (!tab.isEmpty()) {
	        if (nbnamesdl(nomsite) > 0) {
	            double somme = 0;
	            
	            int i;
	            for (i = 0; i < tab.size(); i++) {
	                Sdl sdll = (Sdl) tab.get(i).getObjetev();
	                if (nomsite.equals(sdll.getNom_complet())) 
	                {
	                    somme = somme + tab.get(i).getNote();
	                }
	            }

	            if (nbnamesdl(nomsite) > 0) {
	                somme = somme / nbnamesdl(nomsite);
	                System.out.println("\nla moyenne des notes du site de loisirs " + nomsite + " est " + somme+"★");
	            } else {
	                System.out.println("Aucun avis trouvé pour le site de loisirs" + nomsite);
	            }
	        } else {
	            System.out.println("Le du site de loisirs n'existe pas");
	        }
	    } else {
	        System.out.println("Il n'existe aucun avis !");
	    }
	}

}


