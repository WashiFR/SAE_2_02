import java.util.ArrayList;
import java.util.Collections;

/**
 * Class principale {@code MainBellmanFord} teste l'algorithme de Bellman-Ford
 */
public class MainBellmanFord {
    
    /**
     * Méthode principale
     * @param args arguments de la ligne de commande
     */
    public static void main(String[] args) {

        BellmanFord bf = new BellmanFord();
        // Graphe g = new GrapheListe("graphe.txt");

        // Valeur v = bf.resoudre(g, "A");

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
                
                Valeur v = bf.resoudre(g, "A");
        
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
