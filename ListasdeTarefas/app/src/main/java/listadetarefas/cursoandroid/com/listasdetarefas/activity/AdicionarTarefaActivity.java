package listadetarefas.cursoandroid.com.listasdetarefas.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import listadetarefas.cursoandroid.com.listasdetarefas.R;
import listadetarefas.cursoandroid.com.listasdetarefas.helper.TarefaDAO;
import listadetarefas.cursoandroid.com.listasdetarefas.model.Tarefa;

public class AdicionarTarefaActivity extends AppCompatActivity {
    private TextInputEditText editTarefa;
    private Tarefa tarefaAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);
        editTarefa = findViewById(R.id.textoLido);
        //recuperar tarefa, edicao

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.salvarMenu){
            //TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
            String nomeTarefa = editTarefa.getText().toString();
            if(!nomeTarefa.isEmpty()){
                Tarefa tarefa = new Tarefa();
                tarefa.setNomeTarefa(editTarefa.getText().toString());
                //tarefaDAO.salvar(tarefa);
                Intent intent = new Intent(AdicionarTarefaActivity.this,NotaActivity.class);
                finish();
                intent.putExtra("tarefa",tarefa);
                startActivity(intent);
                //finish();
            }

        }
        return super.onOptionsItemSelected(item);
    }
}
