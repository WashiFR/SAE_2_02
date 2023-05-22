/**
 * Clase MainDijkstra qui permet de lancer l'algorithme de Dijkstra
 */
public class MainDijkstra {

    public static void main(String[] args) {

        GrapheListe graphe = new GrapheListe("graphe.txt");
        Dijkstra dijkstra = new Dijkstra();

        System.out.println(dijkstra.resoudre(graphe, "A").toString());

        // ====== Chemins ======
        System.out.println("Chemin de A vers A : " + dijkstra.resoudre(graphe, "A").calculerChemin("A"));
        System.out.println("Chemin de A vers B : " + dijkstra.resoudre(graphe, "A").calculerChemin("B"));
        System.out.println("Chemin de A vers C : " + dijkstra.resoudre(graphe, "A").calculerChemin("C"));
        System.out.println("Chemin de A vers D : " + dijkstra.resoudre(graphe, "A").calculerChemin("D"));
        System.out.println("Chemin de A vers E : " + dijkstra.resoudre(graphe, "A").calculerChemin("E"));
    }
    
}
