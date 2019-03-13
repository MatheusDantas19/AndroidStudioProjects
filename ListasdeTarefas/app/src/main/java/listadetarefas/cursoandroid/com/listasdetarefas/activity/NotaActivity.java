package listadetarefas.cursoandroid.com.listasdetarefas.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import listadetarefas.cursoandroid.com.listasdetarefas.R;
import listadetarefas.cursoandroid.com.listasdetarefas.helper.TarefaDAO;
import listadetarefas.cursoandroid.com.listasdetarefas.model.Tarefa;

public class NotaActivity extends AppCompatActivity {
    private EditText nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota);
        nota = findViewById(R.id.notaId);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.salvarMenu) {
            TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
            String notacao = nota.getText().toString();
            if (!notacao.isEmpty()) {
                Tarefa tarefa = (Tarefa) getIntent().getSerializableExtra("tarefa");
                tarefa.setTarefa(notacao);
                tarefaDAO.salvar(tarefa);
                finish();
            }
        }
        return super.onOptionsItemSelected(item);

    }
}
