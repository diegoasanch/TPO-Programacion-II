/** @author Diego Sanchez
 * Metodos para operar con implementaciones de la clase del TDA de Tabla definido en
 * miApi/TablaTDA.java
 */
package misAlgoritmos;

import java.io.BufferedReader;
import java.io.FileReader;

import miApi.TablaTDA;


public class MetodosTabla {

    /** Recibe una instancia de TablaTDA a ser cargada y la ubicacion del archivo a leer
     * @Precondicion La tabla a cargar debe estar inicializada
     */
    public void cargaTabla(TablaTDA aCargar, String ubicacion) {
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
    
}
