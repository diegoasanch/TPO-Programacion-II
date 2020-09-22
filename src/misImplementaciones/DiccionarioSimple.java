package misImplementaciones;
import miApi.ConjuntoTDA;
import miApi.DiccionarioSimpleTDA;

public class DiccionarioSimple implements DiccionarioSimpleTDA {
    class Nodo {
        int clave;
        int valor;
        Nodo sig;
    }

    private Nodo inicio;

    public void inicializarDiccionarioSimple() {
        inicio = null;
    }

    public void agregar(int clave, int valor) {
        Nodo nuevo = new Nodo();
        nuevo.clave = clave;
        nuevo.valor = valor;

        // Insertamos el nuevo nodo al inicio del arreglo
        nuevo.sig = inicio;
        inicio = nuevo;
    }

    public void eliminar(int a_sacar) {
        // Si la primera clave es la que buscamos o el diccionario tiene un solo elemento
        if (inicio.clave == a_sacar || inicio.sig == null)
            inicio = inicio.sig;
        else {
            Nodo anterior = inicio;
            Nodo actual = inicio.sig;

            // Buscamos la clave y cambiamos el puntero del nodo anterior al nodo siguiente
            while (actual.clave != a_sacar) {
                anterior = actual;
                actual = actual.sig;
            }
            anterior.sig = actual.sig;
        }
    }

    public int obtener(int a_buscar) {
        Nodo actual = inicio;
        while (actual.clave != a_buscar)
            actual = actual.sig;
        return actual.valor;
    }

    public ConjuntoTDA claves() {
        ConjuntoTDA clavesGuardadas = new Conjunto();
        clavesGuardadas.inicializarConjunto();

        Nodo actual = inicio;
        while (actual != null) {
            clavesGuardadas.agregar(actual.clave);
            actual = actual.sig;
        }
        return clavesGuardadas;
    }
}
