package fr.groupe12.terminalchess;

import java.util.List;
import java.util.Scanner;

import fr.groupe12.terminalchess.serialization.JSONWriter;


public class UserItf {
	
	public static Coordonnees selectPiece(Plateau plateau) {
		Scanner sc = new Scanner(System.in);
		String choix = sc.next();
		quitter(choix, plateau, sc);
		while(!correctPosition(choix.toUpperCase(), plateau)) {
			System.out.println("Saisie incorrect");
			choix = sc.next();
			quitter(choix, plateau, sc);
		}
		return new Coordonnees(choix.toUpperCase());
	}
	
	private static void quitter(String choix, Plateau plateau, Scanner sc) {
		if(choix.toUpperCase().equals("QUITTER")) {
			System.out.println("Voulez-vous sauvegarder ? (O/N)");
			String r = sc.next();
			while(!(r.toUpperCase().equals("O") || r.toUpperCase().equals("N"))) {
				System.out.println("Saisie incorrect");
				r = sc.next();
			}
			if(r.toUpperCase().equals("O")) {
				System.out.println("Donner un nom à la sauvegarde :");
				String name = sc.next();
				System.out.println("La partie a été sauvegardé");
				JSONWriter.saveGame(plateau, name);
				System.exit(0);
			} else {
				System.exit(0);
			}
		}
	}
	
	public static Coordonnees selectCase(List<Coordonnees> coords) {
		Scanner sc = new Scanner(System.in);
		String choix = null;
		boolean ok = false;
		while(!ok) {
			choix = sc.next();
			if(choix.toUpperCase().equals("RETOUR")) {
				return new Coordonnees(-1, -1);
			}
			if(correctFormat(choix.toUpperCase()) && Coordonnees.contains(coords, new Coordonnees(choix.toUpperCase()))) {
				ok = true;
			} else {
				System.out.println("Tu ne peux pas aller sur cette case !");
			}
		}
		return new Coordonnees(choix.toUpperCase());
	}
	
	
	
	public static boolean correctPosition(String entry, Plateau plateau) {
		if(correctFormat(entry)) {
			Coordonnees coo = new Coordonnees(entry);
			if(coo.getX() >= 0 && coo.getX() < 8 && coo.getY() >= 0 && coo.getY() < 8) {
				if(plateau.getPiece(coo) != null) {
					if((plateau.getTurn() && plateau.getPiece(coo).getColor() == Color.WHITE) || (!plateau.getTurn() && plateau.getPiece(coo).getColor() == Color.BLACK)) return true;
				}
			}
		}
		return false;
	}
	
	
	private static boolean correctFormat(String entry) {
		return entry.length() == 2 && Character.isLetter(entry.charAt(0)) && Character.isDigit(entry.charAt(1));
	}

}
