package misAlgoritmos;
import miApi.ConjuntoTDA;
import misImplementaciones.Conjunto;

public class MetodosConjunto {
    /** Retorna entero con la longitud de conj recibido
     * @Precond el conjunto debe estar inicializado
     */
    public int longitud(ConjuntoTDA conj) {
        ConjuntoTDA copia = copiaConj(conj);
        int len;
        for (len = 0; !copia.conjuntoVacio(); len++)
            copia.sacar(copia.obtener());
        
        return len;
    }

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
}
