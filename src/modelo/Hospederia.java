package modelo;

public abstract class Hospederia extends MedioDeAlojamiento {
    protected int capacidad;
    protected boolean esFumador;

    // Constructor

    public Hospederia(int valorBaseNoche, int cantidadNoches, String tipoTemporada, DatosCliente cliente, int capacidad, boolean esFumador) {
        super(valorBaseNoche, cantidadNoches, tipoTemporada, cliente);
        this.capacidad = capacidad;
        this.esFumador = esFumador;
    }


    // Accesadores y mutadores

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean getEsFumador() {
        return esFumador;
    }

    public void setEsFumador(boolean esFumador) {
        this.esFumador = esFumador;
    }

}
