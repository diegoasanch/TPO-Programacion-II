/** @author Diego Sanchez
 * Implementacion dinamica de una Tabla. Guarda un Nombre vinculado a su codigo
 * autogenerado en base a su momento de cargado
 */

package misImplementaciones;

import miApi.TablaTDA;
import miApi.ColaStrTDA;

public class Tabla implements TablaTDA {
    class Nodo {
        int cod;
        String nombre;
        Nodo sig;
    }

    private int cant;
    private Nodo primero;
    private Nodo ultimo;

    public void inicializarTabla() {
        cant = 0;
        primero = ultimo = null;
    }

    public void agregar(String nombre) {
        Nodo nuevo = new Nodo();
        nuevo.nombre = nombre;
        nuevo.cod = cant;

        // Si esta vacia el nuevo es el primer y ultimo nodo
        if (estaVacia())
            primero = ultimo = nuevo;

        else {
            ultimo.sig = nuevo;
            ultimo = nuevo;
        }
        cant++;
    }

    public boolean pertenece(String nombre) {
        boolean esta = false;
        Nodo actual = primero;

        while (!esta && actual != null) {
            esta = actual.nombre.equals(nombre);
            actual = actual.sig;
        }
        return esta;
    }

    public int codigo(String nombre) {
        Nodo actual = primero;
        int codAsociado = actual.cod;

        while (!actual.nombre.equals(nombre)) {
            actual = actual.sig;
            codAsociado = actual.cod;
        }
        return codAsociado;
    }

    public String nombre(int codigo) {
        Nodo actual = primero;
        String nombAsociado = actual.nombre;

        while (actual.cod != codigo) {
            actual = actual.sig;
            nombAsociado = actual.nombre;
        }
        return nombAsociado;
    }

    public ColaStrTDA elementosTabla() {
        ColaStrTDA elementos = new ColaStr();
        elementos.inicializarCola();
        Nodo actual = primero;

        while (actual != null) {
            elementos.acolar(actual.cod + ";" + actual.nombre);
            actual = actual.sig;
        }
        return elementos;
    }

    public void ordenarNombres() {
        if (cant > 1) {
            Nodo base = primero;
            int codAux;
            String nombreAux;

            while (base.sig != null) {
                Nodo actual = base.sig;

                while (actual != null) {
                    // Si el nombre base es alfabeticamente mayor al actual
                    if (base.nombre.compareTo(actual.nombre) > 0) {
                        codAux = base.cod;
                        nombreAux = base.nombre;
                        
                        // Intercambiamos valores
                        base.cod = actual.cod;
                        base.nombre = actual.nombre;
                        actual.cod = codAux;
                        actual.nombre = nombreAux;
                    }
                    actual = actual.sig;
                }
                base = base.sig;
            }
        }
    }

    public void ordenarCodigos() {
        if (cant > 1) {
            Nodo base = primero;
            int codAux;
            String nombreAux;

            while (base.sig != null) {
                Nodo actual = base.sig;

                while (actual != null) {
                    if (base.cod > actual.cod) {
                        codAux = base.cod;
                        nombreAux = base.nombre;
                        
                        // Intercambiamos valores
                        base.cod = actual.cod;
                        base.nombre = actual.nombre;
                        actual.cod = codAux;
                        actual.nombre = nombreAux;
                    }
                    actual = actual.sig;
                }
                base = base.sig;
            }
        }
    }

    public boolean estaVacia() {
        return cant == 0;
    }

}
