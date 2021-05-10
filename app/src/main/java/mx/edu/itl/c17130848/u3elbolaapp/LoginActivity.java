/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                  Activity para la autenticación de la app
:*
:*  Archivo     : LoginActivity.java
:*  Autor       : Angel Eduardo Soto García    17130848
:*  Fecha       : 20/May/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase para la verificación y autenticación de la aplicacion con el usuario: admin
:*                y contraseña: android
:*  Ultima modif:
:*  Fecha       Modifición             Motivo
:*==========================================================================================
:*------------------------------------------------------------------------------------------*/
package mx.edu.itl.c17130848.u3elbolaapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    public static final int CODIGO_USUARIO = 10;
    public static final int CODIGO_CONTRASENA = 20;

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

    //----------------------------------------------------------------------------------------------

    public void btnEntrarClick( View v ){
        String usuario = edtUsuario.getText().toString();
        String contrasena = edtContrasena.getText().toString();

        if( usuario.equals( "admin" ) && contrasena.equals( "android" ) ) {
            Intent intent = new Intent(this, MainActivity.class );
            startActivity(intent);
        } else {
            if (!usuario.equals( "admin" )) {
                edtUsuario.setError( "Usuario incorrecto" );
            } else {
                edtContrasena.setError( "Contraseña incorrecta" );
            }
        }
    }

    //----------------------------------------------------------------------------------------------

    public void btnUsuarioClick( View v ){
        Intent intent = new Intent( this, LeerDatoActivity.class );
        //Establecemos el dato que se trasnpasara al segundo activity
        intent.putExtra( "usuario", edtUsuario.getText().toString() );
        startActivityForResult( intent, CODIGO_USUARIO );
    }

    //----------------------------------------------------------------------------------------------

    public void btnContrasenaClick( View v ){
        Intent intent = new Intent( this, LeerDatoActivity.class );
        //Establecemos el dato que se trasnpasara al segundo activity
        intent.putExtra( "contrasena", edtContrasena.getText().toString() );
        startActivityForResult( intent, CODIGO_CONTRASENA );
    }

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onActivityResult( int requestCode, int resultCode, @Nullable Intent data ) {
        super.onActivityResult( requestCode, resultCode, data );
        // Verificar el estado del resultado devuelto por LeerDataActivity
        if( resultCode == RESULT_OK ){
            if ( requestCode == CODIGO_USUARIO ) {
                edtUsuario.setText( data.getStringExtra( "data_nuevo" ) );
            } else if ( requestCode == CODIGO_CONTRASENA ) {
                edtContrasena.setText( data.getStringExtra("data_nuevo" ) );
            }
        } else if ( resultCode == RESULT_CANCELED ) {
            // Hacer algo si se cancelo la captura del dato nuevo
        }
    }

    //----------------------------------------------------------------------------------------------

    public void btnAcercaDeClick( View v ){
        Intent intent = new Intent(this, AcercaDeActivity.class);
        startActivity(intent);
    }

    //----------------------------------------------------------------------------------------------
}