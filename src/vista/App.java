package vista;

import controlador.TurismoAlojamiento;
import modelo.Cabagna;
import modelo.Carpa;
import modelo.DatosCliente;
import modelo.Hotel;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        int opcion;
        String rutCliente;

        // Coleccion (capa de control)
        TurismoAlojamiento alojamiento = new TurismoAlojamiento(new ArrayList<>());

        do{
            opcion = menu();

            switch(opcion){
                case 1: // ingreso
                    rutCliente = piderut();

                    if(alojamiento.buscarAlojamiento(rutCliente)==-1){
                        // se puede cargar
                        System.out.println("Introducir nombre del cliente: "); String nombre = Leer.dato();
                        System.out.println("Introducir cantidad de noches: "); int noche = Leer.datoInt();
                        System.out.println("Introducir valor base por noche: "); int valorBase = Leer.datoInt();

                        String temporada;
                        do{
                            System.out.println("Tipo de temporada? (alta,media o baja): ");
                            temporada = Leer.dato();
                        }while(temporada.compareToIgnoreCase("alta") !=0 && temporada.compareToIgnoreCase("media") !=0 && temporada.compareToIgnoreCase("baja") !=0);

                        int tipoDeAlojamiento;
                        do{
                            System.out.println("Ingrese tipo de alojamiento: 1) Carpa  2) Hotel  3) Cabaña");
                            System.out.println("--------------------------------------------------");
                            tipoDeAlojamiento = Leer.datoInt();
                        }while(tipoDeAlojamiento<1 || tipoDeAlojamiento>3);

                        if(tipoDeAlojamiento==1){
                            // Carpa
                            System.out.println("Ingrese cantidad de personas: "); int cantPersonas = Leer.datoInt();
                            alojamiento.ingresarAlojamientoCarpa(new Carpa(valorBase,noche,temporada,new DatosCliente(nombre,rutCliente),cantPersonas));
                            System.out.println("Alojamiento Carpa ingresado correctamente");
                        }else{
                            // Hospederia
                            System.out.println("Introducir capacidad: "); int capacidad = Leer.datoInt();
                            System.out.println("El cliente es fumador? (introducir 'true'=sí o ´false'=no):"); boolean esFumador = Leer.datoBoolean();

                            if(tipoDeAlojamiento==2){
                                // Hotel
                                System.out.println("El cliente quiere desayuno? (introducir 'true'=sí o ´false'=no):"); boolean conDesayuno = Leer.datoBoolean();
                                alojamiento.ingresarAlojamientoHotel(new Hotel(valorBase,noche,temporada,new DatosCliente(nombre,rutCliente),capacidad,esFumador,conDesayuno));
                                System.out.println("Alojamiento Hotel ingresado correctamente");
                            }else{
                                // Cabaña
                                System.out.println("El cabaña tiene chimenea? (introducir 'true'=sí o ´false'=no):"); boolean conChimenea = Leer.datoBoolean();
                                alojamiento.ingresarAlojamientoCabagna(new Cabagna(valorBase,noche,temporada,new DatosCliente(nombre,rutCliente),capacidad,esFumador,conChimenea));
                                System.out.println("Alojamiento Cabaña ingresado correctamente");
                            }

                        }

                    }else{
                        System.out.println("El RUT " + rutCliente + " se encuentra asociado a otro cliente. Favor revisar.");
                    }
                    break;
                case 2: // mostrar
                    System.out.println("------------Alojamiento reservados----------------");
                    System.out.println(alojamiento.mediosAlojamientos());
                    System.out.println("--------------------------------------------------");
                    break;
                case 3: // datosCliente
                    String rutSolicitado = piderut();
                    System.out.println("---------------Datos del cliente------------------");
                    System.out.println(alojamiento.datosCliente(rutSolicitado));
                    System.out.println("--------------------------------------------------");
                    break;
                case 4: // totalAdicional
                    System.out.println("----------------Total Adicional-------------------");
                    System.out.println(alojamiento.totalAdicional());
                    System.out.println("--------------------------------------------------");
                    break;
                case 5: // totalBonoDescuento
                    System.out.println("-------------Total Bono Descuento-----------------");
                    System.out.println(alojamiento.totalBonoDescuento());
                    System.out.println("--------------------------------------------------");
                    break;
                case 6: // Cantididad de alojamientos
                    System.out.println("----------Cantididad de alojamientos--------------");
                    System.out.println(alojamiento.cantidadMediosAlojamientos());
                    System.out.println("--------------------------------------------------");
                    break;
                case 7: // Valor a cancelar
                    String rutParaCancelar = piderut();
                    System.out.println("----------------Valor a cancelar------------------");
                    System.out.println(alojamiento.valorACancelarCliente(rutParaCancelar));
                    System.out.println("--------------------------------------------------");
                    break;
                case 8: // Aplicar incremento
                    String rutParaIncremento = piderut();
                    System.out.println("-----------Aplicar incremento (Cabaña)------------");
                    System.out.println(alojamiento.incrementoValorBase(rutParaIncremento));
                    System.out.println("--------------------------------------------------");
                    break;
            }

        }while(opcion!=9);


    }

    public static String piderut(){
        System.out.println("Favor ingrese RUT del cliente: ");
        return Leer.dato();
    }

    public static int menu(){
        System.out.println("\n ----------- Sistema de Alojamiento ----------- ");
        System.out.println("1)\tIngresar Medio de Alojamiento (Carpa/Hotel/Cabaña); solo se puede asociar un cliente por medio de alojamiento ");
        System.out.println("2)\tMostrar medios de alojamiento (muestra los datos de los alojamientos reservados)");
        System.out.println("3)\tDatos del Cliente  (si existe, muestra donde está alojado y todos los datos asociados)");
        System.out.println("4)\tTotal adicional (de todos los huespedes del hotel si son fumadores y con desayuno)");
        System.out.println("5)\tTotal bono descuento (solo para temporada baja (25%) o media (12.5%))");
        System.out.println("6)\tCantidad medios de alojamiento");
        System.out.println("7)\tValor a cancelar (por cliente)");
        System.out.println("8)\tAplicar incremento del valor base (solo para Cabaña y si supera la capacidad de 5)");
        System.out.println("9)\tSalir");
        System.out.println("--------------------------------------------------");
        System.out.println("Favor ingrese una opcion para continuar.");
        System.out.println("--------------------------------------------------");
        return Leer.datoInt();
    }
}
