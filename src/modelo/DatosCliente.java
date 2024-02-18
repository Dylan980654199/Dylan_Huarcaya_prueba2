package modelo;

public class DatosCliente {

    private String nombre;
    private String rut;

    //Constructor

    public DatosCliente(String nombre, String rut) {
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

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
}
