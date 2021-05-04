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