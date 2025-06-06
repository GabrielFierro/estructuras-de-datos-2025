package conjuntistas;

import lineales.dinamicas.*;

public class ArbolBB {
    private NodoABB raiz;

    public ArbolBB() {
        this.raiz = null;
    }

    public boolean insertar(Comparable elemento) {
        boolean exito = true;
        if (this.raiz == null) {
            this.raiz = new NodoABB(elemento);
        } else {
            exito = insertarAux(this.raiz, elemento);
        }
        return exito;
    }

    public boolean insertarAux(NodoABB n, Comparable elemento) {
        // precondicion: n no es nulo
        boolean exito = true;

        if ((elemento.compareTo(n.getElem()) == 0)) {
            exito = false;
        } else if (elemento.compareTo(n.getElem()) < 0) {
            // elemento menor que n.getElem()
            // si tiene HI baja a la izquierda, sino agrega elemento
            if (n.getIzquierdo() != null) {
                exito = insertarAux(n.getIzquierdo(), elemento);
            } else {
                n.setIzquierdo(new NodoABB(elemento));
            }
        } else if (n.getDerecho() != null) {
            // elemento mayor que n.getElem()
            // si tiene HD baja a la derecha, sino agrega elemento
            exito = insertarAux(n.getDerecho(), elemento);
        } else {
            n.setDerecho(new NodoABB(elemento));
        }
        return exito;
    }

    public boolean eliminar(Comparable elemento) {
        boolean exito = false;

        if (this.raiz != null) {
            exito = eliminarAux(this.raiz, null, elemento);
        }
        return exito;
    }

    private boolean eliminarAux(NodoABB n, NodoABB padre, Comparable elemento) {
        // precondicion: n no es nulo
        // Caso 1: el nodo a eliminar es hoja
        // Caso 2: el nodo tiene al menos un hijo
        // Caso 3: el nodo esta en el medio, tengo que elegir 1 candidato
        // Caso 4: el nodo a eliminar es la raiz

        boolean exito = true;

        if (n != null) {
            if (elemento.compareTo(n.getElem()) < 0) {
                exito = eliminarAux(n.getIzquierdo(), n, elemento);
            } else if (elemento.compareTo(n.getElem()) > 0) {
                exito = eliminarAux(n.getDerecho(), n, elemento);
            } else {
                if (n.getIzquierdo() == null && n.getDerecho() == null) {
                    // Caso 1: Es hoja
                    eliminarCaso1(padre, elemento);
                } else if (n.getIzquierdo() != null && n.getDerecho() == null
                        || n.getIzquierdo() == null && n.getDerecho() != null) {
                    // Caso 2: Tiene 1 solo hijo (izquierdo)
                    eliminarCaso2(n, padre, elemento);
                } else {
                    eliminarCaso3(n);
                }
            }
        }
        return exito;
    }

    private void eliminarCaso1(NodoABB nodo, Comparable elemento) {
        // Caso 1: Es hoja
        if (elemento.compareTo(nodo.getElem()) < 0) {
            nodo.setIzquierdo(null);
        } else if (elemento.compareTo(nodo.getElem()) > 0) {
            nodo.setDerecho(null);
        }
    }

    private void eliminarCaso2(NodoABB nodo, NodoABB padre, Comparable elemento) {
        // Caso 2: el nodo a eliminar tiene un hijo izquierdo o derecho
        if (elemento.compareTo(padre.getElem()) < 0) {
            padre.setIzquierdo(nodo.getDerecho());
        } else if (elemento.compareTo(padre.getElem()) > 0) {
            padre.setDerecho(nodo.getIzquierdo());
        }
    }

    private void eliminarCaso3(NodoABB nodo) {
        // Caso 3: El nodo a eliminar tiene 2 hijos tengo que elegir 1 candidato
        NodoABB candidatoIzq = nodo.getIzquierdo();
        NodoABB padre = nodo;

        // nodo = 8
        // padre = 6
        // candidatoIzq = 5
        while (candidatoIzq != null) {
            padre = candidatoIzq;
            candidatoIzq = candidatoIzq.getDerecho();
        }
        // nodo = 8
        // padre = 7
        nodo.setElem(padre.getElem());

        if (padre != null) {
            padre.setElem(null); // Le asigna null y queda guardado como un elemento en el arbol
        }

    }

    public boolean pertenece(Comparable elem) {
        // Devuelve verdadero si el elemento recibido por parametro esta en el arbol y
        // falso en caso contrario
        boolean exito = false;

        if (this.raiz != null) {
            exito = perteneceAux(this.raiz, elem);
        }
        return exito;
    }

