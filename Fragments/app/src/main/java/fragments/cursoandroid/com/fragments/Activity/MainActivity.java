package fragments.cursoandroid.com.fragments.Activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fragments.cursoandroid.com.fragments.Fragment.ContatosFragment;
import fragments.cursoandroid.com.fragments.Fragment.ConversasFragment;
import fragments.cursoandroid.com.fragments.R;

public class MainActivity extends AppCompatActivity {
    private Button botaoConversa,botaoContato;
    private ConversasFragment conversasFragment;
    private ContatosFragment contatosFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conversasFragment = new ConversasFragment();
        botaoContato = findViewById(R.id.botaoContato);
        botaoConversa = findViewById(R.id.botaoConversa);
        //configurar objeto para o fragmento
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameConteudo,conversasFragment);
        transaction.commit();
        botaoContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contatosFragment = new ContatosFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo,contatosFragment);
                transaction.commit();
            }
        });
        botaoConversa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conversasFragment = new ConversasFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo,conversasFragment);
                transaction.commit();
            }
        });
    }
}
