package recyclerview.cursoandroid.com.recyclerview.activity.activity.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import recyclerview.cursoandroid.com.recyclerview.R;
import recyclerview.cursoandroid.com.recyclerview.activity.activity.model.Flime;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private List<Flime> listaFilmes;
    public Adapter(List<Flime> lista){
        listaFilmes = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //nao exibe os itens, apenas criar a visualizacao
        View itemLista = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_lista, viewGroup,false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        //exibicao dos itens
        Flime filme = listaFilmes.get(i);
        myViewHolder.titulo.setText(filme.getFilme().toString());
        myViewHolder.ano.setText(filme.getAno().toString());
        myViewHolder.genero.setText(filme.getGenero().toString());
    }
    @Override
    public int getItemCount() {
        return listaFilmes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView titulo;
        TextView ano;
        TextView genero;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.textTitulo);
            ano = itemView.findViewById(R.id.textAno);
            genero = itemView.findViewById(R.id.textGenero);
        }
    }

}
