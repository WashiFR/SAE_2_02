import java.io.*;
import java.util.ArrayList;

/**
 * Classe GrapheListe qui représente les données associées à un graphe
 */
public class GrapheListe implements Graphe {

    /**
     * Attribut contenant les noms des objets noeuds stockés
     */
    private ArrayList<String> ensNom;    

    /**
     * Attribut contenant les objets noeuds stockés
     */
    private ArrayList<Noeud> ensNoeud;

    /**
     * Constructeur de la classe GrapheListe
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
     * Constructeur de la classe GrapheListe qui prend en paramètre un nom de fichier à lire
     * @param fichier nom du fichier à lire
     * @throws IOException
     */
    public GrapheListe(String fichier) throws IOException {
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
                    noeud.ajouterArc(tab[1], Double.parseDouble(tab[2]));
                    this.ensNoeud.add(noeud);
                    this.ensNom.add(tab[0]);
                }
                // Si le noeud existe déjà
                else {
                    // On parcourt la liste des noeuds du graphe
                    for(Noeud n : this.ensNoeud){
                        if(n.equals(noeud)){
                            n.ajouterArc(tab[1], Double.parseDouble(tab[2]));
                            break; // On sort de la boucle car on a trouvé le noeud
                        }
                    }
                }
            }

            // On ferme le fichier
            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("Le fichier n'existe pas");
        }
    }

    /**
     * Méthode qui créer un fichier contenant une liste d'arcs à partir d'un nom de fichier contenant le descriptif d'un graphe sous forme de matrice d'adjacence
     * @param fichier nom du fichier à lire
     */
    public void matriceToArc(String fichier) throws IOException{
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("../graphes/listeArcs.txt"));
            BufferedReader br = new BufferedReader(new FileReader("../graphes/" + fichier));
            String ligne;
            String[] nomNoeuds = null;
            int i = 0;

            while ((ligne = br.readLine()) != null) {
                // le '\t' ne marche pas car en txt faire 'tab' compte comme plusieurs espaces
                String[] tab = ligne.split(" ");
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
        }
    }

    /**
     * Méthode qui permet d’ajouter des noeuds et des arcs à un objet GrapheListe
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
     * Méthode qui retourne tous les noms des nœuds du graphe
     */
    public ArrayList<String> listeNoeuds(){
        return this.ensNom;
    }

    /**
     * Méthode qui retourne la liste des arcs partant du nœud donné
     * @param n nom du nœud
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
     * Méthode d'affichage du graphe
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
     * Méthode qui retourne le graphe au format Graphviz
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
