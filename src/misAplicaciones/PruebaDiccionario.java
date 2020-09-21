package misAplicaciones;
import miApi.*;
import misImplementaciones.*;

public class PruebaDiccionario {
    public static void main(String[] args) {
        DiccionarioSimpleTDA dicc = new DiccionarioSimple();
        dicc.inicializarDiccionarioSimple();

        for (int i = 0; i < 10; i++) {
            dicc.agregar(i, (i*10 + i));
        }

        ConjuntoTDA claves = dicc.claves();
        int num;

        while (!claves.conjuntoVacio()) {
            num = claves.obtener();
            claves.sacar(num);
            System.out.printf("Clave %d --- Valor %d %n", num, dicc.obtener(num));
        }
    }
}
