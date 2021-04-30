package mx.edu.itl.c17130848.u3elbolaapp;

public class MiSingleton {
    private static MiSingleton instancia = null;

    //Declarar las variables que seran compartidas por el Singleton
    private String usuario;
    private String contrasena;
    private int codigoLogin;

    private MiSingleton () {
        //Iniciarlizaciones de los datos compartidos
        usuario = "";
        contrasena = "";
    }

    public static MiSingleton getInstancia () {
        if ( instancia == null) {
            instancia = new MiSingleton();
        }
        return instancia;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getCodigoLogin() {
        return codigoLogin;
    }

    public void setCodigoLogin(int codigoLogin) {
        this.codigoLogin = codigoLogin;
    }
}
