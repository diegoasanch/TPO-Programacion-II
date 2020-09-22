/** @author Diego Sanchez
 * Programa de prueba para verificar la correcta ejecucion de las
 * implementaciones de Tabla y ColaStr
 */

package programasDePrueba;

import misAlgoritmos.*;

import miApi.*;
import misImplementaciones.*;

public class PruebaTabla {

    public static void main(String[] args) {
        MetodosColaStr metodosCola = new MetodosColaStr();
        MetodosTabla metodosTabla = new MetodosTabla();

        String archivoPrueba = "archivos_de_prueba/StreamCia.txt";

        TablaTDA miTabla = new Tabla();
        miTabla.inicializarTabla();

        metodosTabla.cargaTabla(miTabla, archivoPrueba);

        miTabla.ordenarNombres();
        System.out.println("Tabla ordenada por nombre");
        metodosCola.imprimeCola(miTabla.elementosTabla());

        miTabla.ordenarCodigos();
        System.out.println("Tabla ordenada por codigo");
        metodosCola.imprimeCola(miTabla.elementosTabla());
    }

}
