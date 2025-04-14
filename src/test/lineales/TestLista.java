package test.lineales;

import lineales.dinamicas.Lista;
import lineales.dinamicas.Nodo;

public class TestLista {
    public static void main(String [] args){
        // Zona de declaracion de variables
        Lista l1 = new Lista();
        Lista clon = new Lista();
        boolean esCapicua;

        // Secuencia de valores enteros 1,5,3,7,2,8
        System.out.println("\nTest para Lista");
        System.out.println("\nCaso 1: Tiene n elementos es decir mas de 1 elemento");
        System.out.println("\nVer estado de la lista vacia antes de ingresar elementos: " + l1.toString());
        System.out.println("\nAgregar hasta 7 elementos en la lista");
        System.out.println("Agregar el valor 1: " + l1.insertar(1, 1));
        System.out.println("Agregar el valor 5: " + l1.insertar(5, 2));
        System.out.println("Agregar el valor 3: " + l1.insertar(3, 3));
        System.out.println("Agregar el valor 7: " + l1.insertar(7, 4));
        System.out.println("Agregar el valor 2: " + l1.insertar(2, 5));
        System.out.println("Agregar el valor 8: " + l1.insertar(8, 6));
        System.out.println("Agregar el valor 4: " + l1.insertar(4, 7));

        System.out.println("\nVer los elementos de la lista: " + l1.toString());

        System.out.println("\nEliminar en una posicion especial (pos 0): " + l1.eliminar(0));

        System.out.println("\nVer los elementos de la lista: " + l1.toString());

        System.out.println("\nVer la longitud de la lista (deberia ser 6): " + l1.longitud());

        System.out.println("\nVerificar si la lista esta vacia: " + l1.esVacia());

        System.out.println("\nVer los elementos de la lista: " + l1.toString());

        System.out.println("\nRecuperar un elemento de la lista en la pos 3 (debe ser el numero 7): " + l1.recuperar(3));

        System.out.println("\nVer los elementos de la lista despues de recuperar un elemento en la pos 3: " + l1.toString());

        System.out.println("\nLocalizar la posicion del elemento 8 (debe ser la posicion 5): " + l1.localizar(8));

        System.out.println("\nVer los elementos de la lista despues de localizar un elemento en la pos 5: " + l1.toString());

        System.out.println("\nVacio la lista: " + l1.vaciar());
        System.out.println("\nVerificar si la lista esta vacia: " + l1.esVacia());
        System.out.println("\nVer los elementos de la lista: " + l1.toString());
        System.out.println("\nVer la longitud de la lista (deberia ser 0): " + l1.longitud());

        System.out.println("\nClonar la lista vacia");
        clon = l1.clone();

        System.out.println("\nMuestro la lista original: " + l1.toString());
        System.out.println("\nMuestro la lista clonada: " + clon.toString());

        System.out.println("\nCaso 2: Tiene 1 solo elemento insertado");
        System.out.println("Agregar el valor 1: " + l1.insertar(1, 1));

        System.out.println("\nVer los elementos de la lista: " + l1.toString());

        System.out.println("\nVerificar si la lista esta vacia: " + l1.esVacia());

        System.out.println("\nVer la longitud de la lista (deberia ser 1): " + l1.longitud());

        System.out.println("\nRecuperar un elemento de la lista en la pos 0 (debe ser el numero 0): " + l1.recuperar(1));

        System.out.println("\nVer los elementos de la lista despues de recuperar un elemento en la pos 0: " + l1.toString());

        System.out.println("\nLocalizar la posicion del elemento 0 (debe ser la posicion 0): " + l1.localizar(1));

        System.out.println("\nVacio la lista: " + l1.vaciar());
        System.out.println("\nVer los elementos de la lista despues de vaciarla: " + l1.toString());
        System.out.println("\nVerifico si la lista es vacia: " + l1.esVacia());

        System.out.println("\nCasos especiales");
        System.out.println("Agregar el valor 5: " + l1.insertar(5, 1));
        System.out.println("Agregar el valor 4: " + l1.insertar(4, 2));
        System.out.println("Agregar el valor 3: " + l1.insertar(3, 3));
        System.out.println("Agregar el valor 2: " + l1.insertar(2, 4));
        System.out.println("Agregar el valor 1: " + l1.insertar(1, 5));

        System.out.println("\nVer la longitud de la lista (deberia ser 5): " + l1.longitud());
        System.out.println("\nVer los elementos de la lista: " + l1.toString());

        System.out.println("\nLocalizar un elemento que no existe el elemento 299 (deberia retornar -1): " + l1.localizar(299));

        System.out.println("\nEliminar en una posicion especial (pos 0): " + l1.eliminar(1));

        System.out.println("\nVer los elementos de la lista despues de eliminar en la posicion 1: " + l1.toString());

        System.out.println("\nEliminar en una posicion especial (pos 0): " + l1.eliminar(1));

        System.out.println("\nVer los elementos de la lista despues de eliminar en la posicion 1: " + l1.toString());

        System.out.println("\nEliminar en una posicion invalida (pos 15): " + l1.eliminar(15));

        System.out.println("\nVer los elementos de la lista despues de eliminar en la posicion 15: " + l1.toString());
    }
}
