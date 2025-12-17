package EjerciciosCompletos.abstractas.negocio;
//siempre metodo agregar y algo para cpnsultar la lista
import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private String cedula;
    private String nombre;
    private List<MetodoAutenticacion> autenticaciones;

    public Empleado(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
        autenticaciones = new ArrayList<>();
    }

    public List<MetodoAutenticacion> getAutenticaciones() {return autenticaciones;}
    public String getCedula() {return cedula;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public void adicionarAutenticacion(MetodoAutenticacion me){
        autenticaciones.add(me);
    }

    public int cantidadRegistroHuella(){
        int cont=0;
        for(MetodoAutenticacion me: autenticaciones){
            if (me instanceof HuellaDigital){
                cont++;
            }
        }
        return cont;
    }
    public int cantidadRegistroRostro(){
        int cont=0;
        for(MetodoAutenticacion me: autenticaciones){
            if (me instanceof ReconocimientoFacial){
                cont++;
            }
        }
        return cont;
    }
    public int cantidadRegistroToken(){
        int cont=0;
        for(MetodoAutenticacion me: autenticaciones){
            if (me instanceof TokenSeguridad){
                cont++;
            }
        }
        return cont;
    }

    public boolean autenticar (String dato, String tipo){
        for(MetodoAutenticacion me: autenticaciones){
            if(me.getTipo().equalsIgnoreCase(tipo)){
                if(me.autenticar(dato))
                    return true;
            }
        }
        return false;
    }

    public String seguridadMayorUmbral(int valor){
        String seguridad="";
        for(MetodoAutenticacion me: autenticaciones){
            if(me.getNivelseguridad() >= valor){
                seguridad += me.getTipo();
                seguridad += "\n";
            }
        }
        return seguridad;
    }
}
