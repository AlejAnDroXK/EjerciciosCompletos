package EjerciciosCompletos.gestorProveedores.negocio;

import java.util.ArrayList;
import java.util.List;

public class ClienteEmpresa {
    private String nombre;
    private List<Proveedor> proveedores;

    // CONSTRUCTOR
    public ClienteEmpresa(String nombre) {
        this.nombre = nombre;
        proveedores = new ArrayList<>();
    }

    public String getNombre() {return nombre;}
    public List<Proveedor> getProveedores() {return proveedores;}

    public void contratarProveedor(Proveedor proveedor) {
        proveedores.add(proveedor);
    }

    public boolean tieneProveedorTipo(String tipo) {
        for (Proveedor p : proveedores) {
            if (p.getTipoProveedor().equalsIgnoreCase(tipo)) {
                return true;
            }
        }
        return false;
    }

    public String listarContratosActivos() {
        StringBuilder sb = new StringBuilder();

        for (Proveedor p : proveedores) {
            for (Contrato c : p.getContratos()) {
                if (c.estaActivo()) {
                    sb.append("Cliente: ").append(nombre).append("\n");
                    sb.append("Proveedor: ").append(p.getNombre()).append("\n");
                    sb.append("Tipo: ").append(p.getTipoProveedor()).append("\n");
                    sb.append("Precio: ").append(c.getPrecio()).append("\n");
                    sb.append("Duración: ").append(c.getDuracionMeses()).append(" meses\n");
                    sb.append("-----------------------------\n");
                }
            }
        }
        return sb.toString();
    }
}
