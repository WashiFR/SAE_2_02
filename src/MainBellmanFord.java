/**
 * classe MainBellmanFord : classe principale qui permet de tester l'algorithme de Bellman-Ford
 */
public class MainBellmanFord {
    
    public static void main(String[] args) {

        BellmanFord bf = new BellmanFord();
        Graphe g = new GrapheListe("graphe.txt");

        System.out.println(bf.resoudre(g, "A").toString());

        // ====== Chemins ======
        System.out.println("Chemin de A vers A : " + bf.resoudre(g, "A").calculerChemin("A"));
        System.out.println("Chemin de A vers B : " + bf.resoudre(g, "A").calculerChemin("B"));
        System.out.println("Chemin de A vers C : " + bf.resoudre(g, "A").calculerChemin("C"));
        System.out.println("Chemin de A vers D : " + bf.resoudre(g, "A").calculerChemin("D"));
        System.out.println("Chemin de A vers E : " + bf.resoudre(g, "A").calculerChemin("E"));
    }

}
