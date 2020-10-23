package misImplementaciones;

import miApi.PilaIntTDA;

public class PilaInt implements PilaIntTDA {
	
	class Nodo {
        int valor;
        Nodo siguiente;
    }
    private Nodo inicio;

        @Override
    public void inicializarPila() {
        inicio = null;
    }

        @Override
    public void apilar(int x) {
        Nodo nuevo = new Nodo();
        nuevo.valor = x;
        nuevo.siguiente = inicio;
        inicio = nuevo;
    }
    
        @Override
    public void desapilar(){
    	inicio = inicio.siguiente;
    }

        @Override
    public int tope() {
        return inicio.valor;
    }

        @Override
    public boolean pilaVacia() {
        return inicio == null;
    }

}
