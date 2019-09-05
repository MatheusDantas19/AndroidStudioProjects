package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;

public class SegundaActivity extends AppCompatActivity {
    private ImageView foto;
    private Button botao;
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef = storage.getReference();
    StorageReference mountainsRef = storageRef.child("imagens");
    StorageReference mountainImagesRef = storageRef.child("images/celular.jpg");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        foto = findViewById(R.id.foto);
        botao = findViewById(R.id.botaoUpload);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                foto.setDrawingCacheEnabled(true);
                foto.buildDrawingCache();
                Bitmap bitmap = ((BitmapDrawable) foto.getDrawable()).getBitmap();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                byte[] data = baos.toByteArray();

                UploadTask uploadTask = mountainsRef.putBytes(data);
                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        Toast.makeText(SegundaActivity.this,"Upload falhou"
                                +exception.getMessage().toString(),Toast.LENGTH_LONG);
                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
                        // ...
                        Uri url = taskSnapshot.getUploadSessionUri();
                        Toast.makeText(SegundaActivity.this,"Upload foi um Sucesso"
                                +url.toString(),Toast.LENGTH_LONG);
                    }
                });
            }
        });

    }
}
