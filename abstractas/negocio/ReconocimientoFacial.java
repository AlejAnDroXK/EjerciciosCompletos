package EjerciciosCompletos.abstractas.negocio;

public class ReconocimientoFacial extends MetodoAutenticacion{
    private String patronRostro;

    public ReconocimientoFacial(int nivelseguridad, String patronRostro) {
        super(nivelseguridad, "rostro");
        this.patronRostro = patronRostro;
    }

    public String getPatronRostro() {return patronRostro;}
    public void setPatronRostro(String patronRostro) {this.patronRostro = patronRostro;}

    @Override
    public String toString(){
        return super.toString()+", Patrón rostro: " + patronRostro;
    }
    @Override
    public boolean autenticar(String dato){
        if (patronRostro.contains(dato))
            return true;
        return false;
    }
}
