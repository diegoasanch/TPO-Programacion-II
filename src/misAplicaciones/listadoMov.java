package misAplicaciones;

import misImplementaciones.ColaStr;
import miApi.ColaStrTDA;
import miApi.PilaIntTDA;
import miApi.TablaTDA;

public class listadoMov {

	public void mostrarColaStr(ColaStrTDA cola) {
        System.out.println("---LISTADO DE 10 ULTIMOS MOVIMIENTOS---");
        System.out.println();
        while(!cola.colaVacia()){
            String valor = cola.primero();
            cola.desacolar();
            
            System.out.println(valor);
        }
    }
	
	
         
	public ColaStrTDA crearColaDiezUltimos(PilaIntTDA pilaUltimos, TablaTDA peliculas, TablaTDA proveedores) {
		ColaStrTDA cola = new ColaStr();
		cola.inicializarCola();
		
		int cantidadParaDesapilar = 10;
		while (!pilaUltimos.pilaVacia() && cantidadParaDesapilar > 0) {
			int dato = pilaUltimos.tope();
			pilaUltimos.desapilar();
			int idPersona = dato/1000000;
			int idProveedor = (dato/10000)%100;
			int idPelicula = dato%10000;
			String nombreProveedor = proveedores.nombre(idProveedor);
			String nombrePelicula = peliculas.nombre(idPelicula);
			cola.acolar(String.format("%4d-%-30s-%-30s",idPersona,nombrePelicula,nombreProveedor));
			cantidadParaDesapilar--;
		}
		return cola;
		
	}

	

	
	}

	
        
    

