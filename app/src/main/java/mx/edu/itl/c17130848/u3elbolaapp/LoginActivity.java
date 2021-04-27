package mx.edu.itl.c17130848.u3elbolaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUsuario;
    private EditText edtContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Asignamos las referencias a los EditText en la IU
        edtUsuario = findViewById( R.id.edtUsario );
        edtContrasena = findViewById( R.id.edtContrasena );
    }

    public void btnEntrarClick( View v ){
        String usuario = edtUsuario.getText().toString();
        String contrasena = edtContrasena.getText().toString();

        if( usuario.equals("admin") && contrasena.equals("android") ) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            if (!usuario.equals("admin")) {
                edtUsuario.setError( "Usuario incorrecto" );
            } else {
                edtContrasena.setError( "Contraseña incorrecta" );
            }
        }
    }

    public void btnUsuarioClick( View v ){
        Intent intent = new Intent( this, LeerDatoActivity.class );
        //Establecemos el dato que se trasnpasara al segundo activity
        intent.putExtra( "usuario", edtUsuario.getText().toString() );
        startActivity( intent );
    }

    public void btnContrasenaClick( View v ){
        Intent intent = new Intent( this, LeerDatoActivity.class );
        //Establecemos el dato que se trasnpasara al segundo activity
        intent.putExtra( "contrasena", edtContrasena.getText().toString() );
        startActivity( intent );
    }
}