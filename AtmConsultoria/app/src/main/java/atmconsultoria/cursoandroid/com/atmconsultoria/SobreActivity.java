package atmconsultoria.cursoandroid.com.atmconsultoria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import mehdi.sakout.aboutpage.AboutPage;

public class SobreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_sobre);
        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.logo)
                .setDescription("ATM Cconsultoria tem a missaso de apoiar as organizacoes que desejam alcancar o sucesso atraves da accoes \n")
                .addGroup("Fale conosco")
                //.addItem(adsElement)
                .addEmail("matheusinacio80@gmail.com","Envie um email")
                .addWebsite("http://google.com.br/","nosso site")
                .addGroup("Acesse nossas Redes Sociais")
                .addFacebook("google","Facebook")
                .addTwitter("medyo80")
                .addYoutube("UCdPQtdWIsg7_pi4mrRu46vA")
                .addPlayStore("com.ideashower.readitlater.pro")
                .addGitHub("medyo")
                .addInstagram("medyo80")
                .create();
        setContentView(aboutPage);
    }
}
