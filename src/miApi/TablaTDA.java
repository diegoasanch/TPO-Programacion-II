/** @author Diego Sanchez
 * Tabla es una estructura que permite almacenar una colección de elementos.
 * Cada elemento consta de un nombre asociado a un código (tipo de dato entero).
 */

package miApi;

public interface TablaTDA {

    // Inicializa la tabla
    public void inicializarTabla();

    /* Agrega un nuevo elemento a la tabla, El codigo del elemento sera determinado al
     * momento de agregarlo y depende de la cantidad de elementos previamente agregados
     * a la tabla
     * @precondicion La tabla debe estar inicializada
     */
    public void agregar(String nombre);

    /** Determina si un nombre pertenece a la tabla
     * @Precondicion La tabla debe estar inicializada
     */
    public boolean pertenece(String nombre);

    /** Indica el codigo de un nombre suministrado
     * @Precondicion El  nombre debe pertenecer a la tabla
     */
    public int codigo(String nombre);

    /** Indica el nombre relacionado a un codigo suministrado
     * @Precondicion El codigo debe pertenecer a la tabla
     */
    public String nombre(int codigo);

    /** Devuelve los elementos en una estructura ColaStrTDA donde cada elemento
     * corresponde a la concatenacion "codigo;nombre" segun el orden de guardados
     * @Precondicion La tabla debe estar inicializada
     */
    public ColaStrTDA elementosTabla();

    /** Ordena los elementos de la tabla alfabeticamente por los nombres
     * @Precondicion La tabla debe estar inicializada
     */
    public void ordenarNombres();

    /** Ordena los elementos de la tabla por los codigos en forma ascendente
     * @Precondicion La tabla debe estar inicializada
     */
    public void ordenarCodigos();

    /** Informa si la tabla no tiene elementos guardados
     * @Precondicion La tabla debe estar inicializada
     */
    public boolean estaVacia();
}
