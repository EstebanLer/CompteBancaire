package com.esteban;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        byte choix = 0;
        String numeroLu = "", vide = "";
        Compte C = new Compte(vide);

        Scanner lectureClavier = new Scanner(System.in);

        do {
            choix = menuPrincipal();
            switch (choix) {

                case 1 :
                    System.out.print("Compte Epargne (o/n) : ");
                    if (lectureClavier.next().charAt(0) == 'o') {
                        C = new CpteEpargne();
                    } else {
                        C.creerCpte();
                    }
                    break;

                case 2 :
                    System.out.print("Quel compte souhaitez vous afficher ? : ");
                    numeroLu = lectureClavier.next();
                    if (numeroLu.equalsIgnoreCase(C.getNumeroCpte())) {
                        C.afficherCpte();
                    } else {
                        System.out.println("Le système ne connait pas le compte " + numeroLu);
                    }
                    break;

                case 3 :
                    System.out.print("Pour quel compte souhaitez vous créer une ligne ? : ");
                    numeroLu = lectureClavier.next();
                    if (numeroLu.equalsIgnoreCase(C.getNumeroCpte())) {
                        C.creerLigne();
                    } else {
                        System.out.println("Le système ne connait pas le compte " + numeroLu);
                    }
                    break;

                case 4 :
                    sortir();
                    break;

                case 5 :
                    alAide();
                    break;

                default :
                    System.out.println("Cette option n'existe pas ");
            }

        } while (choix != 4);

    }

    public static byte menuPrincipal() {
        byte tmp;
        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("1. Création d'un compte");
        System.out.println("2. Affichage d'un compte");
        System.out.println("3. Ecrire une ligne comptable");
        System.out.println("4. Sortir");
        System.out.println("5. De l'aide");
        System.out.println();
        System.out.print("Votre choix : ");
        tmp  = lectureClavier.nextByte();
        return tmp;
    }

    public static void sortir() {

        System.out.println("Au revoir et à bientôt !");
        System.exit(0);

    }

    public static void alAide() {

        System.out.println("Option 1. Pour créer un compte Courant entrer C ");
        System.out.println("          Pour créer un compte Joint entrer J ");
        System.out.println("          Pour créer un compte Epargne entrer E");
        System.out.print("            Puis, entrer le numero du compte, et");
        System.out.println(" 			sa première valeur créditée ");
        System.out.println("          Dans le cas d'un compte épargne, entrer le taux ");
        System.out.println("Option 2. Le système affiche les données du compte choisi ");
        System.out.println("Option 3. Ecrire une ligne comptable");
        System.out.println("Option 4. Pour quitter le programme");
        System.out.println("Option 5. Pour afficher de l'aide");

    }
}
