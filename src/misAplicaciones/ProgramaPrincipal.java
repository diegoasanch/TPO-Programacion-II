/** @author Diego Sanchez, Alexis Weigandt, Maxi Rosso, Mariano Coto
 * Programa principal
 */

package misAplicaciones;

import miApi.TablaTDA;
import miApi.ColaIntTDA;
import miApi.ColaPrioridadTDA;
import miApi.ColaStrTDA;
import miApi.DiccionarioSimpleTDA;
import miApi.DiccionarioMultipleTDA;
import miApi.PilaIntTDA;

import misImplementaciones.DiccionarioSimple;
import misImplementaciones.PilaInt;
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
        listadoMov listaUltimos = new listadoMov();
        MismaPeli mismaPelicula = new MismaPeli();

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

        // Creamos la pila para los 10 ultimos movimientos
        PilaIntTDA pilaUltimos = new PilaInt();
        pilaUltimos.inicializarPila();

        // Creamos el diccionario multiple para las personas que solicitaron la misma pelicula a distintos proveedores
        DiccionarioMultipleTDA registroMismaPeli = new DiccionarioMultiple();
        registroMismaPeli.inicializarDiccionarioMultiple();

        int mov;
        int idPelicula, idProveedor, idPersona;

        while (!movimientos.colaVacia()) {
            // Aca se envia el numero de movimiento a cada uno de los programas para que realicen la clasificacion
            // correspondiente, se envia un movimiento por ciclo

            mov = movimientos.primero();
            movimientos.desacolar();

            idPersona = mov / 1000000;
            idProveedor = (mov / 10000) % 1000;
            idPelicula = mov % 10000;

            pilaUltimos.apilar(mov);
            solicitudes.conteoSolicitudes(registroSolicitudes, idPelicula);
            solicitudes.registraCompania(registroCompanias, idPelicula, idProveedor);
            solicitudesPeli.llevarconteo(diccSolicitudes, idPersona);
            mismaPelicula.registraMov(idPelicula, idPersona, idProveedor, registroMismaPeli);
        }

        /** Aca al finalizar el ciclo se haran los llamados a los programas para que estos emitan
        su reporte */

        ColaPrioridadTDA masSolicitados = solicitudes.generaColaSolicitudes(registroSolicitudes);
        ColaPrioridadTDA personasMasSolicitudes = solicitudes.generaColaSolicitudes(diccSolicitudes);
        ColaStrTDA lista10Ultimos = listaUltimos.crearColaDiezUltimos(pilaUltimos, peliculas, proveedores);

        // Item 1
        System.out.println("+ item 1 " + "-".repeat(60) + '+');
        listaUltimos.mostrarColaStr(lista10Ultimos);

        // Item 2
        System.out.println("\n\n+ item 2 " + "-".repeat(60) + '+');
        solicitudesPeli.imprimeSolicitudes(personasMasSolicitudes);

        // Item 3
        System.out.println("\n\n+ item 3 " + "-".repeat(60) + '+');
        solicitudes.imprimeCompanias(registroCompanias, masSolicitados, peliculas);

        // Item 4
        System.out.println("\n\n+ item 4 " + "-".repeat(60) + '+');
        solicitudes.topSolicitudes(masSolicitados, peliculas, 10);
        
        // Item 5
        System.out.println("\n\n+ item 5 " + "-".repeat(60) + '+');
        mismaPelicula.imprimeReporte(registroMismaPeli);
        
    }
}
