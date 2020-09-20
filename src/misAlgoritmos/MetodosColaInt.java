/** @author Diego Sanchez
 * Metodos para operar con los TDA ColaIntTDA
 */

package misAlgoritmos;

import java.io.BufferedReader;
import java.io.FileReader;

import miApi.TablaTDA;
import miApi.ColaIntTDA;

import misImplementaciones.ColaInt;

public class MetodosColaInt {


    // Transfiere los elementos de cola1 a cola2
    public void colaToCola(ColaIntTDA cola1, ColaIntTDA cola2) {
        while (! cola1.colaVacia()) {
            cola2.acolar(cola1.primero());
            cola1.desacolar();
        }
    }

    // Imprime de manera NO destructiva los valores cargados en una cola.
    public void imprimeCola(final ColaIntTDA cola) {

        ColaIntTDA colaTemp = new ColaInt();
        colaTemp.inicializarCola();
        int valor;

        // Guardamos el valor impreso en una cola temporal
        while (!cola.colaVacia()) {
            valor = cola.primero();
            cola.desacolar();

            colaTemp.acolar(valor);
            System.out.println(" -- " + valor);
        }
        // Devolvemos los valores a la cola original
        colaToCola(colaTemp, cola);
    }

    /** Carga una cola de numeros enteros con los movimientos en formato IIIPPSSSS donde III es el
     * identificador de persona, PP es el código de proveedor y SSSS es el código de película.
     * @Precondicion Las tablas deben estar cargadas con los datos a utilizar
     * @Precondicion La cola recibida debe estar inicializada
     */
    public void cargarMovimientos(String archivo, ColaIntTDA aCargar, TablaTDA peliculas, TablaTDA proveedores) {
        try {
            FileReader arch = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(arch);

            int idPersona;
            String linea;
            int idProveedor;
            int idPelicula;
            int codigoCompuesto;

            linea = buffer.readLine();
            while (linea != null) {
                String[] lista = linea.split(";");
                idPersona = Integer.valueOf(lista[0]);
                idProveedor = proveedores.codigo(lista[2].strip());
                idPelicula = peliculas.codigo(lista[1].strip());
                
                linea = buffer.readLine();

                // IIIPPSSSS donde III es el identificador de persona, PP es el código de proveedor y SSSS es el código de película.
                codigoCompuesto = ((idPersona * 100) + idProveedor) * 10000 + idPelicula;
                aCargar.acolar(codigoCompuesto);
            }
            arch.close();
        }
        catch (Exception e) {
            System.out.println("Ocurrio un error al leer el archivo " + archivo + ": " + e);
        }
    }
}
