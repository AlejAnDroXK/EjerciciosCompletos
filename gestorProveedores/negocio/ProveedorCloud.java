package EjerciciosCompletos.gestorProveedores.negocio;

public class ProveedorCloud extends Proveedor {

    public ProveedorCloud(String nombre, String pais) {
        super(nombre, pais);
    }

    @Override
    public String getTipoProveedor() {
        return "Cloud";
    }
}
