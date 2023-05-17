import java.util.ArrayList;

/**
 * classe MainGraphe : classe principale du projet
 */
public class MainGraphe {
    
    public static void main(String[] args) {
        
        // Création des Noeuds
        ArrayList<Noeud> noeuds = new ArrayList<Noeud>();
        noeuds.add(new Noeud("A"));
        noeuds.add(new Noeud("B"));
        noeuds.add(new Noeud("C"));
        noeuds.add(new Noeud("D"));
        noeuds.add(new Noeud("E"));

        // Création du graphe
        GrapheListe graphe = new GrapheListe(noeuds);

        // Ajout des arcs
        graphe.ajouterArc("A", "B", 12);
        graphe.ajouterArc("A", "D", 87);
        graphe.ajouterArc("B", "E", 11);
        graphe.ajouterArc("C", "A", 19);
        graphe.ajouterArc("D", "B", 23);
        graphe.ajouterArc("D", "C", 10);
        graphe.ajouterArc("E", "D", 43);

        // Affichage des noeuds
        System.out.println(graphe.toString());
        // System.out.println(graphe.listeNoeuds());
    }

}
