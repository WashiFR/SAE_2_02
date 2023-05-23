import java.util.ArrayList;
import java.util.Collections;

/**
 * classe MainGraphe : classe principale du projet
 */
public class MainGraphe {
    
    public static void main(String[] args) {

        // ========== Graphe Manuel ==========
        
        // Création des Noeuds
        // ArrayList<Noeud> noeuds = new ArrayList<Noeud>();
        // Collections.addAll(noeuds,
        //     new Noeud("A"),
        //     new Noeud("B"),
        //     new Noeud("C"),
        //     new Noeud("D"),
        //     new Noeud("E")
        // );

        // Création du graphe
        // GrapheListe graphe = new GrapheListe(noeuds);

        // Ajout des arcs
        // graphe.ajouterArc("A", "B", 12);
        // graphe.ajouterArc("A", "D", 87);
        // graphe.ajouterArc("B", "E", 11);
        // graphe.ajouterArc("C", "A", 19);
        // graphe.ajouterArc("D", "B", 23);
        // graphe.ajouterArc("D", "C", 10);
        // graphe.ajouterArc("E", "D", 43);

        // Affichage des noeuds
        // System.out.println(graphe.toString());
        // System.out.println(graphe.toGraphviz());
        // System.out.println(graphe.listeNoeuds());

        // ========== Graphe Fichier ==========

        // Création du graphe
        // GrapheListe graphe2 = new GrapheListe("Graphe51.txt");

        // Affichage des noeuds
        // System.out.println(graphe2.listeNoeuds());

        // Affichage du graphe
        // System.out.println(graphe2.toString());

        // Affichage du graphe en format Graphviz
        // System.out.println(graphe2.toGraphviz());

        // ========== Matrice to Liste Arcs ==========

        // graphe2.matriceToArc("matrice.txt");

        // ========== Graphe Aléatoire ==========
        GrapheListe ga = new GrapheListe(10);

        // Affichage du graphe
        System.out.println(ga.toString());

        // Affichage du graphe en format Graphviz
        System.out.println(ga.toGraphviz());
    }

}
