
import java.util.Date;
import java.util.Scanner;

import pattern.strategy.AmendeProgressive;
import pattern.strategy.AmendeStandard;
import pattern.strategy.Emprunt;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== SYSTEME DE BIBLIOTHEQUE ===");

        //  Création de l'emprunt
        Date dateEmprunt = new Date();

        System.out.println("Emprunt créé aujourd'hui : " + dateEmprunt);

        //  Demander délai de retour prévu
        System.out.print("Entrez nombre de jours pour le retour prévu : ");
        int joursPrevu = sc.nextInt();

        // calcul date retour prévue
        Date dateRetourPrevue = new Date(System.currentTimeMillis()
                + joursPrevu * 24L * 60 * 60 * 1000);

        // création emprunt
        Emprunt emprunt = new Emprunt(1, dateEmprunt, dateRetourPrevue);

        System.out.println("Date retour prévue : " + dateRetourPrevue);

        //  Simuler retour réel
        System.out.print("Entrez nombre de jours de retard réel : ");
        int joursRetardSimulation = sc.nextInt();

        Date dateRetourReelle = new Date(System.currentTimeMillis()
                + (joursPrevu + joursRetardSimulation) * 24L * 60 * 60 * 1000);

        emprunt.retournerLivre(dateRetourReelle);

        System.out.println("Date retour réelle : " + dateRetourReelle);

        //  Choix stratégie
        System.out.println("\nChoisissez une stratégie d'amende :");
        System.out.println("1 - Standard");
        System.out.println("2 - Progressive");
        System.out.print("Votre choix : ");
        int choix = sc.nextInt();

        //  Appliquer stratégie
        if (choix == 1) {

            emprunt.setStrategie(new AmendeStandard(100));
            System.out.println("Amende Standard : " + emprunt.calculerAmende());

        } else if (choix == 2) {

            emprunt.setStrategie(new AmendeProgressive(100, 3, 7));
            System.out.println("Amende Progressive : " + emprunt.calculerAmende());

        } else {
            System.out.println("Choix invalide !");
        }

        // . Affichage du retard réel
        System.out.println("Jours de retard : " + emprunt.getJoursRetard());

        sc.close();
    }
}