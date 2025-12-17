package EjerciciosCompletos.abstractas.negocio;

public abstract class MetodoAutenticacion {
    private int nivelseguridad;
    private String tipo;

    public MetodoAutenticacion(int nivelseguridad, String tipo) {
        this.nivelseguridad = nivelseguridad;
        this.tipo = tipo;
    }

    public int getNivelseguridad() {return nivelseguridad;}
    public String getTipo() {return tipo;}
    public void setNivelseguridad(int nivelseguridad) {this.nivelseguridad = nivelseguridad;}
    public void setTipo(String tipo) {this.tipo = tipo;}

    @Override
    public String toString() {
        return "Tipo: "+ tipo + "\nNivel de seguridad=" + nivelseguridad;
    }


    public abstract boolean autenticar(String dato);
}
