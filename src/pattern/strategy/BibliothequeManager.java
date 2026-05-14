package pattern.strategy;

import java.util.List;

/**
 * Classe BibliothequeManager - contexte du pattern Strategy.
 * Utilise une StrategieRecherche et peut en changer dynamiquement
 * sans modifier son code.
 */
public class BibliothequeManager {

    /** La stratégie de recherche actuellement utilisée */
    private SearchStrategy strategieRecherche;

    /** La liste de tous les livres de la bibliothèque */
    private List<String> books;

    /**
     * Constructeur
     * @param books la liste de livres de la bibliothèque
     */
    public BibliothequeManager(List<String> books) {
        this.books = books;
    }

    /**
     * Permet de changer la stratégie de recherche dynamiquement
     * @param s la nouvelle stratégie à utiliser
     */
    public void setSearchStrategy(SearchStrategy s) {
        this.strategieRecherche = s;
    }

    /**
     * Applique la stratégie de recherche sur la liste de livres
     * @param query la valeur recherchée
     * @return le livre correspondant à la recherche
     */
    public String appliquerRecherche(String query) {
        return strategieRecherche.search(query, books);
    }
}