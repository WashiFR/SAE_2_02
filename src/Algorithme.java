/**
 * Interface {@code Algorithme}  définit les méthodes communes aux algorithmes (Dijkstra et Bellman-Ford)
 */
public interface Algorithme {

    /**
     * Effectue l'algorithme sur un graphe
     * @param g graphe dont on veut trouver le plus court chemin
     * @param depart nom du noeud de départ
     * @return {@code Valeur} objet contenant les valeurs et les parents des noeuds
     */
    public Valeur resoudre(Graphe g, String depart);
    
}
