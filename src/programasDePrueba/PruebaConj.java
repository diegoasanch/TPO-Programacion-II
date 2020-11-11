package programasDePrueba;

import miApi.ConjuntoTDA;
import misImplementaciones.Conjunto;
import misAlgoritmos.MetodosConjunto;

public class PruebaConj {
    public static void main(String[] args) {
        ConjuntoTDA conj = new Conjunto();
        conj.inicializarConjunto();

        int i;
        for (i = 0; i < 10; conj.agregar(i++))
            ;
        
        MetodosConjunto met = new MetodosConjunto();

        int len = met.longitud(conj);
        System.out.printf("La longitud del conjunto es de %d%n", len);
        
        while (!conj.conjuntoVacio()) {
            len = conj.obtener();
            conj.sacar(len);
            System.out.println(len);
        }
    }
    
}
