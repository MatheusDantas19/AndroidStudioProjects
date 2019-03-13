package radiobutton.cursoandroid.com.radiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton radioBotaoEscolhido;
    private Button botaoEscolher;
    private TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroupId);
        botaoEscolher = (Button)findViewById(R.id.botaoId);
        texto = (TextView)findViewById(R.id.textoId);
        botaoEscolher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idRadioButtonEscolhido = radioGroup.getCheckedRadioButtonId();
                if(idRadioButtonEscolhido > 0){
                    radioBotaoEscolhido = (RadioButton)findViewById(idRadioButtonEscolhido);
                    texto.setText(radioBotaoEscolhido.getText());
                }
            }
        });
    }
}
