package matheusinacio.cursoandroid.com.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            //criar banco de dados
            SQLiteDatabase bancoDados= openOrCreateDatabase("app",MODE_PRIVATE,null);
            //criar tabela
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (nome VARCHAR,idade INT(3))");
            //inserir dados
           // bancoDados.execSQL("INSERT INTO pessoas(nome,idade) VALUES('KEILA',44)");
            //bancoDados.execSQL("INSERT INTO pessoas(nome,idade) VALUES('INACIO',54)");

            //RECUPERAR dados
           // String consulta = "SELECT nome,idade FROM pessoas " + "WHERE nome ='MATHEUS' AND idade=17 ";
            //String consulta = "SELECT nome,idade FROM pessoas " + "WHERE idade IN(18,35) ";
            //IN dentro dos parenteses
            //String consulta = "SELECT nome,idade FROM pessoas " + "WHERE idade BETWEEN 30 AND 35";
            //Between range, intevalo
            //String consulta = "SELECT nome,idade FROM pessoas " + "WHERE nome LIKE '%mat%'";
            //String consulta = "SELECT nome,idade FROM pessoas " + "WHERE idade >=1 ORDER BY idade DESC";
            String consulta = "SELECT nome,idade FROM pessoas " + "WHERE idade >=1 ORDER BY idade DESC LIMIT 3";
            // Ordenacao, ASC do menor para o maior, DESC maior para o menor
            Cursor cursor = bancoDados.rawQuery(consulta,null);
            //indices da tabela
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();
            //cursor linha
            while(cursor!=null){
                String nome = cursor.getString(indiceNome);
                String idade = cursor.getString(indiceIdade);
                Log.i("Resultado - nome ",nome+" / idade "+idade);
                cursor.moveToNext();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
