package com.example.matheusinacio.meuprojeto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void alterarTexto(View view){
        TextView texto = (TextView) findViewById(R.id.textoId);
        int randomico = new Random().nextInt(10);
        texto.setText("numero sorteado: "+ randomico);
    }
}
