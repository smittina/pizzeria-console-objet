package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

/**
 * Classe principale
 * @author Formation
 *
 */
public class PizzeriaAdminConsoleApp {
	
	/**
	 * Permet d'afficher le menu pour l'utilisateur
	 * @param scan le Scanner
	 * @return le choix de l'utilisateur
	 */
	public int afficherMenu(Scanner scan) {
		int choixUser = -1;
		System.out.println("***** Pizzeria Administration *****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");
		choixUser = scan.nextInt();
		return choixUser;
		
	}
	
	/**
	 * Permet de lister l'intégralité des pizzas présentes dans le tableau de Pizza
	 * @param lesPizzas le tableau de Pizzas
	 */
	public void listerPizzas(Pizza[] lesPizzas) {
		System.out.println("LISTE DES DIFFERENTES PIZZAS");
		// Affichage des différentes pizzas
		for(int i=0; i<lesPizzas.length; i++) {
			System.out.println(lesPizzas[i].getCode()+" -> "+ lesPizzas[i].getLibelle()+" ("+lesPizzas[i].getPrix()+"€)");
		}
	}
	
	/**
	 * Permet d'ajouter une nouvelle Pizza dans le tableau de Pizza
	 * @param scan le Scanner
	 * @param lesPizzas le tableau de Pizza
	 * @return le nouveau tableau de pizzas
	 */
	public Pizza[] ajoutPizza(Scanner scan, Pizza[] lesPizzas) {
		// Déclarations des variables locales
		String code;
		String nom;
		double prix;
		System.out.println("AJOUTER UNE NOUVELLE PIZZA");
		System.out.println("Veuillez saisir le code : ");
		code = scan.next();
		System.out.println("Veuillez saisir le nom (sans Espace)");
		nom = scan.next();
		System.out.println("Veuillez saisir son prix (€)");
		prix = scan.nextDouble();
		
		// Instanciation de la nouvelle Pizza
		Pizza newPizza = new Pizza(code,nom,prix);
		
		// Ajout dans un nouveau tableau
		Pizza[] pizzasTemp = new Pizza[lesPizzas.length+1];
		for(int i = 0; i<lesPizzas.length;i++) {
			pizzasTemp[i] = lesPizzas[i];
		}
		pizzasTemp[lesPizzas.length] = newPizza;
		
		return pizzasTemp;
	}
	
	public void ajoutBisPizza(Scanner scan, Pizza[] lesPizzas) {
		// Déclarations des variables locales
		String code;
		String nom;
		double prix;
		System.out.println("AJOUTER UNE NOUVELLE PIZZA");
		System.out.println("Veuillez saisir le code : ");
		code = scan.next();
		System.out.println("Veuillez saisir le nom (sans Espace)");
		nom = scan.next();
		System.out.println("Veuillez saisir son prix (€)");
		prix = scan.nextDouble();

		// Instanciation de la nouvelle Pizza
		Pizza newPizza = new Pizza(code,nom,prix);

		// Ajout dans un nouveau tableau
		Pizza[] pizzasTemp = new Pizza[lesPizzas.length+1];
		for(int i = 0; i<lesPizzas.length;i++) {
			pizzasTemp[i] = lesPizzas[i];
		}
		pizzasTemp[lesPizzas.length] = newPizza;
		lesPizzas = pizzasTemp;
	}
	
	/**
	 * Permet de rechercher une pizza dans le tableau en fonction de son code
	 * @param code le code de la pizza à rechercher
	 * @param lesPizzas le tableau de Pizzas
	 * @return l'index de la pizza recherchée dans le tableau
	 */
	public int rechercherIndexPizza(String code, Pizza[] lesPizzas) {
		int index = -1;
		for(int i=0; i<lesPizzas.length;i++) {
			if(lesPizzas[i].getCode().equals(code)) {
				index = i;
			}
		}
		return index;
	}
	
