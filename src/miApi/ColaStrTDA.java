/** @author Diego Sanchez
 * @Cola es una estructura que permite almacenar en una coleccion de cadenas
 * de caracteres, con la particularidad de que el primer elemento e ingresar es el
 * primer elemento en salir. Tambien se la conoce como estructura FIFO.
 */

package miApi;

public interface ColaStrTDA {

    // @tarea InicializarCola incializa la estructura cola
    public void inicializarCola();

    /** Agrega un elemento a la cola
     * @Precondicion La estructura debe estar inicializda
     */
    public void acolar(String x);
    
    /** Elimina el elemento mas antiguo agregado
     * @Precondicion La estructura no debe estar vacia
     */
    public void desacolar();
    
    /** Obtiene el primer elemento a eliminar
     * @Precondicion La estructura no debe estar vacia
     */
    public String primero();
    
    /** Indica si la cola contiene elementos o no
     * @Precondicion La estructura deve estar inicializada
     */
    public boolean colaVacia();
}
