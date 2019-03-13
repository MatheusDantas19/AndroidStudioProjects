package sharedpreferences.cursoandroid.com.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText textoNome;
    private Button salvar;
    private TextView textoExibicao;

    private static final String ARQUIVO_PREFERENCIA = "Arquivo Preferencia";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textoNome = (EditText)findViewById(R.id.textoNomeId);
        textoExibicao = (TextView)findViewById(R.id.textoRespostaId);
        salvar = (Button)findViewById(R.id.botaoId);
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                if(textoNome.getText().toString().equals("\n")){
                    Toast.makeText(getApplicationContext(),"Por favor preencher o nome",Toast.LENGTH_SHORT).show();
                }else{
                    editor.putString("nome",textoNome.getText().toString());
                    editor.commit();
                    textoExibicao.setText("Ola, "+textoNome.getText().toString());
                }
            }
        });
        //recuperar dados salvos
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
        if(sharedPreferences.contains("nome")){
            String usuario = sharedPreferences.getString("nome","usuario nao definido");
            textoExibicao.setText("Ola, "+usuario);
        }else{
            textoExibicao.setText("Ola usuario nao definido");
        }
    }
}
