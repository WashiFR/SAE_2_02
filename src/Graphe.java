import java.util.ArrayList;

/**
 * Interface Graphe 
 */
public interface Graphe {

    /**
     * Méthode qui retourne tous les nœuds du graphe
     * @return ArrayList<String> nom des nœuds
     */
    public ArrayList<String> listeNoeuds();

    /**
     * Méthode qui retourne la liste des arcs partant du nœud donné
     * @param n nom du nœud
     * @return ArrayList<Arc> liste des arcs du nœud
     */
    public ArrayList<Arc> suivants(String n);
    
}
