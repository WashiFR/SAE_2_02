/**
 * classe MainBellmanFord : classe principale qui permet de tester l'algorithme de Bellman-Ford
 */
public class MainBellmanFord {
    
    public static void main(String[] args) {

        BellmanFord bf = new BellmanFord();
        Graphe g = new GrapheListe("graphe.txt");

        Valeur v = bf.resoudre(g, "A");

        System.out.println(v.toString());

        // ====== Chemins ======
        System.out.println("Chemin de A vers A : " + v.calculerChemin("A"));
        System.out.println("Chemin de A vers B : " + v.calculerChemin("B"));
        System.out.println("Chemin de A vers C : " + v.calculerChemin("C"));
        System.out.println("Chemin de A vers D : " + v.calculerChemin("D"));
        System.out.println("Chemin de A vers E : " + v.calculerChemin("E"));
    }

}
