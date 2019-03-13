package listatarefa.cursoandroid.com.listatarefa;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText textoTarefa;
    private Button botaoAdicionar;
    private ListView listaTarefas;
    private SQLiteDatabase bancoDeDados;

    private ArrayAdapter<String> itensAdaptador;
    private ArrayList<String> itens;
    private ArrayList<Integer> ids;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            //Recuperar Componentes
            textoTarefa = (EditText) findViewById(R.id.textoId);
            botaoAdicionar = (Button) findViewById(R.id.botaoId);
            listaTarefas = (ListView)findViewById(R.id.listViewId);
            //Banco de dados
            bancoDeDados = openOrCreateDatabase("apptarefas", MODE_PRIVATE, null);
            //Criando Tabelas
            bancoDeDados.execSQL("CREATE TABLE IF NOT EXISTS tarefas(id INTEGER PRIMARY KEY AUTOINCREMENT,tarefa VARCHAR)");
            botaoAdicionar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String textoDigitado = textoTarefa.getText().toString();
                    salvarTarefa(textoDigitado);
                }
            });
            listaTarefas.setLongClickable(true);
            listaTarefas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                    removerTarefa(ids.get(i));
                    recuperarTarefas();
                    return true;
                }
            });
            //recuperar tarefas
            recuperarTarefas();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void salvarTarefa(String texto){
        try {
            if(texto.equals("")) {
                Toast.makeText(MainActivity.this,"Digite uma tarefa",Toast.LENGTH_SHORT).show();
            }else{
                bancoDeDados.execSQL("INSERT INTO tarefas (tarefa) VALUES('" + texto + "')");
                Toast.makeText(MainActivity.this,"Tarefa salva com sucesso",Toast.LENGTH_SHORT).show();
                recuperarTarefas();
                textoTarefa.setText("");
            }
            }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void recuperarTarefas(){
        try{
            //recupera tarefas
            Cursor cursor = bancoDeDados.rawQuery("SELECT * FROM tarefas ORDER BY id DESC", null);
            //recuperar id das colunas
            int indiceColunaId = cursor.getColumnIndex("id");
            int indiceTarefa = cursor.getColumnIndex("tarefa");
            //Adaptador

            itens = new ArrayList<String>();
            ids = new ArrayList<Integer>();
            itensAdaptador = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1, android.R.id.text1, itens);
            listaTarefas.setAdapter(itensAdaptador);
            cursor.moveToFirst();
            while(cursor!=null){
                Log.i("Resultado - ","Tarefa: "+cursor.getString(indiceTarefa));
                Log.i("Resultado - ","Id: "+cursor.getString(indiceColunaId));
                itens.add(cursor.getString(indiceTarefa));
                ids.add(cursor.getInt(indiceColunaId));
                cursor.moveToNext();
            }
            //cursor.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void removerTarefa(Integer id){
        try{
            bancoDeDados.execSQL("DELETE FROM tarefas WHERE id=="+id);
            Toast.makeText(MainActivity.this,"Tarefa removida com sucesso",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
