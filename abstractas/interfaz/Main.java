package EjerciciosCompletos.abstractas.interfaz;

import EjerciciosCompletos.abstractas.negocio.Empleado;
import EjerciciosCompletos.abstractas.negocio.MetodoAutenticacion;
import EjerciciosCompletos.abstractas.utilitario.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Util u = new Util();
        Scanner sc = new Scanner(System.in);
        String cedula, nombre, patronhuella,token,patronRostro;
        int opc=0,nivelseguridad;
        do {
            u.menu();
            opc = Integer.parseInt(sc.nextLine());
            switch (opc){
                case 1: {//Agregar Empleado
                    System.out.println("-----------------");
                    System.out.println("Ingrese cedula: ");
                    cedula= sc.nextLine();
                    System.out.println("Ingrese su nombre: ");
                    nombre = sc.nextLine();
                    u.agregarEmpleado(cedula, nombre);
                    pausa();
                }break;
                case 2: {//Agregar token seguridad
                    System.out.println("-----------------");
                    System.out.println("Ingrese su cedula: ");
                    cedula= sc.nextLine();
                    if(u.buscarEmpleado(cedula) != -1){
                        System.out.println("Ingrese token: ");
                        token= sc.nextLine();
                        System.out.println("Ingrese nivel de seguridad: ");
                        nivelseguridad=Integer.parseInt(sc.nextLine());
                        u.agregarAutenticacionToken(cedula,token,nivelseguridad);
                    }else {
                        System.out.println("Empleado No Existe");
                    }
                    pausa();
                }break;
                case 3:{//Agregar reconocimiento facial
                    System.out.println("-----------------");
                    System.out.println("Ingrese su cedula: ");
                    cedula= sc.nextLine();
                    if(u.buscarEmpleado(cedula) != -1){
                        System.out.println("Ingrese rostro: ");
                        patronRostro= sc.nextLine();
                        System.out.println("Ingrese nivel de seguridad: ");
                        nivelseguridad=Integer.parseInt(sc.nextLine());
                        u.agregarAutenticacionRostro(cedula,patronRostro,nivelseguridad);
                    }else {
                        System.out.println("Empleado No Existe");
                    }
                    pausa();
                }break;
                case 4:{//Agregar huella digital
                    System.out.println("-----------------");
                    System.out.println("Ingrese su cedula: ");
                    cedula= sc.nextLine();
                    if(u.buscarEmpleado(cedula) != -1){
                        System.out.println("Ingrese huella: ");
                        patronhuella= sc.nextLine();
                        System.out.println("Ingrese nivel de seguridad: ");
                        nivelseguridad=Integer.parseInt(sc.nextLine());
                        u.agregarAutenticacionHuella(cedula,patronhuella,nivelseguridad);
                    }else {
                        System.out.println("Empleado No Existe");
                    }
                    pausa();
                }break;
                case 5: {//Mostrar datos de empleados (todos
                    System.out.println("-----------------");
                    u.listarEmpleados();
                    pausa();
                }break;
                case 6: {//Buscar empleado y mostrar datos
                    System.out.println("-----------------");
                    System.out.println("Ingrese cedula del empleado: ");
                    cedula = sc.nextLine();
                    if (u.buscarEmpleado(cedula) != -1) {
                        Empleado e = u.getEmpleado(cedula);
                        System.out.println("Empleado encontrado:");
                        System.out.println("Nombre: " + e.getNombre());
                        System.out.println("Cédula: " + e.getCedula());
                        System.out.println("Métodos de autenticación: ");
                        for (MetodoAutenticacion ma : e.getAutenticaciones()) {
                            System.out.println(ma);
                        }
                    } else {
                        System.out.println("Empleado no encontrado");
                    }
                    pausa();
                }break;
                case 7: {//Total métodos autenticación empleado
                    System.out.println("-----------------");
                    System.out.println("Ingrese cedula del empleado: ");
                    cedula = sc.nextLine();
                    if (u.buscarEmpleado(cedula) != -1) {
                        Empleado e = u.getEmpleado(cedula);
                        System.out.println("Métodos de autenticación: " + e.getAutenticaciones().size());
                    } else {
                        System.out.println("Empleado no encontrado");
                    }
                    pausa();
                }break;
                case 8: {//Total métodos huella empleado
                    System.out.println("-----------------");
                    System.out.println("Ingrese cedula del empleado: ");
                    cedula = sc.nextLine();
                    if (u.buscarEmpleado(cedula) != -1) {
                        int cantidadHuella = u.cantidadAutenticacionHuella(cedula);
                        System.out.println("Cantidad de métodos de huella digital registrados: " + cantidadHuella);
                    } else {
                        System.out.println("Empleado no encontrado");
                    }
                    pausa();
                } break;
                case 9:{//Total métodos token empleado
                    System.out.println("-----------------");
                    System.out.println("Ingrese cedula del empleado: ");
                    cedula = sc.nextLine();
                    if (u.buscarEmpleado(cedula) != -1) {
                        int cantidadToken = u.cantidadAutenticacionToken(cedula);
                        System.out.println("Cantidad de métodos de token registrados: " + cantidadToken);
                    } else {
                        System.out.println("Empleado no encontrado");
                    }
                    pausa();
                }break;
                case 10:{//Total métodos facial empleado
                    System.out.println("-----------------");
                    System.out.println("Ingrese cedula del empleado: ");
                    cedula = sc.nextLine();
                    if (u.buscarEmpleado(cedula) != -1) {
                        int cantidadRostro = u.cantidadAutenticacionRostro(cedula);
                        System.out.println("Cantidad de métodos de reconocimiento facial registrados: " + cantidadRostro);
                    } else {
                        System.out.println("Empleado no encontrado");
                    }
                    pausa();
                }break;
                case 11:{//Métodos mayor a umbral de empleado
                    System.out.println("-----------------");
                    System.out.println("Ingrese cedula del empleado: ");
                    cedula = sc.nextLine();
                    System.out.println("Ingrese el umbral de seguridad: ");
                    int umbral = Integer.parseInt(sc.nextLine());
                    if (u.buscarEmpleado(cedula) != -1) {
                        String autenticaciones = u.autenticaciionMayorSeguridad(cedula, umbral);
                        System.out.println("Métodos de autenticación mayores al umbral de seguridad: ");
                        System.out.println(autenticaciones);
                    } else {
                        System.out.println("Empleado no encontrado");
                    }
                    pausa();
                }break;
                case 12:{//Autenticar empleado
                    System.out.println("-----------------");
                    System.out.println("Ingrese cedula del empleado: ");
                    cedula = sc.nextLine();
                    System.out.println("Ingrese el tipo de autenticación (huella, rostro, token): ");
                    String tipo = sc.nextLine();
                    System.out.println("Ingrese el dato a autenticar: ");
                    String dato = sc.nextLine();
                    String result = u.autenticarUtil(dato, tipo, cedula);
                    System.out.println(result);
                    pausa();
                }break;
                case 13: {
                    System.out.println("-----------------");
                    System.out.println("Saliendo del sistema...");
                    System.exit(0);
                } break;
                default: {
                    System.out.println("Opcion Invalida. Ingrese Nuevamente");
                }
            }
        } while (opc != 13);
    }

    public static void pausa() {
        System.out.println("__________Presione enter para continuar__________");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }
}
