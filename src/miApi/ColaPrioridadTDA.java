/** @author Diego Sanchez
 * Interface de una cola con prioridad
 */
package miApi;

public interface ColaPrioridadTDA {

    /** @tarea InicializarCola incializa la estructura cola */
    void inicializarCola();
    
    /** @Tarea Acolar agrega un elemento a la cola colocandolo en
     * la posicion acorde a su prioridad
     * @Precondicion La estructura debe estar inicializda
     */
    void acolarPrioridad(int valor, int prioridad);
    
    /** @Tarea Desacolar elimina el elemento mas antiguo agregado
     * @Precondicion La estructura no debe estar vacia
     */
    void desacolar();
    
    /** @Tarea primerValor obtiene el primer elemento a eliminar
     * @Precondicion La estructura no debe estar vacia
     */
    int primerValor();

    /** @tarea primeraPrioridad obtiene la prioridad del primer
     * elemento en salir
     * @Precondicion la cola no debe estar 
     */
    int primeraPrioridad();

    /** @tarea ColaVacia indica si la cola contiene elementos o no
     * @Precondicion La estructura deve estar inicializada
     */
    boolean colaVacia();
}
