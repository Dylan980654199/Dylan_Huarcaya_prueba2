package modelo;

public abstract class MedioDeAlojamiento {

    protected int valorBaseNoche;
    protected int cantidadNoches;
    protected String tipoTemporada;
    protected DatosCliente cliente;

    //Constructor

    public MedioDeAlojamiento(int valorBaseNoche, int cantidadNoches, String tipoTemporada, DatosCliente cliente) {
        this.valorBaseNoche = valorBaseNoche;
        this.cantidadNoches = cantidadNoches;
        this.tipoTemporada = tipoTemporada;
        this.cliente = cliente;
    }

    //Accesadores y mutadores

    public int getValorBaseNoche() {
        return valorBaseNoche;
    }

    public void setValorBaseNoche(int valorBaseNoche) {
        this.valorBaseNoche = valorBaseNoche;
    }

    public int getCantidadNoches() {
        return cantidadNoches;
    }

    public void setCantidadNoches(int cantidadNoches) {
        this.cantidadNoches = cantidadNoches;
    }

    public String getTipoTemporada() {
        return tipoTemporada;
    }

    public void setTipoTemporada(String tipoTemporada) {
        this.tipoTemporada = tipoTemporada;
    }

    public DatosCliente getCliente() {
        return cliente;
    }

    public void setCliente(DatosCliente cliente) {
        this.cliente = cliente;
    }

    /* subtotal: devolverá el subtotal a
    cancelar el cual será cantidad de noches por
     el valorBaseNoche
     */

    public int subtotal(){

        int subtotal = this.getCantidadNoches()*getValorBaseNoche();
        return subtotal;

    }

    /* bonoDescuento: devolverá el valor a descontar
    sabiendo que es un 25% del subTotal si el tipo de temporada
    es baja o es de un 12.5% si el tipo Temporada es media.  */

    public int bonoDescuento(){

        int bonoDescuento = 0;
        if (this.getTipoTemporada().equalsIgnoreCase("baja")){
            bonoDescuento = Math.round(this.subtotal() * 25/100);
        }else if(this.getTipoTemporada().equalsIgnoreCase("media")){
            bonoDescuento = (int) Math.round(this.subtotal() * 12.5/100);
        }else if(this.getTipoTemporada().equalsIgnoreCase("alta")){
            bonoDescuento = 0;
        }
        return bonoDescuento;
    }

    /*valorACancelar: devolverá el valor a cancelar,
    el cual al subtotal se le debe descontar el bono
    y sumar el adicional, donde corresponda.
     */

    public abstract int valorACancelar();



}
