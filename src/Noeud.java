import java.util.ArrayList;

/**
 * Classe {@code Noeud} représentant les nœuds du graphe.
 */
public class Noeud {
    
    /**
     * Nom du nœud qui permet de l’identifier
     */
    private String nom;

    /**
     * Liste des arcs reliant ce nœud à ses nœuds adjacents
     */
    private ArrayList<Arc> adj;

    /**
     * Construit un {@code Noeud} à partir de son nom
     * @param n nom du nœud
     */
    public Noeud(String n) {
        this.nom = n;
        this.adj = new ArrayList<Arc>();
    }

    /**
     * Retourne le nom du nœud
     * @return {@code String} nom du nœud
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Retourne la liste des arcs adjacents
     * @return {@code ArrayList<Arc>} liste des arcs adjacents
     */
    public ArrayList<Arc> getAdj() {
        return this.adj;
    }

    /**
     * Compare les nœuds en fonction de leur nom (2 noeuds sont égaux si ils ont le même nom)
     * @param n nœud à comparer
     * @return {@code true} si les nœuds sont égaux, {@code false} sinon
     */
    public boolean equals(Noeud n) {
        return this.nom.equals(n.nom);
    }

    /**
     * Ajoute un {@code Arc} à la liste des arcs adjacents du nœud
     * @param destination nom du nœud de destination
     * @param cout coût de l’arc
     */
    public void ajouterArc(String destination, double cout) {
        this.adj.add(new Arc(destination, cout));
    }

}
