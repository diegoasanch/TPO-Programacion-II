/** @author Diego Sanchez
 * Programa principal
 */
package misAplicaciones;

import miApi.TablaTDA;
import miApi.ColaIntTDA;
import miApi.DiccionarioSimpleTDA;

import misImplementaciones.Tabla;
import misImplementaciones.ColaInt;
import misImplementaciones.DiccionarioSimple;

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
        
        CantSolicitudes solicitudes = new CantSolicitudes();
        DiccionarioSimpleTDA registroSolicitudes = new DiccionarioSimple();
        registroSolicitudes.inicializarDiccionarioSimple();

        int mov;
        int idPelicula;

        while (!movimientos.colaVacia()) {
            mov = movimientos.primero();
            movimientos.desacolar();

            idPelicula = mov % 10000;
            // System.out.println(idPelicula);
            solicitudes.conteoSolicitudes(registroSolicitudes, idPelicula);
            
            // Aca se envia el numero de movimiento a cada uno de los programa para que realicen la clasificacion
            // correspondiente, se envia un movimiento por ciclo

        }
        solicitudes.imprimeConteo(registroSolicitudes);
        // Aca al finalizar el ciclo se haran los llamados a los programas para que estos emitan
        // su reporte
    }
}
