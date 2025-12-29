package EjerciciosCompletos.gestorProveedores.negocio;

public class Contrato {
    private double precio;
    private int duracionMeses;

    public Contrato(double precio, int duracionMeses) {
        this.precio = precio;
        this.duracionMeses = duracionMeses;
    }

    public double getPrecio() {return precio;}
    public int getDuracionMeses() {return duracionMeses;}

    public boolean estaActivo() {
        return duracionMeses > 0;
    }
}
