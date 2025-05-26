package test.lineales;

/*
import lineales.estaticas.Cola;
*/
import lineales.dinamicas.Cola;
import lineales.dinamicas.Nodo;

public class TestCola {
    public static void main(String [] args){
        // Zona de declaracion de variables
        Cola c1 = new Cola();
        Cola clon = new Cola();
        boolean esCapicua;

        // Secuencia de valores enteros 1,5,3,7,2,8
        System.out.println("\nTest para Cola dinamica");
        System.out.println("\nVer estado de la cola vacia antes de ingresar elementos: " + c1.toString());
        System.out.println("\nAgregar hasta 7 elementos en la cola");
        System.out.println("Agregar el valor 1: " + c1.poner(1));
        System.out.println("Agregar el valor 5: " + c1.poner(5));
        System.out.println("Agregar el valor 3: " + c1.poner(3));
        System.out.println("Agregar el valor 7: " + c1.poner(7));
        System.out.println("Agregar el valor 2: " + c1.poner(2));
        System.out.println("Agregar el valor 8: " + c1.poner(8));
        System.out.println("Agregar el valor 4: " + c1.poner(4));
        System.out.println("Intento agregar el valor 5 (deberia darme error de cola llena en estatica): " + c1.poner(5));

        System.out.println("\nVer los elementos de la cola: " + c1.toString());

        System.out.println("\nVerificar si la cola esta vacia: " + c1.esVacia());

        System.out.println("\nVer los elementos de la cola: " + c1.toString());

        System.out.println("\nObtener el frente de la cola (deberia ser 1): " + c1.obtenerFrente());

        System.out.println("\nVer los elementos de la cola despues de obtener el frente: " + c1.toString());

        System.out.println("\nClonar la cola");
        clon = c1.clone();

        System.out.println("\nMuestro la cola original: " + c1.toString());
        System.out.println("\nMuestro la cola clonada: " + clon.toString());

        System.out.println("\nVacio la cola original");
        c1.vaciar();
        System.out.println("\nVerifico si la cola original esta vacia: " + c1.esVacia());

        System.out.println("\nObtener frente de una cola vacia: " + c1.obtenerFrente());

        System.out.println("Trabajo sobre la cola clonada");
        System.out.println("\nVerifico si esta vacia: " + clon.esVacia());
        System.out.println("\nMuestro la cola clonada: " + clon.toString());
        System.out.println("Agregar el valor 6: " + clon.poner(6));
        System.out.println("Agregar el valor 9: " + clon.poner(9));
        if(!clon.poner(4)){
            System.out.println("La cola esta llena");
        }else{
            System.out.println("Agregar el valor 4");
        }
        System.out.println("\nMuestro la cola clonada: " + clon.toString());
    }
}
