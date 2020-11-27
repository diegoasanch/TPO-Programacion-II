package miApi;

public interface ABBTDA {
    
    void inicializarABB();

    // @Precond el arbol no debe estar vacio
    int raiz();               

    // @Precond el arbol debe estar inicializado
    ABBTDA hijoIzq();         

    // @Precond el arbol debe estar inicializado
    ABBTDA hijoDer();         

    // @Precond x no pertenece al arbol
    void agregar(int x);      

    // @Precond x pertenece al arbol
    void eliminar(int x);     

    // @Precond el arbol debe estar inicializado
    boolean pertenece(int x); 

    // @Precond el arbol debe estar inicializado
    boolean arbolVacio();     
}