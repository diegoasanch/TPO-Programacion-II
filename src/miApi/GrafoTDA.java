/** @author Diego Sanchez */

package miApi;

public interface GrafoTDA {

    /** @tarea inicializarGrafo inicializa la estructura
     */
    public void inicializarGrafo();

    /** @tarea agregarVertice agrega un nuevo vertice al grafo
     * @precond La estructura debe estar inicializada
     * @precond El vertice no debe existir
     */
    public void agregarVertice(int vert);

    /** @tarea agregarArista agrega una arista al grafo entre los vertices
     *   dados y  con el peso dado siempre que ambos vertices existan y
     *   no exista una arista enre ellos
     */
    public void agregarArista(int vert1, int vert2, int peso);

    /** @tarea eliminarVertices elimina el vertice dado siempre que el
     * vertice exista
     */
    public void eliminarVertice(int vert);

    /** @tarea eliminarArista elimina la arista enre los dos vertices dados
     * @precond Debe existir la arista
     */
    public void eliminarArista(int vert1, int vert2);

    /** @tarea existeArista indica si el grafo contiene una arrista entre
     * los vertices dados
     * @precond los vertices deben existir
     */
    public boolean existeArista(int vert1, int vert2);

    /** @tarea pesoArista devuelve el peso de la arista entre los vertices
     *  dados
     * @precond la arista debe existir
     */
    public int pesoArista(int vert1, int vert2);

    /** @tarea vertices retorna el conjunto de vertices del grafo
     * @precond la estructura debe estar inicializada
     */
    public ConjuntoTDA vertices();
}
