/** @author Diego Sanchez
 * Implementacion dinamica del TDA de Grafo
 */

package misImplementaciones;

import miApi.ConjuntoTDA;
import miApi.GrafoTDA;

public class GrafoD implements GrafoTDA {

    class NodoV {
        int vert;
        NodoA inicioArista;
        NodoV sigVertice;
    }

    class NodoA {
        int peso;
        NodoV destino;
        NodoA sigArista;
    }

    private NodoV inicioVertice;

    @Override
    public void inicializarGrafo() {
        inicioVertice = null;
    }

    @Override
    public void agregarVertice(int vert) {
        // Creamos el nuevo vertice y lo agregamos al principio de la lista
        NodoV nuevo = new NodoV();
        nuevo.vert = vert;
        nuevo.sigVertice = inicioVertice;
        inicioVertice = nuevo;
    }

    @Override
    public void agregarArista(int vert1, int vert2, int peso) {
        // Creamos el nodo
        NodoA arista = new NodoA();
        arista.peso = peso;
        arista.destino = buscaVertice(vert2);

        // Lo agregamos de primero en la lista de aristas de vert1
        NodoV origen = buscaVertice(vert1);
        arista.sigArista = origen.inicioArista;
        origen.inicioArista = arista;
    }

    @Override
    public void eliminarVertice(int vert) { // TODO: Eliminar las aristas relacionadas al vertice
        // Si es el primero
        if (inicioVertice.vert == vert)
            inicioVertice = inicioVertice.sigVertice;
        // Si no, lo buscamos y borramos la referencia
        else {
            NodoV anterior = inicioVertice;
            NodoV actual = anterior.sigVertice;

            while (actual.vert != vert) {
                anterior = actual;
                actual = actual.sigVertice;
            }
            anterior.sigVertice = actual.sigVertice;
        }
    }

    @Override
    public void eliminarArista(int vert1, int vert2) {
        NodoV origen = buscaVertice(vert1);

        if (origen.inicioArista.destino.vert == vert2)
            origen.inicioArista = origen.inicioArista.sigArista;
        else {
            NodoA anterior = origen.inicioArista;
            NodoA actual = anterior.sigArista;

            while (actual.destino.vert != vert2) {
                anterior = actual;
                actual = actual.sigArista;
            }
            anterior.sigArista = actual.sigArista;
        }
    }

    @Override
    public boolean existeArista(int vert1, int vert2) {
        // Buscamos el nodo origen y vemos dentro de su lista de aristas
        NodoA actual = buscaVertice(vert1).inicioArista;
        Boolean existe = false;

        while (actual != null && !existe) {
            existe = actual.destino.vert == vert2;
            actual = actual.sigArista;
        }
        return existe;
    }

    @Override
    public int pesoArista(int vert1, int vert2) {
        NodoA actual = buscaVertice(vert1).inicioArista;

        while (actual.destino.vert != vert2)
            actual = actual.sigArista;
        return actual.peso;
    }

    @Override
    public ConjuntoTDA vertices() {
        Conjunto resultado = new Conjunto();
        NodoV actual = inicioVertice;

        while (actual != null) {
            resultado.agregar(actual.vert);
            actual = actual.sigVertice;
        }
        return resultado;
    }

    // Retorna la referencia al vertice recibido
    // @Precondicion el Nodo vertice debe existir
    private NodoV buscaVertice(int vert) {
        NodoV actual = inicioVertice;
        while (actual.vert != vert)
            actual = actual.sigVertice;
        return actual;
    }
}
