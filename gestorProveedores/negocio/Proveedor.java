package EjerciciosCompletos.gestorProveedores.negocio;

import java.util.ArrayList;
import java.util.List;

public abstract class Proveedor {

    protected String nombre;
    protected String pais;

    protected List<Contrato> contratos;

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
