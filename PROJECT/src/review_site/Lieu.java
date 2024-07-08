package review_site;

public class Lieu {
	private String ville ;  
	private String pays ;
	
	public Lieu(String ville, String pays) {
		super();
		this.ville = ville;
		this.pays = pays;
	}
	
	public Lieu() {
		ville = "";
		pays = "";
	}
	
	@Override
	public String toString() {
		return " * ville : " + ville + " + Pays : " + pays + " *";
	}

	public String getVille() {
		return ville;
	}
	
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public String getPays() {
		return pays;
	}
	
	public void setPays(String pays) {
		this.pays = pays;
	} 
	
}
