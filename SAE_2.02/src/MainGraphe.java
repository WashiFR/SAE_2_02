/**
 * classe MainGraphe : classe principale du projet
 */
public class MainGraphe {
    
    public static void main(String[] args) {
        
        // Création du graphe
        Graphe graphe = new GrapheListe();
        
        // Ajout des Noeuds et des Arcs
        Noeud n1 = new Noeud("A");
        Noeud n2 = new Noeud("B");
        Noeud n3 = new Noeud("C");
        Noeud n4 = new Noeud("D");
        Noeud n5 = new Noeud("E");

        n1.ajouterArc("B", 12);
        n1.ajouterArc("D", 87);
        n2.ajouterArc("E", 11);
        n3.ajouterArc("A", 19);
        n4.ajouterArc("B", 23);
        n4.ajouterArc("C", 10);
        n5.ajouterArc("D", 43);

    }

}
