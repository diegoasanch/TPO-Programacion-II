package programasDePrueba;
import miApi.ABBTDA;
import miApi.ColaIntTDA;
import misImplementaciones.ABB;
import misAlgoritmos.MetodosColaInt;
import parte_3.MetodosABB;

public class PruebaABB {
    public static void main(String[] args) {
        MetodosColaInt colas = new MetodosColaInt();
        MetodosABB arboles = new MetodosABB();

        ABBTDA arbol = new ABB();
        arbol.inicializarABB();

        cargaABBPrueba(arbol);

        ColaIntTDA resultado = arboles.caminoTercioAltura(arbol);
        colas.imprimeCola(resultado);
    }

    public static void cargaABBPrueba(ABBTDA arbol) {
        int[] valores = { 10, 5, 3, 2, 1, 4, 27, 11, 12, 13, 14, 15, 16, 17, 40, 50 }; // len = 17

        for (int i = 0; i < 17; i++)
            arbol.agregar(valores[i]);
    }
}
