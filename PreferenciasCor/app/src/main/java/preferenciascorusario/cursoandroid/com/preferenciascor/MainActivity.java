package preferenciascorusario.cursoandroid.com.preferenciascor;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button botao;
    private RelativeLayout layout;
    private static final String ARQUIVO = "arquivo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroupId);
        botao = (Button)findViewById(R.id.botaoSalvar);
        layout = (RelativeLayout)findViewById(R.id.layoutId);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idGroup = radioGroup.getCheckedRadioButtonId();
                if(idGroup>0){
                    radioButton = (RadioButton)findViewById(idGroup);
                    String corEscolhida = radioButton.getText().toString();
                    SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO,0);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("cor",corEscolhida);
                    editor.commit();
                    setBackground(corEscolhida);

                }
            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO,0);
        if(sharedPreferences.contains("cor")){
            setBackground(sharedPreferences.getString("cor", "Nenhuma Cor"));
        }
    }
    private void setBackground(String cor){
        if(cor.equals("Laranja")){
            layout.setBackgroundColor(Color.parseColor("#FFC17700"));
        }else if(cor.equals("Azul")){
            layout.setBackgroundColor(Color.parseColor("#FF4947CF"));
        }else if(cor.equals("Verde")){
            layout.setBackgroundColor(Color.parseColor("#FF3FEA10"));
        }
    }
}
