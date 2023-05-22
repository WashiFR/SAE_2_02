/**
 * class Arc qui représente un arc partant d’un nœud
 */
public class Arc {
    
    /**
     * Attribut dest qui représente le nom du nœud de destination de l’arc
     */
    private String dest;

    /**
     * Attribut cout qui représente le coût de l’arc
     */
    private double cout;

    /**
     * Constructeur de la classe Arc
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
     * Méthode qui retourne le nom du nœud de destination
     * @return String nom du nœud de destination
     */
    public String getDest() {
        return this.dest;
    }

    /**
     * Méthode qui retourne le coût de l’arc
     * @return double coût de l’arc
     */
    public double getCout() {
        return this.cout;
    }
}
