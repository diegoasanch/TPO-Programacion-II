/** @author Diego Sanchez
 * Metodos para operar con implementaciones de la clase del TDA de Tabla definido en
 * miApi/TablaTDA.java
 */
package misAlgoritmos;

import java.io.BufferedReader;
import java.io.FileReader;

import miApi.TablaTDA;
import misImplementaciones.Tabla;


public class MetodosTabla {

    /** Recibe una instancia de TablaTDA a ser cargada y la ubicacion del archivo a leer
     * @Precondicion La tabla a cargar debe estar inicializada
     */
    public TablaTDA cargaTabla(String ubicacion) {
        try {
            FileReader arch = new FileReader(ubicacion);
            BufferedReader buffer = new BufferedReader(arch);

            TablaTDA aCargar = new Tabla();
            aCargar.inicializarTabla();

            String linea, nombre;

            // Descartamos la linea del encabezado
            buffer.readLine();
            linea = buffer.readLine();

            while (linea != null) {
                nombre = linea.strip();
                if (!aCargar.pertenece(nombre))
                    aCargar.agregar(nombre);

                linea = buffer.readLine();
            }
            arch.close();
            return aCargar;
        }
        catch (Exception e) {
            System.out.println("Ocurrio un error al leer el ubicacion " + ubicacion + ": " + e);
            return null;
        }
    }

}
