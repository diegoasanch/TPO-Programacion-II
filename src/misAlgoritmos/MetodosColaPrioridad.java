package misAlgoritmos;

import miApi.ColaPrioridadTDA;
import misImplementaciones.ColaPrioridad;

public class MetodosColaPrioridad {
    
    /** Copia todo el contenido de cola prioridad 'desde' en 'hacia' sin modificar la original
     * @Precondicion ambas colas deben estar inicializadas.
     */
    public ColaPrioridadTDA copiaCola(ColaPrioridadTDA desde) {
        ColaPrioridadTDA colaAux = new ColaPrioridad();
        colaAux.inicializarCola();
        
        ColaPrioridadTDA hacia = new ColaPrioridad();
        hacia.inicializarCola();

        int prio, valor;

        while (!desde.colaVacia()) {
            prio = desde.primeraPrioridad();
            valor = desde.primerValor();
            desde.desacolar();

            colaAux.acolarPrioridad(valor, prio);
        }

        while (!colaAux.colaVacia()) {
            prio = colaAux.primeraPrioridad();
            valor = colaAux.primerValor();
            colaAux.desacolar();

            desde.acolarPrioridad(valor, prio);
            hacia.acolarPrioridad(valor, prio);
        }
        return hacia;
    }
}
