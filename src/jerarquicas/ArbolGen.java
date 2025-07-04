package jerarquicas;

import lineales.dinamicas.*;

public class ArbolGen {
    private NodoGen raiz;

    public ArbolGen() {
        this.raiz = null;
    }

    public boolean insertar(Object elemNuevo, Object elemPadre, char posHijo) {
        boolean exito = true;
        // 1
        // 2 3 4

        if (this.raiz == null) {
            // si el arbol esta vacio, pone elem nuevo en la raiz
            this.raiz = new NodoGen(elemNuevo, null, null);
        } else {
            // si arbol no esta vacio, busca al padre
            NodoGen nPadre = obtenerNodo(this.raiz, elemPadre);
            // si padre existe y lugar no esta ocupado lo pone, sino da error
            if (nPadre != null) {
                if (posHijo == 'I' && nPadre.getHijoIzquierdo() == null) {
                    nPadre.setHijoIzquierdo(new NodoGen(elemNuevo, null, null));
                } else if (posHijo == 'D' && nPadre.getHijoIzquierdo().getHermanoDerecho() == null) {
                    nPadre.getHijoIzquierdo().setHermanoDerecho(new NodoGen(elemNuevo, null, null));
                } else if (posHijo == 'D' && nPadre.getHijoIzquierdo().getHermanoDerecho() != null) {
                    NodoGen hijo = nPadre.getHijoIzquierdo();
                    while (hijo.getHermanoDerecho() != null) {
                        hijo = hijo.getHermanoDerecho();
                    }
                    hijo.setHermanoDerecho(new NodoGen(elemNuevo, null, null));
                } else {
                    exito = false;
                }
            } else {
                exito = false;
            }
        }
        return exito;
    }

    // public boolean insertar(Object elemNuevo, Object elemPadre) {
    // // Inserta elemNuevo como hijo del primer nodo encontrado en preorden
    // // igual a elemPadre, como hijo extremo izquierdo (HEI) o hermano derecho de
    // HEI
    // // (HD), segun
    // // lo indique el parametro lugar
    // // Zona de declaracion e inicializacion de variable
    // boolean exito = true;

    // if (this.raiz == null) {
    // // si el arbol esta vacio, ponemos el elem nuevo en la raiz
    // this.raiz = new NodoGen(elemNuevo, null, null);
    // } else {
    // // si no esta vacio, se busca al padre
    // NodoGen nodoPadre = obtenerNodo(this.raiz, elemPadre);
    // if (nodoPadre != null) {
    // // Si encontro el nodo padre pregunto por el HEI
    // NodoGen hijo = nodoPadre.getHijoIzquierdo();
    // NodoGen nuevo = new NodoGen(elemNuevo, null, null);

    // if (hijo != null) {
    // // Si tiene HEI pregunta si no posee hermano derecho le setea el nodo nuevo
    // // creado anteriormente
    // // Sino lo tiene recorre los hermanos derecho de HEI hasta llegar al ultimo y
    // le
    // // setea el nodo nuevo
    // // creado anteriormente
    // if (hijo.getHermanoDerecho() == null) {
    // hijo.setHermanoDerecho(nuevo);
    // } else {
    // while (hijo.getHermanoDerecho() != null) {
    // hijo = hijo.getHermanoDerecho();
    // }
    // hijo.setHermanoDerecho(nuevo);
    // }
    // } else {
    // // Si no tiene nodo hijo le setea el nodo nuevo ccreado anteriormente
    // nodoPadre.setHijoIzquierdo(nuevo);
    // }
    // } else {
    // exito = false;
    // }
    // }
    // return exito;
    // }

    private NodoGen obtenerNodo(NodoGen n, Object buscado) {
        NodoGen resultado = null;

        if (n != null) {
            if (n.getElem().equals(buscado)) {
                resultado = n;
            } else {
                resultado = obtenerNodo(n.getHijoIzquierdo(), buscado);

                if (resultado == null) {
                    resultado = obtenerNodo(n.getHermanoDerecho(), buscado);
                }
            }
        }
        return resultado;
    }

