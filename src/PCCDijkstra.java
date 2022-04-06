public class PCCDijkstra {

    public boolean estOk (IGraph graphe){
        int cmpt = 0;
        for (int i = 0; i < graphe.getNbNoeuds(); ++i) {
            for (int j = 0; j < graphe.getNbNoeuds(); ++j) {
                if (graphe.getValeur(i,j) < 0)
                    return false;
            }
        }
        return true;
    }
}
