import static libtest.Lanceur.*;
import static libtest.OutilTest.*;

/**
 * Classe de test de l'algorithme de Bellman-Ford
 */
public class TestBellmanFord {

    /**
     * lancement des tests
     * @param args
     */
    public static void main(String[] args) {
        lancer(new TestBellmanFord(), args);
    }

    /**
     * Test 01 : test de la méthode resoudre()
     */
    public void test_01_resoudre() {

        // Création du graphe
        BellmanFord bf = new BellmanFord();
        Graphe g = new GrapheListe("graphe.txt");

        // Appel de la méthode à tester
        Valeur v = bf.resoudre(g, "A");

        // Vérification du résultat
        assertEquals("La valeur de A doit être 0.0", 0.0, v.getValeur("A"));
        assertEquals("La valeur de B doit être 12.0", 12.0, v.getValeur("B"));
        assertEquals("La valeur de C doit être 76.0", 76.0, v.getValeur("C"));
        assertEquals("La valeur de D doit être 66.0", 66.0, v.getValeur("D"));
        assertEquals("La valeur de E doit être 23.0", 23.0, v.getValeur("E"));
    }
    
}
