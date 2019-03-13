package com.example.firebaseapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth usuario = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseReference usuarios = referencia.child("usuarios");
        //DatabaseReference usuariosPesquisa = usuarios.child("-LXzNOzjt_IOw2RBvvcm");
        //Query usuarioPesquisa = usuarios.orderByChild("nome").equalTo("Matheus");
        //Query usuarioPesquisa = usuarios.orderByKey().limitToFirst(2);

        /* Maior ou igual (>=) */
        //Query usuarioPesquisa = usuarios.orderByChild("idade").startAt(40);

        /* Menor ou igual (=<) */
        //Query usuarioPesquisa = usuarios.orderByChild("idade").endAt(25);

        /* Menor e maior */
        //Query usuarioPesquisa = usuarios.orderByChild("idade").startAt(30).endAt(40);

        /*Filtrar palavras*/

        /* palavras */
        Query usuarioPesquisa = usuarios.orderByChild("nome").startAt("M").endAt("M"+"\uf8ff");

        usuarioPesquisa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Usuario dadosUsuario = dataSnapshot.getValue(Usuario.class);
                Log.i("Usuario: ",dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void criaUsuario(String nome, String sobrenome,int idade){
        DatabaseReference usuarios = referencia.child("usuarios");
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setSobrenome(sobrenome);
        usuario.setIdade(idade);
        usuarios.push().setValue(usuario);
    }
}
/* //logar usuario
        usuario.signInWithEmailAndPassword("matheusinacio80@gmail.com","ARQUEIROOFFARE18").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //
            }
        });

        //deslogar usuario
        usuario.signOut();*/

//verificar se esta logado
        /*if(usuario.getCurrentUser()!=null){
            Log.i("Create","usuario logado");
        }else{
            Log.i("Create","usuario nao logado");
        }*/

//cadastrar usuario
        /*usuario.createUserWithEmailAndPassword("matheusinacio89@gmail.com","ARQUEIROOFFARE18")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.i("Info","Sucesso ao criar o usuario");
                        }else{
                            Log.i("Info","Erro ao criar o usuario");
                        }
                    }
                });*/
        /*DatabaseReference usuarios = referencia.child("usuarios");
        //referencia.child("pontos").setValue("100");
        //referencia.child("usuario2").child("001").child("nome").setValue("Inacio");
        usuarios.addValueEventListener(new ValueEventListener() {
            @Override //salvar dados
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.i("Firabase",dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    */