package vista;

import modelo.Cabagna;
import modelo.Carpa;
import modelo.DatosCliente;
import modelo.Hotel;

public class App_Test {
    public static void main(String[] args) {
        DatosCliente cliente = new DatosCliente("Dylan Huarcaya",123456);

        Carpa carpa1 = new Carpa(500,3,"baja",cliente,4);
        Hotel hotel1 = new Hotel(1000,5,"media",cliente,10,true,true);
        Cabagna cabagna1 = new Cabagna(1200,4,"baja",cliente,6,false,true);
        cabagna1.incrementaValorBase();

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








    }
}
