/** @author Diego Sanchez
 * @Cola es una estructura que permite almacenar en una coleccion de valores
 * enteros, con la particularidad de que el primer elemento en ingresar es el
 * primer elemento en salir. Tambien se la conoce como estructura FIFO.
 */

package miApi;

public interface ColaIntTDA {
    /** @tarea InicializarCola incializa la estructura cola */
    public void inicializarCola();

    /** @Tarea Acolar agrega un elemento a la cola
     * @Precondicion La estructura debe estar inicializda
     */
    public void acolar(int x);

    /** @Tarea Desacolar elimina el elemento mas antiguo agregado
     * @Precondicion La estructura no debe estar vacia
     */
    public void desacolar();

    /** @Tarea Primero obtiene el primer elemento a eliminar
     * @Precondicion La estructura no debe estar vacia
     */
    public int primero();

    /** @tarea ColaVacia indica si la cola contiene elementos o no
     * @Precondicion La estructura deve estar inicializada
     */
    public boolean colaVacia();
}
