import java.util.ArrayList;

public class Livreur extends Individu {
	
	
	private String idLivreur;
	private ArrayList<String> idCommandeTab;
	

	Livreur(String nom, String prenom, String adresse, String telephone, String email) {
		super(nom, prenom, adresse, telephone, email);
		
		idCommandeTab = new ArrayList<String>();

	
	
		}
	
		
	private static ArrayList<Livreur> allLivreur;
		
	
	public static int getNbLivreur() {
		return allLivreur.size()	;
	}
	
	public static void addLivreur(Livreur l) {
		allLivreur.add(l);
	}
	
	
	
	
		
	

}
