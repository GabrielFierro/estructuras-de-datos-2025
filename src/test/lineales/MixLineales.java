package test.lineales;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Pila;
import lineales.dinamicas.Nodo;

public class MixLineales {

    public static void main(String[] args){
        Cola c1 = new Cola();
        Cola nuevaCola = new Cola();

        System.out.println("Agregar el valor A: " + c1.poner("A"));
        System.out.println("Agregar el valor B: " + c1.poner("B"));
        System.out.println("Agregar el valor $: " + c1.poner("$"));
        System.out.println("Agregar el valor C: " + c1.poner("C"));
        System.out.println("Agregar el valor $: " + c1.poner("$"));
        System.out.println("Agregar el valor D: " + c1.poner("D"));
        System.out.println("Agregar el valor E: " + c1.poner("E"));
        System.out.println("Agregar el valor F: " + c1.poner("F"));

        System.out.println("Muestro la cola creada: " + c1.toString());

        System.out.println("Genero una nueva cola con otro orden");

        nuevaCola = generarOtraCola(c1);

        System.out.println("Muestro la nueva cola generada: " + nuevaCola.toString());

    }

    public static Cola generarOtraCola(Cola c1){
        // Zona de declaracion de variables
        Cola copia, colaAux, nuevaCola;
        Pila aux = new Pila();
        Object frente;
        // Zona de inicializacion de variables
        copia = c1.clonar();
        colaAux = new Cola();
        nuevaCola = new Cola();

        while(!copia.esVacia()){
            frente = copia.obtenerFrente();

            if(!frente.equals("$")) {
                aux.apilar(frente);
                colaAux.poner(frente);
            }else{
                while(!colaAux.esVacia()){
                    nuevaCola.poner(colaAux.obtenerFrente());
                    colaAux.sacar();
                }
                while(!aux.esVacia()){
                    nuevaCola.poner(aux.obtenerTope());
                    aux.desapilar();
                }
            }
            copia.sacar();
        }
        while(!colaAux.esVacia()){
            nuevaCola.poner(colaAux.obtenerFrente());
            colaAux.sacar();
        }
        while(!aux.esVacia()){
            nuevaCola.poner(aux.obtenerTope());
            aux.desapilar();
        }
        return nuevaCola;
    }

}
