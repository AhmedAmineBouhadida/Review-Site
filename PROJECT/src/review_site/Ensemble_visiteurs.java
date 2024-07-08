package review_site;

import java.util.ArrayList;

public class Ensemble_visiteurs {

	ArrayList<Visiteur> ens_vs = new ArrayList<Visiteur>(); 
	
	public void ajouter(Visiteur nome ) {
		nome.setId((ens_vs.size())+1);
		ens_vs.add(nome);  
	}
	public void afficher()
	{
		for(int i = 0 ;  i<ens_vs.size();i++)
			System.out.println("\tVisiteur Num "+(i+1)+" ⇛"+ens_vs.get(i));
	}
	
	public int getsize()
	{
		return ens_vs.size();
	}
	
	public void pourGenre() 
	{
	    float pourcentageMasculin = 0;

	    for (int i = 0; i < ens_vs.size(); i++) 
	    {
	        if (ens_vs.get(i).genre.equals("M")) 
	        {
	            pourcentageMasculin++;
	        }
	    }

	    float pourcentageFeminin = 100 - (pourcentageMasculin / ens_vs.size() * 100);

	    System.out.println("Le pourcentage des visiteurs de genre Masculin  : " + (pourcentageMasculin / ens_vs.size() * 100)+"%");
	    System.out.println("Le pourcentage des visiteurs de genre Féminin : " + pourcentageFeminin+"%");
	}
	
	
}
