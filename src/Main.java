import java.util.Date;
import java.util.Scanner;

import pattern.strategy.Emprunt;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Création de l'emprunt : tarifBase=100, seuil1=3, seuil2=7
        Emprunt emprunt = new Emprunt(
                1,
                new Date(),
                new Date(),
                new Date(),
                0,
                0.0,
                "",
                100,
                3,
                7
        );

        // Demander le nombre de jours de retard
        System.out.print("Entrez le nombre de jours de retard : ");
        int joursRetard = scanner.nextInt();

        // Calculer l'amende
        double amende = emprunt.calculerAmende(joursRetard);

        // Afficher le résultat
        System.out.println("Pour " + joursRetard + " jour(s) de retard, l'amende est de : " + amende + "€");

        scanner.close();
    }
}