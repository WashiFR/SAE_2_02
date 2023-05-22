import java.util.ArrayList;

/**
 * Classe qui effectue l'algorithme de Dijkstra sur un graphe
 */
public class Dijkstra implements Algorithme {

    /** ====== Algorithme : ======
        Entrées :
        - G un graphe orienté avec une pondération (poids) positive des arcs
        - A un sommet (départ) de G

        Début
        Q <- {} // * utilisation d’une liste de noeuds à traiter
        Pour chaque sommet v de G faire
            v.distance <- Infini
            v.parent <- Indéfini
            Q <- Q U {v} // * ajouter le sommet v à la liste Q
        Fin Pour

        A.distance <- 0
        Tant que Q est un ensemble non vide faire
            u <- un sommet de Q telle que u.distance est minimale
            Q <- Q \ {u} // * enlever le sommet u de la liste Q
            Pour chaque sommet v de Q tel que l’arc (u,v) existe faire
                D <- u.distance + poids(u,v)
                Si D < v.distance
                    Alors v.distance <- D
                        v.parent <- u
                Fin Si
            Fin Pour
        Fin Tant que
        Fin
     */

    /**
     * Méthode qui effectue l'algorithme de Dijkstra sur un graphe
     * @param g graphe dont on veut trouver le plus court chemin
     * @param depart nom du noeud de départ
     * @return Valeur, objet contenant les valeurs et les parents des noeuds
     */
    public Valeur resoudre(Graphe g, String depart) {
        ArrayList<String> noeuds = new ArrayList<String>();
        Valeur v = new Valeur();
        for (String s : g.listeNoeuds()) {
            v.setValeur(s, Integer.MAX_VALUE);
            v.setParent(s, null);
            noeuds.add(s);
        }

        v.setValeur(depart, 0);
        while(!noeuds.isEmpty()) {
            String u = noeuds.get(0);
            for (String s : noeuds) {
                if (v.getValeur(s) < v.getValeur(u))
                    u = s;
            }
            noeuds.remove(u);
            for (Arc a : g.suivants(u)) {
                double d = v.getValeur(u) + a.getCout();
                if (d < v.getValeur(a.getDest())) {
                    v.setValeur(a.getDest(), d);
                    v.setParent(a.getDest(), u);
                }
            }
        }
        return v;
    }
    
}