	/**
	 * Permet de mettre à jour une pizza
	 * @param scan le Scanner
	 * @param lesPizzas le tableau de Pizza
	 */
	public void mettreAJourPizza(Scanner scan, Pizza[] lesPizzas) {
		// Déclarations et Initialisations
		String code;
		int indexPizza = -1;
		String newCode;
		String newLibelle;
		double newPrix;
		
		// Saisies
		System.out.println("MISE A JOUR D'UNE PIZZA");
		listerPizzas(lesPizzas);
		while(indexPizza == -1) {
			System.out.println("Veuillez choisir le code de la pizza à modifier : ");
			code = scan.next();
			indexPizza = rechercherIndexPizza(code,lesPizzas);
			if(indexPizza == -1) {
				System.out.println("Le Code Pizza saisi n'existe pas");
			}
		}
		System.out.println("Veuillez saisir le nouveau code :");
		newCode = scan.next();
		System.out.println("Veuillez saisir le nouveau Nom (sans espaces)");
		newLibelle = scan.next();
		System.out.println("Veuillez saisir le nouveau prix");
		newPrix = scan.nextDouble();
		
		// Mise à jour
		lesPizzas[indexPizza].setCode(newCode);
		lesPizzas[indexPizza].setLibelle(newLibelle);
		lesPizzas[indexPizza].setPrix(newPrix);
	}
	
	/**
	 * Permet de supprimer une pizza du tableau de Pizzas
	 * @param scan le scanner
	 * @param lesPizzas le tableau de pizzas
	 * @return le nouveau tableau de pizza sans la pizza qui a été supprimée
	 */
	public Pizza[] supprimerPizza(Scanner scan, Pizza[] lesPizzas) {
		// Déclarations et Initialisations des variables locales
		String code;
		int indexPizza =-1;
		
		System.out.println("SUPPRESSION D'UNE PIZZA");
		//Affichage de la liste des pizzas
		listerPizzas(lesPizzas);
		while(indexPizza == -1) {
			System.out.println("Veuillez choisir le code de la pizza à supprimer : ");
			code = scan.next();
			indexPizza = rechercherIndexPizza(code,lesPizzas);
			if(indexPizza == -1) {
				System.out.println("Le Code Pizza saisi n'existe pas");
			}
		}
		// Suppression et création du nouveau tableau de Pizzas
		Pizza[] pizzasTemp = new Pizza[lesPizzas.length-1];
		for(int i =0; i<indexPizza;i++) {
			pizzasTemp[i] = lesPizzas[i];
		}
		for(int i=indexPizza+1; i<lesPizzas.length;i++) {
			pizzasTemp[i-1] = lesPizzas[i];
		}
		
		return pizzasTemp;
	}
	
	/**
	 * Permet de dire "Au Revoir" à l'utilisateur
	 */
	public void direAuRevoir() {
		System.out.println("Au Revoir :(");
	}

	/**
	 * Main
	 * @param args tableau d'arguments
	 */
	public static void main(String[] args) {
		// Déclarations et initialisations
		PizzeriaAdminConsoleApp app = new PizzeriaAdminConsoleApp();
		Scanner questionUser = new Scanner(System.in);
		Pizza[] lesPizzas = new Pizza[8];
		lesPizzas[0] = new Pizza(0,"PEP", "Pépéroni",12.50);
		lesPizzas[1] = new Pizza(1,"MAR", "Margherita",14.00);
		lesPizzas[2] = new Pizza(2,"REIN", "La Reine",11.50);
		lesPizzas[3] = new Pizza(3,"FRO", "La 4 Fromages",12.00);
		lesPizzas[4] = new Pizza(4,"CAN", "La cannibale",12.50);
		lesPizzas[5] = new Pizza(5,"SAV", "La Savoyarde",13.00);
		lesPizzas[6] = new Pizza(6,"ORI", "L'Orientale",13.50);
		lesPizzas[7] = new Pizza(7,"IND", "L'indienne",14.00);
		
		// Affichage du premier menu
		int choixUser =	app.afficherMenu(questionUser);
		// Boucle de choix utilisateurs
		do {
			switch(choixUser) {
			case 1 :
				app.listerPizzas(lesPizzas);
				choixUser = app.afficherMenu(questionUser);
				break;
			case 2 :
				lesPizzas = app.ajoutPizza(questionUser, lesPizzas);
				choixUser = app.afficherMenu(questionUser);
				break;
			case 3 :
				app.mettreAJourPizza(questionUser, lesPizzas);
				choixUser = app.afficherMenu(questionUser);
				break;
			case 4 :
				lesPizzas = app.supprimerPizza(questionUser, lesPizzas);
				choixUser = app.afficherMenu(questionUser);
				break;
			case 99 :
				app.direAuRevoir();
				break;
			default :
				System.out.println("Mauvaise saisie ! Recommencez");
				choixUser = app.afficherMenu(questionUser);
				break;
			}
		}while(choixUser != 99);
		app.direAuRevoir();
		
		
		

	}

}
