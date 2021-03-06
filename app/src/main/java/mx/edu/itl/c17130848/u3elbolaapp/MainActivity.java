/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                  Activity principal de la app con un menu
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Angel Eduardo Soto García    17130848
:*  Fecha       : 20/May/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase que contiene un menu amigable para la reproduccion de video, cambio de
:*                imagenes y reproduccion de audio.
:*  Ultima modif:
:*  Fecha       Modifición             Motivo
:*==========================================================================================
:*------------------------------------------------------------------------------------------*/
package mx.edu.itl.c17130848.u3elbolaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private Button btnFiesta;
    private MediaPlayer mediaPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Asignar la referencia del boton del la Party en la IU
        btnFiesta = findViewById( R.id.btnFiesta );
        //Registrar este activity como listener de los eventos Touch del boton Party
        btnFiesta.setOnTouchListener( this );
        //Establecer el canal de audio para reproduccion de musica
        setVolumeControlStream( AudioManager.STREAM_MUSIC );
    }

    //----------------------------------------------------------------------------------------------

    @Override
    public boolean onTouch( View view, MotionEvent event ) {
        if( view.getId() == R.id.btnFiesta ) {
            switch ( event.getAction() ) {
                case MotionEvent.ACTION_DOWN : reproducir_audio(); break;
                case MotionEvent.ACTION_UP : detener_audio(); break;
            }
            return true;
        }
        return false;
    }

    //----------------------------------------------------------------------------------------------

    private void reproducir_audio() {
        if( mediaPlayer == null ) {
          mediaPlayer = MediaPlayer.create( this, R.raw.tropicalisimo );
        }
        mediaPlayer.start();
    }

    //----------------------------------------------------------------------------------------------

    private void detener_audio() {
        if( mediaPlayer != null ) {
            mediaPlayer.stop();
            mediaPlayer = null;
        }
    }

    //----------------------------------------------------------------------------------------------

    public void btnSpotifyClick( View v ) {
        Intent intent = new Intent(this, ConciertoActivity.class );
        startActivity( intent );
    }

    //----------------------------------------------------------------------------------------------
}