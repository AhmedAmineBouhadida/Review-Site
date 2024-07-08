package review_site;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class main_RS {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        EnsembleAvisP avisP = new EnsembleAvisP(); // ArrayList qui contient l'ensemble des avis desproduit
        EnsembleAvisSDL avisSDL = new EnsembleAvisSDL(); // ArrayList qui contient l'ensemble des avis siteloisirs
        Ensemble_visiteurs visiteurs  = new Ensemble_visiteurs() ; // ArrayList des visiteurs 
        Administrateur admin = new Administrateur(); // 1 seul admin 
         
        int choix;

        do {
            // Menu principal
        	System.out.println("|---------------------------------------------------------|");
        	System.out.println("|\t\tBienvenu dans notre site d'avis           |\n|                                                         |");
            System.out.println("|\t1-->Visiteur                                      |");
            System.out.println("|\t2-->Administrateur                                |");
            System.out.println("|\t3-->Exit                                          |");
            System.out.println("|---------------------------------------------------------|");
            System.out.println("¯↓¯ ");
            choix = s.nextInt();

            switch (choix) {
                case 1:
                {
                	System.out.println("|---------------------------------------------------------|");
                  	System.out.println("\t\tS'identifier :                    ");
                  	s.nextLine();
                	
                	System.out.println("\t↯");
                	String namevs = JOptionPane.showInputDialog("Votre nom  : ");
                	
                	String genrevs;
                	while (true) {
                    
                		System.out.println("\t↯");

                        genrevs = JOptionPane.showInputDialog("Donner votre genre (M ou F) : ");

                        if (genrevs.toUpperCase().equals("M") || genrevs.toUpperCase().equals("F"))
                        {
                            break; 
                        } 
                        
                        else 
                        {
                            JOptionPane.showMessageDialog(null, "Genre non valide. Veuillez entrer M ou F.", "Attention !", JOptionPane.WARNING_MESSAGE);
                        }
                    }

                    System.out.println("|---------------------------------------------------------|\n");
                    Visiteur x = new Visiteur(namevs, genrevs.toUpperCase());
                	visiteurs.ajouter(x);
                
                	// Menu Visiteur
                	int choix2;
                	do {
                		do {
	                	    System.out.println("|---------------------------------------------------------|");
	                	    System.out.println("|\t     Bienvenu "+namevs.toUpperCase()+"                   	          |");
	                	    System.out.println("|                                                         |");
	                	    System.out.println("|\t1~~>Publier un AVIS                               |");
	                	    System.out.println("|\t2~~>Consulter tout les avis                       |");
	                	    System.out.println("|\t3~~>Rechercher avis d'un objet bien determiné     |");
	                	    System.out.println("|\t4~~>Classement des produits selon categorie       |");
	                	    System.out.println("|\t5~~>Classement des Sites de loisirs selon Nom     |");
	                	    System.out.println("|\t6~~>Exit                                          |");
	                	    System.out.println("|---------------------------------------------------------|");
	                	    System.out.println("¯↓¯ ");
	                	    choix2 = s.nextInt();
                		}while((choix2<1) || (choix2>6));

                	    switch (choix2) 
                	    {
                	        case 1: 
                	        {
                	            //Ajouter un avis
                	            Avis a = new Avis();
                	            a.saisiravis(x.getNom());
                	            if (a.getObjetev() instanceof Produit)
                	                avisP.ajouteravis(a);
                	            else
                	                avisSDL.ajouteravis(a);
                	            System.out.println("==>votre avis a été ajouté avec succès");
                	            break;
                	        }

                	        case 2: 
                	        {
                	            // Consulter les avis
                	            int c;
                	            do {
                	                System.out.println(" ▶ Choisir le type d'objet à consulter ");
                	                System.out.println("\t1--> Consulter la totalité des produits ");
                	                System.out.println("\t2--> Consulter la totalité des Site de loisir ");
                	                c = s.nextInt();
                	            } while (c < 1 || c > 2);
                	            if (c == 1)
                	                avisP.afficheravisproduits();
                	            else
                	                avisSDL.afficheravisSDL();
                	            break;
                	        }

                	        case 3: 
                	        { // Rechercher avis
                	            int ch;
                	            do 
                	            	{
                	                System.out.println(" ▶ Choisir le type d'objet à consulter ");
                	                System.out.println("\t1--> Consulter les Produit ");
                	                System.out.println("\t2--> Consulter Site de loisir ");
                	                ch = s.nextInt();
                	            	} while (ch < 1 || ch > 2);
                	            
                	            switch (ch) {
                	                case 1: 
                	                {
                	                    // Rechercher avis pour les produits
                	                    int cho;
                	                    do {
                	                        System.out.println(" ▶ Choisir le critere de consultation du produit :  ");
                	                        System.out.println("\t1--> Par categorie : ");
                	                        System.out.println("\t2--> Par nom : ");
                	                        System.out.println("\t3--> Par marque :");
                	                        cho = s.nextInt();
                	                    	} while (cho < 0 || cho > 3);

                	                    	switch (cho) 
                	                    	{
                	                        	case 1: 
                	                        	{
                	                        		// Par categorie
                	                        		String categoriep;
                	                        		System.out.println(" ▶ Donner la categorie des produits pour afficher leurs avis :");
                	                        		categoriep = s.next();
                	                        		if (avisP.nbcat(categoriep) > 0) 
                	                        		{
                	                                System.out.println("Il existe " + avisP.nbcat(categoriep) +
                	                                        " avis pour la categorie " + categoriep + " :");
                	                                avisP.findcat(categoriep);
                	                        			} 
                	                        			else
                	                        				System.out.println("Il n'existe aucun avis pour la categorie " + categoriep);

                	                        	break;
                	                        	}

                	                        case 2: 
                	                        {
                	                            // Par nom
                	                            String nom1;
                	                            System.out.println(" ▶ Donner le nom complet du produit pour afficher l'avis ");
                	                            nom1 = s.next();
                	                            if (avisP.nbnom(nom1) > 0) 
                	                            {
                	                                System.out.println("Il existe " + avisP.nbnom(nom1) +
                	                                        " avis pour le nom " + nom1 + " : ");
                	                                avisP.findnom(nom1);                 
                	                            }
                	                            else
                	                                System.out.println("Il n'existe aucun avis pour le nom " + nom1 + " :");
                	                            break;
                	                        }

                	                        case 3: 
                	                        {
                	                            // Par marque
                	                            String marque1;
                	                            System.out.println(" ▶ Donner la marque des produits pour afficher leurs avis :");
                	                            marque1 = s.next();
                	                            if (avisP.nbmarque(marque1) > 0) 
                	                            {
                	                                System.out.println("Il existe " + avisP.nbmarque(marque1) +
                	                                        " avis pour la marque  " + marque1 + ":");
                	                                avisP.findmarque(marque1);
                	                                avisP.avg_marque(marque1);
                	                            }
                	                            	else
                	                            		System.out.println("Il n'existe aucun avis pour la marque " + marque1);
                	                          break;
                	                        }
                	                    }
                	                  break; 	
                	               }
                	                
                	                case 2: 
                	                {
                	                    // Rechercher avis pour les sites de loisirs
                	                    int critere;
                	                    do {
                	                        System.out.println(" ▶ Donner le critere de choix : ");
                	                        System.out.println("\t1--> Par nom  : ");
                	                        System.out.println("\t2--> Par ville : ");
                	                        System.out.println("\t3--> Par pays :");
                	                        System.out.println("\t4--> Par type :");
                	                        critere = s.nextInt();
                	                    } while (critere < 1 || critere > 4);
                	                    
                	                    switch (critere) 
                	                    {
                	                        case 1: 
                	                        { // Recherche par nom  
                	                            String n;
                	                            System.out.println(" ▶ Donner le nom complet du site de loisirs pour afficher l'avis ");
                	                            n = s.next();
                	                            if (avisSDL.nbnamesdl(n) > 0) {
                	                                System.out.println("Il existe " + avisSDL.nbnamesdl(n) + " d'avis pour le site de loisir " + n);
                	                                avisSDL.findname(n);
                	                                avisSDL.avg_name(n);
                	                            } else
                	                                System.out.println("Il n'existe aucun avis pour le site de loisirs " + n);

                	                            break;
                	                        }
                	                        
                	                        case 2: 
                	                        {  // Recherche par ville 
                	                            String l;
                	                            System.out.println(" ▶ Donner le nom de la ville des sites de loisirs pour afficher leurs avis :");
                	                            l = s.next();
                	                            if (avisSDL.nbville(l) > 0) {
                	                                System.out.println("Il existe " + avisSDL.nbville(l) + " d'avis pour la ville " + l);
                	                                avisSDL.findville(l);
                	                            } else
                	                                System.out.println("Il n'existe aucun avis pour les sites de loisirs de la ville " + l);
                	                            break;
                	                        }
                	                        
                	                        case 3: 
                	                        {		// recherche par pays 
                	                            String pay;
                	                            System.out.println(" ▶ Donner le nom du pays des sites de loisirs pour afficher leurs avis :");
                	                            pay = s.next();
                	                            if (avisSDL.nbpays(pay) > 0) {
                	                                System.out.println("Il existe " + avisSDL.nbpays(pay) + " d'avis pour le pays " + pay);
                	                                avisSDL.findpays(pay);
                	                            } else
                	                                System.out.println("Il n'existe aucun avis pour les sites de loisirs de la pays " + pay);
                	                            break;
                	                        }
                	                        
                	                        case 4: 
                	                        {		// recherche par type  
                	                            String t;
                	                            System.out.println(" ▶ Donner le type de site de loisir pour afficher les avis de ce type ");
                	                            t = s.next();
                	                            if (avisSDL.nbtypes(t) > 0)
                	                            {
                	                                System.out.println("Il existe " + avisSDL.nbtypes(t) + " avis pour le type " + t);
                	                                avisSDL.findtype(t);
                	                            } 
                	                            	else
                	                            		System.out.println("Il n'existe aucun avis pour les sites de loisirs de type " + t);
                	                          break;
                	                        }
                	                    }
                	                }
                	                break;
                	            }
         
                	            break;
                	        }
                	        
                	        case 4 : 
                	        {
                	        	System.out.println(" ▶ Choisir une categorie ");
                	        	String lacat = s.next(); 
                	        	avisP.classemnt_cat(lacat);
                	        	break ; 
                	        }
                	        
                	        case 5 : 
                	        {
                	        	System.out.println(" ▶ Choisir un Nom : ");
                	        	String n = s.next(); 
                	        	avisSDL.classemnt_catsdl(n);
                	        	s.nextLine(); 
                	        	break ; 
                	        }
                	        

                	     }	
                	} while (choix2 != 6);
                
                	break;
                }  

                case 2:
                {
                    // Menu Administrateur
					s.nextLine();
					String mdp;
					mdp= JOptionPane.showInputDialog("Saisir votre Mot de passe : ");
					if(mdp.equals(admin.getMdp()))
					{
                    int choixad;
                    do {
	                        do {
	                            System.out.println("\t|---------------------------------------------------------|");
	                            System.out.println("\t|\t \t⋇ Bienvenu Admin ⋇                        |");
	                            System.out.println("\t|\t1~~> Consulter la totalité des avis               |");
	                            System.out.println("\t|\t2~~> Supprimer un avis                            |");
	                            System.out.println("\t|\t3~~> Afficher les divers statistiques             |");
	                            System.out.println("\t|\t4~~> Exit                                         |");
	                            System.out.println("\t|---------------------------------------------------------|");
	                            System.out.println("¯↓¯ ");
	                            choixad = s.nextInt();
	                        }while (choixad < 1 || choixad > 4);

                        switch (choixad) 
                        {
                            case 1:
                            {
                                int k;
                                do {
                                    System.out.println(" ▶ choisir le type d'objet à consulter ");
                                    System.out.println("\t1--> Consulter la totalité des produits ");
                                    System.out.println("\t2--> Consulter la totalité des Site de loisir ");
                                    k = s.nextInt();
                                } while (k < 1 || k > 2);
                                if (k == 1)
                                    avisP.afficheravisproduits();
                                else
                                    avisSDL.afficheravisSDL();
                                
                                break;
                            }
                                
                            

                            case 2:
                            {
                                String vname;
                                String pname;
                                String sname;
                                int typeo;
                                do {
                                    System.out.println(" ▶ Donner le type de l'objet :");
                                    System.out.println("1---> Produit ");
                                    System.out.println("2---> Site de loisirs ");
                                    typeo = s.nextInt();
                                } while (typeo < 1 || typeo > 2);
                                System.out.println(" ▶ Donner le nom du propriétaire de l'avis a supprimer :");
                                vname = s.next();
                                if (typeo == 1) {
                                    System.out.println(" ▶ Donner le nom du produit a supprimer :  ");
                                    pname = s.next();
                                    avisP.supprimeravp(vname, pname);
                                } 
                                else 
                                {
                                    System.out.println(" ▶ Donner le nom du Site de loisir a supprimer :");
                                    sname = s.nextLine();
                                    avisSDL.supprimeravsdl(vname, sname);
                                }
                                
                                break;
                            }
                                

                            case 3 : 
                            {
                            	int chhoix ; 
                            	System.out.println(" ▶ Choisir la donnée que vous voulez avoir : ");
                            	do {
                            		System.out.println("1---> Le nombre d'avis postés");
                            		System.out.println("2---> Le nombre d'avis pour les produits ");
                            		System.out.println("3---> Le nombre d'avis pour les sites de loisirs ");
                            		System.out.println("4---> Le nombre de visiteurs totales ");
                            		System.out.println("5---> Le pourcentage du genre des visiteurs ");
                            		chhoix = s.nextInt();
                            	}while(1>chhoix || chhoix>5);  
                            		switch(chhoix)
                            		{
	                            		case 1 : 
	                            		{
	                            			System.out.println("\t✓ Le nombre d'avis total : ");
	                            			System.out.println("\t\t"+(avisP.getsize()+ avisSDL.getsize()));
	                            			
	                            			break ; 
	                            		}
	                            			
	                            		case 2 : 
	                            		{
	                            			System.out.println("\t✓ Le nombre d'avis pour les produits  ");
	                            			System.out.println("\t\t"+avisP.getsize());
	                            			
	                            			break ; 
	                            		}
	                            		
	                            		case 3 : 
	                            		{
	                            			System.out.println("\t✓ Le nombre d'avis pour les sites de loisirs ");
	                            			System.out.println("\t\t"+avisSDL.getsize());
	                            			
	                            			break ;
	                            		}
	                            		
	                            		case 4 : 
	                            		{
	                            				System.out.println("\t\tLa liste des visiteurs :\n");
	                            				visiteurs.afficher();
	                            				System.out.println("\t\n✓ Le nombre de visiteurs de ce site : ");
	                            				System.out.println("\t\t"+visiteurs.getsize());
	                            		
	                           				break;
	                           			}
	                            		
	                            		case 5 : 
	                            		{
	                            			System.out.println("Voici le pourcentage des visiteurs de votre site selon le genre : ");
	                            			visiteurs.pourGenre();
	                            			break ; 
	                            		}
                            		}
                            		
                            	break;
                            		}

                        		}
                    		} while (choixad != 4);
						}
					else 
					{
						int choixad;
						String emailad;
						 JOptionPane.showMessageDialog(null, "Le mot de passe que vous avez saisi est incorrecte", "Attention !", JOptionPane.WARNING_MESSAGE);
					
						 choixad= JOptionPane.showConfirmDialog(null, "voulez-vous renitialiser votre mot de passe ?" ,"Choisir !" ,JOptionPane.YES_NO_OPTION);
						
						 if(choixad==0)
						{
							emailad = JOptionPane.showInputDialog("Saisir l'email de l'administrateur :");
							if(emailad.equals(admin.getEmail()))
							{
								
								admin.setMdp(JOptionPane.showInputDialog("Saisir le nouveau mot de passe  :"));
								System.out.println("!!MDP modifier avec succees!!");
							}
							else
							{
								JOptionPane.showMessageDialog(null, "L'email saisi est incorrecte", "Attention !", JOptionPane.WARNING_MESSAGE);
								break;
							}
						}
						else
						{
							break;
						}
					}
					break;
                }
            }
        } while (choix != 3);
        
        s.close();
    }
    
}
