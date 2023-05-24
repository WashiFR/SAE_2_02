/**
 * Class {@code Arc} représentant un arc partant d’un {@code Noeud} et allant vers un autre.
 */
public class Arc {
    
    /**
     * Nom du nœud de destination de l’arc
     */
    private String dest;

    /**
     * Coût de l’arc
     */
    private double cout;

    /**
     * Construit un {@code Arc} à partir du nom du nœud de destination et du coût de l’arc
     * @param d nom du nœud de destination
     * @param c coût de l’arc (doit être positif, sinon il est mis à 0)
     */
    public Arc(String d, double c) {
        this.dest = d;

        if(c < 0)
            this.cout = 0;
        else
            this.cout = c;
    }

    /**
     * Retourne le nom du nœud de destination
     * @return {@code String} nom du nœud de destination
     */
    public String getDest() {
        return this.dest;
    }

    /**
     * Retourne le coût de l’arc
     * @return {@code double} coût de l’arc
     */
    public double getCout() {
        return this.cout;
    }

    /**
     * Redéfinit la méthode {@code equals} pour la classe {@code Arc} (permet d'éviter qu'un noeud ait plusieurs arcs vers le même noeud)
     * @param destination nom du noeud de destination
     * @return {@code true} si les arcs sont égaux, {@code false} sinon
     */
    public boolean equals(String destination) {
        return this.dest.equals(destination);
    }
}
