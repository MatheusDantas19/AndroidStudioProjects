package listadetarefas.cursoandroid.com.listasdetarefas.helper;

import java.util.List;

import listadetarefas.cursoandroid.com.listasdetarefas.model.Tarefa;

public interface ITarefaDAO {
    public boolean salvar(Tarefa tarefa);
    public boolean atualizar(Tarefa tarefa);
    public boolean deletar(Tarefa tarefa);
    public List<Tarefa> lista();
}
