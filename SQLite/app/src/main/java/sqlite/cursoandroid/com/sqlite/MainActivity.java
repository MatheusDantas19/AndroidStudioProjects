package sqlite.cursoandroid.com.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            SQLiteDatabase bancoDeDados = openOrCreateDatabase("app", MODE_PRIVATE, null);
            //criando tabelas
            bancoDeDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas(id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3))");
            //bancoDeDados.execSQL("DROP TABLE pessoas");
            //inserir dados na tabela
            //bancoDeDados.execSQL("INSERT INTO pessoas(nome,idade)VALUES('Inacio',44)");
            //bancoDeDados.execSQL("INSERT INTO pessoas(nome,idade)VALUES('Keila',54)");
            //recuperar dados
            bancoDeDados.execSQL("UPDATE pessoas SET nome = 'Matheus' WHERE id==1");
           // bancoDeDados.execSQL("DELETE FROM pessoas WHERE nome == 'Matheus'");
            Cursor cursor = bancoDeDados.rawQuery("SELECT * FROM pessoas", null);
            int indiceColunaNome = cursor.getColumnIndex("nome");
            int indiceColunaIdade = cursor.getColumnIndex("idade");
            int indiceId = cursor.getColumnIndex("id");
            cursor.moveToFirst();
            while (cursor != null) {
                Log.i("RESULTADO - nome: ", cursor.getString(indiceColunaNome));
                Log.i("RESULTADO - idade: ", cursor.getString(indiceColunaIdade));
                Log.i("RESULTADO - id: ", cursor.getString(indiceId));
                cursor.moveToNext();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
