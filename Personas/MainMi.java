package EjerciciosCompletos.Personas;

import java.sql.SQLOutput;
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

                }break;
                case 2:{
                    System.out.println("Ingrese el nombre");
                    nom=sc.nextLine();
                    System.out.println("Ingrese el cedula");
                    cedula=sc.nextLine();
                    System.out.println("Ingrese el universidad");
                    universidad=sc.nextLine();
                    System.out.println("Ingrese el carrera");
                    carrera=sc.nextLine();
                    perso.add(new AlumnoPregrado(nom,cedula,universidad,carrera));
                }break;
                case 3:{
                    System.out.println("Ingrese el nombre");
                    nom=sc.nextLine();
                    System.out.println("Ingrese el cedula");
                    cedula=sc.nextLine();
                    System.out.println("Ingrese el universidad");
                    universidad=sc.nextLine();
                    System.out.println("Ingrese la tesis");
                    tesis=sc.nextLine();
                    perso.add(new AlumnoMagister(nom,cedula,universidad,tesis));
                }break;
                case 4:{
                    System.out.println("Ingrese el nombre");
                    nom=sc.nextLine();
                    System.out.println("Ingrese el cedula");
                    cedula=sc.nextLine();
                    System.out.println("Ingrese la especialidad");
                    especialidad=sc.nextLine();
                    System.out.println("Ingrese las horas");
                    horas=Integer.parseInt(sc.nextLine());;
                    perso.add(new ProfesorHora(nom,cedula,especialidad,horas));
                }break;
                case 5:{
                    listarAlumnosPregrado(perso);
                }break;
                case 6:{
                    listarAlumnosMagister(perso);
                }
                case 7:{
                    listarProfesores(perso);
                }
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
        System.out.println("7.- Listar Profesores");
        System.out.println("7.- SALIR");
        System.out.println("---------------------INGRESE UNA OPCION---------------------\n :");
    }

    public static void listarAlumnosPregrado(List<Persona> perso){
        System.out.println("----- ALUMNOS DE PREGRADO -----");

        for(Persona p : perso){
            if (p instanceof AlumnoPregrado){
                System.out.println(p);
            }
        }
    }

    public static void listarAlumnosMagister(List<Persona> perso){
        System.out.println("----- ALUMNOS DE MAGISTER -----");

        for(Persona p : perso){
            if (p instanceof AlumnoMagister){
                System.out.println(p);
            }
        }
    }

    public static void listarProfesores(List<Persona> perso){
        System.out.println("----- Profesores Hora -----");

        for(Persona p: perso){
            if (p instanceof ProfesorHora){
                ProfesorHora ph= (ProfesorHora) p;
                System.out.println("Cedula: "+ph.getCedula()+"\nHoras: "+ph.getHoras()+"\nSueldo: "+ph.getHoras()*20);
            }
        }
    }

}