package pattern.strategy;

import java.util.Date;

/**
 * Classe Emprunt - représente l'emprunt d'un livre dans une bibliothèque.
 * en fonction du nombre de jours de retard lors du retour du livre.
 * Le calcul de l'amende se base sur des seuils de jours et un tarif de base.
 */
public class Emprunt {

    private int idEmprunt;
    private Date dateEmprunt;/* Date à laquelle le livre a été emprunté */
    private Date dateRetourPrevue;//Date à laquelle le livre devrait être rendu normalement
    private Date dateRetourReelle;//Date à laquelle le livre a été réellement rendu
    private int joursRetard;//Nombre de jours de retard par rapport à la date de retour prévue
    private double amende;//Montant de l'amende calculée en fonction des jours de retard
    private double tarifBase;//represente le prix qu'on applique par retard
    private int seuil1;//Premier seuil de jours de retard (ex: de 1 à 3 jours).En dessous ou égal à ce seuil, on applique le tarif de base simple.
    /**
     * Deuxième seuil de jours de retard (ex: de 4 à 7 jours).
     * Entre seuil1 et seuil2, on applique le tarif de base multiplié par 2.
     * Au delà de seuil2, on applique le tarif de base multiplié par 3.
     */
    private int seuil2;//(4-7 jours)


//Constructeur
    public Emprunt(int idEmprunt, Date dateEmprunt, Date dateRetourPrevue, Date dateRetourReelle, int joursRetard,
			double amende, String statut, double tarifBase, int seuil1, int seuil2) {
		this.idEmprunt = idEmprunt;
		this.dateEmprunt = dateEmprunt;
		this.dateRetourPrevue = dateRetourPrevue;
		this.dateRetourReelle = dateRetourReelle;
		this.joursRetard = 0;
		this.amende = 0.0;
		this.tarifBase = tarifBase;
		this.seuil1 = seuil1;
		this.seuil2 = seuil2;
	}

    
    /**
     * Calcule le montant de l'amende selon le nombre de jours de retard,
     * en appliquant 3 paliers de tarification :
     * - Palier 1 (<= seuil1) : joursRetard x tarifBase
     * - Palier 2 (seuil1 à seuil2) : tarif doublé pour les jours supplémentaires
     * - Palier 3 (> seuil2) : tarif triplé pour les jours supplémentaires
     *
     * @param joursRetard Nombre de jours de retard
     * @return Montant total de l'amende
     */
    public double calculerAmende(int joursRetard) {

        if (joursRetard <= seuil1) {
        	//tarif simple
            return joursRetard * tarifBase;
        } 
        else if (joursRetard <= seuil2) {
        	//tarif doublé pour les jours dépassant seuil1
            return (seuil1 * tarifBase) + 
                   ((joursRetard - seuil1) * (tarifBase * 2));
        } 
        else {
        	//tarif triplé pour les jours depassant le seuil2
            return (seuil1 * tarifBase)
                 + ((seuil2 - seuil1) * (tarifBase * 2))
                 + ((joursRetard - seuil2) * (tarifBase * 3));
        }
    }

    /** @return L'identifiant de l'emprunt */
    public int getIdEmprunt(){ 
    	return idEmprunt; 
    }

    /** @return La date à laquelle le livre a été emprunté */
    public Date getDateEmprunt(){ 
    	return dateEmprunt;
    }

    /** @return La date prévue pour le retour du livre */
    public Date getDateRetourPrevue() { 
    	return dateRetourPrevue; 
    }

    /** @return Le nombre de jours de retard */
    public int getJoursRetard(){
    	return joursRetard; 
    }

    /** @return Le montant de l'amende calculée */
    public double getAmende(){
    	return amende;
    }
}