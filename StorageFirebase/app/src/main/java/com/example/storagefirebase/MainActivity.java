package com.example.storagefirebase;


import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private Button botaoEnviar;
    private ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoEnviar = findViewById(R.id.buttonUpload);
        foto = findViewById(R.id.imageFoto);

        botaoEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //configura imagem pra ser salva em memoria
                foto.setDrawingCacheEnabled(true);
                foto.buildDrawingCache();

                //Recuperar Bitmap da imagem
                Bitmap bitmap = foto.getDrawingCache();

                //comprimir bitmap para o formato png/jgp
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,75,baos);

                //converte o baos  para pixel brutos em uma matriz de bytes
                //dados da imagem
                byte[] dadosImagem = baos.toByteArray();

                //define nos para o storage
                StorageReference storageReference = FirebaseStorage.getInstance().getReference();
                StorageReference  imagens = storageReference.child("imagens");
                String nomeArquivo = UUID.randomUUID().toString();
                final StorageReference imagemRef = imagens.child(nomeArquivo+".jpeg");

                //Retorna objeto que irá controlar o upload
                UploadTask uploadTask = imagemRef.putBytes(dadosImagem);
                uploadTask.addOnFailureListener(MainActivity.this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this,
                                "erro ao fazer o upload"+e.getMessage().toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                }).addOnSuccessListener(MainActivity.this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        //recuperar informacoes do upload
                        Task<Uri> url = imagemRef.getDownloadUrl();
                        Toast.makeText(MainActivity.this, "sucesso ao fazer o upload: " +url.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
