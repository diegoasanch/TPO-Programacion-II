/** @author Diego Sanchez
*/
package misImplementaciones;

import miApi.ConjuntoTDA;
import miApi.DiccionarioMultipleTDA;

public class DiccionarioMultiple implements DiccionarioMultipleTDA {
    class Nodo {
        int clave;
        ConjuntoTDA valores;
        Nodo sig;
    }
    private Nodo inicio;

    public void inicializarDiccionarioMultiple() {
        inicio = null;
    }

    public void agregar(int clave, int valor) {
        // Si existe la clave, buscamos el nodo y actualizamos su contenido
        // Si NO existe creamos un nuevo nodo y lo agregamos al inicio
        if (claves().pertenece(clave)) {
            Nodo actual = inicio;

            while (actual.clave != clave)
                actual = actual.sig;

            actual.valores.agregar(valor);
        } else {
            Nodo nuevo = new Nodo();
            nuevo.clave = clave;

            nuevo.valores = new Conjunto();
            nuevo.valores.inicializarConjunto();
            nuevo.valores.agregar(valor);

            nuevo.sig = inicio;
            inicio = nuevo;
        }
    }

    public void eliminar(int clave) {
        // Buscamos el nodo y borramos su referencia
        if (inicio.clave == clave) {
            inicio = inicio.sig;
        } else {
            Nodo anterior = inicio;
            Nodo actual = inicio.sig;

            while (actual.clave != clave) {
                anterior = actual;
                actual = actual.sig;
            }
            anterior.sig = actual.sig;
        }
    }

    public void eliminaValor(int clave, int valor) {
        // Buscamos al nodo de la clave y sacamos el valor de su conjunto de valores
        Nodo actual = inicio;
        while (actual.clave != clave)
            actual = actual.sig;

        actual.valores.sacar(valor);
    }

    public ConjuntoTDA obtener(int clave) {
        // Buscamos el elemento perteneciente a la clave suministrada
        Nodo actual = inicio;
        while (actual.clave != clave)
            actual = actual.sig;

        // copiamos el conjunto con la ayuda de un conj auxiliar
        ConjuntoTDA copiaValores = new Conjunto();
        copiaValores.inicializarConjunto();

        ConjuntoTDA valoresAux = new Conjunto();
        valoresAux.inicializarConjunto();

        int valorTemp;

        while (!actual.valores.conjuntoVacio()) {
            valorTemp = actual.valores.obtener();
            actual.valores.sacar(valorTemp);
            valoresAux.agregar(valorTemp);
        }

        // Devolvemos los valores al conjunto asociado a la clave y retornamos la copia
        while (!valoresAux.conjuntoVacio()) {
            valorTemp = valoresAux.obtener();
            valoresAux.sacar(valorTemp);

            actual.valores.agregar(valorTemp);
            copiaValores.agregar(valorTemp);
        }
        return copiaValores;
    }

    public ConjuntoTDA claves() {
        ConjuntoTDA conjClaves = new Conjunto();
        conjClaves.inicializarConjunto();

        Nodo actual = inicio;
        
        while (actual != null) {
            conjClaves.agregar(actual.clave);
            actual = actual.sig;
        }
        return conjClaves;
    }
}
