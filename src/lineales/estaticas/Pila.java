package lineales.estaticas;

/************* Autores ***********
    Gabriel Fierro, Legajo FAI-1938
    Veratti Juan Ignacio, FAI-5347
    Fernando Lopez, Legajo: FAI-3996
*/

public class Pila {

    private Object[] arrPila;
    private int topePila;
    private static final int CAPACIDAD = 10;

    // Crea y devuelve la pila vacía.
    public Pila() {

        this.arrPila = new Object[CAPACIDAD];
        this.topePila = -1;
    }

    // Pone el elemento nuevoElem en el tope de la pila. Devuelve verdadero si el elemento se pudo apilar y falso en caso contrario.
    public boolean apilar(Object nuevoElem) {
        boolean exito = false;

        if (this.topePila < CAPACIDAD - 1) {
            this.topePila++;
            this.arrPila[topePila] = nuevoElem;
            exito = true;
        }

        return exito;
    }

    // Saca el elemento del tope de la pila. Devuelve verdadero si la pila no estaba vacía al momento de desapilar (es decir que se pudo desapilar) y falso en caso contrario.
    public boolean desapilar() {
        boolean exito = false;

        if (this.topePila == 0) {
            this.topePila = -1;
            exito = true;
        } else if (this.topePila > 0){
            this.topePila--;
            exito = true;
        }
        return exito;
    }

    // Devuelve el elemento en el tope de la pila. Precondición: la pila no está vacía. SI LA PILA ESTA VACIA DEVUELVE NULL.
    public Object obtenerTope() {
        Object elem = null;

        if (this.topePila >= 0) {
            elem = this.arrPila[topePila];
        }

        return elem;
    }

    //Devuelve true si la pila está vacia o falso si no lo está.
    public boolean esVacia() {
        return this.topePila == -1;
    }

    //Vacia la pila.
    public void vaciar() {
        /*this.topePila = -1;
        this.arrPila = new Object[CAPACIDAD];*/
        while(this.topePila >= 0) {
            this.arrPila[this.topePila] = null;
            this.topePila--;
        }
    }

    // Devuelve una copia exacta de los datos en la estructura original, y respetando el orden de los mismos,
    // en otra estructura del mismo tipo.
    @Override
    public Pila clone() {
        Pila nuevaPila = new Pila();
        nuevaPila.topePila = this.topePila;

        for (int i = 0; i <= this.topePila; i++) {
            nuevaPila.arrPila[i] = this.arrPila[i];
        }

        return nuevaPila;
    }

    // Devuelve una cadena de caracteres formada por todos los elementos de la pila para poder mostrarla por pantalla. 
    // Es recomendable utilizar este método únicamente en la etapa de prueba y luego comentarlo.
    @Override
    public String toString() {
        String s;

        if (this.esVacia()) {
            s = "[]";
        }else{
            s = "[";
            for (int i = topePila; i != -1; i--){
                s += arrPila[i].toString();
                if (i != 0){
                    s += ",";
                }
            }
            s += "]";
        }
        return s;
    }
    
}
