package conjuntistas;

public class ArbolAVL {
    private NodoAVL raiz;

    public ArbolAVL() {
        this.raiz = null;
    }

    public boolean insertar(Comparable elemento) {
        boolean exito;
        exito = true;

        if (this.raiz == null) {
            this.raiz = new NodoAVL(elemento, null, null);
            this.raiz.recalcularAltura();
        } else {
            exito = insertarAux(this.raiz, elemento);
        }
        return exito;
    }

    private boolean insertarAux(NodoAVL n, Comparable elemento) {
        // precondicion: n no es nulo

        boolean exito;
        exito = true;

        if (elemento.compareTo(n.getElem()) == 0) {
            exito = false;
        } else if (elemento.compareTo(n.getElem()) < 0) {
            // elemento es menor que n.getElem()
            // si tiene HI baja a la izquierda, sino agrega elemento y verifica el balance
            // del arbol
            if (n.getIzquierdo() != null) {
                exito = insertarAux(n.getIzquierdo(), elemento);
                verificarBalance(n);
            } else {
                n.setIzquierdo(new NodoAVL(elemento, null, null));
                n.recalcularAltura(); // Actualizo la altura despues de agregar un nodo
            }
        } else if (n.getDerecho() != null) {
            // elem es mayor que n.getElem()
            // si tiene hijo derecho baja a la derecha
            exito = insertarAux(n.getDerecho(), elemento);
            verificarBalance(n);
        } else {
            // sino tiene hijo derecho se lo agrega
            n.setDerecho(new NodoAVL(elemento, null, null));
            n.recalcularAltura();
        }
        return exito;
    }

    private void verificarBalance(NodoAVL n) {
        // Zona de declaracion de variables
        NodoAVL nodoDesbalanceado, nodoAux;
        int balance, balanceHD, balanceHI;

        nodoDesbalanceado = obtenerNodoDesbalanceado(this.raiz); // Verifico si existe un desbalance en el arbol

        if (nodoDesbalanceado != null) {
            // Si existe un nodo que se encuentre desbalanceado, acomodo el arbol
            balance = calcularBalance(nodoDesbalanceado);
            if (balance == -2) { // El nodo esta caido hacia la derecha
                balanceHD = calcularBalance(nodoDesbalanceado.getDerecho());
                if (balanceHD == -1 || balanceHD == 0) { // Rotacion simple a izquierda
                    this.raiz = rotarIzquierda(nodoDesbalanceado);
                } else {
                    // balanceHD = 1 entonces debo hacer rotacion doble derecha-izquierda
                    balanceHD = calcularBalance(nodoDesbalanceado.getDerecho());
                    if (balanceHD == 1) {
                        nodoAux = rotarDerecha(nodoDesbalanceado.getDerecho());
                        System.out.println("Salio de la rotacion con raiz: " + this.raiz.getElem() + " con HI: "
                                + this.raiz.getIzquierdo().getElem() + " con HD: " + this.raiz.getDerecho().getElem()
                                + " con nodoAux: " + nodoAux.getElem());
                        this.raiz.setDerecho(nodoAux);
                        this.raiz = rotarIzquierda(this.raiz);
                    }
                }
            } else { // El nodo esta caido hacia la izquierda con balance == 2
                balanceHI = calcularBalance(nodoDesbalanceado.getIzquierdo());
                if (balanceHI == 1 || balanceHI == 0) {
                    this.raiz = rotarDerecha(nodoDesbalanceado);
                } else {
                    // balanceHI = -1 entonces debo hacer rotacion doble izquierda-derecha
                    balanceHI = calcularBalance(nodoDesbalanceado.getIzquierdo());
                    if (balanceHI == -1) {
                        nodoAux = rotarIzquierda(nodoDesbalanceado.getIzquierdo());
                        this.raiz.setIzquierdo(nodoAux);
                        this.raiz = rotarDerecha(this.raiz);
                    }
                }
            }
        }
    }

    private NodoAVL obtenerNodoDesbalanceado(NodoAVL n) {
        // Recorre el arbol en preorden, hasta que encuentra un nodo que se encuentre
        // desbalanceado. Si lo encuentra lo retorna.
        NodoAVL nodoABalancear;
        int balance;
        nodoABalancear = null;
        balance = -1;

        if (n != null) {
            balance = calcularBalance(n);

            if (balance == -2 || balance == 2) { // encontre el nodo desbalanceado
                nodoABalancear = n;
            } else { // Sino encontre el nodo desbalanceado recorro el arbol
                if (n.getIzquierdo() != null) {
                    nodoABalancear = obtenerNodoDesbalanceado(n.getIzquierdo());
                }
                if (n.getDerecho() != null) {
                    nodoABalancear = obtenerNodoDesbalanceado(n.getDerecho());
                }
            }
        }
        return nodoABalancear;
    }

