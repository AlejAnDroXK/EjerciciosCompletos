package EjerciciosCompletos.vehiculoss.interfaz;

import EjerciciosCompletos.vehiculoss.negocio.Propietario;
import EjerciciosCompletos.vehiculoss.negocio.Vehiculo;
import EjerciciosCompletos.vehiculoss.util.Utilitario;

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
                case 1: {//Agregar Propietario
                    System.out.println("-----------------");
                    System.out.println("Ingrese cedula: ");
                    cedula= sc.nextLine();
                    System.out.println("Ingrese su nombre: ");
                    nombre = sc.nextLine();
                    System.out.println("Ingrese su telefono: ");
                    telefono= sc.nextLine();

                    u.agregarPropietario(cedula, nombre, telefono);
                    pausa();
                }break;
                case 2: {//Asignar Propietario a Auto
                    System.out.println("-----------------");
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
                    pausa();
                }break;
                case 3:{//Asignar Propietario a Moto
                    System.out.println("-----------------");
                    System.out.println("Ingrese su cedula: ");
                    cedula= sc.nextLine();
                    Propietario p= u.buscarPropietario(cedula);
                    u.buscarPropietario(cedula);
                    if(p!=null){
                        System.out.println("Ingrese marca: ");
                        marca= sc.nextLine();
                        System.out.println("Ingrese modelo: ");
                        modelo= sc.nextLine();
                        System.out.println("Ingrese año: ");
                        anio = Integer.parseInt(sc.nextLine());
                        System.out.println("Ingrese altura: ");
                        altura= Double.parseDouble(sc.nextLine());
                        System.out.println("Ingrese arranque: ");
                        arranque=sc.nextLine();

                        u.agregarMoto(marca,modelo,anio,p,altura,arranque);
                    }else {
                        System.out.println("Propietario No Existe");
                    }
                    pausa();
                }break;
                case 4:{//Buscar Vehiculos por Marca
                    System.out.println("-----------------");
                    System.out.println("Ingrese la marca de vehiculos que quiere buscar: ");
                    marca=sc.nextLine();
                    List<Vehiculo> lista= u.buscarVehiculoMarca(marca);
                    if (lista.isEmpty()) {
                        System.out.println("No se encontraron vehiculos de esa marca.");
                    } else {
                        System.out.println("\n--------------------------------\n");
                        for (Vehiculo v : lista) {
                            System.out.println(v);
                            System.out.println("--------------------------------");
                        }
                    }
                    pausa();
                }break;
                case 5: {//Listar Vehiculos
                    System.out.println("-----------------");
                    System.out.println(u.listarVehiculos());
                    pausa();
                }break;
                case 6: {//Listar Propietarios
                    System.out.println("-----------------");
                    System.out.println(u.listaPropietarios());
                    pausa();
                }break;
                case 7: {//Listar Automoviles
                    System.out.println("-----------------");
                    System.out.println(u.listarAutomoviles());
                    pausa();
                }break;
                case 8: {//Listar Motos
                    System.out.println("-----------------");
                    System.out.println(u.listarMoto());
                    pausa();
                }break;
                case 9: {//Mostrar Motos por Marca
                    System.out.println("-----------------");
                    System.out.print("Ingrese la marca de moto a buscar: ");
                    marca = sc.nextLine();
                    System.out.println(u.buscarMotoMarca(marca));
                    pausa();
                } break;
                case 10:{//Matricular
                    System.out.println("-----------------");
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
                        System.out.println("Si estan bien los datos esta mattriculado ya, si estan mal vuelva a ingresar los datos");
                    }
                    pausa();
                }break;
                case 11: {//salir
                    System.out.println("-----------------");
                    System.out.println("Saliendo del sistema...");
                    System.exit(0);
                } break;
                default: {
                    System.out.println("Opcion Invalida. Ingrese Nuevamente");
                }
            }
        } while (opc != 11);
    }
    public static void pausa() {
        System.out.println("__________Presione enter para continuar__________");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }
}
