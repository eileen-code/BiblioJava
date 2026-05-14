package pattern.strategy;

import java.util.List;

/**
 * Interface StrategieRecherche - définit le contrat pour toutes les stratégies de recherche.
 * Toute classe qui implémente cette interface devra obligatoirement
 * définir la méthode search.
 */
public interface SearchStrategy {

    /**
     * Recherche un livre dans la liste selon une requête
     * @param query la valeur recherchée (ex: ISBN)
     * @param books la liste de livres dans laquelle chercher
     * @return le titre du livre trouvé, ou null si aucun résultat
     */
    String search(String query, List<String> books);
}