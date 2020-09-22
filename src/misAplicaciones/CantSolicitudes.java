/** @author Diego Sanchez
 * Programa que lleva el conteo de las solicitudes de las peliculas, emite listados
 */
package misAplicaciones;

import miApi.DiccionarioSimpleTDA;
import miApi.TablaTDA;
import miApi.ColaPrioridadTDA;
import miApi.ConjuntoTDA;
import misAlgoritmos.MetodosDiccionarioSimple;
import misImplementaciones.ColaPrioridad;

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

    /** Imprime un listado de las 10 peliculas mas solicitadas de un diccionario con formato
     * clave = idPelicula, valor = cantSolicitudes
     * @precondicion El diccionario de registro debe estar inicializado
     */
    public void topSolicitudes(DiccionarioSimpleTDA registro, TablaTDA nombrePeliculas) {
        ColaPrioridadTDA solicitudes = new ColaPrioridad();
        solicitudes.inicializarCola();

        ConjuntoTDA peliculas = registro.claves();
        int peli, cant;

        // Acolamos en una colaPrioridad las peliculas con su cantidad de solicitudes
        while (!peliculas.conjuntoVacio()) {
            peli = peliculas.obtener();
            cant = registro.obtener(peli);

            peliculas.sacar(peli);
            solicitudes.acolarPrioridad(peli, cant);
        }

        System.out.println("Solicitudes        Pelicula");
        System.out.println("---------------------------------");
        for (int i = 0; i < 10; i++) {
            peli = solicitudes.primerValor();
            cant = solicitudes.primeraPrioridad();
            solicitudes.desacolar();

            System.out.printf("%5d  .........  %s%n", cant, nombrePeliculas.nombre(peli));
        }
    }
}
