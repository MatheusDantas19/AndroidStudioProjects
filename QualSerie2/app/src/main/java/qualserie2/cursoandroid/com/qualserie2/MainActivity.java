package qualserie2.cursoandroid.com.qualserie2;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private SeekBar seek;
    private ImageView emoji;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seek = (SeekBar)findViewById(R.id.seekBarId);
        emoji = (ImageView)findViewById(R.id.imagemId);
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(i==1){
                    emoji.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.pouco));
                }else if(i==2){
                    emoji.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.medio));
                }else if(i==3){
                    emoji.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.muito));
                }else if(i==4){
                    emoji.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.susto));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
