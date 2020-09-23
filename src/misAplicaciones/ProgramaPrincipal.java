/** @author Diego Sanchez
 * Programa principal
 */
package misAplicaciones;

import miApi.TablaTDA;
import miApi.ColaIntTDA;
import miApi.ColaPrioridadTDA;
import miApi.DiccionarioSimpleTDA;
import miApi.DiccionarioMultipleTDA;

import misImplementaciones.Tabla;
import misImplementaciones.ColaInt;
import misImplementaciones.DiccionarioSimple;
import misImplementaciones.DiccionarioMultiple;

import misAlgoritmos.MetodosTabla;
import misAlgoritmos.MetodosColaInt;

public class ProgramaPrincipal {
    public static void main(String[] args) {
        MetodosTabla metodosTablas = new MetodosTabla();
        MetodosColaInt metodosColasInt = new MetodosColaInt();

        // Inicializamos las Tablas y las Cargamos
        TablaTDA peliculas = new Tabla();
        peliculas.inicializarTabla();

        TablaTDA proveedores = new Tabla();
        proveedores.inicializarTabla();

        metodosTablas.cargaTabla(peliculas, "archivos_de_prueba/ListadoPeliculas.txt");    
        metodosTablas.cargaTabla(proveedores, "archivos_de_prueba/StreamCia.txt");

        // Creamos y cargamos la cola con los movimientos
        ColaIntTDA movimientos = new ColaInt();
        movimientos.inicializarCola();
        metodosColasInt.cargarMovimientos("archivos_de_prueba/Movimientos.txt", movimientos, peliculas, proveedores);
        
        // Inicializamos la clase que lleva el conteo de las solicitudes
        CantSolicitudes solicitudes = new CantSolicitudes();
        
        // Creamos el diccionario para el registro de las solicitudes
        DiccionarioSimpleTDA registroSolicitudes = new DiccionarioSimple();
        registroSolicitudes.inicializarDiccionarioSimple();

        // Creamos el diccionario multiple para el registro a quien se les solicito la pelicula
        DiccionarioMultipleTDA registroCompanias = new DiccionarioMultiple();
        registroCompanias.inicializarDiccionarioMultiple();



        int mov;
        int idPelicula, idProveedor;

        while (!movimientos.colaVacia()) {
            mov = movimientos.primero();
            movimientos.desacolar();
            
            idProveedor = (mov / 10000) % 1000; 
            idPelicula = mov % 10000;

            solicitudes.conteoSolicitudes(registroSolicitudes, idPelicula);
            solicitudes.registraCompania(registroCompanias, idPelicula, idProveedor);
            
            // Aca se envia el numero de movimiento a cada uno de los programa para que realicen la clasificacion
            // correspondiente, se envia un movimiento por ciclo
        }
        
        /** Aca al finalizar el ciclo se haran los llamados a los programas para que estos emitan
        su reporte */
        
        ColaPrioridadTDA masSolicitados = solicitudes.generaColaSolicitudes(registroSolicitudes);
        
        // Item 3
        solicitudes.imprimeCompanias(registroCompanias, masSolicitados, peliculas);
        // Item 4
        solicitudes.topSolicitudes(masSolicitados, peliculas);
    }
}
