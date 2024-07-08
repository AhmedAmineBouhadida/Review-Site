package review_site;

public class Administrateur extends Utilisateur {
	 
	private  String mdp ;
	private final String email ; 
	public Administrateur() { 
		super("costamigo"); 
		this.mdp = "12345678";
		this.email = "costamigo@gmail.com" ; 
	}
	
	public String getMdp() {
		return mdp;
	}


	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	@Override
	public String toString() {
		return "Administrateur [mdp=" + mdp + ", NomAdmin=" + getNom() + ", Id=" + getId() + "]";
	}

	public String getEmail() {
		return email;
	}

}

