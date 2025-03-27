package lineales.dinamicas;

public class Pila {
    private Nodo tope;

    public Pila(){
        this.tope = null;
    }

    public boolean apilar(Object nuevoElem){
/*      this.tope = new Nodo(nuevoElem, this.tope);*/
        Nodo nuevo = new Nodo(nuevoElem, this.tope);
        this.tope = nuevo;
        return true;
    }

    public boolean desapilar(){
        boolean exito = false;

        if(this.tope != null){
            Nodo aux = this.tope;
            this.tope = this.tope.getEnlace();
            exito = true;
        }
        return exito;
    }

    public Object obtenerTope(){
        Object elem = null;
        if(this.tope != null){
            elem = this.tope.getElem();
        }
        return elem;
    }

    public boolean esVacia(){
        return this.tope == null;
    }

    public void vaciar(){
        // Como es una pila dinamica y tengo un Nodo con un enlace
        // alcanza con poner el enlace en null para vaciar la pila
        this.tope = null;
    }

    public Pila clonar(){
        // entra con  [2,7,3,5,1]
        // Nodo
        // (Elemento, Enlace)
        // Caso 1: Tengo elementos con enlaces
        // (1, 5) -> EL CONJUNTO ES EL TOPE
        // (3, 7)
        // (2, 8)
        // (8, null) este es el ultimo elemento
        // Caso 2: Tengo una pila recien creada la cual tiene tope en null
        Pila clon = new Pila();
        Nodo topeAux = this.tope;

        if(this.tope != null){ // Si tengo elementos clono la pila
            if(topeAux.getEnlace() != null){
                clon.tope = this.tope;
                topeAux = this.tope.getEnlace();
            }
        }
        // topeAux es 7 y this.tope.getEnlace es 7
        return clon;
    }

    @Override
    public String toString(){
        String s = "";

        if(this.tope == null){
            s = "Pila vacia";
        }else{
            Nodo aux = this.tope;
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
