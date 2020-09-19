/** @author Diego Sanchez
 * Implementacion Dinamica de una cola Primero al inicio.
 * Implementa el ColaStrTDA
 */

package misImplementaciones;
import miApi.ColaStrTDA;

public class ColaStr implements ColaStrTDA {
    class Nodo {
        String dato;
        Nodo sig;
    }

    private Nodo primero;
    private Nodo ultimo;

    public void inicializarCola() {
        primero = null;
    }

    public void acolar(String x) {
        Nodo nuevo = new Nodo();
        nuevo.dato = x;
        nuevo.sig = null;

        // Si la cola estaba vacia el nuevo elemento es el primero y ultimo a la vez
        if (colaVacia())
            primero = ultimo = nuevo;

        // Si no esta vacia conseguimos guardamos al nuevo nodo al final
        else {
            ultimo.sig = nuevo;
            ultimo = nuevo;
        }
    }

    public void desacolar() {
        if (primero == ultimo)
            primero = ultimo = null;

        else
            primero = primero.sig;
    }

    public String primero() {
        return primero.dato;
    }

    public boolean colaVacia() {
        return primero == null;
    }
}
