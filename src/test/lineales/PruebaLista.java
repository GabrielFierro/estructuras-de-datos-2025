package test.lineales;
import lineales.dinamicas.*;
public class PruebaLista {

    public static void main(String[] args){
        Lista l1 = new Lista();
        Lista l2 = new Lista();
        Lista listaConcatenada = new Lista();
        System.out.println("Agregar el valor 2: " + l1.insertar(2, 1));
        System.out.println("Agregar el valor 4: " + l1.insertar(4, 2));
        System.out.println("Agregar el valor 6: " + l1.insertar(6, 3));

        System.out.println("Agregar el valor 5: " + l2.insertar(5, 1));
        System.out.println("Agregar el valor 1: " + l2.insertar(1, 2));
        System.out.println("Agregar el valor 6: " + l2.insertar(6, 3));
        System.out.println("Agregar el valor 7: " + l2.insertar(7, 4));

        listaConcatenada = concatenar(l1, l2);

        System.out.println("\nMuestro la lista 1: " + l1.toString());
        System.out.println("\nMuestro la lista 2: " + l2.toString());
        System.out.println("\nMuestro las listas concatenadas: " + listaConcatenada.toString());
    }

    public static Lista concatenar(Lista l1, Lista l2){
        // Recibe 2 listas L1 y L2 y devuelve una lista nueva con los elementos de ambas
        // L1 = [2,4,6] y L2 = [5,1,6,7] => retorna [2,4,6,5,1,6,7]
        Lista listaFinal = new Lista();
        Cola aux = new Cola();
        Object cabecera;
        int i = 0;

        while(!l1.esVacia()){
            aux.poner(l1.recuperar(i));
            l1.eliminar(i);
            i++;
        }
        i = 0;
        while(!l2.esVacia()){
            aux.poner(l2.recuperar(i));
            l2.eliminar(i);
            i++;
        }
        i = 0;
        while(!aux.esVacia()){
            listaFinal.insertar(aux.obtenerFrente(), i);
            aux.sacar();
            i++;
        }
        return listaFinal;
    }
}
