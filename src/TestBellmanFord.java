import static libtest.Lanceur.*;
import static libtest.OutilTest.*;

/**
 * Class {@code TestBellmanFord} tests de l'algorithme de Bellman-Ford
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
     * Test 01 : test de la méthode resoudre() avec A comme sommet de départ
     */
    public void test_01_resoudre_A() {

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

    /**
     * Test 02 : test de la méthode resoudre() avec B comme sommet de départ
     */
    public void test_02_resoudre_B() {

        // Création du graphe
        BellmanFord bf = new BellmanFord();
        Graphe g = new GrapheListe("graphe.txt");

        // Appel de la méthode à tester
        Valeur v = bf.resoudre(g, "B");

        // Vérification du résultat
        assertEquals("La valeur de A doit être 83.0", 83.0, v.getValeur("A"));
        assertEquals("La valeur de B doit être 0.0", 0.0, v.getValeur("B"));
        assertEquals("La valeur de C doit être 64.0", 64.0, v.getValeur("C"));
        assertEquals("La valeur de D doit être 54.0", 54.0, v.getValeur("D"));
        assertEquals("La valeur de E doit être 11.0", 11.0, v.getValeur("E"));
    }

    /**
     * Test 03 : test de la méthode resoudre() avec C comme sommet de départ
     */
    public void test_03_resoudre_C() {

        // Création du graphe
        BellmanFord bf = new BellmanFord();
        Graphe g = new GrapheListe("graphe.txt");

        // Appel de la méthode à tester
        Valeur v = bf.resoudre(g, "C");

        // Vérification du résultat
        assertEquals("La valeur de A doit être 19.0", 19.0, v.getValeur("A"));
        assertEquals("La valeur de B doit être 31.0", 31.0, v.getValeur("B"));
        assertEquals("La valeur de C doit être 0.0", 0.0, v.getValeur("C"));
        assertEquals("La valeur de D doit être 85.0",85.0, v.getValeur("D"));
        assertEquals("La valeur de E doit être 42.0", 42.0, v.getValeur("E"));
    }
}
