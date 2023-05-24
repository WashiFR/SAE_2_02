import static libtest.Lanceur.*;
import static libtest.OutilTest.*;

import java.util.ArrayList;

/**
 * Classe {@code TestGraphe} tests unitaires de la classe Graphe
 */
public class TestGraphe {

    /**
     * lancement des tests
     * @param args
     */
    public static void main(String[] args) {
        lancer(new TestGraphe(), args);
    }

    /**
     * Test 01 : test de la méthode listeNoeuds()
     */
    public void test_01_listeNoeuds() {
        // Création des Noeuds
        ArrayList<Noeud> noeuds = new ArrayList<Noeud>();
        noeuds.add(new Noeud("A"));
        noeuds.add(new Noeud("B"));

        // Création du graphe
        GrapheListe graphe = new GrapheListe(noeuds);

        // Appel de la méthode à tester
        ArrayList<String> listeNoeuds = graphe.listeNoeuds();

        // Vérification du résultat
        assertEquals("La taille de la liste doit être 2", graphe.listeNoeuds().size(), listeNoeuds.size());
        assertEquals("Le premier noeud doit être A", "A", listeNoeuds.get(0));
        assertEquals("Le deuxième noeud doit être B", "B", listeNoeuds.get(1));
    }

    /**
     * Test 02 : test de la méthode ajouterArc() (et de la méthode suivants())
     */
    public void test_02_ajouterArc() {
        // Création des Noeuds
        ArrayList<Noeud> noeuds = new ArrayList<Noeud>();
        noeuds.add(new Noeud("A"));
        noeuds.add(new Noeud("B"));
        noeuds.add(new Noeud("C"));

        // Création du graphe
        GrapheListe graphe = new GrapheListe(noeuds);

        // Appel de la méthode à tester
        graphe.ajouterArc("A", "B", 12);
        graphe.ajouterArc("A", "C", 87);

        // Vérification du résultat
        ArrayList<Arc> listeArcs = graphe.suivants("A");
        assertEquals("La taille de la liste doit être 2", 2, listeArcs.size());
        assertEquals("Le premier arc doit être A -> B", "B", listeArcs.get(0).getDest());
        assertEquals("Le cout du premier arc doit être 12.0", 12.0, listeArcs.get(0).getCout());
        assertEquals("Le deuxième arc doit être A -> C", "C", listeArcs.get(1).getDest());
        assertEquals("Le cout du deuxième arc doit être 87.0", 87.0, listeArcs.get(1).getCout());
    }
    
}
