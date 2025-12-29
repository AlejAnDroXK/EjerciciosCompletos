package EjerciciosCompletos.personas.interfaz;

import EjerciciosCompletos.personas.negocio.AlumnoMagister;
import EjerciciosCompletos.personas.negocio.AlumnoPregrado;
import EjerciciosCompletos.personas.negocio.Persona;
import EjerciciosCompletos.personas.negocio.ProfesorHora;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opc, horas;
        String nom,universidad,carrera,cedula,tesis,especialidad;
        List<Persona> perso = new ArrayList<Persona>();
        do{
            menu();
            opc = Integer.parseInt(sc.nextLine());
            switch (opc){
                case 1:{
                    System.out.println("---------------------LISTADO---------------------");
                    listarAlumnosPregrado(perso);
                    listarAlumnosMagister(perso);
                    listarProfes(perso);
                    pausa();
                }break;
                case 2:{
                    System.out.println("-----------------");
                    System.out.println("Ingrese el nombre");
                    nom=sc.nextLine();
                    System.out.println("Ingrese el cedula");
                    cedula=sc.nextLine();
                    if (existeCedula(perso, cedula)) {
                        System.out.println("La cédula ya existe");
                        pausa();
                        break;
                    }
                    System.out.println("Ingrese el universidad");
                    universidad=sc.nextLine();
                    System.out.println("Ingrese el carrera");
                    carrera=sc.nextLine();
                    perso.add(new AlumnoPregrado(nom,cedula,universidad,carrera));
                    pausa();
                }break;
                case 3:{
                    System.out.println("-----------------");
                    System.out.println("Ingrese el nombre");
                    nom=sc.nextLine();
                    System.out.println("Ingrese el cedula");
                    cedula=sc.nextLine();
                    if (existeCedula(perso, cedula)) {
                        System.out.println("La cédula ya existe");
                        pausa();
                        break;
                    }
                    System.out.println("Ingrese el universidad");
                    universidad=sc.nextLine();
                    System.out.println("Ingrese la tesis");
                    tesis=sc.nextLine();
                    perso.add(new AlumnoMagister(nom,cedula,universidad,tesis));
                    pausa();
                }break;
                case 4:{
                    System.out.println("-----------------");
                    System.out.println("Ingrese el nombre");
                    nom=sc.nextLine();
                    System.out.println("Ingrese el cedula");
                    cedula=sc.nextLine();
                    if (existeCedula(perso, cedula)) {
                        System.out.println("La cédula ya existe");
                        pausa();
                        break;
                    }
                    System.out.println("Ingrese la especialidad");
                    especialidad=sc.nextLine();
                    System.out.println("Ingrese las horas");
                    horas=Integer.parseInt(sc.nextLine());;
                    perso.add(new ProfesorHora(nom,cedula,especialidad,horas));
                    pausa();
                }break;
                case 5:{
                    System.out.println("-----------------");
                    listarAlumnosPregrado(perso);
                    pausa();
                }break;
                case 6:{
                    System.out.println("-----------------");
                    listarAlumnosMagister(perso);
                    pausa();
                }break;
                case 7:{
                    System.out.println("-----------------");
                    listarProfesores(perso);
                    pausa();
                }break;
                case 8:{
                    System.out.println("-----------------");
                    System.out.println("Saliendo del sistema...");
                    System.exit(0);
                }break;
                default:
                    System.out.println("No es una opcion valida");
            }
        }while(opc != 8);
    }
    public static void menu() {
        System.out.println("\n---------------------OPCION---------------------");
        System.out.println("1.- Mostrar listado");
        System.out.println("2.- Ingresar Alumno pregrado");
        System.out.println("3.- Ingresar Alumno magister");
        System.out.println("4.- Ingresar Profesor hora");
        System.out.println("5.- Listar Alumnos Pregrado");
        System.out.println("6.- Listar Alumnos Magister");
        System.out.println("7.- Listar Profesores (Cedula, Horas, Sueldo) ");
        System.out.println("8.- SALIR");
        System.out.println("---------------------INGRESE UNA OPCION---------------------\n");
    }

    public static void listarAlumnosPregrado(List<Persona> perso){
        System.out.println("----- ALUMNOS DE PREGRADO -----");

        for(Persona p : perso){
            if (p instanceof AlumnoPregrado){
                System.out.println("-"+p);
            }
        }
    }

    public static void listarAlumnosMagister(List<Persona> perso){
        System.out.println("----- ALUMNOS DE MAGISTER -----");

        for(Persona p : perso){
            if (p instanceof AlumnoMagister){
                System.out.println("-"+p);
            }
        }
    }

    public static void listarProfes(List<Persona> perso){
        System.out.println("----- PROFESORES -----");

        for(Persona p : perso){
            if (p instanceof ProfesorHora){
                System.out.println("-"+p);
            }
        }
    }

    public static void listarProfesores(List<Persona> perso){
        System.out.println("----- PROFESORES SUELDO -----");
        for(Persona p: perso){
            if (p instanceof ProfesorHora){
                ProfesorHora ph= (ProfesorHora) p;
                System.out.println("Nombre: "+ph.getNombre()+
                        "\n     Cedula: "+ph.getCedula()+
                        "\n     Horas: "+ph.getHoras()+
                        "\n     Sueldo: "+ph.getHoras()*20);
            }
        }
    }
    public static void pausa() {
        System.out.println("__________Presione enter para continuar__________");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

    public static boolean existeCedula(List<Persona> perso, String cedula) {
        for (Persona p : perso) {
            if (p.getCedula().equals(cedula)) {
                return true;
            }
        }
        return false;
    }
}