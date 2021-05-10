/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                  Activity que recive y manda informacion de otro Activity
:*
:*  Archivo     : LeerDatoActivity.java
:*  Autor       : Angel Eduardo Soto García    17130848
:*  Fecha       : 20/May/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase que recive el usuario y/o contraseña del MainActivity
:*                para modificarlo y enviar el nuevo dato
:*  Ultima modif:
:*  Fecha       Modifición             Motivo
:*==========================================================================================
:*------------------------------------------------------------------------------------------*/
package mx.edu.itl.c17130848.u3elbolaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
public class LeerDatoActivity extends AppCompatActivity {

    private EditText edtDato;
    private String llave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leer_dato);

        // Obtener la referencia del EditText en la IU para el dato
        edtDato = findViewById( R.id.edtDato );

        // Recuperamos el valor del argumento que viene desde LoginActivity
        Intent i = getIntent();
        String dato = i.getStringExtra( "usuario" );
        if ( dato != null) {
            edtDato.setText( dato );
            llave = "usuario";
        } else {
            dato = i.getStringExtra("contrasena");
            edtDato.setText( dato );
            llave = "contrasena";
        }
    }

    //----------------------------------------------------------------------------------------------

    public void btnAceptarClick( View v ){
        // Establecemos el valor del resultado de que se devolvera a LoginActivity
        Intent intent = getIntent();
        intent.putExtra( "dato_nuevo", edtDato.getText().toString() );
        setResult( RESULT_OK, intent );
        finish();
    }

    //----------------------------------------------------------------------------------------------

    public void btnCancelarClick( View v ){
        setResult( RESULT_CANCELED );
        finish();
    }

    //----------------------------------------------------------------------------------------------
}