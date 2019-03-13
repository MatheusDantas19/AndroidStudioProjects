package pedrapapeloutesoura.cursoandroid.com.pedrapapeloutesoura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int resultado=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void selecionarPedra(View view){
        resultado = 0;
        opcaoSelecionada();
    }
    public void selecionarPapel(View view){
        resultado = 1;
        opcaoSelecionada();
    }
    public void selecionarTesoura(View view){
        resultado = 2;
        opcaoSelecionada();
    }
    public void opcaoSelecionada(){
        TextView texto = (TextView)findViewById(R.id.textoId);
        ImageView img = (ImageView)findViewById(R.id.botId);
        int num = new Random().nextInt(3);
        if(num==0){
            img.setImageResource(R.drawable.pedra);
        }else if(num==1){
            img.setImageResource(R.drawable.papel);
        }else{
            img.setImageResource(R.drawable.tesoura);
        }
        if(resultado == num){
            texto.setText("EMPATE!");
        }else if(resultado==0 && num==1){
            texto.setText("Voce Perdeu!");
        }else if(resultado == 0 && num==2){
            texto.setText("Voce Ganhou!");
        }else if(resultado ==1 && num ==0){
            texto.setText("Voce Ganhou!");
        }else if (resultado == 1 && num ==2){
            texto.setText("Voce Perdeu!");
        }else if(resultado ==2 && num ==0){
            texto.setText("Voce Perdeu!");
        }else if(resultado ==2 && num == 1){
            texto.setText("Voce Ganhou!");
        }
    }
}
