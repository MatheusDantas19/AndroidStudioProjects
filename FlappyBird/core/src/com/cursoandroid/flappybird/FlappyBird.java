package com.cursoandroid.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.RandomXS128;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Random;

public class FlappyBird extends ApplicationAdapter {

	private SpriteBatch batch;
	private Texture[] passaros;
	private Texture fundo;
	private Texture canoBaixo;
	private Texture canoTopo;
	private Texture gameOver;
	private Random numeroRandomico = new Random();
	private BitmapFont mensagem;
	private BitmapFont fonte;
	private Circle passaroCirculo;
	private Rectangle retanguloCanoTopo;
	private Rectangle retanguloCanoBaixo;
	//private ShapeRenderer shape;

	private int largura;
	private int altura;
	private int estadoJogo=0;
	private int pontuacao = 0;

	private float variacao = 0;
	private float velocidadeQueda = 0;
	private float posicaoInicialVertical = 0;
	private float posicaoMovimentoCanoHorizontal;
	private float espacoCanos=0;
	private float deltaTime;
	private float alturaEntreCanosRandomica=0;

	private boolean marcou = false;

	private OrthographicCamera camera;
	private Viewport viewport;

	@Override
	public void create () {
		batch = new SpriteBatch();
		passaros = new Texture[3];
		//shape = new ShapeRenderer();
		passaroCirculo = new Circle();
		retanguloCanoBaixo = new Rectangle();
		retanguloCanoTopo = new Rectangle();
		passaros[0]= new Texture("passaro1.png");
		passaros[1]= new Texture("passaro2.png");
		passaros[2]= new Texture("passaro3.png");
		fundo = new Texture("fundo.png");
		canoBaixo = new Texture("cano_baixo.png");
		canoTopo = new Texture("cano_topo.png");
		gameOver = new Texture("game_over.png");
		altura = Gdx.graphics.getHeight();
		largura = Gdx.graphics.getWidth();
		posicaoInicialVertical = altura/2;
		posicaoMovimentoCanoHorizontal = largura;
		espacoCanos = 300;
		fonte = new BitmapFont();
		mensagem = new BitmapFont();
		fonte.setColor(Color.WHITE);
		fonte.getData().scale(6);
		mensagem.getData().scale(3);
		mensagem.setColor(Color.WHITE);
		camera = new OrthographicCamera();
	}

	@Override
	public void render () {
		deltaTime = Gdx.graphics.getDeltaTime();
		variacao += deltaTime*10;
		if (variacao > 2) {
			variacao = 0;
		}
		if(estadoJogo == 0){
			if(Gdx.input.justTouched()){
				estadoJogo = 1;
			}
		}else {
			velocidadeQueda++;
			if (posicaoInicialVertical > 0 || velocidadeQueda < 0) {
				posicaoInicialVertical = posicaoInicialVertical - velocidadeQueda;
			}
			if(estadoJogo == 1){
				posicaoMovimentoCanoHorizontal -= deltaTime * 200;
				if (Gdx.input.justTouched()) {
					velocidadeQueda = -15;
				}

				if (posicaoMovimentoCanoHorizontal < -canoTopo.getWidth()) {
					posicaoMovimentoCanoHorizontal = largura-20;
					alturaEntreCanosRandomica = numeroRandomico.nextInt(400) - 200;
					marcou = false;
				}
				if(posicaoMovimentoCanoHorizontal < 120 && !marcou){
					pontuacao++;
					marcou = true;
				}
			}else{
				if(Gdx.input.justTouched()){
					estadoJogo = 0;
					pontuacao = 0;
					velocidadeQueda = 0;
					posicaoInicialVertical = altura /2;
					posicaoMovimentoCanoHorizontal = largura;
				}
			}

		}
		batch.begin();
		batch.draw(fundo,0,0,largura,altura);
		batch.draw(canoTopo,posicaoMovimentoCanoHorizontal,altura/2 + espacoCanos/2 + alturaEntreCanosRandomica);
		batch.draw(canoBaixo,posicaoMovimentoCanoHorizontal,altura/2 - canoBaixo.getHeight() - espacoCanos/2 + alturaEntreCanosRandomica);
		batch.draw(passaros[(int)variacao],120,posicaoInicialVertical);
		fonte.draw(batch,String.valueOf(pontuacao),largura/2,altura - 50);
		if(estadoJogo == 2){
			batch.draw(gameOver,largura/2 - gameOver.getWidth()/2,altura/2);
			mensagem.draw(batch,"Toque Para Reiniciar!",largura/2 -250,altura/2 - gameOver.getWidth()/2);
		}
		batch.end();

		passaroCirculo.set(120 + passaros[0].getWidth()/2,posicaoInicialVertical+passaros[0].getHeight()/2,30);
		retanguloCanoBaixo = new Rectangle(posicaoMovimentoCanoHorizontal,altura/2 - canoBaixo.getHeight() - espacoCanos/2 + alturaEntreCanosRandomica,
				canoBaixo.getWidth(),canoBaixo.getHeight()
		);
		retanguloCanoTopo = new Rectangle(posicaoMovimentoCanoHorizontal,altura/2 + espacoCanos/2 + alturaEntreCanosRandomica,
				canoTopo.getWidth(),canoTopo.getHeight());

		//desenhar formas
		/*shape.begin(ShapeRenderer.ShapeType.Filled);
		shape.circle(passaroCirculo.x,passaroCirculo.y,passaroCirculo.radius);
		shape.rect(retanguloCanoBaixo.x,retanguloCanoBaixo.y,retanguloCanoBaixo.width,retanguloCanoBaixo.height);
		shape.rect(retanguloCanoTopo.x,retanguloCanoTopo.y,retanguloCanoTopo.width,retanguloCanoTopo.height);
		shape.setColor(Color.RED);
		shape.end();*/

		//Teste de Colisao
		if(Intersector.overlaps(passaroCirculo,retanguloCanoBaixo) || Intersector.overlaps(passaroCirculo,retanguloCanoTopo)
				|| posicaoInicialVertical<=1 || posicaoInicialVertical >=altura){
			estadoJogo = 2;
		}


	}


}
