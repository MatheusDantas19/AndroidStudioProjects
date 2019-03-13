package gasolinaoualcool.cursoandroid.com.gasolinaoualcool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText caixaAlcool;
    private EditText caixaGasolina;
    private Button verificar;
    private TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        caixaAlcool = (EditText) findViewById(R.id.caixaAlcoolId);
        caixaGasolina = (EditText) findViewById(R.id.caixaGasolinaId);
        verificar = (Button) findViewById(R.id.botaoVerificarId);
        resultado = (TextView) findViewById(R.id.resultadoId);
        verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoAlcool = caixaAlcool.getText().toString();
                String textoGasolina = caixaGasolina.getText().toString();
                double alcool = Double.parseDouble(textoAlcool);
                double gasolina = Double.parseDouble(textoGasolina);
                double resultadoValor = alcool/gasolina;
                if(textoAlcool.isEmpty() || textoGasolina.isEmpty()){
                    resultado.setText("Valor Vazio!!");
                }else{
                    if(resultadoValor >= 0.7){
                        resultado.setText("Compensa ultizar Gasolina");
                    }else{
                        resultado.setText("Compensa ultizar Alcool");
                    }
                }
            }
        });
    }
}
