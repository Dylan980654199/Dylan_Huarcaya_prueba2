package modelo;

public class Hotel extends Hospederia {
    private boolean conDesayuno;

    //Constructor

    public Hotel(int valorBaseNoche, int cantidadNoches, String tipoTemporada, DatosCliente cliente, int capacidad, boolean esFumador, boolean conDesayuno) {
        super(valorBaseNoche, cantidadNoches, tipoTemporada, cliente, capacidad, esFumador);
        this.conDesayuno = conDesayuno;
    }

    // Accesadores y mutadores

    public boolean getConDesayuno() {
        return conDesayuno;
    }

    public void setConDesayuno(boolean conDesayuno) {
        this.conDesayuno = conDesayuno;
    }

    /* adicional: devolverá el valor adicional,
    que corresponde al 30% del subtotal si es Fumador
    y con desayuno.
     */

    public int adicional(){

        int adicional = 0;

        if (this.getEsFumador()==true && this.getConDesayuno()==true){
            adicional = subtotal()*30/100;
        }else{
            adicional = 0;
        }
         return adicional;
    }

    public int valorACancelar(){
        int valorTotal = this.subtotal() - bonoDescuento(); // Restar el bono de descuento del subtotal

        // Verificar si el adicional aplica y sumarlo
        if (this.getEsFumador() && this.getConDesayuno()) {
            valorTotal += adicional();
        }

        return valorTotal;
    }

}