    private int calcularBalance(NodoAVL n) {
        // A partir de dicho nodo, calculo su balance teniendo en cuenta la altura de
        // sus hijos izquierdo y derecho, y
        // retorna dicho valor. Retorna un valor de tipo entero.

        // Zona de declaracion de variables
        int balance, alturaIzq, alturaDer;
        // Zona de inicializacion de variables
        alturaIzq = -1;
        alturaDer = -1;

        if (n.getIzquierdo() != null) { // Si tiene hijo izquierdo actualiza su altura y la almacena en una variable
            n.getIzquierdo().recalcularAltura();
            alturaIzq = n.getIzquierdo().getAltura();
        }
        if (n.getDerecho() != null) { // Si tiene hijo derecho actualiza su altura y la almacena en una variable
            n.getDerecho().recalcularAltura();
            alturaDer = n.getDerecho().getAltura();
        }
        balance = alturaIzq - alturaDer; // Calculo el balance con la altura del hijo izquierdo e hijo derecho
        return balance;
    }

    private NodoAVL rotarIzquierda(NodoAVL r) {
        // Metodo privado ya que recibe un nodo de tipo NodoAVL perteneciente a la
        // estructura interna del arbol.
        // Y realiza una rotacion simple a izquierda, tomando como pivot al nodo
        // recibido por parametro.
        // Zona de declaracion de variables
        NodoAVL h, temp;

        h = r.getDerecho();
        temp = h.getIzquierdo();
        h.setIzquierdo(r);
        r.setDerecho(temp);

        return h; // Retorna la nueva raiz del subarbol
    }

    private NodoAVL rotarDerecha(NodoAVL r) {
        // Metodo privado ya que recibe un nodo de tipo NodoAVL perteneciente a la
        // estructura interna del arbol.
        // Y realiza una rotacion simple a derecha, tomando como pivot al nodo recibido
        // por parametro.
        // Zona de declaracion de variables
        NodoAVL h, temp;
        h = r.getIzquierdo();
        temp = h.getDerecho();
        h.setDerecho(r);
        r.setIzquierdo(temp);

        return h; // Retorna la nueva raiz del subarbol
    }

    public void vaciar() {
        this.raiz = null;
    }

    @Override
    public String toString() {
        // Metodo que dada una estructura de tipo Arbol binario de busqueda, la recorre
        // y almacena en una cadena
        // de caracteres los elementos de los nodos. Al terminar retorna dicha cadena de
        // caracteres.
        // Zona de declaracion de variable
        String cadena;
        // Zona de inicializacion de variable
        cadena = "Arbol binario de busqueda vacio";

        if (this.raiz != null) {
            cadena = toStringAuxiliar(this.raiz, "");
        }

        return cadena;
    }

    private String toStringAuxiliar(NodoAVL nodo, String cadena) {
        // Metodo recursivo privado porque su parametro es de tipo NodoABB, que almacena
        // en una cadena de caracteres
        // los nodos de una estructura de tipo Arbol binario de busqueda. Hace un
        // recorrido del tipo preorden,
        // visitando primero el nodo actual, seguido de su hijo izquierdo y por ultimo
        // el hijo derecho.
        // Zona de declaracion de variable
        NodoAVL nodoIzq, nodoDer;

        if (nodo != null) {
            cadena = cadena + "\n" + nodo.getElem() + "\t";

            nodoIzq = nodo.getIzquierdo();
            nodoDer = nodo.getDerecho();
            // Primero inserto el elemento del nodo
            if (nodoIzq != null && nodoDer != null) { // nodos no nulos
                cadena = cadena + "HI: " + nodoIzq.getElem() + "\tHD: " + nodoDer.getElem();
            } else {
                if (nodoIzq != null) { // nudo izquierdo distinto a nulo
                    cadena = cadena + "HI: " + nodoIzq.getElem() + "\tHD: -";

                } else {
                    if (nodoDer != null) { // nodo derecho distinto a nulo
                        cadena = cadena + "HI: -" + "\tHD: " + nodoDer.getElem();
                    } else { // nodos nulos
                        cadena = cadena + "HI: -" + "\tHD: -";
                    }
                }
            }
            // Luego, recorro primero hacia la izquierda y despues hacia la izquierda
            cadena = toStringAuxiliar(nodoIzq, cadena);
            cadena = toStringAuxiliar(nodoDer, cadena);
        }
        return cadena;
    }
}
