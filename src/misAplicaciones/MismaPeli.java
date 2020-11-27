/**@author Marian Coto, Diego Sanchez
*/

package misAplicaciones;
import miApi.DiccionarioMultipleTDA;
import miApi.ConjuntoTDA;
import misAlgoritmos.MetodosConjunto;
public class MismaPeli {
    public void registraMov(int id_peli, int id_pers, int id_prov, DiccionarioMultipleTDA registro) {
        int clave = (id_pers * 10000) + id_peli; // III SSSS

        if (!registro.claves().pertenece(clave) || !registro.obtener(clave).pertenece(id_prov))
            registro.agregar(clave, id_prov);
    }

    public void imprimeReporte(DiccionarioMultipleTDA reporte) {
        MetodosConjunto met = new MetodosConjunto();
        ConjuntoTDA claves = reporte.claves();
        int clave;
        ConjuntoTDA proveedores;
        int persona, pelicula, proveedor;
        int masDeUnProv = 0;

        while (!claves.conjuntoVacio()) {
            clave = claves.obtener();
            claves.sacar(clave);
            proveedores = reporte.obtener(clave);

            if (met.longitud(proveedores) > 1) {
                masDeUnProv++;
                persona = clave / 10000;
                pelicula = clave % 10000;

                System.out.printf("La persona: %d pidio la pelicula: %d a los siguientes proveedores:", persona, pelicula);
                
                while (!proveedores.conjuntoVacio()) {
                    proveedor = proveedores.obtener();
                    proveedores.sacar(proveedor);

                    System.out.printf("  - %d", proveedor);
                }
                System.out.println('\n');
            }
        }
        
        if (masDeUnProv == 0)
            System.out.println("Ninguna persona solicito la misma pelicula a mas de un proveedor.");
    }
}