    public boolean verificarCamino(Lista lis) {
        boolean exito = true;

        if (this.raiz != null) {
            exito = verificarCaminoAux(this.raiz, lis, false);
        }
        return exito;
    }

    private boolean verificarCaminoAux(NodoGen nodo, Lista lis, boolean exito) {
        if (nodo != null) {
            Object elem = lis.recuperar(1);
            if (lis.esVacia() && !exito) {
                exito = true;
            } else {
                if (nodo.getElem().equals(elem)) {
                    lis.eliminar(1);
                    if (lis.esVacia()) {
                        exito = true;
                    }
                    exito = verificarCaminoAux(nodo.getHijoIzquierdo(), lis, exito);
                } else {
                    exito = verificarCaminoAux(nodo.getHermanoDerecho(), lis, exito);
                }
            }
        }
        return exito;
    }

    public boolean pertenece(Object buscado) {
        // Devuelve verdadero si el elemento pasado por parametro esta en el arbol,
        // falso en caso contrario
        boolean exito = false;

        exito = perteneceAux(this.raiz, buscado);
        return exito;
    }

    private boolean perteneceAux(NodoGen nodo, Object buscado) {
        // Recorrido en preorden para buscar el elemento
        boolean exito = false;
        // Entro con raiz en A y busca X
        if (nodo != null) {
            if (nodo.getElem().equals(buscado)) {
                exito = true;
            } else {
                NodoGen hijo = nodo.getHijoIzquierdo();
                while (hijo != null) {
                    exito = perteneceAux(hijo, buscado);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }

        return exito;
    }

    public Lista ancestros(Object elem) {
        // Si el elemento se encuentra en el arbol, devuelve una lista con el camino
        // desde la raiz hasta dicho elemento
        Lista lis = new Lista();
        return lis;
    }

    // private NodoGen obtenerPosicion(NodoGen n, Object buscado, Object pos){
    // NodoGen resultado = null;

    // if(n != null){
    // if(n.getElem().equals(buscado)){
    // resultado = n;
    // }else{
    // resultado = obtenerNodo(n.getHijoIzquierdo(), buscado);

    // if(resultado == null){
    // resultado = obtenerNodo(n.getHermanoDerecho(), buscado);
    // }
    // }
    // }
    // return resultado;
    // }

    public boolean esVacio() {
        return this.raiz == null;
    }

    public int altura() {
        // devuelve la altura del arbol, es decir, la longitud del camino mas largo
        // desde la raiz hasta una hoja
        // Casos especiales: 1 arbol vacio tiene altura -1 y una hoja tiene altura 0
        int altura = -1;

        if (this.raiz != null) {
            altura = alturaAux(this.raiz, -1);
        }
        return altura;
    }

    private int alturaAux(NodoGen nodo, int altura) {
        int alturaIzq, alturaDer;
        if (nodo != null) {
            alturaIzq = alturaAux(nodo.getHijoIzquierdo(), altura) + 1;
            alturaDer = alturaAux(nodo.getHermanoDerecho(), altura) + 1;
            altura = Math.max(alturaIzq, alturaDer);
        }
        return altura;
    }

    public int nivel(Object elemento) {
        // Devuelve el nivel de un elemento en el arbol.
        // Caso especial: Si el elemento no existe en el arbol devuelve -1.
        int nivel = 0;

        if (this.raiz != null) {
            nivel = nivelAux(this.raiz, elemento, -1);
        }
        return nivel;
    }

    private int nivelAux(NodoGen nodo, Object buscado, int nivel) {
        if (nodo != null) {
            if (nodo.getElem().equals(buscado)) {
                nivel++;
            } else {
                nivel = nivelAux(nodo.getHijoIzquierdo(), buscado, nivel);
                if (nivel != -1) {
                    nivel++;
                } else {
                    nivel = nivelAux(nodo.getHermanoDerecho(), buscado, nivel);
                    if (nivel != -1) {
                        nivel++;
                    }
                }
            }
        }
        return nivel;
    }

    // public Object padre(Object buscado) {
    // // Dado un elemento devuelve el valor almacenado en su nodo padre
    // // Busca la primer aparicion del elemento padre.
    // Object padre = null;
    // NodoGen nodo = this.raiz;

    // if (this.raiz != null) {
    // if (!this.raiz.getElem().equals(buscado)) {
    // padre = padreAux(nodo, buscado);
    // }
    // }
    // return padre;
    // }

    // private Object padreAux(NodoGen nodo, Object buscado) {
    // Object padre = null;
    // NodoGen nodoIzq, nodoDer;

    // if (nodo != null) {
    // // Esto solo funciona con los arboles binarios, falta que itere los hermanos
    // // derechos
    // // Corregir
    // nodoIzq = nodo.getHijoIzquierdo();
    // if (nodoIzq != null) {
    // if (nodoIzq.getElem().equals(buscado)) {
    // padre = nodo.getElem();
    // } else {
    // nodoDer = nodoIzq.getHermanoDerecho();
    // if (nodoDer.getElem().equals(buscado)) {
    // padre = nodo.getElem();
    // } else {
    // padre = padreAux(nodoIzq, buscado);
    // if (padre == null) {
    // // nodo = 24 = C con HI = 31 = F
    // // nodoIzq = 31 = F
    // // nodoDer = 32 = G
    // // Corregir esto y hacer que funcione para todos los hermanos derechos
    // while (nodoDer != null) {
    // if (nodoDer.getElem().equals(buscado)) {
    // padre = nodo.getElem();
    // } else {
    // padre = padreAux(nodoDer, buscado);
    // }
    // nodoDer = nodoDer.getHermanoDerecho();
    // }
    // }
    // }
    // }
    // }
    // }
    // return padre;
    // }

    public Object padre(Object buscado) {
        // Metodo que dado una estructura de tipo Arbol Generico y un elemento de tipo
        // Object que recibe por parametro,
        // verifica que posea elementos. Luego, busca el nodo padre llamando a un metodo
        // auxiliar si fuese necesario.
        // Zona de declaracion de variable
        Object resultado;
        // Zona de inicializacion de variable
        resultado = null; // En caso de que el elemento a buscar sea el elemento raiz retorna null

        if (this.raiz != null) {
            if (!this.raiz.getElem().equals(buscado)) { // Si el elemento buscado no está en la raíz lo busca
                resultado = padreAux(this.raiz, this.raiz.getElem(), buscado);
            }
        }
        return resultado;
    }

    private Object padreAux(NodoGen nodo, Object padre, Object buscado) {
        // Metodo privado recursivo porque recibe un nodo de la estructura. Ademas
        // recibe un elemento de tipo Object del cual
        // debe buscar su elemento padre en la estructura.
        // Zona de declaracion de variables
        Object resultado;
        // Zona de inicializacion de variable
        resultado = null;

        if (nodo != null) {
            if (nodo.getElem().equals(buscado)) {
                resultado = padre;
            } else {
                resultado = padreAux(nodo.getHermanoDerecho(), padre, buscado);
                if (resultado == null) {
                    resultado = padreAux(nodo.getHijoIzquierdo(), nodo.getElem(), buscado);
                }
            }
        }
        return resultado;
    }

    public Lista listarPreorden() {
        // retorna una lista con los elementos del arbol en PREORDEN
        Lista lis = new Lista();
        listarPreordenAux(this.raiz, lis);
        return lis;
    }

    private void listarPreordenAux(NodoGen nodo, Lista lis) {
        // metodo recursivo privado porque su parametro es de tipo NodoGen

        if (nodo != null) {
            // visita el elemento en el nodo
            lis.insertar(nodo.getElem(), lis.longitud() + 1);

            // recorre a sus hijos en preorden
            listarPreordenAux(nodo.getHijoIzquierdo(), lis);
            listarPreordenAux(nodo.getHermanoDerecho(), lis);
        }
    }

    public Lista listarInorden() {
        // retorna una lista con los elementos del arbol en PREORDEN
        Lista lis = new Lista();
        listarInordenAux(this.raiz, lis);
        return lis;
    }

    private void listarInordenAux(NodoGen nodo, Lista lis) {
        // metodo recursivo privado porque su parametro es de tipo NodoGen

        if (nodo != null) {
            // recorre a sus hijos en inorden
            listarInordenAux(nodo.getHijoIzquierdo(), lis);
            // visita el elemento en el nodo
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
            listarInordenAux(nodo.getHermanoDerecho(), lis);
        }
    }

    public Lista listarPosorden() {
        // retorna una lista con los elementos del arbol en PREORDEN
        Lista lis = new Lista();
        listarPosordenAux(this.raiz, lis);
        return lis;
    }

    private void listarPosordenAux(NodoGen nodo, Lista lis) {
        // metodo recursivo privado porque su parametro es de tipo NodoGen

        if (nodo != null) {
            // recorre a sus hijos en posorden
            listarPosordenAux(nodo.getHijoIzquierdo(), lis);
            listarPosordenAux(nodo.getHermanoDerecho(), lis);
            // visita el elemento en el nodo
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
        }
    }

    public Lista frontera() {
        // Metodo que devuelve una lista con la secuencia formada por las hojas del
        // arbol de izq a der
        Lista listaNueva = new Lista();
        fronteraAux(this.raiz, listaNueva);
        return listaNueva;
    }

    private Lista fronteraAux(NodoGen nodo, Lista listaNueva) {

        if (nodo != null) {
            fronteraAux(nodo.getHijoIzquierdo(), listaNueva);
            fronteraAux(nodo.getHermanoDerecho(), listaNueva);
            if (nodo.getHijoIzquierdo() == null && nodo.getHermanoDerecho() == null) { // es hoja
                listaNueva.insertar(nodo.getElem(), listaNueva.longitud() + 1);
            }
        }
        return listaNueva;
    }

    // public Lista listarPorNiveles(){
    // Lista lis = new Lista();
    // Cola cola = new Cola();
    // listarPorNivelesAux(this.raiz, lis, cola);
    // return lis;
    // }

    // private void listarPorNivelesAux(NodoGen nodo, Lista lis, Cola q){
    // if(nodo != null){
    // q.poner(nodo);
    // while(!q.esVacia()){
    // NodoGen nodoActual = q.obtenerFrente();
    // q.sacar();
    // listarPorNivelesAux(nodoActual, lis, q);
    // }
    // // recorre a sus hijos por niveles
    // listarPorNivelesAux(nodo.getHijoIzquierdo(), lis, q);
    // listarPorNivelesAux(nodo.getHermanoDerecho(), lis, q);
    // // visita el elemento en el nodo
    // lis.insertar(nodo.getElem(), lis.longitud()+1);
    // }
    // }

    public void vaciar() {
        this.raiz = null;
    }

    public ArbolGen clone() {
        // Metodo que dada una estructura de tipo Arbol binario, verifica si posee al
        // menos un elemento e invoca
        // al metodo cloneAux
        // Zona de declaracion e inicializacion de una variable de tipo ArbolBin
        ArbolGen clon = new ArbolGen();

        if (this.raiz != null) {
            clon.raiz = cloneAux(this.raiz);
        }
        return clon;
    }

    private NodoGen cloneAux(NodoGen nodo) {
        // Metodo privado recursivo que dada una estructura de tipo Arbol Binario y un
        // nodo de tipo NodoGen
        // recibidos por parametro, hace una copia exacta de los elementos de un Arbol
        // en el mencionado
        // y lo retorna.
        NodoGen nuevo = null;

        if (nodo != null) {
            // Obtengo el nodo raiz
            nuevo = new NodoGen(nodo.getElem(), null, null);
            // Recorro los subarboles izquierdo y derecho
            nuevo.setHijoIzquierdo(cloneAux(nodo.getHijoIzquierdo()));
            nuevo.setHermanoDerecho(cloneAux(nodo.getHermanoDerecho()));
        }
        return nuevo;
    }

    // @Override
    // public String toString(){
    // String arbol = "";

    // if(this.raiz == null){
    // arbol = "Arbol vacio";
    // }else{
    // arbol = toStringAux(this.raiz, "");
    // }
    // return arbol;
    // }

    // private String toStringAux(NodoGen nodo, String cadena){
    // NodoGen nodoIzq, nodoDer;
    // if(nodo != null){
    // nodoIzq = nodo.getHijoIzquierdo();
    // nodoDer = nodo.getHermanoDerecho();

    // cadena = cadena + "\n\t\t" + nodo.getElem() + "\n";

    // if(nodoIzq != null && nodoDer != null){
    // cadena = cadena + "\n\t" + "HI: " + nodoIzq.getElem() + "\t\t" + "HD: " +
    // nodoDer.getElem() + "\n";
    // }else{
    // if(nodoIzq != null){
    // cadena = cadena + "\n\t" + "HI: " + nodoIzq.getElem() + "\t\tHD: -" + "\n";
    // }else{
    // if (nodoDer != null) {
    // cadena = cadena + "\n" + "\t\t\tHD: " + nodoDer.getElem() + "\n";
    // }else{
    // cadena = cadena + "\n\tHI: -" + "\t\tHD: -" + "\n";
    // }
    // }
    // }
    // cadena = toStringAux(nodoIzq, cadena);
    // cadena = toStringAux(nodoDer, cadena);
    // }
    // return cadena;
    // }

    public String toString() {
        return toStringAux(this.raiz);
    }

    private String toStringAux(NodoGen n) {
        String s = "";

        if (n != null) {
            // visita del nodo n
            s += n.getElem().toString() + " -> ";
            NodoGen hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                s += hijo.getElem().toString() + ", ";
                hijo = hijo.getHermanoDerecho();
            }

            // comienza recorrido de lso hijos de n llamado recursivamente
            // para que cada hijo agregue su subcadena a la general
            hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                s += "\n" + toStringAux(hijo);
                hijo = hijo.getHermanoDerecho();
            }
        }
        return s;
    }

