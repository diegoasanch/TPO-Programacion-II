/** @author Diego Sanchez
 * Implementacion dinamica de un conjunto implementando la interfas de ConjuntoTDA
 */
package misImplementaciones;
import miApi.ConjuntoTDA;

public class Conjunto implements ConjuntoTDA {
    class Nodo {
        int dato;
        Nodo sig;
    }
    private Nodo inicio;

    public void inicializarConjunto() {
        inicio = null;
    }

    public void agregar(int dato) {
        // Agregamos el nuevo nodo al inicio
        Nodo nuevo = new Nodo();
        nuevo.dato = dato;
        nuevo.sig = inicio;
        inicio = nuevo;
    }

    public void sacar(int dato) {
        // Buscamos el dato
        if (inicio.dato == dato) {
            inicio = inicio.sig;
        }
        else {
            Nodo anterior;
            Nodo actual = inicio;
            do {
                anterior = actual;
                actual = actual.sig;
            } while (actual.dato != dato);

            anterior.sig = actual.sig;
        }
    }

    public int obtener() { // Devolvemos el primer dato
        return inicio.dato;
    }

    public boolean conjuntoVacio() {
        return inicio == null;
    }

    public boolean pertenece(int dato) {
        boolean existe = false;
        Nodo actual = inicio;
        while (!existe && actual != null) {
            existe = (actual.dato == dato);
            actual = actual.sig;
        }
        return existe;
    }
}
