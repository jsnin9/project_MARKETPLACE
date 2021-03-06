
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Client extends Membre {
	
	
	/*attributs non "satatic"*/
	
	private String idClient;
	
	Client(String nom, String prenom, String adresse, String telephone, String email, String pseudo, String password, String statut, String type){
		
        super(nom, prenom, adresse, telephone, email, pseudo, password,statut, type );
        this.idClient = super.getIdIndividu();
    }
	
	
	/*surcharge*/
	
	Client(String idft, String nom, String prenom, String adresse, String telephone, String email, String pseudo, String password, String statut, String type){
		
        super(idft, nom, prenom, adresse, telephone, email, pseudo, password,statut, type);
        this.idClient = super.getIdIndividu();
    }
	
	/*attributs  "satatic"*/


	private static ArrayList<Client> allClient = new ArrayList<Client>(); /*tableau de tous les clients*/

	
	public static void addClient(Client c) {
		allClient.add(c);
	}
	
	public static Client getClient(int indice) {
		return allClient.get(indice);
	}
	
	public static int getNbClient() {
		return allClient.size();
	}
	
	
	/*methodes non "static"*/
	
		
	public static int sidentifier(String psd, String pwd) {
			
			int p = 0;
			int test = 1;
			
			try {
				while (test == 1) {
					
					Client v = Client.getClient(p);
					
					if (v.getPseudo().equals(psd) && v.getPassword().equals(pwd)) {
						test = 0;
					}
					
					p++;
				}
				
			}
			catch(IndexOutOfBoundsException e) {
				
				System.out.println("\nAucun compte ne correspond ? ces coordonn?es");
			}
			
			return p-1;
	    }
	
	
		
	void consulterCommande() {
	    	
	    	try {
	    		
	    		Scanner sc = new Scanner(System.in);
	    		
	    		super.verif();
	    		
	    		ArrayList<Commande> ListCommande = new ArrayList<>();
	    		
	    		int tail_com = Commande.getNbCommande();
	    		
	    		for (int i = 0; i < tail_com ; i++) {
	    			
	    			Commande com = Commande.getCommande(i);
	    			
	    			if ((com.getIdClient() == idClient)) {
	    				
	    				ListCommande.add(com);
	    			}
	    		}
	    		
	    		int tail = ListCommande.size();
	    		
	    		if (tail > 0) {
	   
	    			System.out.println("\nVoici la liste de toutes vos commandes\n");
	    			
	    			for (int j = 1; j <= tail; j++) {
	    				
	    				Commande pj = ListCommande.get(j-1);
		    			ArrayList<String> idProduitJ = pj.getTabIdProduit();
	    				
		    			System.out.println("\n---> Commande n?"+j+" | sold? : "+ pj.getetatSolde() + "  |livre : "+ pj.getLivree());


		    			for (int p = 0; p < idProduitJ.size(); p++) {
		    				

		    				
		    				int test = 1;
		    				int cmp = 0;
		    				
		    				while ((test == 1) & (cmp < tail_com)) {
		    					Produit prd = Produit.getProduit(cmp);

		    					
		    					if (prd.getIdProduit() == idProduitJ.get(j-1)) {
		    						
		    						test = 0;
		    						System.out.println("      "+j+")"+prd.getNom()+"  |  "+prd.getPrix()+"euros");
		    					}
		    					
		    					cmp++;
		    				}
		    			}
	    				
	    			}
	    			
	    			System.out.println("Voulez vous validez une commande : \n--> oui : 1\n---> non : 2");
	    			int choix = Integer.parseInt(sc.nextLine());
	    			if(choix == 1) {
	    				System.out.println("laquelle ?");
	    					int choice = Integer.parseInt(sc.nextLine());
	    					int o = 0;
	    					int t = 1;
	    					while((o < tail_com) & (t == 1)) {
	    						if(ListCommande.get(choice).getIdCommande().equals(Commande.getCommande(o))) {
	    							Commande.getCommande(o).setEtatSolde(true);
	    							t = 0;
	    						}
	    						o++;
	    					}
	    			}
	    				    		}
	    		
	    		else {
	    			System.out.println("Vous n'avez aucune commande");
	    		}
	    	}
	    	catch(NosExceptions e ){
	    		System.out.println(e.getMessage());	
	    	}	    	
	    }
    
    
    
    
    
    public void faireUneCommande(){
    	
    	try {
    		super.verif();
    		
    		ArrayList<String> idProduits = new ArrayList<String>();
    		
    		@SuppressWarnings("resource")   /*qu'est ce que c'est*/
			Scanner sc = new Scanner(System.in);
    		
    		
    		int test = 1;
    		
    		while(test == 1) {  		
    		
	    		System.out.println("\nNom du produit : ");
	    		String nom = sc.nextLine();
	    		
	    		ArrayList<Produit> tabPrd = new ArrayList<>();
	    		
	    		
	    		for (int i = 0; i < Produit.getNbProduit(); i++) {
	
	    			Produit p = Produit.getProduit(i);
	    			
	    			if ((p.getNom().equals(nom)) && (p.getVendu() == false) ) {
	    				tabPrd.add(p);
	    			}
	    			
	    		}
	    		
	    		ArrayList<Produit> newTabPrd = Produit.triTableau(tabPrd);
	    		
	    		for (int i = 1; i <= newTabPrd.size(); i++) {
	    			System.out.println("   "+i+")"+" "+newTabPrd.get(i-1).getNom()+" : "+newTabPrd.get(i-1).getPrix()+" euros");
	    		}
	    		
	    		System.out.println("\nChoisissez le n? de produit que vous souhaitez");
	    		int choix  = Integer.parseInt(sc.nextLine());
	    		
	    		String id = newTabPrd.get(choix-1).getIdProduit();
	    		
	    		idProduits.add(id);
	    		
	    		int q = 0;
	    		int test1 = 1;
	    		
	    		
	    		while((q < Produit.getNbProduit()) && (test1 == 1)) {
	    			
	    			Produit p = Produit.getProduit(q);
	    			
	    			if (p.getIdProduit().equals(id)) {
	    				
	    				p.setVendu(true);
	    				test1 = 0;
	    			}
	    			q = q+1;	
	    		}
	    		
	    		System.out.println("\n---> Si vous voulez un autre produit : tapez sur 1\n---> Sinon : tapez sur 2");
	    		choix = Integer.parseInt(sc.nextLine());
	    		
	    		if (choix != 1) {
	    			
	    			SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss" );
	    			Date d = new Date();
	    					
	    			test = 0;
	    			
	    			System.out.println("\nVeuillez choisir le mode de livraison\n---> Maison : tapez 1\n---> Point r?lais : tapez 2");
		    		choix = Integer.parseInt(sc.nextLine());
		    		Boolean bool;
		    		if (choix == 1) {
		    			 bool = true;
		    		}
		    		else {
		    			bool = false;
		    		}
		    		
	    			Commande cmd = new Commande(s.format(d), idClient, null, idProduits, false, false, bool, false);
	    			Commande.addCommande(cmd);
	    		}
	    		
	    		
    		}

    		System.out.println("\n\nVeuillez validez votre commande dans l'espace d?di?\nNous vous remercions!");
    	}
    	
    	catch(NosExceptions e) {
    		System.out.println("n'importe quoi"); /*il y a d'autres exceptions ? voir*/
    	}
    }
    
    
    
    /*methode "static"*/

	
	public static void seCreerUnCompte() throws NosExceptions {  /*try catch*/
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nD?but de la cr?tion du compte client");

		System.out.println("\nEntrez votre nom");
		String nom = sc.nextLine();
		
		System.out.println("Entrez votre prenom");
		String prenom = sc.nextLine();
		
		System.out.println("Entrez votre adresse");
		String adresse = sc.nextLine();
		
		System.out.println("Entrez votre du telephone");
		String telephone = sc.nextLine();
		
		System.out.println("Entrez votre email");
		String email = sc.nextLine();
		
		System.out.println("Quel type de client souhaitez vous ?tre?\nParituclier ---> 1\nProfessionel --->2");
		
		String type = sc.nextLine();
		NosExceptions.verifChamp(type);
		
		int choix = Integer.parseInt(type);
		if(choix == 1) {
			type = "Particulier";
		}
		else {
			type = "Professionel";
		}

		
		System.out.println("Entrez votre pseudo");
		String pseudo = sc.nextLine();
		
		System.out.println("Entrez votre password");
		String password = sc.nextLine();
		
		Client c  = new Client(nom, prenom, adresse, telephone, email, pseudo, password, "Client", type);
		Client.addClient(c);
		
		System.out.println("\nVotre compte a bien ?t? cr??!");	
		
	}
	
	
	
	
	
}
