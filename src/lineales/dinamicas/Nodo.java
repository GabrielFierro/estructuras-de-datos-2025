package lineales.dinamicas;
/************* Autores ***********
    Gabriel Fierro, Legajo FAI-1938
    Veratti Juan Ignacio, FAI-5347
    Fernando Lopez, Legajo: FAI-3996
*/
public class Nodo {
    private Object elem;
    private Nodo enlace;

    public Nodo(Object elem, Nodo enlace){
        this.elem = elem;
        this.enlace = enlace;
    }

    public void setElem(Object elem){
        this.elem = elem;
    }

    public void setEnlace(Nodo enlace){
        this.enlace = enlace;
    }

    public Object getElem(){
        return this.elem;
    }

    public Nodo getEnlace(){
        return this.enlace;
    }
}
