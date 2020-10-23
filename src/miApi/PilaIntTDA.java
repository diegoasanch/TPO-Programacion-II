package miApi;

/**@author WeigandtAlexis
 * @Pila es una estructura que permite almacenar conjuntos de valores, eliminarlos y recuperarlos, con
 * a particularidad de que el elemento que se recupera o elimina es el �ltimo que ingres�.
 */

public interface PilaIntTDA {
	
	/**
     * @param x *  @Tarea Apilar agrega un elemento.
	*   @Precondici�n la pila debe estar inicializada
	*/
	
	void apilar(int x);
	
	/** @Tarea Desapilar elimina el �ltimo elemento agregado a la pila.
	*   @Precondici�n la pila debe estar inicializada y no vac�a.
	*/
	
	void desapilar();
	
	/**
     * @return  *  @Tarea Tope obtiene el valor del �ltimo elemento ingresado a la pila.
	*   @Precondici�n: la pila debe estar inicializada y no vac�a.
	*/
	
	int tope();
	
	/**
     * @return  *  @Tarea pilaVacia indica si la pila contiene elementos o no.
	*   @Precondici�n la pila debe estar inicializada.
	*/
	
	boolean pilaVacia();
	
	/** @Tarea InicializarPila inicializa la estructura de la pila. **/
	
	void inicializarPila();

	

}
