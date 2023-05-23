import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase MainDijkstra qui permet de lancer l'algorithme de Dijkstra
 */
public class MainDijkstra {

    public static void main(String[] args) {

        Dijkstra dijkstra = new Dijkstra();
        // Graphe g = new GrapheListe("graphe.txt");

        // Valeur v = dijkstra.resoudre(g, "A");

        // System.out.println(v.toString());

        // ====== Chemins ======
        // for (String s : g.listeNoeuds()) {
        //     System.out.println("Chemin de A vers " + s + " : " + v.calculerChemin(s));
        // }

        // ====== Temps d'execution ======
        ArrayList<String> fichiers = new ArrayList<String>();
        Collections.addAll(fichiers, 
            "graphe.txt",
            "Graphes1.txt",
            "Graphes11.txt",
            "Graphes51.txt",
            "Graphes101.txt",
            "Graphes501.txt",
            "Graphes1001.txt"
        );

        for (String fichier : fichiers) {

            System.out.println("Fichier: " + fichier);

            long moyenne = 0;
            int nbExec = 1000;

            for (int i = 0; i < nbExec; i++) {
                Graphe g = new GrapheListe("graphe.txt");
                
                long startTime = System.nanoTime();
                
                Valeur v = dijkstra.resoudre(g, "A");
        
                long endTime = System.nanoTime();
        
                // obtenir la différence entre les deux valeurs de temps nano
                long timeElapsed = endTime - startTime;

                moyenne += timeElapsed;
            }
    
            moyenne /= nbExec;
            System.out.println("Execution en nanosecondes: " + moyenne);
        }
    }
    
}
