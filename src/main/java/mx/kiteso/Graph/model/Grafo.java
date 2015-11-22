package mx.kiteso.Graph.model;

import mx.kiteso.Graph.algorithms.LimiteException;

import java.util.List;

/**
 * Created by Arreola on 11/7/2015.
 */
public interface Grafo<E> {
    int inf = 999999;

    void insVertice(E var1);

    void insArco(int var1, int var2, int var3) throws LimiteException;

    void elimArco(int var1, int var2) throws LimiteException;

    int costoArco(int var1, int var2) throws LimiteException;

    List<E> sucesores(int var1) throws LimiteException;

    E infoVertice(int var1) throws LimiteException;

    int ordenGrafo();
}
