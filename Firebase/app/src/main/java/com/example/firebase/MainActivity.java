package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth usuario = FirebaseAuth.getInstance();
    private Button logar;
    private EditText email;
    private EditText senha;
    private TextView res;
    //private TextI

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        senha = findViewById(R.id.senha);
        logar = findViewById(R.id.logar);
        res = findViewById(R.id.resposta);

        //logar usuario


        /*deslogar Usuario*/
        usuario.signOut();

        /*verifica usuario logado//
        if(usuario.getCurrentUser()!=null){
            Log.i("Create User: ","Logado");
        }else{
            Log.i("Create User: ","Deslogado");
        }*/


        /*Cadastra email do usuario
        usuario.createUserWithEmailAndPassword(
                "matheusinacio80@gmail.com","12345678")
                .addOnCompleteListener(MainActivity.this,new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Log.i("Create User: ","Sucesso");
                        }else{
                            Log.i("Create User: ","Falho");
                        }
                    }
                })
        ;*/


        //referencia.child("pontos").setValue("100");
        //referencia.child("usuarios2").child("001").child("nome").setValue("Maria");

        //DatabaseReference usuarios = referencia.child("usuarios");//.child("001");
        //Usuario usuario = new Usuario("Matheus","Dantas",20);
        //usuarios.child("001").setValue(usuario);

        /*usuarios.addValueEventListener(new ValueEventListener() { //recupera dados
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.i("Firebase:",dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/
    }
    public void clicado(View v){
        String emailS = email.getText().toString();
        String senhaS = senha.getText().toString();
        if(emailS.isEmpty() || senhaS.isEmpty()){
            return;
        }
        usuario.signInWithEmailAndPassword(
                emailS,senhaS)
                .addOnCompleteListener(MainActivity.this,new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Log.i("usuario Logado: ","Sucesso");
                            Intent intent = new Intent(MainActivity.this,SegundaActivity.class);
                            startActivity(intent);
                        }else{
                            Log.i("usuario nao logado: ","Falho");
                        }
                    }
                });
    }
}