    public boolean insertarEnPosicion(Object elem, int pos) {
        boolean exito = false;
        if (this.raiz != null) {
            exito = insertarEnPosicionAux(this.raiz, elem, pos, 1);
        }
        return exito;
    }

    private boolean insertarEnPosicionAux(NodoGen nodo, Object elem, int pos, int contador) {
        // Metodo que inserta ELEM como ultimo hijo del elemento que
        // se encuentra en posicion POS en PREORDEN
        // insertarEnPosicion('B', 6) => HEI de Y
        boolean exito = false;

        if (nodo != null) {
            if (contador == pos) {
                NodoGen hijo = nodo.getHijoIzquierdo();

                NodoGen aux = new NodoGen(elem, null, null);
                if (hijo != null) {
                    while (hijo != null && !exito) {
                        if (hijo.getHermanoDerecho() == null) {
                            hijo.setHermanoDerecho(aux);
                            exito = true;
                        } else {
                            hijo = hijo.getHermanoDerecho();
                        }
                    }
                } else {
                    nodo.setHijoIzquierdo(aux);
                }
            } else {
                NodoGen hijo = nodo.getHijoIzquierdo();
                while (hijo != null) {
                    contador++;
                    exito = insertarEnPosicionAux(hijo, elem, pos, contador);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }

        return exito;
    }

}
