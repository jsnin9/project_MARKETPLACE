 
public class Main {

	public static void main(String[] args) throws NosExceptions {
		
		Fichier.initFichier();
		
		Fichier.chargementIndividu();
		Fichier.chargementContrat();
		Fichier.chargementProduit();
		Fichier.chargementCommande();
		
		
		//VENDEUR
		
		 //Vendeur.faireUnContrat();    /*ici on teste la creation d'un compte vendeur*/
		 //Vendeur.sidentifier("will", "tutu");  /*on renvoie le message d'ereur car ce compte n'existe pas*/
		 //int p = Vendeur.sidentifier("gis.com", "zik74x");  /*cette ligne ne doit pas �tre cach�e pour la suite*/
		 //System.out.println(p);   /*on affiche bien 1 qui est l'indice du deuxi�me vendeur*/
		 //Vendeur.getVendeur(p).publierProduit();
		// Vendeur.getVendeur(p).seConnecter();  /*connexion, la ligne doit rester ouverte*/
		 //Vendeur.getVendeur(p).publierProduit();
		 //  pour resilier son contrat
		 // pour supprimer un produit
		 
		 
		 
		 //CLIENT
		 
		 //Client.seCreerUnCompte();    /*ici on teste la creation d'un compte client*/
		 //Client.sidentifier("will", "tutu");  /*on renvoie le message d'ereur car ce compte n'existe pas*/
		// int q = Client.sidentifier("sharon7","asz4gl");  /*cette ligne ne doit pas �tre cach�e pour la suite*/
		 //System.out.println(q);   /*on affiche bien 1 qui est l'indice du deuxi�me vendeur*/
		 //Client.getClient(q).faireUneCommande();
		//Client.getClient(q).seConnecter();  /*connexion, la ligne doit rester ouverte*/
		//Produit.AfficherProduitDisponible();
		// Client.getClient(q).faireUneCommande();
		// Client.getClient(q).faireUneCommande();

		 //Client.getClient(q).faireUneCommande();

		// System.out.println(Commande.getNbCommande());
		//Client.getClient(q).consulterCommande();
		
		 

		 
		

		
		
		
		
		Fichier.actualisation();
	}}

