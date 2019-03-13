package atmempresaconsultoria.cursoandroid.com.atmempresaconsultoria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView botaoEmpresa;
    private ImageView botaoServicos;
    private ImageView botaoCliente;
    private ImageView botaoContato;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botaoEmpresa = (ImageView)findViewById(R.id.empresaId);
        botaoServicos = (ImageView)findViewById(R.id.servicosId);
        botaoCliente = (ImageView)findViewById(R.id.clientesId);
        botaoContato = (ImageView)findViewById(R.id.contatoId);
        botaoEmpresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,EmpresaActivity.class));
            }
        });

        botaoServicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ServicosActivity.class));
            }
        });

        botaoCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ClientesActivity.class));
            }
        });

        botaoContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ContatoActivity.class));
            }
        });
    }
}
