package misAlgoritmos;
import miApi.DiccionarioSimpleTDA;
import miApi.ConjuntoTDA;

public class MetodosDiccionarioSimple {
    public void imprime(DiccionarioSimpleTDA aImprimir) {
        ConjuntoTDA claves = aImprimir.claves();

        int clave;
        while (!claves.conjuntoVacio()) {
            clave = claves.obtener();
            claves.sacar(clave);

            System.out.printf("Pelicula: %d Solicitudes %d %n", clave, aImprimir.obtener(clave));
        }
    }
}
