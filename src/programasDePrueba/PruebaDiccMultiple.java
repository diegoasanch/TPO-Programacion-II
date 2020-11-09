package programasDePrueba;
import miApi.DiccionarioMultipleTDA;
import misImplementaciones.DiccionarioMultiple;
import miApi.ConjuntoTDA;

public class PruebaDiccMultiple {
    public static void main(String[] args) {
        DiccionarioMultipleTDA dicc = new DiccionarioMultiple();
        dicc.inicializarDiccionarioMultiple();

        int i, j;

        for (i = 0; i < 10; i++)
            for (j = i; j < (i + 10); j++)
                dicc.agregar(i, j);

        int clave, valor;
        ConjuntoTDA claves = dicc.claves();
        ConjuntoTDA valores;

        while (!claves.conjuntoVacio()) {
            clave = claves.obtener();
            claves.sacar(clave);

            System.out.printf("%nClave: %d -- valores: %n\t", clave);

            valores = dicc.obtener(clave);
            while (!valores.conjuntoVacio()) {
                valor = valores.obtener();
                valores.sacar(valor);

                System.out.print(" - " + valor);
            }
        }
    }
}
