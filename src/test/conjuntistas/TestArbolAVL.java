package test.conjuntistas;

import conjuntistas.ArbolAVL;

public class TestArbolAVL {
        public static void main(String[] args) {
                ArbolAVL arbol = new ArbolAVL();

                System.out.println("\n---------------Comienzo de test con elementos numericos---------------");

                System.out.println("\nInserto elementos para implementar la rotacion simple a izquierda");

                System.out.println("\nInsertar el elemento raiz 19: " + arbol.insertar(19));

                System.out.println("\nInsertar el elemento 14 como hijo izquierdo de 19: " + arbol.insertar(14));
                System.out.println("\nInsertar el elemento 23 como hijo derecho de 19: " + arbol.insertar(23));
                System.out.println("\nInsertar el elemento 21 como hijo izquierdo de 23: " + arbol.insertar(21));
                System.out.println("\nInsertar el elemento 26 como hijo derecho de 23: " + arbol.insertar(26));
                System.out.println("\nInsertar el elemento 24 como hijo izquierdo de 26: " + arbol.insertar(24));

                System.out.println("\nEl arbol desbalanceado tiene la forma: \n"
                                + "\n                                19"
                                + "\n                               /  \\"
                                + "\n                             14    23"
                                + "\n                                  /  \\"
                                + "\n                                 21   26"
                                + "\n                                      /"
                                + "\n                                     24"
                                + "\n");
                System.out.println("\nRotacion simple a izquierda");
                System.out.println("Tienen igual signo y el balance es negativo (esta caido hacia la derecha)");

                System.out.println("\nMuestro el arbol balanceado: " + arbol.toString());

                System.out.println("\nEl arbol balanceado tiene la forma: \n"
                                + "\n                                23"
                                + "\n                              /    \\"
                                + "\n                            19      26"
                                + "\n                           /  \\     /"
                                + "\n                         14   21   24"
                                + "\n");

                arbol.vaciar(); // Vacio la estructura para seguir trabajando con la misma

                System.out.println("\nInserto elementos para implementar la rotacion simple a derecha");
                System.out.println("Tienen igual signo y el balance es positivo (esta caido hacia la izquierda)");

                System.out.println("\nInsertar el elemento raiz 28: " + arbol.insertar(28));

                System.out.println("\nInsertar el elemento 21 como hijo izquierdo de 28: " + arbol.insertar(21));
                System.out.println("\nInsertar el elemento 35 como hijo derecho de 28: " + arbol.insertar(35));
                System.out.println("\nInsertar el elemento 15 como hijo izquierdo de 21: " + arbol.insertar(15));
                System.out.println("\nInsertar el elemento 26 como hijo derecho de 21: " + arbol.insertar(26));
                System.out.println("\nInsertar el elemento 8 como hijo izquierdo de 15: " + arbol.insertar(8));

                System.out.println("\nEl arbol desbalanceado tiene la forma: \n"
                                + "\n                                28"
                                + "\n                               /  \\"
                                + "\n                             21    35"
                                + "\n                            /  \\"
                                + "\n                          15   26"
                                + "\n                         /"
                                + "\n                        8"
                                + "\n");

                System.out.println("\nMuestro el arbol balanceado: " + arbol.toString());

                System.out.println("\nEl arbol balanceado tiene la forma: \n"
                                + "\n                                21"
                                + "\n                              /    \\"
                                + "\n                            15      28"
                                + "\n                           /       /  \\"
                                + "\n                          8      26    35"
                                + "\n");

                arbol.vaciar(); // Vacio la estructura para seguir trabajando con la misma

                System.out.println("\nInserto elementos para implementar la rotacion doble izq-der");

                System.out.println("\nInsertar el elemento raiz 28: " + arbol.insertar(28));

                System.out.println("\nInsertar el elemento 21 como hijo izquierdo de 28: " + arbol.insertar(21));
                System.out.println("\nInsertar el elemento 35 como hijo derecho de 28: " + arbol.insertar(35));
                System.out.println("\nInsertar el elemento 15 como hijo izquierdo de 21: " + arbol.insertar(15));
                System.out.println("\nInsertar el elemento 26 como hijo derecho de 21: " + arbol.insertar(26));
                System.out.println("\nInsertar el elemento 23 como hijo izquierdo de 26: " + arbol.insertar(23));

                System.out.println("\nEl arbol desbalanceado tiene la forma: \n"
                                + "\n                                28"
                                + "\n                               /  \\"
                                + "\n                             21    35"
                                + "\n                            /  \\"
                                + "\n                          15   26"
                                + "\n                               /"
                                + "\n                              23"
                                + "\n");

                System.out.println("\nMuestro el arbol balanceado: " + arbol.toString());

                System.out.println("\nEl arbol balanceado tiene la forma: \n"
                                + "\n                                26"
                                + "\n                              /    \\"
                                + "\n                            21      28"
                                + "\n                           /  \\       \\"
                                + "\n                         15    23      35"
                                + "\n");

                arbol.vaciar(); // Vacio la estructura para seguir trabajando con la misma

                System.out.println("\nInserto elementos para implementar la rotacion doble der-izq");

                System.out.println("\nInsertar el elemento raiz 17: " + arbol.insertar(17));

                System.out.println("\nInsertar el elemento 15 como hijo izquierdo de 17: " + arbol.insertar(15));
                System.out.println("\nInsertar el elemento 21 como hijo derecho de 17: " + arbol.insertar(21));
                System.out.println("\nInsertar el elemento 19 como hijo izquierdo de 21: " + arbol.insertar(19));
                System.out.println("\nInsertar el elemento 25 como hijo derecho de 21: " + arbol.insertar(25));
                System.out.println("\nInsertar el elemento 18 como hijo izquierdo de 19: " + arbol.insertar(18));

                System.out.println("\nEl arbol desbalanceado tiene la forma: \n"
                                + "\n                                17"
                                + "\n                               /  \\"
                                + "\n                             15    21"
                                + "\n                                   / \\"
                                + "\n                                 19   25"
                                + "\n                                /"
                                + "\n                              18"
                                + "\n");

                System.out.println("\nMuestro el arbol balanceado: " + arbol.toString());

                System.out.println("\nEl arbol balanceado tiene la forma: \n"
                                + "\n                                19"
                                + "\n                              /    \\"
                                + "\n                            17      21"
                                + "\n                           /  \\       \\"
                                + "\n                         15    18      25"
                                + "\n");

        }
}
