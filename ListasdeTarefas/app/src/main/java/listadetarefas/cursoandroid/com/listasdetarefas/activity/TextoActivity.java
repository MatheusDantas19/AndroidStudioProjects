package listadetarefas.cursoandroid.com.listasdetarefas.activity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import listadetarefas.cursoandroid.com.listasdetarefas.R;
import listadetarefas.cursoandroid.com.listasdetarefas.helper.DbHelper;
import listadetarefas.cursoandroid.com.listasdetarefas.helper.TarefaDAO;
import listadetarefas.cursoandroid.com.listasdetarefas.model.Tarefa;

public class TextoActivity extends AppCompatActivity {
    private TextView texto;
    private Tarefa tarefaAtual;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texto);
        texto = findViewById(R.id.textoId);
        tarefaAtual = (Tarefa) getIntent().getSerializableExtra("tarefa");
        if(tarefaAtual!=null){
            texto.setText(tarefaAtual.getTarefa());
        }
    }
}
