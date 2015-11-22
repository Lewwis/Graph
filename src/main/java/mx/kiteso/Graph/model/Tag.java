package mx.kiteso.Graph.model;

/**
 * Created by Arreola on 11/5/2015.
 */
public class Tag {
    int numeroIteracion;
    double valorAcumulado;
    Node nodoProcedente;

    public Tag(int numeroIteracion, double valorAcumulado, Node nodoProcedente) {
        this.numeroIteracion = numeroIteracion;
        this.valorAcumulado = valorAcumulado;
        this.nodoProcedente = nodoProcedente;
    }

}
