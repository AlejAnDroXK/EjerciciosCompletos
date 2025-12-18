package EjerciciosCompletos.abstractas.negocio;

public class HuellaDigital extends MetodoAutenticacion{
    private  String patronHuella;

    public HuellaDigital(int nivelseguridad, String patronHuella) {
        super(nivelseguridad, "huella");
        this.patronHuella = patronHuella;
    }

    public String getPatronHuella() {return patronHuella;}
    public void setPatronHuella(String patronHuella) {this.patronHuella = patronHuella;}

    @Override
    public String toString(){
        return super.toString()+", Patrón huella: " + patronHuella;
    }
    @Override
    public boolean autenticar(String dato){
        if (patronHuella.contains(dato))
            return true;
        return false;
    }

}
