package test.jerarquicas;
import jerarquicas.*;

public class TestArbolBin {

    public static void main(String []args){
        ArbolBin arbol = new ArbolBin();

        System.out.println("Inserto el nodo raiz A: " + arbol.insertar('A', null, 'I'));
        System.out.println("Inserto el nodo B como HI de A: " + arbol.insertar('B', 'A', 'I'));
        System.out.println("Inserto el nodo C como HD de A: " + arbol.insertar('C', 'A', 'D'));
        System.out.println("Inserto el nodo D como HI de C: " + arbol.insertar('D', 'C', 'I'));

        System.out.println("Muestro la estructura del arbol binario: " + arbol.toString());
    }
}
