package misAplicaciones;
import miApi.ColaPrioridadTDA;
import miApi.DiccionarioSimpleTDA;
import misAlgoritmos.MetodosColaPrioridad;
import misImplementaciones.ColaPrioridad;

public class ListMayorCantPeliculas {
	public void llevarconteo(DiccionarioSimpleTDA registro, int idPelicula){
		int entradas = 1;
        // Si la pelicula ya existe sacamos su valor anterior y le sumamos 1, eliminamos esa clave
        if (registro.claves().pertenece(idPelicula)) {
            entradas += registro.obtener(idPelicula);
            registro.eliminar(idPelicula);
        }
        // Creamos nuevo elemento con clave= idPelicula y las entradas totales
        registro.agregar(idPelicula, entradas);
	}

	public void imprimeSolicitudes(ColaPrioridadTDA masSolicitados) {
		ColaPrioridadTDA reporte = extraeTop(masSolicitados);
		int persona, cantidad;
		System.out.println("\nPersonas que solicitaron mas veces:\n");

		while (!reporte.colaVacia()) {
			cantidad= reporte.primerValor();
			persona = reporte.primeraPrioridad();

			reporte.desacolar();
			System.out.printf("  -Persona %d solicito %d veces%n",persona, cantidad);
		}
	}

	public ColaPrioridadTDA extraeTop(ColaPrioridadTDA solicitantes) {

		MetodosColaPrioridad metodos = new MetodosColaPrioridad();
		ColaPrioridadTDA copiaSolicitudes = metodos.copiaCola(solicitantes);

		int cantidad, masSolicitada, persona;
		masSolicitada = cantidad = copiaSolicitudes.primeraPrioridad();

		ColaPrioridadTDA nueva = new ColaPrioridad();
		nueva.inicializarCola();

		while (cantidad == masSolicitada && !copiaSolicitudes.colaVacia()) {
			persona = copiaSolicitudes.primerValor();
			copiaSolicitudes.desacolar();

			// Acolamos en cola prioridad, prioridad = ID persona
			nueva.acolarPrioridad(cantidad, persona);

			cantidad = copiaSolicitudes.primeraPrioridad();
		}
		return nueva;
	}
}