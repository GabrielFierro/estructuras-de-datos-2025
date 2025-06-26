/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lineales.estaticas;

/*************
 * Autores ***********
 * - Gabriel Fierro, Legajo FAI-1938
 * - Juan Ignacio Veratti, Legajo FAI-5347
 * - Fernando Lopez, Legajo FAI-3996
 */
public class Cola {

    // Atributos
    private Object[] arreglo;
    private int frente;
    private int fin;
    private final int TAMANIO = 10;

    // Constructor
    public Cola() {
        this.arreglo = new Object[this.TAMANIO];
        this.frente = 0;
        this.fin = 0;
    }

    public boolean poner(Object nuevoElem) {
        /*
         * Pone el elemento al final de la cola. Devuelve verdadero si
         * el elemento se pudo agregar en la estructura y falso en caso contrario.
         */
        boolean exito;
        if ((this.fin + 1) % TAMANIO == this.frente) { // La cola esta llena.
            // La cola esta llena
            exito = false;
        } else {
            this.arreglo[this.fin] = nuevoElem;
            this.fin = (this.fin + 1) % this.TAMANIO; // Avanza de forma circular
            exito = true;
        }
        return exito;
    }

    public boolean sacar() {
        /*
         * Saca el elemento que está en el frente de la cola. Devuelve verdadero si el
         * elemento
         * se pudo sacar (la estructura no estaba vacía) y falso en caso contrario.
         */
        boolean exito = true;

        if (this.frente == this.fin) { // La cola está vacía
            exito = false;
        } else { // Al menos hay un elemento: avanza frente de manera circular
            this.arreglo[this.frente] = null; // Elimina el elemento
            this.frente = (this.frente + 1) % this.TAMANIO; // Avanza de forma circular
        }
        return exito;
    }

    public Object obtenerFrente() {
        // Devuelve el elemento que está en el frente. Precondición: la cola no está
        // vacía.
        Object elem;
        if (this.esVacia()) {
            elem = null;
        } else {
            elem = this.arreglo[this.frente];
        }
        return elem;
    }

    public boolean esVacia() {
        // Devuelve verdadero si la cola no tiene elementos y falso en caso contrario
        return this.frente == this.fin;
    }

    public void vaciar() {
        // Saca todos los elementos de la estructura.
        while (this.frente != this.fin) {
            this.arreglo[this.frente] = null; // Elimina el elemento
            this.frente = (this.frente + 1) % this.TAMANIO; // Avanza de forma circular
        }
    }

    @Override
    public Cola clone() {
        /*
         * Devuelve una copia exacta de los datos en la estructura original,
         * y respetando el orden de los mismos, en otra estructura del mismo tipo
         */
        Cola copia = new Cola();

        // Copiamos los elementos de la cola original a la nueva
        int i = this.frente;
        while (i != this.fin) {
            copia.arreglo[i] = this.arreglo[i];
            i = (i + 1) % TAMANIO;
        }

        // Copiamos los punteros
        copia.frente = this.frente;
        copia.fin = this.fin;

        return copia;
    }

    @Override
    public String toString() {
        /*
         * Crea y devuelve una cadena de caracteres formada por todos los elementos de
         * la cola
         * para poder mostrarla por pantalla.
         */
        String salida = "[";
        int i = this.frente;
        while (i != this.fin) {
            salida += this.arreglo[i].toString();
            i = (i + 1) % this.TAMANIO; // Avanza de forma circular
            if (i != this.fin) {
                salida += ",";
            }
        }
        salida += "]";
        return salida;
    }

}
