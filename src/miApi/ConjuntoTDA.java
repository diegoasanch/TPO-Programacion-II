/** @author diegoasanch
 * @Conjunto es una estructura que permite almacenar una coleccion de valores
 * enteros no repetidos y no necesariamente ordenado
 */
package miApi;

public interface ConjuntoTDA {
    /** @tarea InicializarConjunto Inicializa el conjunto
     */
    public void inicializarConjunto();

    /** @tarea Agregar agrega un elemento x suministrado.
     * @Precondicion el conjunto debe estar inicializado y el elemento no debe existir
     */
    public void agregar(int x);

    /** @tarea Sacar elimina un elemento suministrado x.
     * @Precondicion EL elemento debe pertenecer al conjunto.
     */
    public void sacar(int x);

    /** @tarea Obtener devuelve un valor cualquiera del conjunto.
     * @Precondicion el conjunto no debe estar vacio
     */
    public int obtener();

    /** @tarea ConjuntoVacio devuelve verdadero si el conjunto tiene elementos
     * @Precondicion El conjunto debe estar inicializado
     */
    public boolean conjuntoVacio();

    /** @tarea Pertenece devuelve verdadero si el valor x recibido como parametro pertenece al conjunto
     * @Precondicion el conjunto debe estar incializado
     */
    public boolean pertenece(int x);

}

