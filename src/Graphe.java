import java.util.ArrayList;

/**
 * Interface Graphe 
 */
public interface Graphe {

    /**
     * Méthode qui retourne tous les nœuds du graphe
     */
    public ArrayList<String> listeNoeuds();

    /**
     * Méthode qui retourne la liste des arcs partant du nœud donné
     * @param n nom du nœud
     */
    public ArrayList<Arc> suivants(String n);
    
}
