package signos.cursoandroid.com.signos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listaSignos;
    private String[] itens ={
            "Áries","Touro","Gêmeos","Câncer",
            "Leao","Virgem","Libra","Escorpiao",
            "Sagitario","Capricornio","Aquario","Peixes"
    };
    private String[] perfis ={" Áries é ardente, impulsivo, rápido, corajoso, espontâneo e bruto. Não mede esforços quando luta para conquistar seus objetivos.",
            "O taurino sabe esperar e trabalhar com afinco por aquilo que deseja. É muito decidido, calmo e prático. De temperamento afável, ele dificilmente se irrita.",
            "Gêmeos é por excelência o signo da dualidade. De personalidade versátil e comunicativa, é o mais rápido e adaptável do zodíaco. É entusiasmado, alegre, dinâmico, divertido e bem humorado.",
            "Câncer é um signo de elemento água, regido pela Lua, portanto um dos signos mais sensíveis do Zodíaco. Compreensivo, amigo, romântico, alegre e de fácil comunicação.",
            "Leão tem personalidade voluntariosa, e sempre consegue o que quer, seja através de sua autoridade ou de seu charme pessoal. Acriatividade também é um dos seus pontos fortes.",
            "Virgem é o mais atarefado do Zodíaco. Nervoso e agitado, costuma estar sempre com pressa e detesta a ociosidade.",
            "Libra tem facilidade para compreender o ponto de vista alheio e sabe dar a devida importância às mais diferentes opiniões.",
            "Escorpião é muito intenso e capaz de sentimentos fortíssimos, porém é reservado e dedica muito de seu tempo para sua vida interior.",
            "Sagitário é um aventureiro, sempre em busca do sentido da vida e pronto a expandir e conquistar alvos mais elevados.",
            "Capricórnio é fechado e reservado, porém seguro de si mesmo, traça seus objetivos e espera pacientemente o momento certo de atingi-los. O segredo é a persistência.",
            "Aquário simboliza a amizade e a compreensão racional do mundo. Ama a humanidade e valoriza altamente a paz.",
            "Peixes é honesto, carinhoso e protetor, além de ser extremamente romântico e carente. Tem muitos amigos, os quais conquista facilmente com seu jeito doce e meigo."};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaSignos = (ListView)findViewById(R.id.listViewId);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                itens
        );
        listaSignos.setAdapter(adapter);
        listaSignos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int posicao = i;
                String palavra = perfis[posicao];
                Toast.makeText(getApplicationContext(),palavra,Toast.LENGTH_LONG).show();
            }
        });

    }
}
