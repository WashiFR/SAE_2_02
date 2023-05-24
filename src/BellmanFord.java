/**
 * Classe {@code BellmanFord} effectue l'algorithme de Bellman-Ford sur un graphe
 */
public class BellmanFord implements Algorithme {

    /** ====== Algorithme : ======

        fonction resoudre (g : Graphe, depart : Chaine) : Valeur
        début
            pour i de 0 à g.listeNoeuds().lenght() - 1 faire
                si g.listeNoeuds()[i] = depart 
                    alors
                        L(g.listeNoeuds()[i]) ← 0
                    sinon
                        L(g.listeNoeuds()[i]) ← +∞
                fsi
                parent(g.listeNoeuds()[i]) ← null
            fpour

        changement ← vrai

        tant que changement = vrai faire
            changement ← faux
            pour chaque noeud dans g.listeNoeuds() faire
                valeurCourante ← L(noeud)
                pour chaque arc dans g.suivants(noeud) faire
                    nouvelleValeur ← L(arc.getDest())
                    si arc.getCout() + valeurCourante < nouvelleValeur 
                        alors
                            L(arc.getDest()) ← arc.getCout() + valeurCourante
                            parent(arc.getDest()) ← noeud
                            changement ← vrai
                    fsi
                fpour
            fpour
        ftantque
            retourner v
        fin

        ====== Lexique : ======

        - g : Graphe, graphe dont on veut trouver le plus court chemin
        - depart : Chaine, nom du noeud de départ
        - i : Entier, indice de parcours
        - changement : Booleen, indique si il y a eu un changement dans la boucle
        - noeud : Chaine, nom du noeud courant
        - valeurCourante : Entier, valeur courante du noeud
        - arc : Arc, arc courant
        - nouvelleValeur : Entier, nouvelle valeur du noeud
    */
    
    /**
     * Effectue l'algorithme de Bellman-Ford sur un graphe
     * @param g graphe dont on veut trouver le plus court chemin
     * @param depart nom du noeud de départ
     * @return {@code Valeur} objet contenant les valeurs et les parents des noeuds
     */
    public Valeur resoudre(Graphe g, String depart) {
        Valeur v = new Valeur();
        for (String s : g.listeNoeuds()) {
            if (s.equals(depart))
                v.setValeur(s, 0);
            else
                // Double.MAX_DOUBLE ne marche pas
                v.setValeur(s, Double.MAX_VALUE);
            v.setParent(s, null);
        }

        boolean changement = true;

        while (changement) {
            changement = false;
            for (String noeud : g.listeNoeuds()) {
                double valeurCourante = v.getValeur(noeud);
                for (Arc arc : g.suivants(noeud)) {
                    double nouvelleValeur = v.getValeur(arc.getDest());
                    if (arc.getCout() + valeurCourante < nouvelleValeur) {
                        v.setValeur(arc.getDest(), arc.getCout() + valeurCourante);
                        v.setParent(arc.getDest(), noeud);
                        changement = true;
                    }
                    // Affichage de l'évolution de l'algorithme
                    // System.out.println(v.toString());
                }
            }
        }
        return v;
    }

}