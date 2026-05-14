package pattern.strategy;

import java.util.List;

/**
 * Classe SearchByISBN - implémente StrategieRecherche.
 * Stratégie de recherche d'un livre par son ISBN.
 */
public class SearchByISBN implements SearchStrategy {

    /**
     * Recherche un livre dont l'ISBN correspond à la requête
     * @param query l'ISBN recherché
     * @param books la liste de livres dans laquelle chercher
     * @return le livre trouvé, ou null si aucun résultat
     */
    @Override
    public String search(String query, List<String> books) {
        for (String livre : books) {
            if (livre.equalsIgnoreCase(query)) {
                return livre;
            }
        }
        return null;
    }
}