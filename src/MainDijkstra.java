/**
 * Clase MainDijkstra qui permet de lancer l'algorithme de Dijkstra
 */
public class MainDijkstra {

    public static void main(String[] args) {

        Dijkstra dijkstra = new Dijkstra();
        Graphe g = new GrapheListe("graphe.txt");

        Valeur v = dijkstra.resoudre(g, "A");

        System.out.println(v.toString());

        // ====== Chemins ======
        System.out.println("Chemin de A vers A : " + v.calculerChemin("A"));
        System.out.println("Chemin de A vers B : " + v.calculerChemin("B"));
        System.out.println("Chemin de A vers C : " + v.calculerChemin("C"));
        System.out.println("Chemin de A vers D : " + v.calculerChemin("D"));
        System.out.println("Chemin de A vers E : " + v.calculerChemin("E"));
    }
    
}
