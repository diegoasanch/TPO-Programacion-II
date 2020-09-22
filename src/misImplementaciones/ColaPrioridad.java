package misImplementaciones;

import miApi.ColaPrioridadTDA;

public class ColaPrioridad implements ColaPrioridadTDA {
    class Nodo {
        int valor;
        int prior;
        Nodo sig;
    }
    private Nodo inicio;

    public void inicializarCola() {
        inicio = null;
    }

    public void acolarPrioridad(int valor, int prior) {
        Nodo nuevo = new Nodo();
        nuevo.valor = valor;
        nuevo.prior = prior;

        if (inicio == null) {
            nuevo.sig = null;
            inicio = nuevo;
        }
        else if (nuevo.prior > inicio.prior) {
            nuevo.sig = inicio;
            inicio = nuevo;
        }
        else {
            Nodo anterior;
            Nodo actual = inicio;
            do {
                anterior = actual;
                actual = actual.sig;
            } while (actual != null && nuevo.prior < actual.prior);

            nuevo.sig = actual;
            anterior.sig = nuevo;
        }     
    }

    public void desacolar() {
        inicio = inicio.sig;
    }

    public int primerValor() {
        return inicio.valor;
    }
    
    public int primeraPrioridad() {
        return inicio.prior;
    }

    public boolean colaVacia() {
        return inicio == null;
    }
}
