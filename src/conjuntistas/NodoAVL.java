package conjuntistas;

public class NodoAVL {
    // Zona de atributos
    private Comparable elem;
    private int altura;
    private NodoAVL izquierdo;
    private NodoAVL derecho;

    // Constructor
    public NodoAVL(Comparable elem, NodoAVL izquierdo, NodoAVL derecho) {
        this.elem = elem;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    // Observadores
    public Comparable getElem() {
        return this.elem;
    }

    public int getAltura() {
        return this.altura;
    }

    public NodoAVL getIzquierdo() {
        return this.izquierdo;
    }

    public NodoAVL getDerecho() {
        return this.derecho;
    }

    // Modificadores
    public void setElem(Comparable elem) {
        this.elem = elem;
    }

    public void setIzquierdo(NodoAVL izquierdo) {
        this.izquierdo = izquierdo;
    }

    public void setDerecho(NodoAVL derecho) {
        this.derecho = derecho;
    }

    // Aplicacion
    public void recalcularAltura() {
        // Zona de declaracion de variables
        int alturaIzq, alturaDer;
        // Zona de inicializacion de variables
        alturaIzq = -1;
        alturaDer = -1;

        if (this.izquierdo != null) {
            alturaIzq = this.izquierdo.getAltura();
        }
        if (this.derecho != null) {
            alturaDer = this.derecho.getAltura();
        }
        this.altura = Math.max(alturaIzq, alturaDer) + 1;
    }
}
