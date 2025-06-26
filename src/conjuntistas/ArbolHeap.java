package conjuntistas;

public class ArbolHeap {
    // Estructura de tipo Arbol Heap

    // Atributos
    private static final int TAMANIO = 14;
    private Comparable[] heap; // Se declara un array de tipo Object
    private int ultimo = 0;

    public ArbolHeap() {
        this.heap = new Comparable[TAMANIO];
    }

    public boolean insertar(Comparable elem) {
        // recibe un elemento y lo inserta en el arbol segun el algoritmo que se
        // explicara en la siguiente seccion.
        // Si la operacion termina con exito devuelve verdadero y false en caso
        // contrario.
        // Acepta elementos repetidos.
        // Zona de declaracion de variable
        boolean exito;

        if (this.ultimo + 1 >= TAMANIO) {
            exito = false;
        } else {
            ultimo++;
            this.heap[ultimo] = elem;
            hacerSubir(ultimo);
            exito = true;
        }
        return exito;
    }

    private void hacerSubir(int posHijo) {
        int posP;
        Comparable temp = this.heap[posHijo];
        boolean salir = false;

        while (!salir) {
            posP = posHijo / 2;
            if (posP >= 1) {
                // compara al hijo menor con el padre
                if (this.heap[posP].compareTo(temp) > 0) {
                    // el hijo es menor que el padre, los intercambia
                    this.heap[posHijo] = this.heap[posP];
                    this.heap[posP] = temp;
                    posHijo = posP;
                } else {
                    // el padre es menor que sus hijos, esta bien ubicado
                    salir = true;
                }
            } else {
                // el temp es hoja, esta bien ubicado
                salir = true;
            }
        }
    }

    public boolean eliminarCima() {
        // Metodo que dada una estructura de tipo ArbolHeap, elimina el elemento que se
        // encuentra en la cima
        // reemplazando el ultimo elemento del array por el de la cima en posicion 1.
        // Luego, balancea el arbol
        // para que siga cumpliendo la propiedad de que el nodo padre es menor a sus
        // hijos
        boolean exito;

        if (this.ultimo == 0) {
            // estructura vacia
            exito = false;
        } else {
            // saca la raiz y pone la ultima hoja en su lugar
            this.heap[1] = this.heap[ultimo];
            this.ultimo--;
            // reestablece la propiedad de heap minimo
            hacerBajar(1);
            exito = true;
        }
        return exito;
    }

    private void hacerBajar(int posPadre) {
        int posH;
        Comparable temp = this.heap[posPadre];
        boolean salir = false;

        while (!salir) {
            posH = posPadre * 2;
            if (posH <= this.ultimo) {
                // temp tiene al menos un hijo (izq) y lo considera menor

                if (posH < this.ultimo) {
                    // hijoMenor tiene hermano derecho

                    if (this.heap[posH + 1].compareTo(this.heap[posH]) < 0) {
                        // el hijo derecho es el menor de los dos
                        posH++;
                    }
                }

                // compara al hijo menor con el padre
                if (this.heap[posH].compareTo(temp) < 0) {
                    // el hijo es menor que el padre, los intercambia
                    this.heap[posPadre] = this.heap[posH];
                    this.heap[posH] = temp;
                    posPadre = posH;
                } else {
                    // el padre es menor que sus hijos, esta bien ubicado
                    salir = true;
                }
            } else {
                // el temp es hoja, esta bien ubicado
                salir = true;
            }
        }
    }

    public Object recuperarCima() {
        // Metodo que obtiene el elemento que se encuentra en la posicion 1 del array y
        // retorna dicho valor.
        // Zona de declaracion de variable
        Object cima;

        cima = this.heap[1];

        return cima;
    }

    public boolean esVacio() {
        // Metodo que dada una estructura de tipo ArbolHeap verifica si no posee
        // elementos la estructura. En caso
        // afirmativo retorna un true, y en caso contrario retorna false.
        // Zona de declaracion de variable
        boolean exito;
        // Zona de inicializacion de variable
        exito = false;

        if (this.heap[1] == null) {
            exito = true;
        }
        return exito;
    }

    @Override
    public String toString() {
        // Metodo que dada una estructura de ArbolHeap, recorre el array y muestra los
        // elementos cargados en el mismo.
        // Zona de declaracion de variables
        String cadena;
        int i;
        // Zona de inicializacion de variable
        cadena = "| ";

        if (!esVacio()) {
            for (i = 1; i <= this.ultimo; i++) {
                cadena = cadena + this.heap[i] + " | ";
            }
        } else {
            cadena = "Arbol heap vacio";
        }
        return cadena;
    }
}
