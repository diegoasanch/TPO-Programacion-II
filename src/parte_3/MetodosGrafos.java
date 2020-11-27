/** @author Diego Sanchez */

package parte_3;

import java.util.Scanner;
import miApi.GrafoTDA;
import miApi.ConjuntoTDA;
import misImplementaciones.Conjunto;
import misImplementaciones.GrafoD;
import misImplementaciones.GrafoE;

public class MetodosGrafos {

    /** Copia los elementos de grafo1 a grafo2 manteniendo su estructura */
    public void copiaGrafo(GrafoTDA grafo1, GrafoTDA grafo2) {
        ConjuntoTDA vertices = grafo1.vertices();
        int vert;

        // Agregamos los vertices
        while (!vertices.conjuntoVacio()) {
            vert = vertices.obtener();
            vertices.sacar(vert);
            grafo2.agregarVertice(vert);
        }

        vertices = grafo1.vertices();

        // Aca guardaremos los vertices a recorrer en el ciclo anidado
        ConjuntoTDA verticesCiclo;
        int vertBase, vertRef;

        while (!vertices.conjuntoVacio()) {
            vertBase = vertices.obtener();
            vertices.sacar(vertBase);

            verticesCiclo = grafo1.vertices();

            while (!verticesCiclo.conjuntoVacio()) {
                vertRef = verticesCiclo.obtener();
                verticesCiclo.sacar(vertRef);

                // Si existe en el grafo original pero no en el segundo (para evitar duplicados)
                if (grafo1.existeArista(vertBase, vertRef) && !grafo2.existeArista(vertBase, vertRef))
                    grafo2.agregarArista(vertBase, vertRef, grafo1.pesoArista(vertBase, vertRef));
            }
        }
    }

    // imprime el grafo recibido por pantalla
    public void imprimeGrafo(GrafoTDA grafo) {
        ConjuntoTDA verticesBase = grafo.vertices();
        ConjuntoTDA verticesRef;
        int vertActual, vertRef;

        while (!verticesBase.conjuntoVacio()) {
            vertActual = verticesBase.obtener();
            verticesBase.sacar(vertActual);

            System.out.println("\nVertice " + vertActual + ":");
            verticesRef = grafo.vertices();

            while (!verticesRef.conjuntoVacio()) {
                vertRef = verticesRef.obtener();
                verticesRef.sacar(vertRef);

                // Arista saliente
                if (grafo.existeArista(vertActual, vertRef))
                    System.out.println("    " + vertActual + " --- " + grafo.pesoArista(vertActual, vertRef) + " ---> " + vertRef);

                // Arista entrante
                else if (grafo.existeArista(vertRef, vertActual))
                    System.out.println("    " + vertActual + " <--- " + grafo.pesoArista(vertRef, vertActual) + " --- " + vertRef);
            }
        }
    }

    // Carga vertices y aristas en el grafo recibido hasta recibir un campo vacio
    public void cargaGrafo(GrafoTDA grafo) {

        Scanner teclado = new Scanner(System.in);
        String linea;
        int vert1, vert2, peso;

        System.out.print("Ingrese (vertice1, vertice2, pesoArista): ");
        linea = teclado.nextLine();

        while (!linea.equals("")) {
            String[] valores = linea.split(",");
            vert1 = Integer.valueOf(valores[0]);
            vert2 = Integer.valueOf(valores[1]);
            peso = Integer.valueOf(valores[2]);

            if (!grafo.vertices().pertenece(vert1))
                grafo.agregarVertice(vert1);

            if (!grafo.vertices().pertenece(vert2))
                grafo.agregarVertice(vert2);

            if (!grafo.existeArista(vert1, vert2))
                grafo.agregarArista(vert1, vert2, peso);

            else
                System.out.println("La arista ya pertenece al grafo");

            System.out.print("Ingrese (vertice1, vertice2, pesoArista): ");
            linea = teclado.nextLine();
        }
        teclado.close();
    }

    /** 3. a) Retorna un ConjuntoTDA con los vertices adyacentes dobles del vertice
     * origen recibido.
     * @Precondicion el vertice debe existir en el grafo
     * @Precondicion el grafo debe estar inicializado
     */
    public ConjuntoTDA adyacentesDobles(GrafoTDA grafo, int origen) {
        ConjuntoTDA adyacentes = new Conjunto();
        adyacentes.inicializarConjunto();

        ConjuntoTDA vertices = grafo.vertices();
        ConjuntoTDA vertices_internos;
        int vert, vert_int;

        while (!vertices.conjuntoVacio()) {
            vert = vertices.obtener();
            vertices.sacar(vert);

            // Si existe arista entre el vertice origen y el del ciclo
            if (vert != origen && grafo.existeArista(origen, vert)) {
                vertices_internos = grafo.vertices();

                // Buscamos las aristas del vertice intermedio
                while (!vertices_internos.conjuntoVacio()) {
                    vert_int = vertices_internos.obtener();
                    vertices_internos.sacar(vert_int);

                    if (grafo.existeArista(vert, vert_int) && !adyacentes.pertenece(vert_int))
                        adyacentes.agregar(vert_int);
                }
            }
        }
        return adyacentes;
    }

