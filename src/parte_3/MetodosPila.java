package parte_3;

import misImplementaciones.PilaInt;
import miApi.PilaIntTDA;

public class MetodosPila {
    
    /** Retorna una nueva pila con el contenido de la pila recibida invertido, no se modifica la
     * pila original
     * @Precondicion la pila debe estar inicializada
     */
    public PilaIntTDA inviertePila(PilaIntTDA pila) {
        PilaIntTDA respuesta = new PilaInt();
        respuesta.inicializarPila();

        PilaIntTDA aux = new PilaInt();
        aux.inicializarPila();

        while (!pila.pilaVacia()) {
            respuesta.apilar(pila.tope());
            aux.apilar(pila.tope());
            pila.desapilar();
        }
        while (!aux.pilaVacia()) {
            pila.apilar(aux.tope());
            aux.desapilar();
        }
        return respuesta;
    }
}
