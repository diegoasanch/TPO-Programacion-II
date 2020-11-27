/** @author Diego Sanchez
 * Implementacion estatica de grafo con conjunto acotado
 */

package misImplementaciones;

import miApi.ConjuntoTDA;
import miApi.GrafoTDA;

public class GrafoE implements GrafoTDA {

    private int[][] matriz;
    private int[] etiquetas;
    private int cant;

    @Override
    public void inicializarGrafo() {
        matriz = new int[100][100];
        etiquetas = new int[100];
        cant = 0;
    }

    @Override
    public void agregarVertice(int vert) {
        etiquetas[cant] = vert;

        for (int i = 0; i < cant; i++) {
            matriz[cant][i] = 0;
            matriz[i][cant] = 0;
        }
        cant++;
    }

    @Override
    public void agregarArista(int vert1, int vert2, int peso) {
        int pos1 = buscaPos(vert1);
        int pos2 = buscaPos(vert2);
        matriz[pos1][pos2] = peso;
    }

    @Override
    public void eliminarVertice(int vert) {
        int pos = buscaPos(vert);
        etiquetas[pos] = etiquetas[cant - 1];

        for (int i = 0; i < cant; i++) {
            matriz[pos][i] = matriz[cant - 1][i];
            matriz[i][pos] = matriz[i][cant - 1];
        }
        cant--;
    }

    @Override
    public void eliminarArista(int vert1, int vert2) {
        int pos1 = buscaPos(vert1);
        int pos2 = buscaPos(vert2);
        matriz[pos1][pos2] = 0;
    }

    @Override
    public boolean existeArista(int vert1, int vert2) {
        return pesoArista(vert1, vert2) != 0;
    }

    @Override
    public int pesoArista(int vert1, int vert2) {
        int pos1 = buscaPos(vert1);
        int pos2 = buscaPos(vert2);
        return matriz[pos1][pos2];
    }

    @Override
    public ConjuntoTDA vertices() {
        ConjuntoTDA verts = new Conjunto();
        verts.inicializarConjunto();

        for (int i = 0; i < cant; i++)
            verts.agregar(etiquetas[i]);
        return verts;
    }

    // Retorna la posicion del vertice dentro de etiquetas
    // El vertice debbe pertenecer al grafo
    private int buscaPos(int vertice) {
        int pos = 0;
        while (etiquetas[pos] != vertice)
            pos++;
        return pos;
    }
}
