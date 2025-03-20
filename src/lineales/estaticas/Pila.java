package lineales.estaticas;

public class Pila {
    private Object[] arreglo;
    private int tope;
    private static final int TAMANIO = 20;

    public Pila() {
        this.arreglo = new Object[TAMANIO];
        this.tope = -1;
    }

    public boolean apilar(Object newElem){
        boolean exito;

        if(this.tope+1 >= this.TAMANIO){
            // ERROR: pila llena
            exito = false;
        }else{
            // pone el elemento en el tope de la pila
            this.tope++;
            this.arreglo[this.tope] = newElem;
            exito = true;
        }
        return exito;
    }

    public boolean desapilar(){
        boolean exito;

        if(this.tope < 0){
            exito = false;
        }else{
            this.arreglo[this.tope] = null;
            this.tope--;
            exito = true;
        }
        return false;
    }

    public Object obtenerTope(){
        Object elemento;

        if(this.tope < 0){
            elemento = null;
        }else{
            elemento = arreglo[this.tope];
        }
        return elemento;
    }

    public boolean esVacia(){
        return this.tope < 0;
        /*boolean exito = false;

        if(this.tope < 0){
            exito = true;
        }
        return exito;*/
    }

    public void vaciar(){
        // verificar esto
        this.arreglo = null;
    }

    public Pila clonar(){
        // Recorrer el arreglo con un for pasando por cada elemento
        // y hacer una copia de los elementos en una nueva pila
        Pila pilaAux = new Pila();

        for(int i = 0; i < this.tope; i++){
            pilaAux.arreglo[i] = this.arreglo[i];
        }
        return pilaAux;
    }

    public String toString(){
        // Esto debe recorrer el array y retornar una cadena de caracteres con los valores
        String valores = "";

        for(int i = 0; i < this.tope; i++){
            valores += this.arreglo[i];
        }

        return valores;
    }
}
