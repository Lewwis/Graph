package mx.kiteso.Graph.model;

import mx.kiteso.Graph.algorithms.Graph;

/**
 * Created by Arreola on 11/7/2015.
 */
public class Dijkstra {
    private double mCostos [][];
    private int ultimo[];
    private double D[];
    private boolean F[];
    private int s, n;

    public Dijkstra(int s, Graph g) {
        n = g.nodes.size(); //Numero de nodos que tiene el grafo
        this.s = s;
        mCostos = insMatriz(g);
        ultimo = new int[n];
        D = new double[n];
        F = new boolean[n];

    }

    public void caminosMinimos() {
        for(int i = 0; i < n; i++) {
            F[i] = false;
            D[i] = mCostos[s][i];
            ultimo[i] = s;
        }
        F[s] = true;
        D[s] = 0;

        for(int i=0; i<n; i++){
            int v = minimo();

            F[v] = true;

            for(int j=0; j<n; j++){
                if(!F[j]) {
                    if((D[v] + mCostos[v][j]) < D[j]) {
                        D[j] = D[v] + mCostos[v][j];
                        ultimo[j] = v;
                    }
                }
            }
        }

        for(int i=0; i < n; i++) {
            System.out.println("Costo minimo a " + i + ": " + D[i]);
        }
    }

    public int minimo(){
        double mx = 9999;
        int min = 1;
        for(int i=0; i  < n; i++) {
            if(!F[i] && D[i] <= mx){
                mx = D[i];
                min = i;
            }
        }
        return min;
    }

    private double[][] insMatriz(Graph g) {
        int t = g.nodes.size();
        mCostos = new double[t][t];
        for(int i = 0; i < t; i++) {
            for(int j=0; j<t; j++) {
                mCostos[i][j] = g.searchLinkWeigh(g.nodes.get(i), g.nodes.get(j));
            }
        }
        return mCostos;
    }
}
