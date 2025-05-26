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

    // // private NodoABB obtenerPosicion(NodoABB n, Object buscado, Object pos){
    // // NodoABB resultado = null;

    // // if(n != null){
    // // if(n.getElem().equals(buscado)){
    // // resultado = n;
    // // }else{
    // // resultado = obtenerNodo(n.getIzquierdo(), buscado);

    // // if(resultado == null){
    // // resultado = obtenerNodo(n.getDerecho(), buscado);
    // // }
    // // }
    // // }
    // // return resultado;
    // // }

    // public int altura(){
    // // devuelve la altura del arbol, es decir, la longitud del camino mas largo
    // // desde la raiz hasta una hoja
    // // Casos especiales: 1 arbol vacio tiene altura -1 y una hoja tiene altura 0
    // int altura = -1;

    // if(this.raiz != null){
    // altura = alturaAux(this.raiz, -1);
    // }
    // return altura;
    // }

    // private int alturaAux(NodoABB nodo, int altura){
    // int alturaIzq, alturaDer;
    // if(nodo != null){
    // alturaIzq = alturaAux(nodo.getIzquierdo(), altura) + 1;
    // alturaDer = alturaAux(nodo.getDerecho(), altura) + 1;
    // altura = Math.max(alturaIzq, alturaDer);
    // }
    // return altura;
    // }

    // public int nivel(Object elemento){
    // // Devuelve el nivel de un elemento en el arbol.
    // // Caso especial: Si el elemento no existe en el arbol devuelve -1.
    // int nivel = 0;

    // if(this.raiz != null){
    // nivel = nivelAux(this.raiz, elemento, -1);
    // }
    // return nivel;
    // }

    // private int nivelAux(NodoABB nodo, Object buscado, int nivel){
    // if(nodo != null){
    // if(nodo.getElem().equals(buscado)){
    // nivel++;
    // }else{
    // nivel = nivelAux(nodo.getIzquierdo(), buscado, nivel);
    // if(nivel != -1){
    // nivel++;
    // }else{
    // nivel = nivelAux(nodo.getDerecho(), buscado, nivel);
    // if(nivel != -1){
    // nivel++;
    // }
    // }
    // }
    // }
    // return nivel;
    // }

    // public Object padre(Object buscado){
    // // Dado un elemento devuelve el valor almacenado en su nodo padre
    // // Busca la primer aparicion del elemento padre.
    // Object padre = null;

    // if(this.raiz != null){
    // if(!this.raiz.getElem().equals(buscado)){
    // padre = padreAux(this.raiz, buscado);
    // }
    // }
    // return padre;
    // }

    // private Object padreAux(NodoABB nodo, Object buscado){
    // Object padre = null;
    // NodoABB nodoIzq, nodoDer;

    // if(nodo != null){
    // nodoIzq = nodo.getIzquierdo();
    // nodoDer = nodo.getDerecho();

    // if(nodoIzq != null && nodoIzq.getElem().equals(buscado) || nodoDer != null &&
    // nodoDer.getElem().equals(buscado)){
    // padre = nodo.getElem();
    // }else{
    // padre = padreAux(nodoIzq, buscado);
    // padre = padreAux(nodoDer, buscado);
    // }
    // }
    // return padre;
    // }

    // public Lista listarPreorden(){
    // // retorna una lista con los elementos del arbol en PREORDEN
    // Lista lis = new Lista();
    // listarPreordenAux(this.raiz, lis);
    // return lis;
    // }

    // private void listarPreordenAux(NodoABB nodo, Lista lis){
    // // metodo recursivo privado porque su parametro es de tipo NodoABB

    // if(nodo != null){
    // // visita el elemento en el nodo
    // lis.insertar(nodo.getElem(), lis.longitud()+1);

    // // recorre a sus hijos en preorden
    // listarPreordenAux(nodo.getIzquierdo(), lis);
    // listarPreordenAux(nodo.getDerecho(), lis);
    // }
    // }

    // public Lista listarInorden(){
    // // retorna una lista con los elementos del arbol en PREORDEN
    // Lista lis = new Lista();
    // listarInordenAux(this.raiz, lis);
    // return lis;
    // }

    // private void listarInordenAux(NodoABB nodo, Lista lis){
    // // metodo recursivo privado porque su parametro es de tipo NodoABB

    // if(nodo != null){
    // // recorre a sus hijos en inorden
    // listarInordenAux(nodo.getIzquierdo(), lis);
    // // visita el elemento en el nodo
    // lis.insertar(nodo.getElem(), lis.longitud()+1);
    // listarInordenAux(nodo.getDerecho(), lis);
    // }
    // }

    // public Lista listarPosorden(){
    // // retorna una lista con los elementos del arbol en PREORDEN
    // Lista lis = new Lista();
    // listarPosordenAux(this.raiz, lis);
    // return lis;
    // }

    // private void listarPosordenAux(NodoABB nodo, Lista lis){
    // // metodo recursivo privado porque su parametro es de tipo NodoABB

    // if(nodo != null){
    // // recorre a sus hijos en posorden
    // listarPosordenAux(nodo.getIzquierdo(), lis);
    // listarPosordenAux(nodo.getDerecho(), lis);
    // // visita el elemento en el nodo
    // lis.insertar(nodo.getElem(), lis.longitud()+1);
    // }
    // }

    // public Lista frontera(){
    // // Metodo que devuelve una lista con la secuencia formada por las hojas del
    // arbol de izq a der
    // Lista listaNueva = new Lista();
    // fronteraAux(this.raiz, listaNueva);
    // return listaNueva;
    // }

    // private Lista fronteraAux(NodoABB nodo, Lista listaNueva){

    // if(nodo != null){
    // fronteraAux(nodo.getIzquierdo(), listaNueva);
    // fronteraAux(nodo.getDerecho(), listaNueva);
    // if(nodo.getIzquierdo() == null && nodo.getDerecho() == null){ // es hoja
    // listaNueva.insertar(nodo.getElem(), listaNueva.longitud()+1);
    // }
    // }
    // return listaNueva;
    // }

    // // public Lista listarPorNiveles(){
    // // Lista lis = new Lista();
    // // Cola cola = new Cola();
    // // listarPorNivelesAux(this.raiz, lis, cola);
    // // return lis;
    // // }

    // // private void listarPorNivelesAux(NodoABB nodo, Lista lis, Cola q){
    // // if(nodo != null){
    // // q.poner(nodo);
    // // while(!q.esVacia()){
    // // NodoABB nodoActual = q.obtenerFrente();
    // // q.sacar();
    // // listarPorNivelesAux(nodoActual, lis, q);
    // // }
    // // // recorre a sus hijos por niveles
    // // listarPorNivelesAux(nodo.getIzquierdo(), lis, q);
    // // listarPorNivelesAux(nodo.getDerecho(), lis, q);
    // // // visita el elemento en el nodo
    // // lis.insertar(nodo.getElem(), lis.longitud()+1);
    // // }
    // // }

    public void vaciar() {
        this.raiz = null;
    }

    // public ArbolBB clone(){
    // // Metodo que dada una estructura de tipo Arbol binario, verifica si posee al
    // menos un elemento e invoca
    // // al metodo cloneAux
    // // Zona de declaracion e inicializacion de una variable de tipo ArbolBin
    // ArbolBB clon = new ArbolBB();

    // if(this.raiz != null){
    // clon.raiz = cloneAux(this.raiz);
    // }
    // return clon;
    // }

    // private NodoABB cloneAux(NodoABB nodo){
    // // Metodo privado recursivo que dada una estructura de tipo Arbol Binario y
    // un nodo de tipo NodoABB
    // // recibidos por parametro, hace una copia exacta de los elementos de un
    // Arbol en el mencionado
    // // y lo retorna.
    // NodoABB nuevo = null;

    // if(nodo != null){
    // // Obtengo el nodo raiz
    // nuevo = new NodoABB(nodo.getElem(), null, null);
    // // Recorro los subarboles izquierdo y derecho
    // nuevo.setIzquierdo(cloneAux(nodo.getIzquierdo()));
    // nuevo.setDerecho(cloneAux(nodo.getDerecho()));
    // }
    // return nuevo;
    // }

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
