/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lineales.dinamicas;

/************* Autores *********** 
    - Gabriel Fierro, Legajo FAI-1938
    - Juan Ignacio Veratti, Legajo FAI-5347
    - Fernando Lopez, Legajo FAI-3996
*/
public class Cola {

    // Atributos
    private Nodo frente;
    private Nodo fin;

    // Constructor
    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    public boolean poner(Object nuevoElem) {
        /* Pone el elemento al final de la cola. Devuelve verdadero si 
         el elemento se pudo agregar en la estructura y falso en caso contrario.*/

        // Crea un nuevo nodo con el elemento, inicialmente sin enlace
        Nodo nuevo = new Nodo(nuevoElem, null);
        
        if (this.frente == null) {
            // Si la cola está vacía, el nuevo nodo es tanto el frente como el final
            this.frente = nuevo;
            this.fin = nuevo;
        } else {
            // Si no está vacía, se enlaza al final
            this.fin.setEnlace(nuevo);
            this.fin = nuevo;
        }

        // Nunca hay error de pila llena, entonces devuelve true
        return true;
    }

    public boolean sacar() {
        /* Saca el elemento que está en el frente de la cola. Devuelve verdadero si el elemento
         se pudo sacar (la estructura no estaba vacía) y falso en caso contrario.*/
        boolean exito;
        if (this.esVacia()) {
            exito = false; // La cola está vacía, no se puede sacar
        } else {
            this.frente = this.frente.getEnlace(); // Avanza al siguiente nodo
            if (this.frente == null) { 
                // Si el frente queda en null, también debe actualizarse el fin
                this.fin = null;
            }
            exito = true; // Operación exitosa
        }
        return exito;
    }

    public Object obtenerFrente() {
        // Devuelve el elemento que está en el frente. Precondición: la cola no está vacía.
        Object elem;
        if (this.esVacia()) {
            elem = null;
        } else {
            elem = this.frente.getElem();
        }
        return elem;
    }

    public boolean esVacia() {
        // Devuelve verdadero si la cola no tiene elementos y falso en caso contrario
        return this.frente == null;
    }

    public void vaciar() {
        // Saca todos los elementos de la estructura.
        this.frente = null;
        this.fin = null;
    }

    @Override

    public Cola clone() {
        /* Devuelve una copia exacta de los datos en la estructura original, 
         y respetando el orden de los mismos, en otra estructura del mismo tipo.*/
        Cola clon = new Cola();

        // Verifica si la cola original está vacía
        if (this.frente != null) {
            // Clona el primer nodo
            Nodo aux1 = this.frente;
            clon.frente = new Nodo(aux1.getElem(), null);

            // Referencia para construir la cola clonada
            Nodo aux2 = clon.frente;

            // Clona los nodos restantes
            while (aux1.getEnlace() != null) {
                aux1 = aux1.getEnlace();
                Nodo nuevoNodo = new Nodo(aux1.getElem(), null);
                aux2.setEnlace(nuevoNodo);
                aux2 = nuevoNodo;
            }

            // Actualiza la referencia del fin en la cola clonada
            clon.fin = aux2;
        }

        return clon;
    }

    @Override
    public String toString() {
        /* Crea y devuelve una cadena de caracteres formada por todos los elementos de la cola
         para poder mostrarla por pantalla.*/
        String salida = "[";
        Nodo aux = this.frente;
        while (aux != null) {
            salida += aux.getElem().toString();
            aux = aux.getEnlace();
            if (aux != null) { 
                // Solo añade la coma si no es el último elemento
                salida += ",";
            }
        }
        salida += "]";
        return salida;
    }
}
