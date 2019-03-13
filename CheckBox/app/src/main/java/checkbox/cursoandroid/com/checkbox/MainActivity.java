package checkbox.cursoandroid.com.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private CheckBox cao;
    private CheckBox gato;
    private CheckBox papagaio;
    private Button botao;
    private TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cao = (CheckBox)findViewById(R.id.checkBoxCaoId);
        gato = (CheckBox)findViewById(R.id.checkBoxGatoId);
        papagaio = (CheckBox)findViewById(R.id.checkBoxPapagaioId);
        botao = (Button)findViewById(R.id.botaoMostrarId);
        texto = (TextView)findViewById(R.id.textoId);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itensSelecionados = "";
                itensSelecionados += "Item: "+cao.getText()+" Status: "+cao.isChecked()+"\n";
                itensSelecionados += "Item: "+gato.getText()+" Status: "+gato.isChecked()+"\n";
                itensSelecionados += "Item: "+papagaio.getText()+" Status: "+papagaio.isChecked()+"\n";
                texto.setText(itensSelecionados);
            }
        });
    }
}
