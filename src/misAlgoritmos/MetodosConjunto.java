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

    public void imprimeCon(ConjuntoTDA conj) {
        ConjuntoTDA copia = copiaConj(conj);
        int valor;

        System.out.println("Valores del conjunto:");
        while (!copia.conjuntoVacio()) {
            valor = copia.obtener();
            copia.sacar(valor);

            System.out.printf("  %d", valor);
        }
        System.out.println();
    }
}
