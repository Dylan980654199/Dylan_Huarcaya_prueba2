package vista;

import controlador.TurismoAlojamiento;
import modelo.Cabagna;
import modelo.Carpa;
import modelo.DatosCliente;
import modelo.Hotel;

import java.util.ArrayList;

public class App_Test {
    public static void main(String[] args) {
        DatosCliente cliente = new DatosCliente("Dylan Huarcaya","1.234.567-8");
        DatosCliente cliente2 = new DatosCliente("Katia Garcia","1.578.567-9");
        DatosCliente cliente3 = new DatosCliente("Diego Maizo","2.254.555-2");
        DatosCliente cliente4 = new DatosCliente("Diego Maizo","2.254.585-2");
        DatosCliente cliente5 = new DatosCliente("Cristian Galarza","2.999.585-2");

        Carpa carpa1 = new Carpa(500,3,"baja",cliente,4);
        Hotel hotel1 = new Hotel(1000,5,"media",cliente2,10,true,true);
        Hotel hotel2 = new Hotel(3000,6,"media",cliente5,8,true,true);
        Cabagna cabagna1 = new Cabagna(1200,4,"baja",cliente3,6,false,true);
        Cabagna cabagna2 = new Cabagna(2500,4,"baja",cliente4,4,false,true);
        cabagna1.incrementaValorBase();


        TurismoAlojamiento alojamiento = new TurismoAlojamiento(new ArrayList<>());

        System.out.println("La cantidad de alojamientos registrados es: "+ alojamiento.getAlojamiento().size());

        alojamiento.ingresarAlojamientoCarpa(carpa1);
        alojamiento.ingresarAlojamientoHotel(hotel1);
        alojamiento.ingresarAlojamientoHotel(hotel2);

        System.out.println("La cantidad de alojamientos registrados es: "+ alojamiento.getAlojamiento().size());

        alojamiento.ingresarAlojamientoCabagna(cabagna1);
        alojamiento.ingresarAlojamientoCabagna(cabagna2);

        System.out.println("La cantidad de alojamientos registrados es: "+ alojamiento.getAlojamiento().size());


        System.out.println(alojamiento.mediosAlojamientos());
        System.out.println(alojamiento.datosCliente("2.254.555-2"));
        System.out.println(alojamiento.totalAdicional());
        System.out.println(alojamiento.totalBonoDescuento());
        System.out.println(alojamiento.cantidadMediosAlojamientos());
        System.out.println(alojamiento.valorACancelarCliente("2.254.555-2"));


        /*
        System.out.println("El subtotal de la carpa es: $" + carpa1.subtotal());
        System.out.println("El bono de descuento de la carpa es: $" + carpa1.bonoDescuento());
        System.out.println("El valor total a pagar de la carpa es: $" + carpa1.valorACancelar());
        System.out.println("---------------------------------------------------");
        System.out.println("El subtotal del hotel es: $" + hotel1.subtotal());
        System.out.println("El bono de descuento del hotel es: $" + hotel1.bonoDescuento());
        System.out.println("El pago adicional del hotel es: $" + hotel1.adicional());
        System.out.println("El valor total a pagar del hotel es: $" + hotel1.valorACancelar());
        System.out.println("---------------------------------------------------");
        System.out.println("El valor base por capacidad de la cabaña es: $"+cabagna1.getValorBaseNoche());
        System.out.println("El subtotal de la cabaña es: $" + cabagna1.subtotal());
        System.out.println("El bono de descuento de la cabaña es: $" + cabagna1.bonoDescuento());
        System.out.println("El valor total a pagar de la cabaña es: $" + cabagna1.valorACancelar());
        */







    }
}
