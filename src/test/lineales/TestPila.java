package test.lineales;

import lineales.estaticas.Pila;
/*import lineales.dinamicas.Pila;
import lineales.dinamicas.Nodo;*/

public class TestPila {
    public static void main(String [] args){
        // Zona de declaracion de variables
        Pila p1 = new Pila();
        Pila clon = new Pila();
        boolean esCapicua;

        // Secuencia de valores enteros 1,5,3,7,2,8
        System.out.println("Apilar valores numéricos del 1 al 10");
        System.out.println("Apilar el valor 1: " + p1.apilar(1));
        System.out.println("Apilar el valor 5: " + p1.apilar(5));
        System.out.println("Apilar el valor 3: " + p1.apilar(3));
        System.out.println("Apilar el valor 7: " + p1.apilar(7));
        System.out.println("Apilar el valor 2: " + p1.apilar(2));
        System.out.println("Apilar el valor 8: " + p1.apilar(8));

        System.out.println("Ver los elementos de la pila: " + p1.toString());

        System.out.println("Verificar si la pila esta vacia: " + p1.esVacia());

        System.out.println("Ver los elementos de la pila: " + p1.toString());

        System.out.println("Obtener el tope de la pila (deberia ser 8): " + p1.obtenerTope());

        /*System.out.println("Desapilar (esto deberia sacar el ultimo elemento): " + p1.desapilar());*/
        System.out.println("Desapilar (esto deberia sacar el primer elemento): " + p1.desapilar());

        System.out.println("Ver los elementos de la pila: " + p1.toString());

        System.out.println("Clonar la pila");
        clon = p1.clonar();

        System.out.println("Muestro la pila original: " + p1.toString());
        System.out.println("Muestro la pila clonada: " + clon.toString());

        System.out.println("Vacio la pila");
        p1.vaciar();
        if(p1.esVacia()){
            System.out.println("La pila esta vacia");
        }

        System.out.println("Obtener tope de una pila vacia: " + p1.obtenerTope());

        System.out.println("Ver los elementos de la pila: " + p1.toString());

        System.out.println("\nApilo elementos para verificar si la secuencia de numeros es capicua");

        System.out.println("\nApilar los numeros 1,2,3,2,1");
        System.out.println("Apilar el valor 1: " + p1.apilar(1));
        System.out.println("Apilar el valor 2: " + p1.apilar(2));
        System.out.println("Apilar el valor 3: " + p1.apilar(3));
        System.out.println("Apilar el valor 2: " + p1.apilar(2));
        System.out.println("Apilar el valor 1: " + p1.apilar(1));

        System.out.println("\nVer los elementos de la pila: " + p1.toString());
        System.out.println("\nVerifico si la pila esta vacia");

        if(p1.esVacia()){
            System.out.println("La pila esta vacia");
        }else{
            System.out.println("La pila no esta vacia");
        }

        System.out.println("\nVerificar si la pila es Capicua");

        esCapicua = esCapicua(p1);
        if(esCapicua){
            System.out.println("La pila es capicua");
        } else{
            System.out.println("La pila no es capicua");
        }

        System.out.println("\nApilar los numeros 1,2,3,2,3");
        System.out.println("Apilar el valor 1: " + p1.apilar(1));
        System.out.println("Apilar el valor 2: " + p1.apilar(2));
        System.out.println("Apilar el valor 3: " + p1.apilar(3));
        System.out.println("Apilar el valor 2: " + p1.apilar(2));
        System.out.println("Apilar el valor 3: " + p1.apilar(3));

        System.out.println("\nVer los elementos de la pila: " + p1.toString());
        System.out.println("\nVerifico si la pila esta vacia");

        if(p1.esVacia()){
            System.out.println("La pila esta vacia");
        }else{
            System.out.println("La pila no esta vacia");
        }

        System.out.println("\nVerificar si la pila es Capicua");

        esCapicua = esCapicua(p1);
        if(esCapicua){
            System.out.println("La pila es capicua");
        } else{
            System.out.println("La pila no es capicua");
        }
    }

    public static boolean esCapicua(Pila p1){
        Pila p1Aux = new Pila();
        Pila p2 = p1.clonar();
        boolean exito = true;

        while(!p1.esVacia()){
            p1Aux.apilar(p1.obtenerTope());
            p1.desapilar();
        }

        while(!p2.esVacia()) {
            if (!p2.obtenerTope().equals(p1Aux.obtenerTope())) {
                exito = false;
            }
            p2.desapilar();
            p1Aux.desapilar();
        }
        return exito;
    }

   /* public static boolean esCapicua(Pila p1){
        // metodo recursivo sin terminar
        // p1 = [1,2,3,2,1]
        // p1Aux = [1,2,3,2,1]
        Pila p1Aux = p1;
        int ini, fin;
        boolean exito = false;

        if(p1.esVacia()){ // cambiar caso base
            return true;
        }else{
            ini = (int) p1.obtenerTope(); // 1
            p1.desapilar(); // [2,3,4,5,4,3,2,1]
            exito = esCapicua(p1);
            if(p1Aux.obtenerTope().equals(ini)){
                exito = true;
            }else{
                exito = false;
            }
        }
        return exito;

    }*/
}
