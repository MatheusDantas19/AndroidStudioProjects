package cardview.cursoandroid.com.cardview.Activity.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import cardview.cursoandroid.com.cardview.Activity.Adapter.Adapter;
import cardview.cursoandroid.com.cardview.Activity.Model.Postagem;
import cardview.cursoandroid.com.cardview.R;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerPostagem;
    private List<Postagem> postagens = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPostagem = (RecyclerView)findViewById(R.id.recyclerViewId);

        //Define Layout
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //layoutManager.setOrientation(LinearLayout.HORIZONTAL);
       RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        //RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerPostagem.setLayoutManager(layoutManager);
        //Define Adapter
        prepararPostagens();
        Adapter adapter = new Adapter(postagens);
        recyclerPostagem.setAdapter(adapter);
    }
    public void prepararPostagens(){
        Postagem p = new Postagem("Matheus Inacio","#TBT Muito Top",R.drawable.imagem1);
        postagens.add(p);
        p = new Postagem("Suzzy Keila","#TBT Muito Lindo",R.drawable.imagem2);
        postagens.add(p);
        p = new Postagem("Keila Regina","#Maravilhoso",R.drawable.imagem3);
        postagens.add(p);
        p = new Postagem("Inacio Dantas","#Muito legal",R.drawable.imagem4);
        postagens.add(p);
    }
}
