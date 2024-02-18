package modelo;

public class Cabagna extends Hospederia {

    private boolean chimenea;

    //Constructor

    public Cabagna(int valorBaseNoche, int cantidadNoches, String tipoTemporada, DatosCliente cliente, int capacidad, boolean esFumador, boolean chimenea) {
        super(valorBaseNoche, cantidadNoches, tipoTemporada, cliente, capacidad, esFumador);
        this.chimenea = chimenea;
    }

    //Accesadores y mutadores

    public boolean isChimenea() {
        return chimenea;
    }

    public void setChimenea(boolean chimenea) {
        this.chimenea = chimenea;
    }

    /* incrementaValorBase: aumenta el valor base
    en un 18% si la capacidad de la cabaña
    es superior a 5.
     */

    public void incrementaValorBase(){
        int nuevoValorBase = 0;
        if(this.getCapacidad()>5){
            nuevoValorBase = this.getValorBaseNoche()*18/100 + this.getValorBaseNoche();
            setValorBaseNoche(nuevoValorBase);
        }
    }

    @Override
    public int valorACancelar() {
        int valorTotal = this.subtotal()-this.bonoDescuento();
        return valorTotal;
    }
}
