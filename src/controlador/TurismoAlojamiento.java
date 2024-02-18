package controlador;

import modelo.Cabagna;
import modelo.Carpa;
import modelo.Hotel;
import modelo.MedioDeAlojamiento;

import java.util.ArrayList;

public class TurismoAlojamiento {

    // Atributos
    private ArrayList<MedioDeAlojamiento> alojamiento;

    // Metodos

    public TurismoAlojamiento(ArrayList<MedioDeAlojamiento> alojamiento) {
        this.alojamiento = alojamiento;
    }

    public ArrayList<MedioDeAlojamiento> getAlojamiento() {
        return alojamiento;
    }

    public void setAlojamiento(ArrayList<MedioDeAlojamiento> alojamiento) {
        this.alojamiento = alojamiento;
    }

    public int buscarAlojamiento(String rutCliente){

        for (int i=0; i<alojamiento.size();i++){

            if (alojamiento.get(i).getCliente().getRut().compareToIgnoreCase(rutCliente)==0){
                // encontre el cliente
                return i;
            }
        }
        return -1; // no existe el cliente asociado a ningun medio de alojamiento
    }

    public void ingresarAlojamientoCarpa(Carpa carpa){
        if (buscarAlojamiento(carpa.getCliente().getRut())==-1){
            alojamiento.add(carpa);
        }
    }

    public void ingresarAlojamientoHotel(Hotel hotel){
        if (buscarAlojamiento(hotel.getCliente().getRut())==-1){
            alojamiento.add(hotel);
        }
    }

    public void ingresarAlojamientoCabagna(Cabagna cabagna){
        if (buscarAlojamiento(cabagna.getCliente().getRut())==-1){
            alojamiento.add(cabagna);
        }
    }

    public String mediosAlojamientos(){
        String mensaje = "";
        Carpa carpa = null;
        Hotel hotel = null;
        Cabagna cabagna = null;
        for (int i=0; i<alojamiento.size();i++){
            if (alojamiento.get(i) instanceof Carpa){
                carpa = (Carpa) alojamiento.get(i);
                mensaje = mensaje  +"\n El valor base por noche de la carpa es: "+ carpa.getValorBaseNoche() +
                    ", La cantidad de noches de la carpa es: " + carpa.getCantidadNoches()  +
                    ", El tipo de temporada de la carpa es: " + carpa.getTipoTemporada() +
                    ", La cantidad de personas en la carpa es: " + carpa.getCantidadPersonas();

            }else if(alojamiento.get(i) instanceof Hotel){
                hotel = (Hotel) alojamiento.get(i);
                mensaje = mensaje +"\n El valor base por noche del hotel es: "+ hotel.getValorBaseNoche() +
                        ", La cantidad de noches del hotel es: " + hotel.getCantidadNoches()  +
                        ", El tipo de temporada del hotel es: " + hotel.getTipoTemporada() +
                        ", La capacidad del hotel es: " + hotel.getCapacidad() +
                        ", El cliente es fumador?: " + hotel.getEsFumador() +
                        ", El cliente quiere desayuno?: " + hotel.getConDesayuno();

            }else if(alojamiento.get(i) instanceof Cabagna){
                cabagna = (Cabagna) alojamiento.get(i);
                mensaje = mensaje + "\n El valor base por noche de la cabaña es: "+ cabagna.getValorBaseNoche() +
                        ", La cantidad de noches de la cabaña es: " + cabagna.getCantidadNoches()  +
                        ", El tipo de temporada de la cabaña es: " + cabagna.getTipoTemporada() +
                        ", La capacidad de la cabaña es: " + cabagna.getCapacidad() +
                        ", El cliente es fumador?: " + cabagna.getEsFumador() +
                        ", El cliente quiere chimenea?: " + cabagna.isChimenea();
            }
        }
        return mensaje;

    }

