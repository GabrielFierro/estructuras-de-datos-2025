package lineales.dinamicas;

/************* Autores ***********
    Gabriel Fierro, Legajo FAI-1938
    Veratti Juan Ignacio, FAI-5347
    Fernando Lopez, Legajo: FAI-3996
*/


public class Lista {
    private Nodo cabecera;

    public Lista(){
        this.cabecera = null;
    }

    public boolean insertar(Object nuevoElem, int pos){
        // inserta el elemento nuevo en la posicion pos
        // detecta y reporta error posicion invalida
        boolean exito = true;

        if(pos < 1 || pos > this.longitud() + 1){
            exito = false;
        }else{
            if(pos == 1){   // crea un nuevo nodo y se enlaza a la cabecera
                this.cabecera = new Nodo(nuevoElem, this.cabecera);
            }else{ // avanza hasta el elemento en posicion pos-1
                Nodo aux = this.cabecera;
                int i = 1;
                while(i < pos - 1){
                    aux = aux.getEnlace();
                    i++;
                }
                // crea el nodo y lo enlaza
                Nodo nuevo = new Nodo(nuevoElem, aux.getEnlace());
                aux.setEnlace(nuevo);
            }
        }
        // nunca hay error de lista llena, entonces devuelve true
        return exito;
    }

    public boolean eliminar(int pos) {
        // Metodo que dado un valor de tipo int recibido por parametro, busca el elemento de dicha posicion en la
        // estructura de tipo lista, y lo elimina de la misma
        // Zona de declaracion de variable
        boolean exito;
        int i;
        Nodo aux;
        // Zona de inicializacion de variable
        exito = true;
        i = 1;

        if (pos < 1 || pos > this.longitud()) {
            exito = false;
        } else {
            if (pos == 1) {
                if (this.cabecera != null) {
                    aux = this.cabecera.getEnlace();
                    this.cabecera = aux;
                } else {
                    exito = false;
                }
            } else {
                aux = this.cabecera;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                aux.setEnlace(aux.getEnlace().getEnlace());
            }
        }
        return exito;
    }

    public Object recuperar(int pos){
        Nodo aux = this.cabecera;
        int cont = 1;
        Object elem = null;
        boolean encontrado = false;

        while (!encontrado && aux != null) {
            if (cont == pos) {
                elem = aux.getElem();
                encontrado = true;
            } else {
                cont++;
                aux = aux.getEnlace();
            }
        }
        return elem;
    }

    public int localizar(int elem){
        Nodo aux = this.cabecera;
        int cont = 1;

        if(this.cabecera != null){
            while(aux!= null && !aux.getElem().equals(elem)){
                aux = aux.getEnlace();
                cont++;
            }
            if(aux == null){
                cont = -1;
            }
        }else{
            cont = -1;
        }
        return cont;
    }

    public boolean vaciar(){
        this.cabecera = null;
        return true;
    }

    public boolean esVacia(){
        return this.cabecera == null;
    }

    public int longitud(){
        int contador = 0;
        Nodo aux = this.cabecera;

        while(aux != null){
            aux = aux.getEnlace();
            contador++;
        }
        return contador;
    }

    @Override
    public Lista clone() {
        Lista nuevaLista = new Lista();
        if (this.cabecera != null) {
            int pos = 1;
            Nodo aux = this.cabecera;
            while (aux != null) {
                nuevaLista.insertar(aux.getElem(), pos);
                pos++;
                aux = aux.getEnlace();
            }

        }
        return nuevaLista;
    }

    @Override
    public String toString(){
        String s = "";

        if(this.cabecera == null){
            s = "[]";
        }else{
            Nodo aux = this.cabecera;
            s = "[";

            while(aux != null){
                s += aux.getElem().toString();
                aux = aux.getEnlace();
                if(aux != null){
                    s += ",";
                }
            }
            s += "]";
        }
        return s;
    }
}
