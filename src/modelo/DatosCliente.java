package modelo;

public class DatosCliente {

    private String nombre;
    private int rut;

    //Constructor

    public DatosCliente(String nombre, int rut) {
        this.nombre = nombre;
        this.rut = rut;
    }

    //Accesadores y mutadores


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }
}
