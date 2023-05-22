/**
 * Interface Algorithme qui permet de définir les méthodes communes aux algorithmes
 */
public interface Algorithme {

    /**
     * Méthode qui effectue l'algorithme sur un graphe
     * @param g graphe dont on veut trouver le plus court chemin
     * @param depart nom du noeud de départ
     * @return Valeur, objet contenant les valeurs et les parents des noeuds
     */
    public Valeur resoudre(Graphe g, String depart);
    
}
