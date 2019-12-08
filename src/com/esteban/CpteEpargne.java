package com.esteban;

import java.util.Scanner;

public class CpteEpargne extends Compte {

    private double taux;

    public CpteEpargne() {
        super("Epargne");
        taux = controleTaux();
    }

    private double controleTaux() {

        double tmp;
        Scanner lectureClavier = new Scanner(System.in);

        do {
            System.out.print("Taux de placement : ");
            tmp = lectureClavier.nextDouble();
        }while (tmp < 0);

        return tmp;
    }

    public void afficherCpte() {
        super.afficherCpte();
        System.out.println("Taux d'épargne du compte : " + taux);

    }

    public double getTaux() {
        return taux;
    }

}
