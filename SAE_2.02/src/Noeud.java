import java.util.ArrayList;

/**
 * classe Noeud qui représente les nœuds du graphe.
 */
public class Noeud {
    
    /**
     * Attribut nom correspondant au nom du nœud qui permet de l’identifier
     */
    private String nom;

    /**
     * Attribut adj contenant la liste des arcs reliant ce nœud à ses nœuds adjacents
     */
    private ArrayList<Arc> adj;

    /**
     * Constructeur de la classe Noeud
     * @param n nom du nœud
     */
    public Noeud(String n) {
        this.nom = n;
        this.adj = new ArrayList<Arc>();
    }

    /**
     * Méthode qui retourne la liste des arcs adjacents
     * @return ArrayList<Arc> liste des arcs adjacents
     */
    public ArrayList<Arc> getAdj() {
        return this.adj;
    }

    /**
     * Méthode qui permet de savoir si deux nœuds sont égaux
     * @param n nœud à comparer
     * @return true si les nœuds sont égaux, false sinon
     */
    public boolean equals(Noeud n) {
        return this.nom.equals(n.nom);
    }

    /**
     * Méthode qui permet d’ajouter un arc à la liste des arcs adjacents
     * @param destination nom du nœud de destination
     * @param cout coût de l’arc
     */
    public void ajouterArc(String destination, double cout) {
        this.adj.add(new Arc(destination, cout));
    }

}
