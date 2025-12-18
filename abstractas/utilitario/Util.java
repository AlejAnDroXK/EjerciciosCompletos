package EjerciciosCompletos.abstractas.utilitario;

import EjerciciosCompletos.abstractas.negocio.*;

import java.util.ArrayList;
import java.util.List;

public class Util {
    private List<Empleado> empleados;
    public Util(){
        empleados= new ArrayList<>();
    }
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void agregarEmpleado(String cedula, String nombre){
        int indice=buscarEmpleado(cedula);
        if(indice==-1){
            empleados.add(new Empleado(cedula,nombre));
        }else{
            System.out.println("Empleado ya existe");
        }
    }

    public int buscarEmpleado(String cedula){
        for(int i=0; i <empleados.size();i++){
            if(empleados.get(i).getCedula().equals(cedula)){
                return i;
            }
        }
        return -1;
    }

    public Empleado getEmpleado(String cedula) {
        int indice = buscarEmpleado(cedula);
        if (indice != -1) {
            return empleados.get(indice);
        } else {
            return null;
        }
    }

    public void agregarAutenticacionRostro(String cedula, String patronRostro, int nivelSeguridad){
        int indice =buscarEmpleado(cedula);
        if(indice != -1){
            if(cantidadAutenticacionRostro(cedula)==0){
                empleados.get(indice).adicionarAutenticacion(new ReconocimientoFacial(nivelSeguridad,patronRostro));
            }else{
                System.out.println("Ya tiene un rostro");
            }
        }else{
            System.out.println("Empleado no existe");
        }
    }
    public void agregarAutenticacionToken(String cedula, String token, int nivelSeguridad) {
        int indice = buscarEmpleado(cedula);
        if (indice != -1) {
            empleados.get(indice).adicionarAutenticacion(new TokenSeguridad(nivelSeguridad,token));
        } else {
            System.out.println("Empleado no existe");
        }
    }
    public void agregarAutenticacionHuella(String cedula, String huella, int nivelSeguridad){
        int indice =buscarEmpleado(cedula);
        if(indice != -1){
            empleados.get(indice).adicionarAutenticacion(new HuellaDigital(nivelSeguridad,huella));
        }else{
            System.out.println("Empleado no existe");
        }
    }

    public int cantidadAutenticacionHuella(String cedula){
        int indice =buscarEmpleado(cedula);
        if(indice != -1){
            return empleados.get(indice).cantidadRegistroHuella();
        }else{
            System.out.println("Empleado no existe");
            return -1;
        }
    }
    public int cantidadAutenticacionRostro(String cedula){
        int indice =buscarEmpleado(cedula);
        if(indice != -1){
            return empleados.get(indice).cantidadRegistroRostro();
        }else{
            System.out.println("Empleado no existe");
            return -1;
        }
    }
    public int cantidadAutenticacionToken(String cedula){
        int indice =buscarEmpleado(cedula);
        if(indice != -1){
            return empleados.get(indice).cantidadRegistroToken();
        }else{
            System.out.println("Empleado no existe");
            return -1;
        }
    }

    public String autenticaciionMayorSeguridad(String cedula, int nivel){
        int indice =buscarEmpleado(cedula);
        if(indice != -1){
            return empleados.get(indice).seguridadMayorUmbral(nivel);
        }else{
            System.out.println("Empleado no existe");
            return null;
        }
    }
    public String autenticarUtil (String dato,String tipo,String cedula){
        int indice=buscarEmpleado(cedula);
        if(indice!=-1){
            Empleado empleado = empleados.get(indice);
            boolean autenticado = empleado.autenticar(dato, tipo);
            if (autenticado) {
                return "Acceso concedido";
            } else {
                return "Acceso denegado";
            }
        } else {
            return "Empleado no encontrado";
        }
    }
    public void listarEmpleados() {
        System.out.println("----- EMPLEADOS -----");
        for (Empleado e : empleados) {
            System.out.println("Nombre: " + e.getNombre() + ", Cédula: " + e.getCedula());
        }
    }

    public void menu(){
        System.out.println("----- MENU -----");
        System.out.println("1. Agregar Empleado");
        System.out.println("2. Agregar token seguridad");
        System.out.println("3. Agregar reconocimiento facial");
        System.out.println("4. Agregar huella digital");
        System.out.println("5. Mostrar datos de empleados (todos)");
        System.out.println("6. Buscar empleado y mostrar datos");
        System.out.println("7. Total métodos autenticación empleado");
        System.out.println("8. Total métodos huella empleado");
        System.out.println("9. Total métodos token empleado");
        System.out.println("10. Total métodos facial empleado");
        System.out.println("11. Métodos mayor a umbral de empleado");
        System.out.println("12. Autenticar empleado");
        System.out.println("13. Salir");
        System.out.println("----------------");
    }
}
