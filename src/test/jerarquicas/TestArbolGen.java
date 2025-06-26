package test.jerarquicas;

import jerarquicas.ArbolGen;
import lineales.dinamicas.Lista;

public class TestArbolGen {
    static String sOk = "OK!", sErr = "ERROR";

    public static void main(String[] args) {
        ArbolGen arbol = new ArbolGen();
        ArbolGen clon = new ArbolGen();
        Lista lisPre, lisIn, lisPos, lisNiv;
        Lista lisPreClon, lisInClon, lisPosClon, lisNivClon;
        Lista lisAncestrosClon;
        Lista lisDescendientesClon;
        Lista lisFronteraClon;

        System.out.println("---------------Comienzo de carga del arbol generico---------------");

        System.out.println("\nVerifico si el arbol esta vacio: " + (arbol.esVacio() ? sOk : sErr));

        System.out.println("\nAgregar la raiz A: " + (arbol.insertar("A", "A", 'I') ? sOk : sErr));

        System.out
                .println("Agregar el nodo hijo izquierdo B al nodo A: " + (arbol.insertar("B", "A", 'I') ? sOk : sErr));
        System.out.println(
                "Agregar el nodo hermano derecho C al nodo B: " + (arbol.insertar("C", "A", 'D') ? sOk : sErr));
        System.out
                .println("Agregar el nodo hijo izquierdo D al nodo B: " + (arbol.insertar("D", "B", 'I') ? sOk : sErr));
        System.out.println(
                "Agregar el nodo hermano derecho E al nodo D: " + (arbol.insertar("E", "B", 'D') ? sOk : sErr));
        System.out
                .println("Agregar el nodo hijo izquierdo F al nodo C: " + (arbol.insertar("F", "C", 'I') ? sOk : sErr));
        System.out.println(
                "Agregar el nodo hermano derecho G al nodo F: " + (arbol.insertar("G", "C", 'D') ? sOk : sErr));
        System.out.println(
                "Agregar el nodo hermano derecho H al nodo G: " + (arbol.insertar("H", "C", 'D') ? sOk : sErr));
        System.out.println(
                "Agregar el nodo hermano derecho I al nodo H: " + (arbol.insertar("I", "C", 'D') ? sOk : sErr));

        // System.out.println("Determino la frontera del arbol:" +
        // arbol.frontera().toString());

        System.out.println("\nMuestro el arbol generico: " + arbol.toString());

        System.out.println("\nBusco el padre del nodo A: " + arbol.padre("A"));
        System.out.println("Busco el padre del nodo B: " + arbol.padre("B"));
        System.out.println("Busco el padre del nodo C: " + arbol.padre("C"));
        System.out.println("Busco el padre del nodo D: " + arbol.padre("D"));
        System.out.println("Busco el padre del nodo E: " + arbol.padre("E"));
        System.out.println("Busco el padre del nodo F: " + arbol.padre("F"));
        System.out.println("Busco el padre del nodo G: " + arbol.padre("G"));
        System.out.println("Busco el padre del nodo H: " + arbol.padre("H"));
        System.out.println("Busco el padre del nodo I: " + arbol.padre("I"));

        System.out.println("\n------Comienzo a listar el arbol en diferentes recorridos------");

        System.out.println("\nMuestro el arbol generico: " + arbol.toString());

        System.out.println("\nListar en preorden");
        lisPre = arbol.listarPreorden();
        System.out.println("Muestro la lista en preorden: " + lisPre.toString());

        System.out.println("\nListar en inorden");
        lisIn = arbol.listarInorden();
        System.out.println("Muestro la lista en inorden: " + lisIn.toString());

        System.out.println("\nListar en posorden");
        lisPos = arbol.listarPosorden();
        System.out.println("Muestro la lista en posorden: " + lisPos.toString());

        // System.out.println("\nListar por niveles");
        // lisNiv = arbol.listarPorNiveles();
        // System.out.println("Muestro la lista en preorden: " + lisNiv.toString());

        System.out.println("\n------Determino la altura del arbol generico------");

        System.out.println("\nMuestro el arbol generico: " + arbol.toString());

        System.out.println("\nLa altura del arbol generico es: " + arbol.altura());

        System.out.println("\nVacio el arbol");
        arbol.vaciar();

        System.out.println("\nVerifico si el arbol esta vacio: " + (arbol.esVacio() ? sOk : sErr));

        System.out.println("\nMuestro el arbol: " + arbol.toString());

        System.out.println("\nLa altura del arbol generico vacio es: " + arbol.altura());

        System.out.println("\nAgregar la raiz A: " + (arbol.insertar("A", "A", 'I') ? sOk : sErr));

        System.out.println("\nVerifico si el arbol esta vacio: " + (arbol.esVacio() ? sOk : sErr));

        System.out.println("\nMuestro el arbol: " + arbol.toString());

        System.out.println("\nLa altura del arbol generico solamente con la raiz es: " + arbol.altura());

        System.out.println("\n------Verificar camino del arbol------");
        arbol.vaciar();

        System.out.println("\nCargo la lista");
        Lista list = new Lista();
        Lista list2 = new Lista();
        Lista list3 = new Lista();

        list.insertar(20, 1);
        list.insertar(54, 2);
        list.insertar(27, 3);

        list2.insertar(20, 1);
        list2.insertar(13, 2);
        list2.insertar(12, 3);
        list2.insertar(45, 4);

        list3.insertar(20, 1);
        list3.insertar(17, 2);

        System.out.println("\nLista: " + list.toString());
        System.out.println("\nLista 2: " + list.toString());

        System.out.println("\nCargo nuevamente el arbol");
        System.out.println("\nAgregar la raiz 20: " + (arbol.insertar(20, 20, 'I') ? sOk : sErr));
        System.out.println(
                "\nAgregar el nodo izquierdo 13 al nodo 20: " + (arbol.insertar(13, 20, 'I') ? sOk : sErr));
        System.out
                .println("\nAgregar el nodo derecho 54 al nodo 20: " + (arbol.insertar(54, 20, 'D') ? sOk : sErr));
        System.out.println(
                "\nAgregar el nodo izquierdo 15 al nodo 13: " + (arbol.insertar(15, 13, 'I') ? sOk : sErr));
        System.out
                .println("\nAgregar el nodo derecho 12 al nodo 13: " + (arbol.insertar(12, 13, 'D') ? sOk : sErr));
        System.out.println(
                "\nAgregar el nodo izquierdo 11 al nodo 54: " + (arbol.insertar(11, 54, 'I') ? sOk : sErr));
        System.out
                .println("\nAgregar el nodo derecho 27 al nodo 11: " + (arbol.insertar(27, 54, 'D') ? sOk : sErr));
        System.out.println("\nAgregar el nodo derecho 4 al nodo 11: " + (arbol.insertar(4, 54, 'D') ? sOk : sErr));

        System.out.println("\nMuestro el arbol");
        System.out.println(arbol.toString());

        System.out.println(
                "\nMuestro el camino para la lista <20, 54, 27> y debe devolver TRUE: " + arbol.verificarCamino(list));

        System.out.println(
                "\nMuestro el camino para la lista <20, 13, 12, 45> y debe devolver FALSE: "
                        + arbol.verificarCamino(list2));

        System.out.println(
                "\nMuestro el camino para la lista <20, 13, 12, 45> y debe devolver FALSE: "
                        + arbol.verificarCamino(list3));
    }
}