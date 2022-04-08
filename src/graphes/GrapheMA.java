package graphes;

public class GrapheMA implements IGraph {
    private int [][] matrice;

    /**
     * @brief génère un graphe orienté représenté par une matrice de booléens
     * @param i : la taille de la matrice
     */
    public GrapheMA(Sommet[] sommets) {
        matrice = new int[sommets.length][sommets.length];
        for (int j = 0; j < matrice.length; ++j) {
            for (int k = 0; k < matrice[j].length; ++k) {
                matrice[j][k] = IGraph.inf;
            }
        }
    }

    /**
     * @brief Ajoute un arc au graphe
     * @param i : Prédécesseur de j
     * @param j : Successeur de i
     */
    public void ajouterArc(Sommet i, Sommet j, int valeur) {

        matrice[i.getValeur()-1][j.getValeur()-1] = valeur;
    }

    /**
     * @brief Indique si l'arc existe dans le graphe
     * @param i : Prédécesseur de j
     * @param j : Successeur de i
     * @return valeur booléenne
     */
    public boolean aArc(Sommet i, Sommet j) {
        if (i.getValeur()-1 < 0 || j.getValeur()-1 < 0)
            return false;
        return (matrice[i.getValeur()-1][j.getValeur()-1] != IGraph.inf);
    }

    /**
     * @brief Renvoie le degré sortant du sommet
     * @param i : le sommet
     * @return un int : le degré sortant
     */
    public int dOut(Sommet i) {
        int cmpt = 0;
        for (int s: matrice[i.getValeur()-1]) {
            if(s != IGraph.inf){
                cmpt += 1;
            }
        }
        return cmpt;
    }

    /**
     * @brief Renvoie le degré entrant du sommet
     * @param i : le sommet
     * @return un int : le degré entrant
     */
    public int dIn(Sommet i) {
        int cmpt = 0;
        for (int[] s: matrice) {
            if(s[i.getValeur()-1] != IGraph.inf)
                cmpt += 1;

        }
        return cmpt;
    }

    /**
     * @brief Renvoie le nombre de noeuds du graphe
     * @return un int : le nombre de noeuds
     */
    public int getNbNoeuds() {
        return matrice.length;
    }

    /**
     * @brief Renvoie une chaine de caractère représentant le graphe
     * @return un string : le graphe
     */
    public String toString() {
        String chaine = "";
        for (int[] tab: matrice) {
            for (int s: tab) {
                if (s != IGraph.inf)
                    chaine += s + " ";
                else
                    chaine += 0 + " ";
            }
            chaine += "\n";
        }
        return chaine;
    }

    public int getValeur(Sommet i, Sommet j) {
        return matrice[i.getValeur()-1][j.getValeur()-1];
    }
}