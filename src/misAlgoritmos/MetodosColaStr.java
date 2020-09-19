/** @author Diego Sanchez
 * Metodos para operar con el TDA de ColaStr
 */
package misAlgoritmos;

import miApi.ColaStrTDA;
import misImplementaciones.ColaStr;

import java.util.Scanner;

public class MetodosColaStr {

    // Carga Strings en una cola Finaliza la carga al ingresar una cadena vacia
    public void cargaCola(ColaStrTDA cola) {
        Scanner teclado = new Scanner(System.in);
        String cadena;

        System.out.print("Ingrese una cadena: ");
        cadena = teclado.nextLine();

        while (!cadena.equals("")) {
            cola.acolar(cadena);
            System.out.print("Ingrese una cadena: ");
            cadena = teclado.nextLine();
       }
       teclado.close();
    }

    // Transfiere los elementos de cola1 a cola2
    public void colaToCola(ColaStrTDA cola1, ColaStrTDA cola2) {
        while (! cola1.colaVacia()) {
            cola2.acolar(cola1.primero());
            cola1.desacolar();
        }
    }

    // Imprime de manera NO destructiva los valores cargados en una cola.
    public void imprimeCola(final ColaStrTDA cola) {

        ColaStrTDA colaTemp = new ColaStr();
        colaTemp.inicializarCola();
        String elem;

        // Guardamos el elemento impreso en una cola temporal
        while (!cola.colaVacia()) {
            elem = cola.primero();
            cola.desacolar();

            colaTemp.acolar(elem);
            System.out.println(" - " + elem);
        }
        // Devolvemos los valores a la cola original
        colaToCola(colaTemp, cola);
    }

    // Copia los elementos de cola1 a cola2
    public void copiaCola(ColaStrTDA cola1, ColaStrTDA cola2) {
        // Creamos una cola auxiliar
        ColaStrTDA colaAux = new ColaStr();
        colaAux.inicializarCola();

        // Pasamos todos los valores a colaAux
        while (! cola1.colaVacia()) {
            colaAux.acolar(cola1.primero());
            cola1.desacolar();
        }

        String valor;
        // Copiamos los valores de colaAux a las ambas colas recibidas
        while (! colaAux.colaVacia()) {
            valor = colaAux.primero();
            colaAux.desacolar();

            cola1.acolar(valor);
            cola2.acolar(valor);
        }
    }

}
