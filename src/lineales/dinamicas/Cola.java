package lineales.dinamicas;

public class Cola {
    private Nodo frente;
    private Nodo fin;

    public Cola(){
        this.frente = null;
        this.fin = null;
    }

    public boolean poner(Object nuevoElem){
        // Primer caso no tengo elementos entonces frente y fin apuntan al mismo lugar --> []
        // Segundo caso tengo por lo menos 1 elemento
        Nodo nuevo = new Nodo(nuevoElem, null);

        if(this.frente == null){
            this.fin = nuevo;
            this.frente = nuevo;
        }else{
            this.fin.setEnlace(nuevo);
            this.fin = nuevo;
        }
        return true;
    }

    public boolean sacar(){
        boolean exito = true;

        if(this.frente == null){
            // la cola esta vacia, reportar error
            exito = false;
        }else{
            // al menos hay un elemento
            // quita el primer elemento y actualiza el frente (fin si queda vacia)
            this.frente = this.frente.getEnlace();
            if(this.frente == null){
                this.fin = null;
            }
        }
        return exito;
    }

    public Object obtenerFrente(){
        Object elem = null;
        if(this.frente != null){
            elem = this.frente.getElem();
        }
        return elem;
    }

    public boolean esVacia(){
        return this.frente == null;
    }

    public void vaciar(){
        this.frente = null;
        this.fin = null;
    }

    public Cola clonar(){
        Cola clon = new Cola();

        if(this.frente != null){
            Nodo aux = this.frente;
            clon.frente = aux;
            clon.fin = aux;
            aux = aux.getEnlace();

            while(aux != null){
                clon.fin = aux;
                aux = aux.getEnlace();
            }
        }
        return clon;
    }

    @Override
    public String toString(){
        String s = "";

        if(this.frente == null){
            s = "Cola vacia";
        }else{
            Nodo aux = this.frente;
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
