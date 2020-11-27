/** @author Diego Sanchez */

package parte_3;

import miApi.ConjuntoTDA;
import misImplementaciones.Conjunto;

public class MetodosConjuntos {

    /** Genera una copia de un ConjuntoTDA, no destruye el conjunto recibido 
     * @Precondicion El conjunto debe estar inicializado
    */
    public ConjuntoTDA copiaConj(ConjuntoTDA conj) {
        ConjuntoTDA aux = new Conjunto();
        aux.inicializarConjunto();
        
        ConjuntoTDA nuevo = new Conjunto();
        nuevo.inicializarConjunto();

        int actual;

        while (!conj.conjuntoVacio()) {
            actual = conj.obtener();
            conj.sacar(actual);
            aux.agregar(actual);
        }
        while (!aux.conjuntoVacio()) {
            actual = aux.obtener();
            aux.sacar(actual);

            conj.agregar(actual);
            nuevo.agregar(actual);
        }
        return nuevo;
    }

    /** Retorna un conjunto con la diferencia simetrica entre ambos conjuntos recibidos
     * @Precondicion Ambos conjuntos deben estar inicializados
     */
    public ConjuntoTDA diferenciaSimetrica(ConjuntoTDA conj_1, ConjuntoTDA conj_2) {
        return union(
            diferencia(conj_1, conj_2),
            diferencia(conj_2, conj_1)
        );
    }

    /** Retorna un conjunto con la diferencia de conjunto_1 con conjunto_2
     * @Precondicion ambos conjuntos deben estar inicializados
     */
    private ConjuntoTDA diferencia(ConjuntoTDA conjunto_1, ConjuntoTDA conjunto_2) {
        ConjuntoTDA resultado = new Conjunto();
        resultado.inicializarConjunto();

        ConjuntoTDA copia_1 = copiaConj(conjunto_1);
        int valor;

        while (!copia_1.conjuntoVacio()) {
            valor = copia_1.obtener();
            copia_1.sacar(valor);

            if (!conjunto_2.pertenece(valor))
                resultado.agregar(valor);
        }
        return resultado;
    }

    /** Retorna conjunto con la union de los valores de ambos conjuntos recibidos
     * @Precondicion ambos conjuntos deben estar inicializados
     */
    private ConjuntoTDA union(ConjuntoTDA conjunto_1, ConjuntoTDA conjunto_2) {
        ConjuntoTDA resultado = copiaConj(conjunto_1);
        ConjuntoTDA copia_2 = copiaConj(conjunto_2);
        int valor;

        while (!copia_2.conjuntoVacio()) {
            valor = copia_2.obtener();
            copia_2.sacar(valor);

            if (!resultado.pertenece(valor))
                resultado.agregar(valor);
        }
        return resultado;
    }

}
