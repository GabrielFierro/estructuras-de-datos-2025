package test.jerarquicas;

import jerarquicas.ArbolGen;
import lineales.dinamicas.Lista;

public class TestArbolGen {
    static String sOk = "OK!", sErr = "ERROR";
    public static void main(String [] args){
        ArbolGen arbol = new ArbolGen();
        ArbolGen clon = new ArbolGen();
        Lista lisPre, lisIn, lisPos, lisNiv;
        Lista lisPreClon, lisInClon, lisPosClon, lisNivClon;
        Lista lisAncestrosClon;
        Lista lisDescendientesClon;
        Lista lisFronteraClon;

        System.out.println("---------------Comienzo de carga del arbol generico---------------");

        System.out.println("\nVerifico si el arbol esta vacio: " + (arbol.esVacio() ? sOk : sErr));

        System.out.println("\nAgregar la raiz A: " + (arbol.insertar("A","A", 'I') ? sOk : sErr));

        System.out.println("Agregar el nodo hijo izquierdo B al nodo A: " + (arbol.insertar("B","A", 'I') ? sOk : sErr));
        System.out.println("Agregar el nodo hermano derecho C al nodo B: " + (arbol.insertar("C","A", 'D') ? sOk : sErr));
        System.out.println("Agregar el nodo hijo izquierdo D al nodo B: " + (arbol.insertar("D","B", 'I') ? sOk : sErr));
        System.out.println("Agregar el nodo hermano derecho E al nodo D: " + (arbol.insertar("E","B", 'D') ? sOk : sErr));
        System.out.println("Agregar el nodo hijo izquierdo F al nodo C: " + (arbol.insertar("F","C", 'I') ? sOk : sErr));
        System.out.println("Agregar el nodo hermano derecho G al nodo F: " + (arbol.insertar("G", "C", 'D') ? sOk : sErr));
        System.out.println("Agregar el nodo hermano derecho H al nodo G: " + (arbol.insertar("H", "C", 'D') ? sOk : sErr));
        System.out.println("Agregar el nodo hermano derecho I al nodo H: " + (arbol.insertar("I", "C", 'D') ? sOk : sErr));

        // System.out.println("Determino la frontera del arbol:" + arbol.frontera().toString());

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

        System.out.println("\nAgregar la raiz A: " + (arbol.insertar("A","A", 'I') ? sOk : sErr));

        System.out.println("\nVerifico si el arbol esta vacio: " + (arbol.esVacio() ? sOk : sErr));

        System.out.println("\nMuestro el arbol: " + arbol.toString());

        System.out.println("\nLa altura del arbol generico solamente con la raiz es: " + arbol.altura());

        // System.out.println("\n------Determino el nivel de diferentes elementos sobre el arbol------");

        // System.out.println("\nCargo nuevamente el arbol");
        // System.out.println("\nAgregar el nodo izquierdo B al nodo A: " + (arbol.insertar("B","A", 'I') ? sOk : sErr));
        // System.out.println("Agregar el nodo derecho C al nodo A: " + (arbol.insertar("C","A", 'D') ? sOk : sErr));
        // System.out.println("Agregar el nodo izquierdo D al nodo B: " + (arbol.insertar("D","B", 'I') ? sOk : sErr));
        // System.out.println("Agregar el nodo izquierdo E al nodo C: " + (arbol.insertar("E","C", 'I') ? sOk : sErr));
        // System.out.println("Agregar el nodo derecho F al nodo C: " + (arbol.insertar("F","C", 'D') ? sOk : sErr));
        // System.out.println("Agregar el nodo izquierdo G al nodo E: " + (arbol.insertar("G", "E", 'I') ? sOk : sErr));
        // System.out.println("Agregar el nodo derecho H al nodo E: " + (arbol.insertar("H","E", 'D') ? sOk : sErr));

        // System.out.println("\nVerifico si el arbol esta vacio: " + (arbol.esVacio() ? sOk : sErr));

        // System.out.println("\nMuestro el arbol: " + arbol.toString());

        // System.out.println("\nEl nivel del nodo raiz A es: " + arbol.nivel("A"));

        // System.out.println("\nEl nivel del nodo B es: " + arbol.nivel("B"));

        // System.out.println("\nEl nivel del nodo D es: " + arbol.nivel("D"));

        // System.out.println("\nEl nivel del nodo H es: " + arbol.nivel("H"));

        // System.out.println("\nEl nivel del nodo Z no existente es: " + arbol.nivel("Z"));

        // System.out.println("\n------Creo un arbol clon y trabajo sobre el------");

        // System.out.println("\nMuestro el arbol original: " + arbol.toString());

        // // System.out.println("\nClono la estructura de tipo Arbol");

        // // // clon = arbol.clone();

        // System.out.println("\nMuestro el arbol clonado: " + clon.toString());

        // System.out.println("\nVerifico si el arbol clon esta vacio: " + (clon.esVacio() ? sOk : sErr));

        // System.out.println("\nLa altura del arbol generico clon es: " + clon.altura());

        // System.out.println("\n------Comienzo a listar el arbol clonado en diferentes recorridos------");

        // System.out.println("\nMuestro el arbol generico clon: " + clon.toString());

        // System.out.println("\nListar en preorden");
        // lisPreClon = clon.listarPreorden();
        // System.out.println("Muestro la lista en preorden: " + lisPreClon.toString());

        // System.out.println("\nListar en inorden");
        // lisInClon = clon.listarInorden();
        // System.out.println("Muestro la lista en preorden: " + lisInClon.toString());

        // System.out.println("\nListar en posorden");
        // lisPosClon = clon.listarPosorden();
        // System.out.println("Muestro la lista en preorden: " + lisPosClon.toString());

        // // System.out.println("\nListar por niveles");
        // // lisNivClon = clon.listarPorNiveles();
        // // System.out.println("Muestro la lista en preorden: " + lisNivClon.toString());


        // // System.out.println("\n------ Busco los ancestros de elementos existentes y no existentes en arbol clon------");

        // // System.out.println("\nAncestros del nodo raiz A");
        // // lisAncestrosClon = clon.obtenerAncestros("A");
        // // System.out.println("\nMuestro la lista que contiene los ancestros de A: " + lisAncestrosClon.toString());

        // // System.out.println("\nAncestros del nodo B");
        // // lisAncestrosClon = clon.obtenerAncestros("B");
        // // System.out.println("\nMuestro la lista que contiene los ancestros de B: " + lisAncestrosClon.toString());

        // // System.out.println("\nAncestros del nodo Z no existente");
        // // lisAncestrosClon = clon.obtenerAncestros("Z");
        // // System.out.println("\nMuestro la lista que contiene los ancestros de Z: " + lisAncestrosClon.toString());


        // // System.out.println("\n------ Busco los descendientes de elementos existentes y no existentes en arbol clon------");

        // // System.out.println("\nDescendientes del nodo raiz A");
        // // lisDescendientesClon = clon.obtenerDescendientes("A");
        // // System.out.println("\nMuestro la lista que contiene los descendientes de A: " + lisDescendientesClon.toString());

        // // System.out.println("\nDescendientes del nodo B");
        // // lisDescendientesClon = clon.obtenerDescendientes("B");
        // // System.out.println("\nMuestro la lista que contiene los descendientes de B: " + lisDescendientesClon.toString());

        // // System.out.println("\nDescendientes del nodo Z no existente");
        // // lisDescendientesClon = clon.obtenerDescendientes("Z");
        // // System.out.println("\nMuestro la lista que contiene los Descendientes de Z: " + lisDescendientesClon.toString());

        // // System.out.println("\n------ Busco los nodos hoja que componen la frontera del arbol ------");

        // // System.out.println("\nMuestro el arbol clon: " + clon.toString());

        // // System.out.println("\nFrontera del arbol clon:");
        // // lisFronteraClon = arbol.frontera();

        // // System.out.println("Muestro la lista de la frontera: " + lisFronteraClon.toString());

        // ArbolGen nuevoArbol = new ArbolGen();
        // Lista fronteraNuevoArbol = new Lista();

        // System.out.println("\nAgregar el nodo raiz A: " + (nuevoArbol.insertar("A","A", 'I') ? sOk : sErr));
        // System.out.println("Agregar el nodo izquierdo B al nodo A: " + (nuevoArbol.insertar("B","A", 'I') ? sOk : sErr));
        // System.out.println("Agregar el nodo derecho C al nodo A: " + (nuevoArbol.insertar("C","A", 'D') ? sOk : sErr));
        // System.out.println("Agregar el nodo izquierdo D al nodo B: " + (nuevoArbol.insertar("D","B", 'I') ? sOk : sErr));

        // System.out.println("\nMuestro el nuevo arbol: " + nuevoArbol.toString());

        // // fronteraNuevoArbol = nuevoArbol.frontera();

        // // System.out.println("\nMuestro la lista de la frontera: " + fronteraNuevoArbol.toString());

        // System.out.println("\nVacio el arbol");
        // arbol.vaciar();

        // System.out.println("\nAgregar la raiz 10: " + (arbol.insertar(10,10, 'I')));
        // System.out.println("Agregar el nodo izquierdo 5 al nodo 10: " + (arbol.insertar(5,10, 'I')));
        // System.out.println("Agregar el nodo derecho 23 al nodo 10: " + (arbol.insertar(23,10, 'D')));
        // System.out.println("Agregar el nodo izquierdo 2 al nodo 5: " + (arbol.insertar(2,5, 'I')));
        // System.out.println("Agregar el nodo izquierdo 15 al nodo 23: " + (arbol.insertar(15,23, 'I')));
        // System.out.println("Agregar el nodo derecho 24 al nodo 15: " + (arbol.insertar(24,15, 'D')));

        // System.out.println("\nMuestro el arbol: " + arbol.toString());

        // // System.out.println("\nModifico el arbol");
        // // arbol.modificarSubarboles(23, 7, 78);

        // // System.out.println("\nMuestro el arbol modificado: " + arbol.toString());
    }
}