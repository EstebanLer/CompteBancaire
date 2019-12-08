package com.esteban;

import java.util.Scanner;

public class Compte {

    private String typeCpte;
    private double val_courante, taux;
    private String numeroCpte;
    private LigneComptable ligne;
    private int nbLigneReel;

    public Compte() {

        Scanner lectureClavier = new Scanner(System.in);
        typeCpte = controleType();
        System.out.print("Numéro du compte : ");
        numeroCpte = lectureClavier.next();
        val_courante = controleValInit();
        nbLigneReel = 0;
    }

    public Compte(String type) {

        Scanner lectureClavier = new Scanner(System.in);

        if(type.equalsIgnoreCase("Epargne")) {
            typeCpte = type;
            System.out.print("Numéro du compte : ");
            numeroCpte = lectureClavier.next();
            val_courante = controleValInit();
            nbLigneReel = 0;

        }
    }

    public String quelTypeDeCompte() {
        return typeCpte;
    }

    public double getVal_courante() {
        return val_courante;
    }

    public double getTaux() {
        return taux;
    }

    public String getNumeroCpte() {
        return numeroCpte;
    }

    public LigneComptable getLigne() {
        return ligne;
    }

    public int getNbLigneReel() {
        return nbLigneReel;
    }

    private String controleType() {

        char tmpc;
        String tmpS = "";
        Scanner lectureClavier = new Scanner(System.in);

        do {
            System.out.println("Type de compte [Types possibles : C(ourant), J(oint)] ");
            tmpc = lectureClavier.next().charAt(0);
        } while (tmpc != 'C' && tmpc != 'J');

        switch (tmpc) {

            case 'C':
                tmpS = "Courant";
                break;

            case 'J':
                tmpS = "Joint";
                break;

        }
        return tmpS;
    }

    private double controleValInit() {

        double tmp, tmpval;
        Scanner lectureClavier = new Scanner(System.in);

        do {
            System.out.print("Valeur initiale du compte : ");
            tmpval = lectureClavier.nextDouble();
        }while (tmpval <= 0);

        return tmpval;
    }

    public void creerCpte() {

        Scanner lectureClavier = new Scanner(System.in);

        typeCpte = controleType();

        System.out.println("Numéro du compte : ");
        numeroCpte = lectureClavier.next();
        if (typeCpte.equalsIgnoreCase("Epargne")) {
            System.out.println("Taux de placement : ");
            taux = lectureClavier.nextDouble();
        }
        val_courante = controleValInit();
    }

    public void creerLigne() {

        ligne = new LigneComptable();
        nbLigneReel = 1;
        val_courante = val_courante + ligne.getValeur();

    }

    public void afficherCpte() {

        System.out.println("Le compte n° : " + numeroCpte + " est un compte " +
                typeCpte);

        if (nbLigneReel > 0) {
            ligne.afficherLigne();
            System.out.println("Valeur courante : " + val_courante);
        }

        if (val_courante < 0) {
            System.out.println("Attention compte débiteur ... !");
        }


    }

}
