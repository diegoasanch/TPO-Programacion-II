package misAplicaciones;
import miApi.ColaPrioridadTDA;
import miApi.ConjuntoTDA;
import miApi.DiccionarioMultipleTDA;
import miApi.DiccionarioSimpleTDA;
import miApi.TablaTDA;
import misAlgoritmos.MetodosColaPrioridad;
import misImplementaciones.ColaPrioridad;

public class ListMayorCantPeliculas {
	public void Llevarconteo(DiccionarioSimpleTDA registro, int idPelicula){
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
	        MetodosColaPrioridad metodos = new MetodosColaPrioridad();
	        ColaPrioridadTDA copiaSolicitudes = metodos.copiaCola(masSolicitados);

	        int persona, cantidad, masSolicitada;
	        masSolicitada = cantidad = copiaSolicitudes.primeraPrioridad();
	        
	        System.out.println("\nPeliculas mas solicitadas:\n");

	        while (cantidad == masSolicitada) {

	            persona = copiaSolicitudes.primerValor();
	            copiaSolicitudes.desacolar();
	            System.out.printf("Persona %d solicito %d veces%n",persona, cantidad);

	            cantidad = copiaSolicitudes.primeraPrioridad();
	        }
	    }
}
