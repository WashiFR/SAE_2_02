import java.io.*;
import java.util.ArrayList;

/**
 * Classe {@code GrapheListe} représentant les données associées à un graphe
 */
public class GrapheListe implements Graphe {

    /**
     * Liste des noms des {@code Noeud} stockés dans le graphe
     */
    private ArrayList<String> ensNom;    

    /**
     * Liste des {@code Noeud} stockés dans le graphe
     */
    private ArrayList<Noeud> ensNoeud;

    /**
     * Construit un {@code GrapheListe} à partir d'une liste de {@code Noeud}
     * @param noeuds liste des noeuds du graphe
     */
    public GrapheListe(ArrayList<Noeud> noeuds) {
        this.ensNoeud = noeuds;
        this.ensNom = new ArrayList<String>();
        for(Noeud noeud : noeuds){
            this.ensNom.add(noeud.getNom());
        }
    }

    /**
     * Construit un {@code GrapheListe} à partir d'un fichier contenant une liste d'arcs
     * @param fichier nom du fichier à lire
     */
    public GrapheListe(String fichier) {
        this.ensNoeud = new ArrayList<Noeud>();
        this.ensNom = new ArrayList<String>();

        try {
            // On lit le fichier
            BufferedReader br = new BufferedReader(new FileReader("../graphes/" + fichier));
            String ligne;

            while ((ligne = br.readLine()) != null) {

                // On découpe la ligne
                String[] tab = ligne.split("\t");
                // On ajoute l'arc
                Noeud noeud = new Noeud(tab[0]);

                // Si le noeud n'existe pas
                if(!this.ensNom.contains(tab[0])){
                    this.ensNoeud.add(noeud);
                    this.ensNom.add(tab[0]);
                }
                if(!this.ensNom.contains(tab[1])){
                    this.ensNoeud.add(new Noeud(tab[1]));
                    this.ensNom.add(tab[1]);
                }
                
                this.ajouterArc(tab[0], tab[1], Double.parseDouble(tab[2]));
            }

            // On ferme le fichier
            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("Le fichier n'existe pas");
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier");
        }
    }

    /**
     * Construit un {@code GrapheListe} aléatoire à partir du nombre de noeuds
     * @param nbNoeuds nombre de noeuds du graphe
     */
    public GrapheListe(int nbNoeuds) {
        this.ensNoeud = new ArrayList<Noeud>();
        this.ensNom = new ArrayList<String>();

        // On ajoute les noeuds
        for(int i = 0; i < nbNoeuds; i++){
            this.ensNoeud.add(new Noeud("N" + i));
            this.ensNom.add("N" + i);
        }

        // On ajoute au moins un chemin qui va du premier au dernier noeud
        for (int i = 0; i < nbNoeuds - 1; i++)
            this.ajouterArc("N" + i, "N" + (i + 1), Math.random() * 100);

        // On ajoute des chemins aléatoires
        for (int i = 0; i < nbNoeuds; i++) {
            for (int j = 0; j < nbNoeuds; j++) {
                // On ajoute un chemin avec une probabilité de 20%
                // On vérifie que le noeud de départ et d'arrivée ne sont pas les mêmes
                if (Math.random() < 0.2 && i != j){
                    // On vérifie que le noeud de départ et d'arrivée ne sont pas déjà reliés
                    boolean existe = false;
                    for(Arc arc : this.suivants("N" + i)){
                        if(arc.getDest().equals("N" + j)){
                            existe = true;
                            break;
                        }
                    }
                    if(!existe)
                        this.ajouterArc("N" + i, "N" + j, Math.random() * 100);
                }
            }
        }
    }

    /**
     * Créer un fichier contenant une liste d'arcs à partir d'un nom de fichier contenant le descriptif d'un graphe sous forme de matrice d'adjacence
     * @param fichier nom du fichier à lire
     */
    public void matriceToArc(String fichier) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("../graphes/listeArcs.txt"));
            BufferedReader br = new BufferedReader(new FileReader("../graphes/" + fichier));
            String ligne;
            String[] nomNoeuds = null;
            int i = 0;

            while ((ligne = br.readLine()) != null) {
                String[] tab = ligne.split("\t");
                if(i == 0){
                    nomNoeuds = tab;
                    i++;
                }
                else {
                    for(int j = 0; j < tab.length; j++){
                        // On vérifie que la valeur n'est pas 0 ou une lettre
                        if(!tab[j].equals("0.") && !tab[j].matches("^[a-zA-Z]*$")){
                            bw.write(tab[0] + "\t" + nomNoeuds[j] + "\t" + tab[j] + "\n");
                        }
                    }
                }
            }
            
            bw.close();
            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("Le fichier n'existe pas");
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier");
        }
    }

    /**
     * Ajoute des noeuds et des arcs à un {@code GrapheListe}
     * @param depart nom du nœud de départ
     * @param destination nom du nœud de destination
     * @param cout coût de l’arc
     */
    public void ajouterArc(String depart, String destination, double cout){
        // On vérifie que les noeuds existent
        if(this.ensNom.contains(depart) && this.ensNom.contains(destination)){
            // On parcourt la liste des noeuds du graphe
            for(Noeud noeud : this.ensNoeud){
                if(noeud.equals(new Noeud(depart))){
                    noeud.ajouterArc(destination, cout);
                    break; // On sort de la boucle car on a trouvé le noeud
                }
            }
        }
    }

    /**
     * Retourne tous les noms des nœuds du graphe
     * @return {@code ArrayList<String>} liste des noms des nœuds
     */
    public ArrayList<String> listeNoeuds(){
        return this.ensNom;
    }

    /**
     * Retourne la liste des arcs partant du nœud donné
     * @param n nom du nœud
     * @return {@code ArrayList<Arc>} liste des arcs du nœud
     */
    public ArrayList<Arc> suivants(String n){
        ArrayList<Arc> listeSuivant = new ArrayList<Arc>();

        // On parcourt la liste des noeuds du graphe
        for(Noeud noeud : this.ensNoeud){
            if(noeud.equals(new Noeud(n))){
                listeSuivant = noeud.getAdj();
                break; // On sort de la boucle car on a trouvé le noeud
            }
        }
        return listeSuivant;
    }

    /**
     * Affiche le graphe
     * @return {@code String} représentation du graphe
     */
    public String toString(){
        String s = "";
        // On parcourt la liste des noeuds du graphe
        for(Noeud noeud : this.ensNoeud){
            s += noeud.getNom() + " -> ";
            // On parcourt la liste des arcs adjacents du noeud
            for(Arc arc : noeud.getAdj()){
                s += arc.getDest() + "(" + (int)arc.getCout() + ") ";
            }
            s += "\n";
        }
        return s;
    }

    /**
     * Affiche le graphe au format Graphviz
     * @return {@code String} représentation du graphe au format Graphviz
     */
    public String toGraphviz(){
        String s = "digraph G {\n";
        // On parcourt la liste des noeuds du graphe
        for(Noeud noeud : this.ensNoeud){
            // On parcourt la liste des arcs adjacents du noeud
            for(Arc arc : noeud.getAdj()){
                s += noeud.getNom() + " -> " + arc.getDest() + " [label = " + (int)arc.getCout() + "]\n";
            }
        }
        s += "}";
        return s;
    }
}
