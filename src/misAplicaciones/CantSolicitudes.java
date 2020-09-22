/** @author Diego Sanchez
 * Programa que lleva el conteo de las solicitudes de las peliculas, emite listados
 */
package misAplicaciones;

import miApi.DiccionarioSimpleTDA;
import misAlgoritmos.MetodosDiccionarioSimple;

// import miApi.ConjuntoTDA;
// import misImplementaciones.DiccionarioSimple;

public class CantSolicitudes {
    
    /** Lleva el conteo de las solicitudes totales de una pelicula, lleva el conteo 
     * @precondicion El DiccionarioSimple de registro debe estar inicializado
    */
    public void conteoSolicitudes(DiccionarioSimpleTDA registro, int idPelicula) {
        int entradas = 1;
        // Si la pelicula ya existe sacamos su valor anterior y le sumamos 1, eliminamos esa clave
        if (registro.claves().pertenece(idPelicula)) {
            entradas += registro.obtener(idPelicula);
            registro.eliminar(idPelicula);
        }
        // Creamos nuevo elemento con clave= idPelicula y las entradas totales
        registro.agregar(idPelicula, entradas);
    }

    /** Imprime listado de las peliculas y sus correspondientes solicitudes */
    public void imprimeConteo(DiccionarioSimpleTDA aImprimir) {
        MetodosDiccionarioSimple metodos = new MetodosDiccionarioSimple();
        metodos.imprime(aImprimir);
    }
}
