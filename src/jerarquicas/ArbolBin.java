package jerarquicas;
import lineales.dinamicas.Lista;

public class ArbolBin {
    private NodoArbol raiz;

    public ArbolBin(){
        this.raiz = null;
    }

    public boolean insertar(Object elemNuevo, Object elemPadre, char posHijo){
        boolean exito = true;

        if(this.raiz == null){
            // si el arbol esta vacio, pone elem nuevo en la raiz
            this.raiz = new NodoArbol(elemNuevo, null, null);
        }else{
            // si arbol no esta vacio, busca al padre
            NodoArbol nPadre = obtenerNodo(this.raiz, elemPadre);
            // si padre existe y lugar no esta ocupado lo pone, sino da error
            if(nPadre != null){
                if(posHijo == 'I' && nPadre.getIzquierdo() == null){
                    nPadre.setIzquierdo(new NodoArbol(elemNuevo, null, null));
                }else if(posHijo == 'D' && nPadre.getDerecho() == null){
                    nPadre.setDerecho(new NodoArbol(elemNuevo, null, null));
                }else{
                    exito = false;
                }
            }else{
                exito = false;
            }
        }
        return exito;
    }

    private NodoArbol obtenerNodo(NodoArbol n, Object buscado){
        NodoArbol resultado = null;

        if(n != null){
            if(n.getElem().equals(buscado)){
                resultado = n;
            }else{
                resultado = obtenerNodo(n.getIzquierdo(), buscado);

                if(resultado == null){
                    resultado = obtenerNodo(n.getDerecho(), buscado);
                }
            }
        }
        return resultado;
    }

    public boolean esVacio(){
        return this.raiz == null;
    }

    public int altura(){
        // devuelve la altura del arbol, es decir, la longitud del camino mas largo
        // desde la raiz hasta una hoja
        // Casos especiales: 1 arbol vacio tiene altura -1 y una hoja tiene altura 0
        int altura = -1;

        if(this.raiz != null){
            altura = alturaAux(this.raiz, -1);
        }
        return altura;
    }

    private int alturaAux(NodoArbol nodo, int altura){
        int alturaIzq, alturaDer;
        if(nodo != null){
            alturaIzq = alturaAux(nodo.getIzquierdo(), altura) + 1;
            alturaDer = alturaAux(nodo.getDerecho(), altura) + 1;
            altura = Math.max(alturaIzq, alturaDer);
        }
        return altura;
    }

    public int nivel(Object elemento){
        // Devuelve el nivel de un elemento en el arbol.
        // Caso especial: Si el elemento no existe en el arbol devuelve -1.
        int nivel = 0;

        if(this.raiz != null){
            nivel = nivelAux(this.raiz, elemento, -1);
        }
        return nivel;
    }

    private int nivelAux(NodoArbol nodo, Object buscado, int nivel){
        if(nodo != null){
            if(nodo.getElem().equals(buscado)){
                nivel++;
            }else{
                nivel = nivelAux(nodo.getIzquierdo(), buscado, nivel);
                if(nivel != -1){
                    nivel++;
                }else{
                    nivel = nivelAux(nodo.getDerecho(), buscado, nivel);
                    if(nivel != -1){
                        nivel++;
                    }
                }
            }
        }
        return nivel;
    }

    public Object padre(Object buscado){
        // Dado un elemento devuelve el valor almacenado en su nodo padre
        // Busca la primer aparicion del elemento padre.
        Object padre = null;

        if(this.raiz != null){
            if(!this.raiz.getElem().equals(buscado)){
                padre = padreAux(this.raiz, buscado);
            }
        }
        return padre;
    }

    private Object padreAux(NodoArbol nodo, Object buscado){
        Object padre = null;
        NodoArbol nodoIzq, nodoDer;

        if(nodo != null){
            nodoIzq = nodo.getIzquierdo();
            nodoDer = nodo.getDerecho();

            if(nodoIzq != null && nodoIzq.getElem().equals(buscado) || nodoDer != null && nodoDer.getElem().equals(buscado)){
                padre = nodo.getElem();
            }else{
                padre = padreAux(nodoIzq, buscado);
                padre = padreAux(nodoDer, buscado);
            }
        }
        return padre;
    }

    public Lista listarPreorden(){
        // retorna una lista con los elementos del arbol en PREORDEN
        Lista lis = new Lista();
        listarPreordenAux(this.raiz, lis);
        return lis;
    }

    private void listarPreordenAux(NodoArbol nodo, Lista lis){
        // metodo recursivo privado porque su parametro es de tipo NodoArbol

        if(nodo != null){
            // visita el elemento en el nodo
            lis.insertar(nodo.getElem(), lis.longitud()+1);

            // recorre a sus hijos en preorden
            listarPreordenAux(nodo.getIzquierdo(), lis);
            listarPreordenAux(nodo.getDerecho(), lis);
        }
    }

    @Override
    public String toString(){
        String arbol = "";

        if(this.raiz == null){
            arbol = "Arbol vacio";
        }else{
            arbol = toStringAux(this.raiz, "");
        }
        return arbol;
    }

    private String toStringAux(NodoArbol nodo, String cadena){
        NodoArbol nodoIzq, nodoDer;
        if(nodo != null){
            nodoIzq = nodo.getIzquierdo();
            nodoDer = nodo.getDerecho();

            cadena = cadena + "\n\t\t" + nodo.getElem() + "\n";

            if(nodoIzq != null && nodoDer != null){
               cadena = cadena + "\n" + "HI: " + nodoIzq.getElem() + "\tHD: " + nodoDer.getElem();
            }else{
                if(nodoIzq != null){
                   cadena = cadena + "\n" + "HI: " + nodoIzq.getElem() + "\tHD: -";
                }else{
                    if (nodoDer != null) {
                        cadena = cadena + "\n" + "HD: " + nodoDer.getElem();
                    }else{
                        cadena = cadena + "HI: -" + "\tHD: -";
                    }
                }
            }
            cadena = toStringAux(nodoIzq, cadena);
            cadena = toStringAux(nodoDer, cadena);
        }
        return cadena;
    }

}
