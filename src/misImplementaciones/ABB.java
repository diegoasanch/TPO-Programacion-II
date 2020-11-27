/** @author Diego Sanchez */

package misImplementaciones;
import miApi.ABBTDA;

public class ABB implements ABBTDA {

    class Nodo {
        int v;
        ABBTDA izq, der;
    }

    private Nodo inicio;

    public void inicializarABB() {
        inicio = null;
    }

    public int raiz() {
        return inicio.v;
    }

    public ABBTDA hijoIzq() {
        return inicio.izq;
    }

    public ABBTDA hijoDer() {
        return inicio.der;
    }

    public void agregar(int x) {
        if (arbolVacio()) {
            inicio = new Nodo();
            inicio.v = x;

            inicio.izq = new ABB();
            inicio.izq.inicializarABB();
            inicio.der = new ABB();
            inicio.der.inicializarABB();
        }
        else if (x < inicio.v)
            inicio.izq.agregar(x);
        else
            inicio.der.agregar(x);
    }

    private boolean esHoja() {
        return hijoDer().arbolVacio() && hijoIzq().arbolVacio();
    }

    private int menorValor(ABBTDA subArbol) {
        if (subArbol.hijoIzq().arbolVacio())
            return subArbol.raiz();
        else
            return menorValor(subArbol.hijoIzq());
    }

    private int mayorValor(ABBTDA subArbol) {
        if (subArbol.hijoDer().arbolVacio())
            return subArbol.raiz();
        else
            return mayorValor(subArbol.hijoDer());
    }

    public void eliminar(int x) {
        if (x == raiz()) {
            if (esHoja())
                inicio = null;
            else if (!hijoIzq().arbolVacio()) {
                inicio.v = mayorValor(hijoIzq());
                hijoIzq().eliminar(inicio.v);
            }
            else {
                inicio.v = menorValor(hijoDer());
                hijoDer().eliminar(inicio.v);
            }
        }
        else if (x < raiz())
            hijoIzq().eliminar(x);
        else
            hijoDer().eliminar(x);
    }

    public boolean pertenece(int x) {
        if (arbolVacio())
            return false;
        else if (x == raiz())
            return true;
        else if (x < raiz())
            return hijoIzq().pertenece(x);
        else
            return hijoDer().pertenece(x);
    }

    public boolean arbolVacio() {
        return inicio == null;
    }
}
