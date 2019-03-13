package recyclerview.cursoandroid.com.recyclerview.activity.activity.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import recyclerview.cursoandroid.com.recyclerview.R;
import recyclerview.cursoandroid.com.recyclerview.activity.activity.RecyclerItemClickListener;
import recyclerview.cursoandroid.com.recyclerview.activity.activity.adapter.Adapter;
import recyclerview.cursoandroid.com.recyclerview.activity.activity.model.Flime;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Flime> listaFilmes = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerViewId);
        //Listagem de filmes
        this.criarFilmes();
        //configurar adapter
        Adapter adapter = new Adapter(listaFilmes);
        //configurar Recycler View
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);
        //configurar click
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Toast.makeText(getApplicationContext(),listaFilmes.get(position).getFilme(),
                                        Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Toast.makeText(getApplicationContext(),"Click Longo",
                                        Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );
    }
    public void criarFilmes(){
        Flime filme = new Flime("Jogos Mortais","Terror","2018");
        listaFilmes.add(filme);

        filme = new Flime("Vingadores","Acao","2018");
        listaFilmes.add(filme);

        filme = new Flime("Homem Aranha","Aventura","2018");
        listaFilmes.add(filme);

        filme = new Flime("Dragon Ball Super","Anime","2018");
        listaFilmes.add(filme);

        filme = new Flime("Shrek","Desenho","2018");
        listaFilmes.add(filme);
    }
}
