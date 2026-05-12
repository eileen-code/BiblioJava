package pattern.strategy;

import java.util.Date;

public class Emprunt {

    private int idEmprunt;
    private Date dateEmprunt;
    private Date dateRetourPrevue;
    private Date dateRetourReelle;
    private int joursRetard;
    private double amende;
    private String statut;

    private StrategieAmende strategie;

    public Emprunt(int idEmprunt, Date dateEmprunt, Date dateRetourPrevue) {
        this.idEmprunt = idEmprunt;
        this.dateEmprunt = dateEmprunt;
        this.dateRetourPrevue = dateRetourPrevue;
        this.statut = "EN_COURS";
        this.joursRetard = 0;
        this.amende = 0;
    }

    public void setStrategie(StrategieAmende strategie) {
        this.strategie = strategie;
    }

    public void retournerLivre(Date dateRetourReelle) {
        this.dateRetourReelle = dateRetourReelle;
        this.statut = "RETOURNE";
        calculerRetard();
    }

    public int calculerRetard() {
        long diff = dateRetourReelle.getTime() - dateRetourPrevue.getTime();
        int jours = (int) (diff / (1000 * 60 * 60 * 24));
        this.joursRetard = Math.max(0, jours);
        return this.joursRetard;
    }

    public double calculerAmende() {
        if (strategie == null) {
            throw new IllegalStateException("Aucune stratégie définie !");
        }

        this.amende = strategie.calculerAmende(joursRetard);
        return this.amende;
    }

    // Getters (optionnel mais recommandé)
    public int getJoursRetard() {
        return joursRetard;
    }

    public double getAmende() {
        return amende;
    }
}
