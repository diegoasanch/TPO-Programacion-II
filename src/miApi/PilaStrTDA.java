package miApi;

/**@author WeigandtAlexis
 * @Pila es una estructura que permite almacenar conjuntos de valores, eliminarlos y recuperarlos, con
 * a particularidad de que el elemento que se recupera o elimina es el último que ingresó.
 */

public interface PilaStrTDA {
	
	/**
     * @param x *  @Tarea Apilar agrega un elemento.
	*   @Precondición la pila debe estar inicializada
	*/
	
	void apilar(String x);
	
	/** @Tarea Desapilar elimina el último elemento agregado a la pila.
	*   @Precondición la pila debe estar inicializada y no vacía.
	*/
	
	void desapilar();
	
	/**
     * @return  *  @Tarea Tope obtiene el valor del último elemento ingresado a la pila.
	*   @Precondición: la pila debe estar inicializada y no vacía.
	*/
	
	String tope();
	
	/**
     * @return  *  @Tarea pilaVacia indica si la pila contiene elementos o no.
	*   @Precondición la pila debe estar inicializada.
	*/
	
	boolean pilaVacia();
	
	/** @Tarea InicializarPila inicializa la estructura de la pila. **/
	
	void inicializarPila();

}
