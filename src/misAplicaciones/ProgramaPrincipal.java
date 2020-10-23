/** @author Diego Sanchez
 * Programa principal
 */
package misAplicaciones;

import miApi.TablaTDA;
import miApi.ColaIntTDA;
import miApi.ColaPrioridadTDA;
import miApi.DiccionarioSimpleTDA;
import miApi.DiccionarioMultipleTDA;

import misImplementaciones.DiccionarioSimple;
import misImplementaciones.DiccionarioMultiple;

import misAlgoritmos.MetodosTabla;
import misAlgoritmos.MetodosColaInt;

public class ProgramaPrincipal {
    public static void main(String[] args) {
        
        // Inicializamos los metodos que llevaran a cabo las funciones
        MetodosTabla metodosTablas = new MetodosTabla();
        MetodosColaInt metodosColasInt = new MetodosColaInt();
        ListMayorCantPeliculas solicitudesPeli = new ListMayorCantPeliculas();
        CantSolicitudes solicitudes = new CantSolicitudes();
        
        // Inicializamos las Tablas y las Cargamos
        TablaTDA peliculas = metodosTablas.cargaTabla("archivos_de_prueba/ListadoPeliculas.txt");
        TablaTDA proveedores = metodosTablas.cargaTabla("archivos_de_prueba/StreamCia.txt");
    
        // Creamos y cargamos la cola con los movimientos
        ColaIntTDA movimientos = metodosColasInt.cargarMovimientos("archivos_de_prueba/Movimientos.txt", peliculas, proveedores);
        
        // Creamos el diccionario para el registro de las solicitudes
        DiccionarioSimpleTDA registroSolicitudes = new DiccionarioSimple();
        registroSolicitudes.inicializarDiccionarioSimple();
        DiccionarioSimpleTDA diccSolicitudes = new DiccionarioSimple();
        diccSolicitudes.inicializarDiccionarioSimple();

        // Creamos el diccionario multiple para el registro a quien se les solicito la pelicula
        DiccionarioMultipleTDA registroCompanias = new DiccionarioMultiple();
        registroCompanias.inicializarDiccionarioMultiple();

        int mov;
        int idPelicula, idProveedor, idPersona;

        while (!movimientos.colaVacia()) {
            // Aca se envia el numero de movimiento a cada uno de los programa para que realicen la clasificacion
            // correspondiente, se envia un movimiento por ciclo

            mov = movimientos.primero();
            movimientos.desacolar();
            
            idPersona = mov / 1000000;
            idProveedor = (mov / 10000) % 1000; 
            idPelicula = mov % 10000;

            solicitudes.conteoSolicitudes(registroSolicitudes, idPelicula);
            solicitudes.registraCompania(registroCompanias, idPelicula, idProveedor);
            solicitudesPeli.Llevarconteo(diccSolicitudes, idPersona);
        }
        
        /** Aca al finalizar el ciclo se haran los llamados a los programas para que estos emitan
        su reporte */
        
        ColaPrioridadTDA masSolicitados = solicitudes.generaColaSolicitudes(registroSolicitudes);
        ColaPrioridadTDA personasMasSolicitudes = solicitudes.generaColaSolicitudes(diccSolicitudes);
        
        System.out.println('+' + "-".repeat(60) + '+');
        // Item 2
        solicitudesPeli.imprimeSolicitudes(personasMasSolicitudes);
        
        System.out.println('+' + "-".repeat(60) + '+');
        // Item 3
        solicitudes.imprimeCompanias(registroCompanias, masSolicitados, peliculas);
        
        System.out.println('+' + "-".repeat(60) + '+');
        // Item 4
        solicitudes.topSolicitudes(masSolicitados, peliculas, 10);
    }
}
