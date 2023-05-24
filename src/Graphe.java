import java.util.ArrayList;

/**
 * Interface {@code Graphe} qui définit les méthodes d'un graphe
 */
public interface Graphe {

    /**
     * Retourne tous les noms des {@code Noeud} du graphe
     * @return {@code ArrayList<String>} liste des noms des nœuds
     */
    public ArrayList<String> listeNoeuds();

    /**
     * Retourne la liste des arcs partant du nœud donné
     * @param n nom du nœud
     * @return {@code ArrayList<Arc>} liste des arcs du nœud
     */
    public ArrayList<Arc> suivants(String n);
    
}
