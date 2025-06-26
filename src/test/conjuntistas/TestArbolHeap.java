package test.conjuntistas;

import conjuntistas.ArbolHeap;

public class TestArbolHeap {
    public static void main(String [] args){
        ArbolHeap arbol = new ArbolHeap();

        System.out.println("---------------Comienzo de carga del arbol heap---------------");

        System.out.println("\n El arbol tiene la siguiente forma: \n"
                + "\n                                2"
                + "\n                   +------------+------------+"
                + "\n                   |                         |"
                + "\n                   5                         3"
                + "\n            +------+----------+          +---+---+"
                + "\n            |                 |          |       |"
                + "\n            7                 6          6       19"
                + "\n        +---+---+         +---+---+"
                + "\n        |       |         |       |"
                + "\n        7       9         10      8"
                + "\n");


        System.out.println("\nVerifico si el arbol esta vacio: " + arbol.esVacio());

        System.out.println("\nRecupero la cima del arbol: " + arbol.recuperarCima());

        System.out.println("\nAgregar la raiz 2: " + arbol.insertar(2));

        System.out.println("Agregar el elemento 5: " + arbol.insertar(5));
        System.out.println("Agregar el elemento 3: " + arbol.insertar(3));
        System.out.println("Agregar el elemento 7: " + arbol.insertar(7));
        System.out.println("Agregar el elemento 6: " + arbol.insertar(6));
        System.out.println("Agregar el elemento 5: " + arbol.insertar(5));
        System.out.println("Agregar el elemento 19: " + arbol.insertar(19));
        System.out.println("Agregar el elemento 7: " + arbol.insertar(7));
        System.out.println("Agregar el elemento 9: " + arbol.insertar(9));
        System.out.println("Agregar el elemento 10: " + arbol.insertar(10));
        System.out.println("Agregar el elemento 8: " + arbol.insertar(8));
        System.out.println("Agregar el elemento 6: " + arbol.insertar(6));

        System.out.println("\nMuestro el arbol heap: " + arbol.toString());

        System.out.println("\nElimino la cima: " + arbol.eliminarCima());

        System.out.println("\nMuestro el arbol heap: " + arbol.toString());

        System.out.println("\nRecupero la cima del arbol: " + arbol.recuperarCima());

        System.out.println("\nMuestro el arbol heap: " + arbol.toString());

        System.out.println("\nAgregar el elemento 2: " + arbol.insertar(2));

        System.out.println("\nMuestro el arbol heap: " + arbol.toString());
    }
}
