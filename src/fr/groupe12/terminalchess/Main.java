package fr.groupe12.terminalchess;

import java.io.File;
import java.util.Scanner;

import fr.groupe12.terminalchess.serialization.JSONReader;

public class Main {
    public static void main(String[] args) {
        String bienvenue = 
        "████████╗███████╗██████╗ ███╗   ███╗██╗███╗   ██╗ █████╗ ██╗          ██████╗██╗  ██╗███████╗███████╗███████╗\n"+
        "╚══██╔══╝██╔════╝██╔══██╗████╗ ████║██║████╗  ██║██╔══██╗██║         ██╔════╝██║  ██║██╔════╝██╔════╝██╔════╝\n"+
        "   ██║   █████╗  ██████╔╝██╔████╔██║██║██╔██╗ ██║███████║██║         ██║     ███████║█████╗  ███████╗███████╗\n"+
        "   ██║   ██╔══╝  ██╔══██╗██║╚██╔╝██║██║██║╚██╗██║██╔══██║██║         ██║     ██╔══██║██╔══╝  ╚════██║╚════██║\n"+
        "   ██║   ███████╗██║  ██║██║ ╚═╝ ██║██║██║ ╚████║██║  ██║███████╗    ╚██████╗██║  ██║███████╗███████║███████║\n"+
        "   ╚═╝   ╚══════╝╚═╝  ╚═╝╚═╝     ╚═╝╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝╚══════╝     ╚═════╝╚═╝  ╚═╝╚══════╝╚══════╝╚══════╝";
        String slogan = "La victoire est brillante mais l'échec est mat !";
        String choix = "Que voulez-vous faire ?";
        String un = "1. Commencer une nouvelle partie";
        String deux = "2. Continuer la dernière partie";
        String trois = "3. Quitter le jeu";

        
        Scanner sc = new Scanner(System.in);
        boolean verif = false;
        String saisie = null;
        while(!verif){
        	System.out.print(Ansi.clear);

            System.out.println(Ansi.Cyan.format(bienvenue));
            System.out.println(new Ansi(Ansi.ITALIC, Ansi.BLUE).format(slogan));
            System.out.println("\n\n\n");
            System.out.println(choix);
            System.out.println(Ansi.Green.format(un));
            System.out.println(Ansi.Yellow.format(deux));
            System.out.println(Ansi.Red.format(trois));
        	saisie = sc.next();
			if(saisie.equals("1")) {
				verif = true;
				
				System.out.print(Ansi.clear);
				
				Plateau plateau = new Plateau();
				plateau = plateau.init();
				plateau.start();
			}else if(saisie.equals("2")) {
				System.out.println(Ansi.clear);
				System.out.println("Liste des parties disponibles :");
				File dir = new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "saves");
				File[] files = dir.listFiles();
				int i = 1;
				if(files != null) {
					for(i=1; i<=files.length; i++) {
						System.out.println(i + " - " + files[i-1].getName());
					}
				}
				System.out.println(i + " - Quitter");
				String res = "";
				boolean bo = true;
				while(bo) {
					res = sc.next();
					if(Integer.valueOf(res) != null && Integer.valueOf(res) >= 1 && Integer.valueOf(res) <= (files.length+1)) bo = false;
					else System.out.println("Saisie incorrecte");
				}
				int save = Integer.valueOf(res);
				if(save != (files.length+1)) {
					Plateau plateau = JSONReader.loadPlateau(files[save-1].getPath());
					plateau.start();
				}
			}else if(saisie.equals("3")) {
				verif = true;
				System.out.print(Ansi.clear);
				System.exit(0);
			}else System.out.println("Saisie incorrect");
        }
    }
}