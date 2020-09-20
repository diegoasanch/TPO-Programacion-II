/** @author Diego Sanchez
 * Programa de prueba para verificar la correcta ejecucion de las
 * implementaciones de Tabla y ColaStr
 */

package misAplicaciones;

import misAlgoritmos.*;

import java.io.BufferedReader;
import java.io.FileReader;

import miApi.*;
import misImplementaciones.*;

public class PruebaTabla {

    public static void cargaTabla(TablaTDA aCargar, String ubicacion) {
        try {
            FileReader arch = new FileReader(ubicacion);
            BufferedReader buffer = new BufferedReader(arch);

            String linea;
            linea = buffer.readLine();

            while (linea != null) {
                if (!aCargar.pertenece(linea))
                    aCargar.agregar(linea);

                linea = buffer.readLine();
            }
            arch.close();
        }
        catch (Exception e) {
            System.out.println("Ocurrio un error al leer el ubicacion " + ubicacion + ": " + e);
        }
    }

    public static void main(String[] args) {
        MetodosColaStr metodos = new MetodosColaStr();
        String archivoPrueba = "archivos_de_prueba/StreamCia.txt";

        TablaTDA miTabla = new Tabla();
        miTabla.inicializarTabla();

        cargaTabla(miTabla, archivoPrueba);

        miTabla.ordenarNombres();
        System.out.println("Tabla ordenada por nombre");
        metodos.imprimeCola(miTabla.elementosTabla());

        miTabla.ordenarCodigos();
        System.out.println("Tabla ordenada por codigo");
        metodos.imprimeCola(miTabla.elementosTabla());
    }

}