    /** 3. b) Retorna ConjuntoTDA con los vertices Predecesores del vertice "vert" dentro del grafo
     * "grafo" ambos recibidos como parametro
     * @Precondicion el vertice debe existir en el grafo
     * @Precondicion el grafo debe estar inicializado
     */
    public ConjuntoTDA predecesores(GrafoTDA grafo, int vert) {
        ConjuntoTDA pred = new Conjunto();
        pred.inicializarConjunto();

        ConjuntoTDA vertices = grafo.vertices();
        int actual;

        while (!vertices.conjuntoVacio()) {
            actual = vertices.obtener();
            vertices.sacar(actual);

            if (grafo.existeArista(actual, vert))
                pred.agregar(actual);
        }
        return pred;
    }

    /** 3. c) Retorna ConjuntoTDA con los certices aislados pertenecientes al grafo recibido
     * @Precondicion el grafo debe estar inicializado
     */
    public ConjuntoTDA aislados(GrafoTDA grafo) {
        //Comenzamos con todos los vertices y quitamos los que tengan aristas (entrantes y/o salientes)
        ConjuntoTDA resultado = grafo.vertices();

        ConjuntoTDA ciclo_externo = grafo.vertices();
        ConjuntoTDA ciclo_interno;
        int origen, destino;

        while (!ciclo_externo.conjuntoVacio()) {
            origen = ciclo_externo.obtener();
            ciclo_externo.sacar(origen);
            ciclo_interno = grafo.vertices();

            while (!ciclo_interno.conjuntoVacio()) {
                destino = ciclo_interno.obtener();
                ciclo_interno.sacar(destino);

                // Si existe arista y el valor esta en el resultado, lo sacamos
                if (grafo.existeArista(origen, destino)) {
                    if (resultado.pertenece(origen))
                        resultado.sacar(origen);
                    if (resultado.pertenece(destino))
                        resultado.sacar(destino);
                }
            }
        }
        return resultado;
    }

    /** 3. d) Retorna el grado del vertice dentro del grafo, ambos recibidos como parametro
     * @Precondicion el grafo debe estar inicializado
     */
    public int gradoVertice(GrafoTDA grafo, int vert) {
        // Comenzamos con el resultado en cero, las arista salientes sumamos, entrantes restamos
        int resultado = 0;
        int actual;
        ConjuntoTDA vertices = grafo.vertices();

        while (!vertices.conjuntoVacio()) {
            actual = vertices.obtener();
            vertices.sacar(actual);

            if (grafo.existeArista(vert, actual))
                resultado++;
            if (grafo.existeArista(actual, vert))
                resultado--;
        }
        return resultado;
    }

    /** 4. a) Retorna nuevo grafo donde el conjunto de vertices es la diferencia simetrica de los
     * conjuntos de vertices de los dos grafos recibidos
     * @Precondicion ambos grafos deben estar inicializados
     */
    public GrafoTDA diferenciaSimetrica(GrafoTDA grafo_1, GrafoTDA grafo_2) {
        MetodosConjuntos conjuntos = new MetodosConjuntos();
        GrafoTDA resultado = new GrafoE();
        resultado.inicializarGrafo();

        // Buscamos los vertices que pertenecen a la diferencia simetrica de los conjuntos de
        // vertices de ambos grafos recibidos
        ConjuntoTDA vertices_simetricos = conjuntos.diferenciaSimetrica(
            grafo_1.vertices(), grafo_2.vertices()
        );
        ConjuntoTDA nuevos_vertices = conjuntos.copiaConj(vertices_simetricos);

        // Agregamos los vertices al nuevo grafo
        int vert;

        while (!nuevos_vertices.conjuntoVacio()) {
            vert = nuevos_vertices.obtener();
            nuevos_vertices.sacar(vert);
            resultado.agregarVertice(vert);
        }

        // Agregamos las aristas a los vertices del nuevo grafo
        ConjuntoTDA nuevos_vertices_2;
        nuevos_vertices = conjuntos.copiaConj(vertices_simetricos);
        int actual, referencia;

        while (!nuevos_vertices.conjuntoVacio()) {
            actual = nuevos_vertices.obtener();
            nuevos_vertices.sacar(actual);

            nuevos_vertices_2 = conjuntos.copiaConj(nuevos_vertices);

            while (!nuevos_vertices_2.conjuntoVacio()) {
                referencia = nuevos_vertices_2.obtener();
                nuevos_vertices_2.sacar(referencia);

                // Vemos si la arista existe en el grafo 1
                agregaAristas(grafo_1, resultado, actual, referencia);

                // Vemos si la arista existe en el grafo 2
                agregaAristas(grafo_2, resultado, actual, referencia);
            }
        }
        return resultado;
    }

    /** Verifica si existe una arista entre base y referencia en ambos sentidos y de existir, la 
     * agrega al grafo resultado
     * @Precondicion Ambos grafos deben estar inicializados
     */
    private void agregaAristas(GrafoTDA grafo, GrafoTDA resultado, int base, int referencia) {

        // Vemos si el grafo contiene ambos vertices
        if (grafo.vertices().pertenece(base) && grafo.vertices().pertenece(referencia)) {

            // Si existe arista saliente se agrega
            if (grafo.existeArista(base, referencia))
                resultado.agregarArista(base, referencia, grafo.pesoArista(base, referencia));
            // Arista entrante
            if (grafo.existeArista(referencia, base))
                resultado.agregarArista(referencia, base, grafo.pesoArista(referencia, base));   
        }
    }
}
