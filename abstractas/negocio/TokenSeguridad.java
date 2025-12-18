package EjerciciosCompletos.abstractas.negocio;

public class TokenSeguridad extends MetodoAutenticacion{
    private String token;

    public TokenSeguridad(int nivelseguridad, String token) {
        super(nivelseguridad, "token");
        this.token = token;
    }

    public void setToken(String token) {this.token = token;}

    @Override
    public String toString(){
        return super.toString()+", Patrón token: "+token;
    }
    @Override
    public boolean autenticar(String dato){
        if (token.equals(dato))
            return true;
        return false;
    }
}
