 

public class MarketPlace {
	
	private static int id = 0;
	
	private int idMarketPlace;
	private String nomMarketPlace;
	
	MarketPlace(String nom) {
		idMarketPlace = id;
		nomMarketPlace = nom;
		id++;
	}
	
	
	public int getidMarketPlace() {
		return idMarketPlace;
	}
	
	public String getNom() {
		return nomMarketPlace;
	}
	
	public void resilierContrat(Contrat c) {
		c.setEtat(false);
	}
}
	
	
	
	
	
	
	
	
	
	
	

