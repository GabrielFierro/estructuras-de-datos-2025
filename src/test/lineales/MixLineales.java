package test.lineales;

import lineales.dinamicas.*;

public class MixLineales {

    public static void main(String[] args) {
        Cola c1 = new Cola();
        Cola nuevaCola = new Cola();
        Cola colaAuxiliar = new Cola();
        Lista listaAuxiliar = new Lista();

        System.out.println("Agregar el valor a: " + c1.poner("a"));
        System.out.println("Agregar el valor b: " + c1.poner("b"));
        System.out.println("Agregar el valor c: " + c1.poner("c"));
        System.out.println("Agregar el valor #: " + c1.poner("#"));
        System.out.println("Agregar el valor d: " + c1.poner("d"));
        System.out.println("Agregar el valor e: " + c1.poner("e"));
        System.out.println("Agregar el valor f: " + c1.poner("f"));
        System.out.println("Agregar el valor #: " + c1.poner("#"));
        System.out.println("Agregar el valor q: " + c1.poner("q"));
        System.out.println("Agregar el valor w: " + c1.poner("w"));
        System.out.println("Agregar el valor r: " + c1.poner("r"));
        System.out.println("Agregar el valor t: " + c1.poner("t"));
        System.out.println("Agregar el valor y: " + c1.poner("y"));
        System.out.println("Agregar el valor #: " + c1.poner("#"));
        System.out.println("Agregar el valor s: " + c1.poner("s"));
        System.out.println("Agregar el valor j: " + c1.poner("j"));

        System.out.println("Muestro la cola creada: " + c1.toString());

        // System.out.println("Genero una nueva cola con otro orden");

        // nuevaCola = generarOtraCola(c1);

        System.out.println("Genero una nueva lista a partir de la cola creada");

        listaAuxiliar = generarLista(c1);

        System.out.println("Muestro la nueva cola generada: " + listaAuxiliar.toString());
    }

    public static Lista generarLista(Cola q) {
        Lista lis = new Lista();
        Pila p = new Pila();
        Cola c = new Cola();
        int pos = 1;
        int contador = 1;
        Object frente;

        while (!q.esVacia()) {
            frente = q.obtenerFrente();

            if (!frente.equals("#")) {
                if (contador % 2 == 1) {
                    p.apilar(frente);
                } else {
                    c.poner(frente);
                }
            } else {
                if (contador % 2 == 1) {
                    while (!p.esVacia()) {
                        lis.insertar(p.obtenerTope(), pos);
                        pos++;
                        p.desapilar();
                    }
                } else {
                    while (!c.esVacia()) {
                        lis.insertar(c.obtenerFrente(), pos);
                        pos++;
                        c.sacar();
                    }
                }
                lis.insertar("#", pos);
                pos++;
                contador++;
            }
            q.sacar();
        }
        if (contador % 2 == 1) {
            while (!p.esVacia()) {
                lis.insertar(p.obtenerTope(), pos);
                pos++;
                p.desapilar();
            }
        } else {
            while (!c.esVacia()) {
                lis.insertar(c.obtenerFrente(), pos);
                pos++;
                c.sacar();
            }
        }
        contador++;

        return lis;
    }

    public static Cola generarOtraCola(Cola c1) {
        // $
        // c1 = A,B,$,C,$,D,E,F
        // Debe retornar A,B,B,A,$,C,C,$,D,E,F,F,E,D

        // pila: A,B -> BA
        // Cola: A,B -> AB
        // Zona de declaracion de variables
        Cola copia, colaAux, nuevaCola;
        Pila aux = new Pila();
        Object frente;
        // Zona de inicializacion de variables
        copia = c1.clone();
        colaAux = new Cola();
        nuevaCola = new Cola();

        while (!copia.esVacia()) {
            frente = copia.obtenerFrente();

            if (!frente.equals("$")) {
                aux.apilar(frente);
                colaAux.poner(frente);
            } else {
                while (!colaAux.esVacia()) {
                    nuevaCola.poner(colaAux.obtenerFrente());
                    colaAux.sacar();
                }
                while (!aux.esVacia()) {
                    nuevaCola.poner(aux.obtenerTope());
                    aux.desapilar();
                }
                nuevaCola.poner('$');
            }
            copia.sacar();
        }
        while (!colaAux.esVacia()) {
            nuevaCola.poner(colaAux.obtenerFrente());
            colaAux.sacar();
        }
        while (!aux.esVacia()) {
            nuevaCola.poner(aux.obtenerTope());
            aux.desapilar();
        }
        return nuevaCola;
    }

    public static Cola generar(Cola c1) {
        // $
        // c1 = AB#C#DEF
        // Debe retornar ABBAAB#CCC#DEFFEDDEF

        // Cola: A,B -> AB
        // pila: A,B -> BA
        // Cola: A,B -> AB
        // -> ABBAAB
        // Zona de declaracion de variables
        Cola copia, colaAux, colaAuxiliar, nuevaCola;
        Pila aux = new Pila();
        Object frente;
        // Zona de inicializacion de variables
        copia = c1.clone();
        colaAux = new Cola();
        colaAuxiliar = new Cola();
        nuevaCola = new Cola();

        while (!copia.esVacia()) {
            frente = copia.obtenerFrente();

            if (!frente.equals("$")) {
                aux.apilar(frente);
                colaAux.poner(frente);
                colaAuxiliar.poner(frente);
            } else {
                while (!colaAux.esVacia()) {
                    nuevaCola.poner(colaAux.obtenerFrente());
                    colaAux.sacar();
                }
                while (!aux.esVacia()) {
                    nuevaCola.poner(aux.obtenerTope());
                    aux.desapilar();
                }
                while (!colaAuxiliar.esVacia()) {
                    nuevaCola.poner(colaAuxiliar.obtenerFrente());
                    colaAuxiliar.sacar();
                }
                nuevaCola.poner('$');
            }
            copia.sacar();
        }
        while (!colaAux.esVacia()) {
            nuevaCola.poner(colaAux.obtenerFrente());
            colaAux.sacar();
        }
        while (!aux.esVacia()) {
            nuevaCola.poner(aux.obtenerTope());
            aux.desapilar();
        }
        while (!colaAuxiliar.esVacia()) {
            nuevaCola.poner(colaAuxiliar.obtenerFrente());
            colaAuxiliar.sacar();
        }
        return nuevaCola;
    }

}
