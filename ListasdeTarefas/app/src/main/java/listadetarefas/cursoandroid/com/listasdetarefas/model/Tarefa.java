package listadetarefas.cursoandroid.com.listasdetarefas.model;

import java.io.Serializable;

public class Tarefa implements Serializable {
    private String nomeTarefa;
    private String tarefa;
    private Long id;

    public Tarefa(){

    }
    public Tarefa(String nomeTarefa, String tarefa, Long id) {
        this.nomeTarefa = nomeTarefa;
        this.tarefa = tarefa;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }
}
