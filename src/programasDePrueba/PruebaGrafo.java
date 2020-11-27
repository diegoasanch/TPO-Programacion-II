package programasDePrueba;

import miApi.ConjuntoTDA;
import miApi.GrafoTDA;
import misImplementaciones.GrafoD;
import misImplementaciones.GrafoE;
import parte_3.MetodosGrafos;
import misAlgoritmos.MetodosConjunto;

public class PruebaGrafo {
    public static void main(String[] args) {
        GrafoTDA grafo = new GrafoE();
        grafo.inicializarGrafo();

        MetodosGrafos grafos = new MetodosGrafos();
        // grafos.cargaGrafo(grafo);
        cargaPrueba(grafo);

        MetodosConjunto conjuntos = new MetodosConjunto();

        // 3. a) ----------------------------------------------
        // ConjuntoTDA adyacentesDob = grafos.adyacentesDobles(grafo, 5);
        // conjuntos.imprimeCon(adyacentesDob);

        // 3. b) ----------------------------------------------
        // System.out.println("Test 1. predecesores de \"6\" ");
        // ConjuntoTDA predecesores = grafos.predecesores(grafo, 6);
        // conjuntos.imprimeCon(predecesores);

        // System.out.println("Test 1. predecesores de \"5\" ");
        // predecesores = grafos.predecesores(grafo, 5);
        // conjuntos.imprimeCon(predecesores);
        
        // System.out.println("Test 1. predecesores de \"4\" ");
        // predecesores = grafos.predecesores(grafo, 4);
        // conjuntos.imprimeCon(predecesores);

        // 3. c) ----------------------------------------------
        // grafo.agregarVertice(11);
        // grafo.agregarVertice(13);
        // ConjuntoTDA aislados = grafos.aislados(grafo);
        // conjuntos.imprimeCon(aislados);

        // 3. d) ----------------------------------------------
        // int vert = 6;
        // int grado = grafos.gradoVertice(grafo, vert);
        // System.out.printf("El grado del vertice %d es %d", vert, grado);


        // 4. a)
        GrafoTDA grafo_1 = new GrafoD();
        GrafoTDA grafo_2 = new GrafoD();
        cargaSim(grafo_1, grafo_2);

        GrafoTDA res = grafos.diferenciaSimetrica(grafo_1, grafo_2);
        grafos.imprimeGrafo(res);
        
    }
    
    public static void cargaPrueba(GrafoTDA grafo) {
        int[][] valores = {
            {2, 3},
            {2, 5},
            {3, 6},
            {4, 2},
            {4, 7},
            {5, 3},
            {5, 8},
            {5, 9},
            {6, 5},
            {8, 2},
            {8, 5},
            {9, 6}
        };

        int i;
        int desde, hasta;
        ConjuntoTDA verts;

        for (i = 0; i < 12; i++) {
            verts = grafo.vertices();
            desde = valores[i][0];
            hasta = valores[i][1];
            
            if (!verts.pertenece(desde))
                grafo.agregarVertice(desde);
            if (!verts.pertenece(hasta))
                grafo.agregarVertice(hasta);
            if (!grafo.existeArista(desde, hasta))
                grafo.agregarArista(desde, hasta, 1);
        }
    }

    public static void cargaSim(GrafoTDA grafo_1, GrafoTDA grafo_2) {
        int[][] valores_sim_1 = {
            {2, 3},
            {3, 9},
            {4, 17},
            {6, 3},
            {6, 15},
            {17, 15},
        };
        int[][] valores_sim_2 = {
            {3, 9},
            {6, 3},
            {9, 13},
            {13, 6},
            {13, 42},
            {42, 9},
        };

        int i;
        int desde, hasta;
        ConjuntoTDA verts;

        for (i = 0; i < 6; i++) {
            verts = grafo_1.vertices();
            desde = valores_sim_1[i][0];
            hasta = valores_sim_1[i][1];
            
            if (!verts.pertenece(desde))
                grafo_1.agregarVertice(desde);
            if (!verts.pertenece(hasta))
                grafo_1.agregarVertice(hasta);
            if (!grafo_1.existeArista(desde, hasta))
                grafo_1.agregarArista(desde, hasta, 1);
        }
        for (i = 0; i < 6; i++) {
            verts = grafo_2.vertices();
            desde = valores_sim_2[i][0];
            hasta = valores_sim_2[i][1];
            
            if (!verts.pertenece(desde))
                grafo_2.agregarVertice(desde);
            if (!verts.pertenece(hasta))
                grafo_2.agregarVertice(hasta);
            if (!grafo_2.existeArista(desde, hasta))
                grafo_2.agregarArista(desde, hasta, 1);
        }
    }
}
