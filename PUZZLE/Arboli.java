package PUZZLE;


public class Arboli {
	
    private Nodo raiz;

    public Arboli() {
        raiz = null;
    }

    public boolean vacio() {
        return raiz == null;
    }

    public Nodo buscarNodo(String nombre) {
        return buscarNodo(raiz, nombre);
    }

    private Nodo buscarNodo(Nodo nodo, String nombre) {
        if (nodo == null || nodo.getNombre() == nombre) {
            return nodo;
        }
        if (nombre.length() <= nodo.getNombre().length()) {
            return buscarNodo(nodo.getIzquierdo(), nombre);
        }
        return buscarNodo(nodo.getDerecho(), nombre);
    }

    public void insertar(String nombre) {
        raiz = insertarNodo(raiz, nombre);
    }

    private Nodo insertarNodo(Nodo nodo, String nombre) {
        if (nodo == null) {
            nodo = new Nodo(nombre);
            return nodo;
        }
        if (nombre.length() <= nodo.getNombre().length()) {
            nodo.setIzquierdo(insertarNodo(nodo.getIzquierdo(), nombre));
        } else if (nombre.length() > nodo.getNombre().length()) {
        	nodo.setDerecho(insertarNodo(nodo.getDerecho(), nombre));
        }
        return nodo;
    }

    public void imprimirArbol() {
        imprimirArbol(raiz);
    }

    private void imprimirArbol(Nodo nodo) {
        if (nodo != null) {
            System.out.println(nodo.getNombre());
            imprimirArbol(nodo.getIzquierdo());
            imprimirArbol(nodo.getDerecho());
        }
    }
}
