package lineales.dinamicas;

/************* Autores ***********
    Gabriel Fierro, Legajo FAI-1938
    Veratti Juan Ignacio, FAI-5347
    Fernando Lopez, Legajo: FAI-3996
*/

public class Pila {

    private Nodo tope;

    // Crea y devuelve la pila vacía.
    public Pila() {

        this.tope = null;
    }

    // Pone el elemento nuevoElem en el tope de la pila. Devuelve verdadero si el elemento se pudo apilar y falso en caso contrario.
    public boolean apilar(Object nuevoElem) {

        Nodo nuevo = new Nodo(nuevoElem, this.tope);
        this.tope = nuevo;
        return true;
    }

    // Saca el elemento del tope de la pila. Devuelve verdadero si la pila no estaba vacía al momento de desapilar (es decir que se pudo desapilar) y falso en caso contrario.
    public boolean desapilar() {
        boolean exito = false;

        if (this.tope != null) {
            this.tope = this.tope.getEnlace();
            exito = true;
        }

        return exito;
    }

    // Devuelve el elemento en el tope de la pila. Precondición: la pila no está vacía.
    public Object obtenerTope() {
        Object elem = null;

        if (this.tope != null){
            elem = this.tope.getElem();
        }

        return elem;
    }

    //Devuelve true si la pila está vacia o falso si no lo está.
    public boolean esVacia() {
        return this.tope == null;
    }

    //Vacia la pila.
    public void vaciar() {
        this.tope = null;
    }

    // Devuelve una copia exacta de los datos en la estructura original, y respetando el orden de los mismos,
    // en otra estructura del mismo tipo.
    @Override
    public Pila clone() {
        Pila nuevaPila = new Pila();
        Nodo aux = this.tope;
        // este nodo pila invertida va a ser un puntero al tope de la pila **this** invertida. Luego lo recorremos nuevamente para ir apilando correctamente en nuevaPila
        Nodo nodoPilaInvertida = null;

        while (aux != null) {
            nodoPilaInvertida = new Nodo(aux.getElem(), nodoPilaInvertida);
            aux = aux.getEnlace();
        }

        while (nodoPilaInvertida != null) {
            nuevaPila.tope = new Nodo(nodoPilaInvertida.getElem(), nuevaPila.tope);
            nodoPilaInvertida = nodoPilaInvertida.getEnlace();
        }
        
        return nuevaPila;
    }

    // Devuelve una cadena de caracteres formada por todos los elementos de la pila para poder mostrarla por pantalla. 
    // Es recomendable utilizar este método únicamente en la etapa de prueba y luego comentar el
    @Override
    public String toString() {
        String s;

        if (this.tope == null){
            s = "[]";
        }else{
            Nodo aux = this.tope;
            s = "[";

            while (aux != null){
                s += aux.getElem().toString();
                aux = aux.getEnlace();
                if (aux != null){
                    s += ",";
                }
            }
            s += "]";
        }
        
    return s;
    }
}
