package cardview.cursoandroid.com.cardview.Activity.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cardview.cursoandroid.com.cardview.Activity.Model.Postagem;
import cardview.cursoandroid.com.cardview.R;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private List<Postagem> postagens;
    public Adapter(List<Postagem> listaPostagens) {
        this.postagens = listaPostagens;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //criar a visualizacao, apos terminar o layout
        View itemLista = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.postagem_detalhe,viewGroup,false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        //exibicao dos itens
        Postagem postagem = postagens.get(i);
        myViewHolder.textNome.setText(postagem.getNome());
        myViewHolder.textPostagem.setText(postagem.getPostagem());
        myViewHolder.imagem.setImageResource(postagem.getImagem());
    }

    @Override
    public int getItemCount() {
        return postagens.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView textNome;
        private TextView textPostagem;
        private ImageView imagem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textNome = itemView.findViewById(R.id.textoNome);
            textPostagem = itemView.findViewById(R.id.textPostagem);
            imagem = itemView.findViewById(R.id.imagemPostagem);
        }
    }
}
