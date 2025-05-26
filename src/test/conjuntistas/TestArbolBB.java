package test.conjuntistas;

import conjuntistas.*;
import lineales.dinamicas.Lista;

public class TestArbolBB {
    static String sOk = "OK!", sErr = "ERROR";

    public static void main(String[] args) {
        ArbolBB arbol = new ArbolBB();
        Lista listarElementos = new Lista();
        Lista listarPorRango = new Lista();
        // ArbolBB clon = new ArbolBB();
        // Lista lisPre, lisIn, lisPos, lisNiv;
        // Lista lisPreClon, lisInClon, lisPosClon, lisNivClon;
        // Lista lisAncestrosClon;
        // Lista lisDescendientesClon;
        // Lista lisFronteraClon;

        System.out.println("---------------Comienzo de carga del arbol binario---------------");

        System.out.println("\nAgregar la raiz 3: " + (arbol.insertar(3) ? sOk : sErr));
        System.out.println("\nAgregar el nodo 1: " + (arbol.insertar(1) ? sOk : sErr));
        System.out.println("\nAgregar el nodo 8: " + (arbol.insertar(8) ? sOk : sErr));
        System.out.println("\nAgregar el nodo 0: " + (arbol.insertar(0) ? sOk : sErr));
        System.out.println("\nAgregar el nodo 2: " + (arbol.insertar(2) ? sOk : sErr));
        System.out.println("\nAgregar el nodo 5: " + (arbol.insertar(5) ? sOk : sErr));
        System.out.println("\nAgregar el nodo 9: " + (arbol.insertar(9) ? sOk : sErr));
        System.out.println("\nAgregar el nodo 4: " + (arbol.insertar(4) ? sOk : sErr));
        System.out.println("\nAgregar el nodo 6: " + (arbol.insertar(6) ? sOk : sErr));
        System.out.println("\nAgregar el nodo 10: " + (arbol.insertar(10) ? sOk : sErr));
        System.out.println("\nAgregar el nodo 7: " + (arbol.insertar(7) ? sOk : sErr));

        System.out.println("\nMuestro el Arbol Binario de Busqueda: " + arbol.toString());

        System.out.println("\nElimino el nodo 0 del arbol: " + arbol.eliminar(0));

        System.out.println("\nMuestro el Arbol Binario de Busqueda: " + arbol.toString());

        System.out.println("---------------------------------------------------");

        System.out.println("\nElimino el nodo 1 del arbol: " + arbol.eliminar(1));

        System.out.println("\nMuestro el Arbol Binario de Busqueda: " + arbol.toString());

        System.out.println("---------------------------------------------------");

        // System.out.println("\nElimino el nodo 8 del arbol: " + arbol.eliminar(8));

        // System.out.println("\nMuestro el Arbol Binario de Busqueda: " +
        // arbol.toString());

        System.out.println("---------------------------------------------------");

        System.out.println("\nBusco el nodo 5 en el arbol: " + arbol.pertenece(5));

        System.out.println("\n---------------------------------------------------");

        listarElementos = arbol.listar();

        System.out.println("Mostrar la lista del arbol en forma creciente: " + listarElementos.toString());

        System.out.println("---------------------------------------------------");

        System.out.println("\nAgregar el nodo 1: " + (arbol.insertar(1) ? sOk : sErr));

        System.out.println("\nMuestro el Arbol Binario de Busqueda: " + arbol.toString());

        System.out.println("\nObtener el minimo del arbol: " + arbol.minimoElem());

        System.out.println("\n---------------------------------------------------");

        System.out.println("\nObtener el maximo del arbol: " + arbol.maximoElem());

        System.out.println("\n---------------------------------------------------");

        System.out.println("Listar los elementos del arbol en el rango [1,2] = [1,2]");
        listarPorRango = arbol.listarRango(1, 2);

        System.out.println(listarPorRango.toString());

        System.out.println("\n---------------------------------------------------");

        System.out.println("Listar los elementos del arbol en el rango [2,9] = [2,3,4,5,6,7,8,9]");
        listarPorRango = arbol.listarRango(2, 9);

        System.out.println(listarPorRango.toString());

        System.out.println("\n---------------------------------------------------");

    }
}