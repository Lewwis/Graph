package mx.kiteso.Graph.algorithms;

import mx.kiteso.Graph.model.Grafo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arreola on 11/7/2015.
 */
public class GrafoCol<E> implements Grafo<E> {
    List<E> vertices = new ArrayList();
    int[][] aristas = new int[100][100];

    public GrafoCol() {
        for(int i = 0; i < this.aristas.length; ++i) {
            for(int j = 0; j < this.aristas.length; ++j) {
                if(i != j) {
                    this.aristas[i][j] = 999999;
                }
            }
        }
    }

    public void insVertice(E dato) {
        this.vertices.add(dato);
    }

    public void insArco(int o, int d, int dato) throws LimiteException {
        if(o < this.ordenGrafo() && d < this.ordenGrafo()) {
            this.aristas[o][d] = dato;
        } else {
            throw new LimiteException("Error indice vertices");
        }
    }

    public void elimArco(int o, int d) throws LimiteException {
        if(o < this.ordenGrafo() && d < this.ordenGrafo()) {
            this.aristas[o][d] = 999999;
        } else {
            throw new LimiteException("Error indice vertices");
        }
    }

    public int costoArco(int x, int y) throws LimiteException {
        if(x < this.ordenGrafo() && y < this.ordenGrafo()) {
            return this.aristas[x][y];
        } else {
            throw new LimiteException("Error indice vertices");
        }
    }

    public List<E> sucesores(int v) throws LimiteException {
        if(v >= this.ordenGrafo()) {
            throw new LimiteException("Error indice vertice");
        } else {
            ArrayList suc = new ArrayList();

            for(int i = 0; i < this.ordenGrafo(); ++i) {
                if(v != i && this.aristas[v][i] != 999999) {
                    suc.add(this.infoVertice(i));
                }
            }

            return suc;
        }
    }

    public E infoVertice(int v) throws LimiteException {
        if(v >= this.ordenGrafo()) {
            throw new LimiteException("Error indice vertice");
        } else {
            return this.vertices.get(v);
        }
    }

    public int ordenGrafo() {
        return this.vertices.size();
    }
}
