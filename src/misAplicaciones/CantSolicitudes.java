/** @author Diego Sanchez
 * Programa que lleva el conteo de las solicitudes de las peliculas, emite listados
 */
package misAplicaciones;

import miApi.DiccionarioSimpleTDA;
import miApi.TablaTDA;
import miApi.ColaPrioridadTDA;
import miApi.ConjuntoTDA;
import miApi.DiccionarioMultipleTDA;
import misAlgoritmos.MetodosDiccionarioSimple;
import misImplementaciones.ColaPrioridad;
import misAlgoritmos.MetodosColaPrioridad;

// import miApi.ConjuntoTDA;
// import misImplementaciones.DiccionarioSimple;
// ejemplo

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
    
    /** Lleva el registro de a que empresas fue solicitada una pelicula
     * @Precondicion el DiccionarioTDA registro debe estar inicializado
     */
    public void registraCompania(DiccionarioMultipleTDA registro, int idPelicula, int idProveedor) {
        // Si no existe clave con el idPelicula o si existe pero no tiene el idProveedor asociado
        // Agregamos el idProveedor al cojunto de valores
        if (!registro.claves().pertenece(idPelicula) || !registro.obtener(idPelicula).pertenece(idProveedor))
            registro.agregar(idPelicula, idProveedor);
    }

    /** Imprime las peliculas con mayor cantidad de solicitudes junto a que empresa fueron solicitadas
     * @Precondicion el Diccionario de registro debe estar inicializado
     * @Precondicion la cola de masSolicitados debe estar inicializado
      */
    public void imprimeCompanias(DiccionarioMultipleTDA registro, ColaPrioridadTDA masSolicitados, TablaTDA nombrePeliculas) {
        MetodosColaPrioridad metodos = new MetodosColaPrioridad();
        ColaPrioridadTDA copiaSolicitudes = metodos.copiaCola(masSolicitados);

        int peli, cia, prio, masSolicitada;
        ConjuntoTDA cias;
        masSolicitada = prio = copiaSolicitudes.primeraPrioridad();
        
        System.out.println("\nPeliculas mas solicitadas:\n");

        while (prio == masSolicitada) {

            peli = copiaSolicitudes.primerValor();
            copiaSolicitudes.desacolar();
            System.out.printf("Pelicula %s solicitada a:%n", nombrePeliculas.nombre(peli));

            cias = registro.obtener(peli);
            while (!cias.conjuntoVacio()) {
                cia = cias.obtener();
                cias.sacar(cia);

                System.out.printf("\t- %d", cia);
            }
            System.out.println();
            prio = copiaSolicitudes.primeraPrioridad();
        }
    }

    public ColaPrioridadTDA generaColaSolicitudes(DiccionarioSimpleTDA registro) {

        ColaPrioridadTDA miCola = new ColaPrioridad();
        miCola.inicializarCola();

        ConjuntoTDA peliculas = registro.claves();
        int peli, cant;

        // Acolamos en una colaPrioridad las peliculas con su cantidad de solicitudes
        while (!peliculas.conjuntoVacio()) {
            peli = peliculas.obtener();
            cant = registro.obtener(peli);

            peliculas.sacar(peli);
            miCola.acolarPrioridad(peli, cant);
        }
        return miCola;
    }


    /** Imprime listado de las peliculas y sus correspondientes solicitudes */
    public void imprimeConteo(DiccionarioSimpleTDA aImprimir) {
        MetodosDiccionarioSimple metodos = new MetodosDiccionarioSimple();
        metodos.imprime(aImprimir);
    }

    /** Imprime una cola con prioridad de manera valor = pelicula; prioridad = n de solicitudes
     * las 10 peliculas mas solicitadas, el nombre de la pelicula se busca en la TablaTDA nombrePeliculas
     * @param top cantidad de elementos en el listado
     * @precondicion La cola y la tabla deben estar inicializadas, los codigos de la cola deben pertenecer a la tabla
     */
    public void topSolicitudes(ColaPrioridadTDA solicitudes, TablaTDA nombrePeliculas, int top) {
        
        int peli, cant;

        MetodosColaPrioridad metodosColaPri = new MetodosColaPrioridad();

        ColaPrioridadTDA copiaSolicitudes = metodosColaPri.copiaCola(solicitudes);

        System.out.printf("%nTop %d Peliculas mas solicitadas:%n%n", top);
        System.out.println("Solicitudes        Pelicula");
        System.out.println("---------------------------------");
        for (int i = 0; i < top; i++) {
            peli = copiaSolicitudes.primerValor();
            cant = copiaSolicitudes.primeraPrioridad();
            copiaSolicitudes.desacolar();

            System.out.printf("%5d  .........  %s%n", cant, nombrePeliculas.nombre(peli));
        }
    }

}
