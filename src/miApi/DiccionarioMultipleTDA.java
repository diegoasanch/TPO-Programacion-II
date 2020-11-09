/** @author Diego Sanchez
 * Diccionario múltiple es una colección de elementos asociados clave-valores.
 * La clave y los valores son números enteros. Las claves son únicas. No puede
 * existir clave sin valor asociado. Los valores son únicos para una misma clave
 */

package miApi;

public interface DiccionarioMultipleTDA {

    // Inicializa el diccionario
    public void inicializarDiccionarioMultiple();

    /** Agrega un valor a una clave, ambos datos suministrados. Si no existe la
     * clave, se agrega.
     * @Precondicion El diccionario debe estar inicializado y el valor no debe
     * existir para esa clave
     */
    public void agregar(int clave, int valor);

    /** Elimina una clave suministradajunto con los valores asociados.
     * @Precondicion La clave debe existir.
     */
    public void eliminar(int clave);

    /** Elimina un valor asociado a unaclave, ambos datos suministrados.
     * @Precondicion Ambos deben existir.
     */
    public void eliminaValor(int clave, int valor);

    /** Devuelve el conjunto de valores asociadosa una clave suministrada. No
     * elimina los valores.
     * @Precondicion La clave debe existir
     */
    public ConjuntoTDA obtener(int clave);

    /** Devuelve el conjunto de claves del diccionario. No elimina las claves.
     * @Precondicion El diccionario debe estar inicializado.
     */
    public ConjuntoTDA claves();
}
