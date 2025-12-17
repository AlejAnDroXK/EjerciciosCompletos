package EjerciciosCompletos.Vehiculos.interfaz;

import EjerciciosCompletos.Vehiculos.negocio.Propietario;
import EjerciciosCompletos.Vehiculos.negocio.Vehiculo;
import EjerciciosCompletos.Vehiculos.util.Utilitario;

import java.util.List;
import java.util.Scanner;

public class MainSistemaVehiculos {
    public static void main(String[] args) {
        Utilitario u = new Utilitario();
        Scanner sc = new Scanner(System.in);
        String marca, modelo;
        int anio;
        String traccion;
        String tipo;

        //Propietario
        String cedula, nombre, telefono;

        //Moto
        double altura;
        String arranque;

        int opc=0;

        do {
            u.menu();
            opc = Integer.parseInt(sc.nextLine());
            switch (opc){
                case 1: {
                    System.out.println("Ingrese cedula: ");
                    cedula= sc.nextLine();
                    System.out.println("Ingrese su nombre: ");
                    nombre = sc.nextLine();
                    System.out.println("Ingrese su telefono: ");
                    telefono= sc.nextLine();

                    u.agregarPropietario(cedula, nombre, telefono);
                }break;
                case 2: {
                    System.out.println("Ingrese su cedula: ");
                    cedula= sc.nextLine();
                    Propietario p = u.burscarPropietario(cedula);
                    if(p != null){
                        System.out.println("Ingrese marca: ");
                        marca= sc.nextLine();
                        System.out.println("Ingree modelo: ");
                        modelo=sc.nextLine();
                        System.out.println("Ingrese Tipo: ");
                        tipo=sc.nextLine();
                        System.out.println("Ingrese traccion: ");
                        traccion=sc.nextLine();
                        System.out.println("Ingrese anio: ");
                        anio= Integer.parseInt(sc.nextLine());

                        u.agregarAuto(marca,modelo,anio,p,traccion,tipo);
                    }else {
                        System.out.println("Propietario No Existe");
                    }

                }break;
                case 3:{
                    System.out.println("Escriba la cedula del propietario al que le va a asignar un auto: ");
                    cedula= sc.nextLine();
                    Propietario p= u.buscarPropietario(cedula);
                    u.buscarPropietario(cedula);
                    if(p!=null){
                        System.out.println("Ingrese marca: ");
                        marca= sc.nextLine();
                        System.out.println("Ingrese modelo: ");
                        modelo= sc.nextLine();
                        System.out.println("Ingrese año: ");
                        anio=sc.nextInt();
                        System.out.println("Ingrese altura: ");
                        altura= sc.nextDouble();
                        System.out.println("Ingrese arranque: ");
                        arranque=sc.nextLine();

                        u.agregarMoto(marca,modelo,anio,p,altura,arranque);
                    }else {
                        System.out.println("Ya esta asignado");
                    }
                }break;
                case 4:{
                    System.out.println("Ingrese la marca de vehiculos que quiere buscar: ");
                    marca=sc.nextLine();
                    List<Vehiculo> lista= u.buscarVehiciuloMarca(marca);
                    System.out.println(lista);
                }break;
                case 5: {
                    System.out.println(u.listarVehiculos());
                }break;
                case 6: {
                    System.out.println(u.listaPropietarios());
                }break;
                case 7: {
                    System.out.println(u.listarAutomoviles());
                }break;
                case 8: {
                    System.out.print("Ingrese la marca de moto a buscar: ");
                    marca = sc.nextLine();
                    System.out.println(u.listarNombreAnioArranqueMotoXMarca(marca));
                } break;
                case 9:{
                    System.out.println("Escriba la cedula: ");
                    cedula= sc.nextLine();
                    System.out.println("Marca: ");
                    marca= sc.nextLine();
                    System.out.println("Año: ");
                    anio= Integer.parseInt(sc.nextLine());

                    int valor= u.matricular(cedula,marca,anio);
                    if (valor!=-1){
                        System.out.println("Valor "+valor+"\nMatriculado");
                    }else{
                        System.out.println("Se ha producido un error");
                    }
                }break;
                case 10: {
                    System.out.println("Saliendo del sistema...");
                    System.exit(0);
                } break;
                default: {
                    System.out.println("Opcion Invalida. Ingrese Nuevamente");
                }
            }
        } while (opc != 10);
    }
}
