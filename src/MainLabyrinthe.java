import java.io.IOException;

/**
 * Classe MainLabyrinthe qui permet de tester la classe Labyrinthe
 */
public class MainLabyrinthe {

    public static void main(String[] args) throws IOException {

        // création d'un labyrinthe
        Labyrinthe laby = new Labyrinthe("laby1.txt");

        // création du graphe
        GrapheListe graphe = laby.genererGraphe();

        // affichage du graphe
        System.out.println(graphe.toString());

        BellmanFord bf = new BellmanFord();

        Valeur v1 = bf.resoudre(graphe, "(1,1)");
        System.out.println(v1.toString());
        for (String s : graphe.listeNoeuds()) {
            System.out.println("Chemin de (1,1) vers " + s + " : " + v1.calculerChemin(s));
        }

        Dijkstra dij = new Dijkstra();
        
        Valeur v2 = dij.resoudre(graphe, "(1,1)");
        System.out.println(v2.toString());
        for (String s : graphe.listeNoeuds()) {
            System.out.println("Chemin de (1,1) vers " + s + " : " + v2.calculerChemin(s));
        }
    }
    
}