    public String datosCliente(String rut){

        for (int i=0; i<alojamiento.size();i++){
            if(alojamiento.get(i).getCliente().getRut().compareToIgnoreCase(rut)==0){
                MedioDeAlojamiento medio = alojamiento.get(i);
                if (medio instanceof Carpa) {
                    Carpa carpa = (Carpa) medio;
                    return "Nombre del cliente: " + carpa.getCliente().getNombre() +
                            "\nRUT: " + carpa.getCliente().getRut() +
                            "\nTipo de hospedaje: Carpa" +
                            "\nValor por noche: " + carpa.getValorBaseNoche() +
                            "\nCantidad de noches: " + carpa.getCantidadNoches() +
                            "\nTipo de temporada: " + carpa.getTipoTemporada() +
                            "\nCantidad de personas: " + carpa.getCantidadPersonas();

                } else if (medio instanceof Hotel) {
                    Hotel hotel = (Hotel) medio;
                    return "Nombre del cliente: " + hotel.getCliente().getNombre() +
                            "\nRUT: " + hotel.getCliente().getRut() +
                            "\nTipo de hospedaje: Hotel" +
                            "\nValor por noche: " + hotel.getValorBaseNoche() +
                            "\nCantidad de noches: " + hotel.getCantidadNoches() +
                            "\nTipo de temporada: " + hotel.getTipoTemporada() +
                            "\nCapacidad: " + hotel.getCapacidad() +
                            "\nEs fumador?: " + hotel.getEsFumador() +
                            "\nCon desayuno?: " + hotel.getConDesayuno();

                } else if (medio instanceof Cabagna) {
                    Cabagna cabagna = (Cabagna) medio;
                    return "Nombre del cliente: " + cabagna.getCliente().getNombre() +
                            "\nRUT: " + cabagna.getCliente().getRut() +
                            "\nTipo de hospedaje: Cabagna" +
                            "\nValor por noche: " + cabagna.getValorBaseNoche() +
                            "\nCantidad de noches: " + cabagna.getCantidadNoches() +
                            "\nTipo de temporada: " + cabagna.getTipoTemporada() +
                            "\nCapacidad: " + cabagna.getCapacidad() +
                            "\nEs fumador?: " + cabagna.getEsFumador() +
                            "\nTiene chimenea?: " + cabagna.isChimenea();
                }

            }
        }
        return "El Rut " + rut + "no esta asociado a ningun cliente. Vuelva a intentar.";
    }

    public String totalAdicional(){
        int suma = 0;
        for (int i=0; i<alojamiento.size();i++){
            if(alojamiento.get(i) instanceof Hotel){
                suma = suma + ((Hotel) alojamiento.get(i)).adicional();
            }
        }

        return "El total del valor adicional es: " + suma;
    }

    public String totalBonoDescuento(){
        int suma = 0;
        for (int i=0; i<alojamiento.size();i++){
            suma = suma + alojamiento.get(i).bonoDescuento();

        }

        return "El total del bono de descuento es: " + suma;
    }

    public String cantidadMediosAlojamientos(){
        int hotel = 0;
        int cabagna = 0;
        int carpa = 0;
        for (int i=0; i<alojamiento.size();i++){
            if(alojamiento.get(i) instanceof Hotel){
                hotel = hotel + 1;
            } else if (alojamiento.get(i) instanceof Cabagna){
                cabagna = cabagna + 1;
            } else if (alojamiento.get(i) instanceof Carpa){
                carpa = carpa + 1;
            }
        }

        return "Hay " + hotel + " hotel(es), "+cabagna+ " cabaña(s) y "+carpa+ " carpa(s) ocupadas";
    }

    public String valorACancelarCliente(String rut){
        int total = 0;
        String nombre = null;
        for (int i=0; i<alojamiento.size();i++){
            if(alojamiento.get(i).getCliente().getRut().compareToIgnoreCase(rut)==0){
                total = alojamiento.get(i).subtotal();
                nombre = alojamiento.get(i).getCliente().getNombre();
                return "El cliente "+ nombre + " debe cancelar $" + total;
            }
        }
        return "El cliente no existe";
    }

    public String incrementoValorBase(){

        return "0";

    }



}
