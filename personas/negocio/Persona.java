package EjerciciosCompletos.personas.negocio;

public class Persona {
    private String nombre, cedula;

    public Persona(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    @Override
    public String toString() {
        return  "Nombre=" + nombre + ", Cedula=" + cedula;
    }
}
