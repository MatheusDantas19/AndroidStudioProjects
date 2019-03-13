package exercutandovideos.cursoandroid.com.exercutandovideos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
    private VideoView video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        video = findViewById(R.id.videoViewId);
        //esconde a sattusbar e barra de navegacao
        View decorView = getWindow().getDecorView();
        int uiOpcoes = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(0);

        //esconde a acctionbar
        getSupportActionBar().hide();
        video.setMediaController(new MediaController(this));
        video.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.video);
        video.start();
    }
}
