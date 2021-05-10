/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                      Activity que reproduce un video
:*
:*  Archivo     : ConciertoActivity.java
:*  Autor       : Angel Eduardo Soto García    17130848
:*  Fecha       : 20/May/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase que reproduce un video con la ayuda de la clase VideoView
:*
:*  Ultima modif:
:*  Fecha       Modifición             Motivo
:*==========================================================================================
:*------------------------------------------------------------------------------------------*/
package mx.edu.itl.c17130848.u3elbolaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class ConciertoActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concierto);

        //Configuramos el objeto videoView para la reproduccion del video
        videoView = findViewById( R.id.videoView );

        String uriPath = "android.resource://" + getPackageName() + "/" + R.raw.la_pachanga;
        Uri uri = Uri.parse( uriPath );
        videoView.setVideoURI( uri );
        videoView.setMediaController( new MediaController( this ) );
        videoView.requestFocus();
        videoView.start();
    }
}