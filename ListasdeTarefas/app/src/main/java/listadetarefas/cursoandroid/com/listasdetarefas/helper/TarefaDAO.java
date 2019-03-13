package listadetarefas.cursoandroid.com.listasdetarefas.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import listadetarefas.cursoandroid.com.listasdetarefas.model.Tarefa;

public class TarefaDAO implements ITarefaDAO {

    private SQLiteDatabase escreve;
    private SQLiteDatabase ler;

    public TarefaDAO(Context context) {
        DbHelper db = new DbHelper(context);
        escreve = db.getWritableDatabase();
        ler = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(Tarefa tarefa) {
        ContentValues cv = new ContentValues();
        cv.put("nome",tarefa.getNomeTarefa());
        cv.put("nota",tarefa.getTarefa());
        try{
            escreve.insert(DbHelper.TABELA_TAREFAS,null,cv);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean atualizar(Tarefa tarefa) {
        return false;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {
        return false;
    }

    @Override
    public List<Tarefa> lista() {

        List<Tarefa> tarefas = new ArrayList<>();
        String sql = "SELECT * FROM "+DbHelper.TABELA_TAREFAS+" ;";
        Cursor c = ler.rawQuery(sql,null);
        while (c.moveToNext()){
            Tarefa tarefa = new Tarefa();
            long id = c.getLong(c.getColumnIndex("id"));
            String nomeTarefa = c.getString(c.getColumnIndex("nome"));
            String nota = c.getString(c.getColumnIndex("nota"));
            tarefa.setId(id);
            tarefa.setNomeTarefa(nomeTarefa);
            tarefa.setTarefa(nota);
            tarefas.add(tarefa);
        }
        return tarefas;

    }
}
