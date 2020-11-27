/** @author Diego Sanchez */

package parte_3;

import miApi.ABBTDA;
import miApi.ColaIntTDA;
import miApi.PilaIntTDA;

import misImplementaciones.ColaInt;
import misImplementaciones.PilaInt;

public class MetodosABB {

    /** 4. b) Devuelve ColaInt con la secuencias de valores enteros separados por 000 . Cada 
     * secuencia corresponde a los nodos pertenecientes al camino del arbol cuya longitud sea igual
     * al tercio de la altura del arbol original
     * @Precondicion el arbol debe estar inicializado
     */
    public ColaIntTDA caminoTercioAltura(ABBTDA arbol) {

        int altura = alturaArbol(arbol) / 3;
        System.out.println("Altura del arbol: " + alturaArbol(arbol));
        ColaIntTDA resultado = new ColaInt();
        resultado.inicializarCola();

        PilaIntTDA sec_actual = new PilaInt();
        sec_actual.inicializarPila();

        recorreArbol(arbol, altura, 0, sec_actual, resultado);
        
        return resultado;
    }

    /** Recorre el arbol y agrega en el resultado la secuencia del camino hasta llegar a un nodo 
     * donde su altura es igual a nivel_limite
     * @Precondicion el ABBTDA arbol debe estar inicializado
     * @Precondicion la PilaTDA secuencia_actual debe estar inicializada
     * @Precondicion la ColaIntTDA resultado debe estar inicializada
     */
    private void recorreArbol(ABBTDA arbol, int nivel_limite, int nivel_actual, PilaIntTDA secuencia_actual, ColaIntTDA resultado) {
        if (!arbol.arbolVacio()) {
            // Agregamos el nodo actual a la pila de secuencia actual
            secuencia_actual.apilar(arbol.raiz());

            // Si el nivel actual es menor al que buscamos recorremos las ramas hijo
            if (++nivel_actual < nivel_limite ) {
                recorreArbol(arbol.hijoIzq(), nivel_limite, nivel_actual, secuencia_actual, resultado);
                recorreArbol(arbol.hijoDer(), nivel_limite, nivel_actual, secuencia_actual, resultado);
            }
            else {
                agregaSecuencia(secuencia_actual, resultado);
            }

            // Desapilamos el nivel actual de la secuencia
            secuencia_actual.desapilar();
        }
    }

    private void agregaSecuencia(PilaIntTDA secuencia, ColaIntTDA resultado) {
        MetodosPila pilas = new MetodosPila();

        // Invertimos la pila para que el orden sea el del camino
        PilaIntTDA a_cargar = pilas.inviertePila(secuencia);

        // Cargamos la secuencia a la pila
        while (!a_cargar.pilaVacia()) {
            resultado.acolar(a_cargar.tope());
            a_cargar.desapilar();
        }
        // Acolamos los tres ceros de separacion
        for (int i = 0; i < 3; i++)
            resultado.acolar(0);
    }

    /** Devuelve la profundidad de un elemento perteneciente al arbol  
     * @Precondicion el elemento debe estar petenecer al arbol recibido
    */
    public int profundidadNodo(ABBTDA arbol, int valor) {
        if (valor == arbol.raiz())
            return 1;
        else if (valor < arbol.raiz())
            return 1 + profundidadNodo(arbol.hijoIzq(), valor);
        else
            return 1 + profundidadNodo(arbol.hijoDer(), valor);
    }

    // Devuelve la profundidad de la rama mas profunda del arbol
    public int alturaArbol(ABBTDA arbol) {
        if (! arbol.arbolVacio()) {
            int altIzq = alturaArbol(arbol.hijoIzq()) + 1;
            int altDer = alturaArbol(arbol.hijoDer()) + 1;

            // Devolvemos la altura mayor entre la izquierda y la derecha, mas el nivel actual
            return (altIzq > altDer) ? altIzq : altDer;
        }
        return 0;
    }
}