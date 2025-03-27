package lineales.estaticas;

public class Cola {
    private Object[] arreglo;
    private int frente;
    private int fin;
    private static final int TAMANIO = 8;

    public Cola(){
        this.arreglo = new Object[this.TAMANIO];
        this.frente = 0;
        this.fin = 0;
    }

    public boolean poner(Object newElem){
        boolean exito = true;

        if(this.fin+1 == this.TAMANIO){
            exito = false;
        }else{
            this.arreglo[this.fin] = newElem;
            this.fin++;
            exito = true;
        }
        return exito;
    }

    public boolean sacar(){
        boolean exito = true;

        if(this.esVacia()){ // la cola esta vacia
            exito = false;
        }else{  // al menos hay 1 elemento; avanza frente (de manera circular)
            this.arreglo[this.frente] = null;
            this.frente = (this.frente + 1) % this.TAMANIO;
        }
        return exito;
    }

    public Object obtenerFrente(){
        return this.arreglo[this.frente];
    }

    public boolean esVacia(){
        return this.frente == this.fin;
    }

    public void vaciar(){
        while(this.fin > 0){
            this.arreglo[this.fin] = null;
            this.fin--;
        }
        this.frente = 0;
    }

    public Cola clonar(){
        // Recorrer el arreglo con un for pasando por cada elemento
        // y hacer una copia de los elementos en una nueva pila
        Cola clon = new Cola();

        for(int i = 0; i < this.fin; i++){
            clon.arreglo[i] = this.arreglo[i];
        }
        clon.fin = this.fin;
        return clon;
    }

    @Override
    public String toString(){
        // Esto debe recorrer el array y retornar una cadena de caracteres con los valores
        String s = "";

        if(this.fin == 0){
            s = "Cola vacia";
        }else{
            for(int i = 0; i <= this.fin; i++){
                s += this.arreglo[i] + ", ";
            }
        }

        return s;
    }
}
