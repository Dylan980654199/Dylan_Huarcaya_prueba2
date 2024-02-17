package modelo;

public class Carpa extends MedioDeAlojamiento {

    protected int cantidadPersonas;

    //Constructor

    public Carpa(int valorBaseNoche, int cantidadNoches, String tipoTemporada, DatosCliente cliente, int cantidadPersonas) {
        super(valorBaseNoche, cantidadNoches, tipoTemporada, cliente);
        this.cantidadPersonas = cantidadPersonas;
    }

    // Accesadores y mutadores

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }
}
