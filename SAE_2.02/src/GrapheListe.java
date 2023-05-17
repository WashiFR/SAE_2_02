import java.util.ArrayList;

/**
 * Classe GrapheListe qui représente les données associées à un graphe
 */
public class GrapheListe implements Graphe {

    /**
     * Attribut contenant les noms des objets noeuds stockés
     */
    private ArrayList<String> ensNom;    

    /**
     * Attribut contenant les objets noeuds stockés
     */
    private ArrayList<Noeud> ensNoeud;

    /**
     * Constructeur de la classe GrapheListe
     */
    public GrapheListe(ArrayList<Noeud> noeuds) {
        this.ensNoeud = noeuds;
        this.ensNom = new ArrayList<String>();
        for(Noeud noeud : noeuds){
            this.ensNom.add(noeud.getNom());
        }
    }

    /**
     * Méthode qui permet d’ajouter des noeuds et des arcs à un objet GrapheListe
     * @param depart nom du nœud de départ
     * @param destination nom du nœud de destination
     * @param cout coût de l’arc
     */
    public void ajouterArc(String depart, String destination, double cout){
        // On vérifie que les noeuds existent
        if(this.ensNom.contains(depart) && this.ensNom.contains(destination)){
            // On parcourt la liste des noeuds du graphe
            for(Noeud noeud : this.ensNoeud){
                if(noeud.equals(new Noeud(depart))){
                    noeud.ajouterArc(destination, cout);
                    break; // On sort de la boucle car on a trouvé le noeud
                }
            }
        }
    }

    /**
     * Méthode qui retourne tous les noms des nœuds du graphe
     */
    public ArrayList<String> listeNoeuds(){
        return this.ensNom;
    }

    /**
     * Méthode qui retourne la liste des arcs partant du nœud donné
     * @param n nom du nœud
     */
    public ArrayList<Arc> suivants(String n){
        ArrayList<Arc> listeSuivant = new ArrayList<Arc>();

        // On parcourt la liste des noeuds du graphe
        for(Noeud noeud : this.ensNoeud){
            if(noeud.equals(new Noeud(n))){
                listeSuivant = noeud.getAdj();
                break; // On sort de la boucle car on a trouvé le noeud
            }
        }
        return listeSuivant;
    }

    /**
     * Méthode d'affichage du graphe
     */
    public String toString(){
        String s = "";
        // On parcourt la liste des noeuds du graphe
        for(Noeud noeud : this.ensNoeud){
            s += noeud.getNom() + " -> ";
            // On parcourt la liste des arcs adjacents du noeud
            for(Arc arc : noeud.getAdj()){
                s += arc.getDest() + "(" + arc.getCout() + ") ";
            }
            s += "\n";
        }
        return s;
    }

    /**
     * Méthode qui retourne le graphe au format Graphviz
     */
    public String toGraphviz(){
        String s = "digraph G {\n";
        // On parcourt la liste des noeuds du graphe
        for(Noeud noeud : this.ensNoeud){
            // On parcourt la liste des arcs adjacents du noeud
            for(Arc arc : noeud.getAdj()){
                s += noeud.getNom() + " -> " + arc.getDest() + " [label = " + arc.getCout() + "]\n";
            }
        }
        s += "}";
        return s;
    }
}
