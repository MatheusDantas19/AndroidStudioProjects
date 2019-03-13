package listadetarefas.cursoandroid.com.listasdetarefas.activity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import listadetarefas.cursoandroid.com.listasdetarefas.R;
import listadetarefas.cursoandroid.com.listasdetarefas.helper.DbHelper;
import listadetarefas.cursoandroid.com.listasdetarefas.helper.RecyclerItemClickListener;
import listadetarefas.cursoandroid.com.listasdetarefas.adapter.TarefaAdapter;
import listadetarefas.cursoandroid.com.listasdetarefas.helper.TarefaDAO;
import listadetarefas.cursoandroid.com.listasdetarefas.model.Tarefa;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TarefaAdapter tarefaAdapter;
    private List<Tarefa> listaTarefa = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //configurar recycler
        recyclerView = findViewById(R.id.recyclerId);
        //adicionar item de clique
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(), recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
                    public void onItemClick(View view, int position) {
                        Tarefa tarefaSelecionada = listaTarefa.get(position);
                        Intent intent = new Intent(MainActivity.this,TextoActivity.class);
                        intent.putExtra("tarefa",tarefaSelecionada);
                        startActivity(intent);

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }
        ));
        //carregarListaTarefas();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AdicionarTarefaActivity.class);
                startActivity(intent);
            }
        });
    }

    public void carregarListaTarefas(){
        //listar tarefas
        TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
        listaTarefa = tarefaDAO.lista();
        //configurar um adapter
        tarefaAdapter = new TarefaAdapter(listaTarefa);
        //configurar recycler view
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(),LinearLayout.VERTICAL));
        recyclerView.setAdapter(tarefaAdapter);
    }

    @Override
    protected void onStart() { //pq se nao, nao carrega as tarefas
        carregarListaTarefas();
        super.onStart();
    }

    //@Override
    /*public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/

    //@Override
    /*public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.salvarMenu) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