    private boolean perteneceAux(NodoABB nodo, Comparable elem) {
        boolean exito = false;

        if (nodo != null) {
            if (elem.compareTo(nodo.getElem()) < 0) {
                exito = perteneceAux(nodo.getIzquierdo(), elem);
            } else if (elem.compareTo(nodo.getElem()) > 0) {
                exito = perteneceAux(nodo.getDerecho(), elem);
            } else {
                // Encontro el elemento
                exito = true;
            }
        }
        return exito;
    }

    public boolean esVacio() {
        return this.raiz == null;
    }

    public Lista listar() {
        // Recorre el arbol completo y devuelve una lista ordenada con todos los
        // elementos
        Lista lis = new Lista();
        listarAux(this.raiz, lis);
        return lis;
    }

    private void listarAux(NodoABB nodo, Lista lis) {
        if (nodo != null) {
            // recorre a sus hijos en inorden
            listarAux(nodo.getIzquierdo(), lis);
            // visita el elemento en el nodo
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
            listarAux(nodo.getDerecho(), lis);
        }
    }

    public Lista listarRango(Comparable elemMinimo, Comparable elemMaximo) {
        // Recorre parte del arbol (solo lo necesario) y devuelve una lista ordenada
        // con los elementos que se encuentran en el intervalo
        // Recorrido inorden
        Lista lista = new Lista();

        if (this.raiz != null) {
            listarRangoAux(this.raiz, elemMinimo, elemMaximo, lista);
        }
        return lista;
    }

    private void listarRangoAux(NodoABB nodo, Comparable elemMin, Comparable elemMax, Lista lis) {

        if (nodo != null) {
            if (elemMax.compareTo(nodo.getElem()) <= 0) {
                listarRangoAux(nodo.getIzquierdo(), elemMin, elemMax, lis);
                if (elemMax.compareTo(nodo.getElem()) >= 0) {
                    lis.insertar(nodo.getElem(), lis.longitud() + 1);
                    listarRangoAux(nodo.getDerecho(), elemMin, elemMax, lis);
                }
            } else if (elemMin.compareTo(nodo.getElem()) <= 0) {
                listarRangoAux(nodo.getIzquierdo(), elemMin, elemMax, lis);
                if (elemMax.compareTo(nodo.getElem()) >= 0) {
                    lis.insertar(nodo.getElem(), lis.longitud() + 1);
                    listarRangoAux(nodo.getDerecho(), elemMin, elemMax, lis);
                }
            }
        }
    }

    public Comparable minimoElem() {
        Comparable minimo = -1;

        if (this.raiz != null) {
            minimo = minimoElemAux(this.raiz);
        }
        return minimo;
    }

    private Comparable minimoElemAux(NodoABB nodo) {
        Comparable minimo = -1;

        if (nodo != null) {
            minimo = nodo.getElem();
            if (nodo.getIzquierdo() != null) {
                minimo = minimoElemAux(nodo.getIzquierdo());
            }
        }
        return minimo;
    }

    public Comparable maximoElem() {
        Comparable maximo = -1;

        if (this.raiz != null) {
            maximo = maximoElem(this.raiz);
        }
        return maximo;
    }

    private Comparable maximoElem(NodoABB nodo) {
        Comparable maximo = -1;

        if (nodo != null) {
            maximo = nodo.getElem();
            if (nodo.getDerecho() != null) {
                maximo = maximoElem(nodo.getDerecho());
            }
        }
        return maximo;
    }

    @Override
    public String toString() {
        String arbol = "";

        if (this.raiz == null) {
            arbol = "Arbol vacio";
        } else {
            arbol = toStringAux(this.raiz, "");
        }
        return arbol;
    }

    private String toStringAux(NodoABB nodo, String cadena) {
        NodoABB nodoIzq, nodoDer;
        if (nodo != null) {
            nodoIzq = nodo.getIzquierdo();
            nodoDer = nodo.getDerecho();

            cadena = cadena + "\n\t\t" + nodo.getElem() + "\n";

            if (nodoIzq != null && nodoDer != null) {
                cadena = cadena + "\n\t" + "HI: " + nodoIzq.getElem() + "\t\t" + "HD: " + nodoDer.getElem() + "\n";
            } else {
                if (nodoIzq != null) {
                    cadena = cadena + "\n\t" + "HI: " + nodoIzq.getElem() + "\t\tHD: -" + "\n";
                } else {
                    if (nodoDer != null) {
                        cadena = cadena + "\n\tHI: -" + "\t\tHD: " + nodoDer.getElem() + "\n";
                    } else {
                        cadena = cadena + "\n\tHI: -" + "\t\tHD: -" + "\n";
                    }
                }
            }
            cadena = toStringAux(nodoIzq, cadena);
            cadena = toStringAux(nodoDer, cadena);
        }
        return cadena;
    }

}
