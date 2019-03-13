package listadetarefas.cursoandroid.com.listasdetarefas.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import listadetarefas.cursoandroid.com.listasdetarefas.R;
import listadetarefas.cursoandroid.com.listasdetarefas.model.Tarefa;

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.MyViewHolder>{

    private List<Tarefa> listaTarefas;
    public TarefaAdapter(List<Tarefa> lista) {
        listaTarefas = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //criar layout, linear layout, e depois ajustar o linear layout, pq ocupa todo o espaco
        View itemLista = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.lista_adapter,viewGroup,false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Tarefa tarefa = listaTarefas.get(i);
        myViewHolder.tarefa.setText(tarefa.getNomeTarefa());
    }

    @Override
    public int getItemCount() {
        return listaTarefas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tarefa;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tarefa = itemView.findViewById(R.id.textTarefa);
        }
    }
}
