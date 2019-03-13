package dialog.cursoandroid.com.dialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button botao;
    private AlertDialog.Builder dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botao = (Button)findViewById(R.id.botaoId);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //criar alert dialog
                dialog = new AlertDialog.Builder (MainActivity.this);
                //configurar dialog
                dialog.setTitle("Titulo da Dialog");
                //configurar mensagem
                dialog.setMessage("Mensagem da Dialog");
                //cancelar diaolog
                dialog.setCancelable(false);
                //icone
                dialog.setIcon(android.R.drawable.ic_delete);
                //botao negativo
                dialog.setNegativeButton("NAO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"Pressionado botao nao",Toast.LENGTH_SHORT).show();
                    }
                });
                //botao positivo
                dialog.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Pressionado botao sim",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.create();
                dialog.show();
            }
        });
    }
}
