package EjerciciosCompletos.gestorProveedores.negocio;

import java.util.ArrayList;
import java.util.List;

public abstract class Proveedor {

    protected String nombre;
    protected String pais;

    // COMPOSICIÓN:
    // Un Proveedor "posee" contratos.
    // Los contratos NO pueden existir sin un proveedor,
    // por eso se crean y se gestionan desde aquí.
    protected List<Contrato> contratos;

    // CONSTRUCTOR
    public Proveedor(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
        contratos = new ArrayList<>();
    }

    public String getNombre() {return nombre;}
    public String getPais() {return pais;}
    public List<Contrato> getContratos() {return contratos;}

    public void agregarContrato(Contrato contrato) {
        contratos.add(contrato);
    }

    public abstract String getTipoProveedor();
}
