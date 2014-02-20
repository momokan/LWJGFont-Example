

import java.io.IOException;


import net.chocolapod.lwjgfont.myfont.Migu1pRegularH28Font;
import net.chocolapod.lwjgfont.texture.Texture;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.GL_BACK;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_CULL_FACE;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glCullFace;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glScalef;
import static org.lwjgl.opengl.GL11.glTranslatef;
 
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class LwjgfontExampleForBlog {
	private int			width = 800;
	private int			height = 640;
	private int			depth = 300;

	private Texture					texture;
	private Migu1pRegularH28Font	font;

	public void start() {
		try {
			//  ウインドウを生成する
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.setTitle("LWJGFont example");
			Display.create();
		} catch(LWJGLException e) {
			e.printStackTrace();
			return;
		}

		try {
			//  OpenGL の初期設定

			//  テクスチャーを有効化する
			glEnable(GL_TEXTURE_2D);

			//  ポリゴンの表示面を表のみに設定する
//			glEnable(GL_CULL_FACE);
//			glCullFace(GL_BACK);

			//  カメラ用の設定変更を宣言する
			glMatrixMode(GL_PROJECTION);
			//  設定を初期化する
			glLoadIdentity();
			//  視体積（目に見える範囲）を定義する
			glOrtho(0, width, 0, height, 0, depth);

			//  物体モデル用の設定変更を宣言する
			glMatrixMode(GL_MODELVIEW);

			init();

			while (!Display.isCloseRequested()) {
				//  オフスクリーンを初期化する
				glClear(GL_COLOR_BUFFER_BIT);

				//  キー入力を処理する
				update();

				//  オフスクリーンに描画する
				render();

				//  オフスクリーンをスクリーンに反映する
				Display.update();
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			terminate();
			Display.destroy();
		}
	}

	private void init() throws Exception {
		//  ファイルのパス指定で画像を読み込む
//		texture = TextureLoader.loadTexture(LwjgfontTest.class, "night.png");

		//  クラスパスから画像を検索して読み込む
//      texture = new TextureLoader().loadTexture("images/texture.png", this.getClass().getClassLoader());
		
		font = new Migu1pRegularH28Font();
	}

	private void terminate() {
		if (texture != null) texture.dispose();
	}

	private void update() {
	}

	private void render() {
		//  設定を初期化する
//		glLoadIdentity();

		/*
		//  画面中央の座標を (0, 0, 0) とするよう座標系を移動する
		glTranslatef(width / 2f, height / 2f, depth / -2f);

		//  座標のスケールを指定する
		//  ここで指定した x, y, z 毎の係数が、次に指定する座標にそれぞれ掛けられる
		glScalef(30f, 30f, 30f);

		glRotatef(xAngle, 0, 1, 0); //  y 軸を中心に xAngle 度回転させる
		glRotatef(yAngle, 1, 0, 0); //  x 軸を中心に yAngle 度回転させる

		//  テクスチャをバインドする
		texture.bind();

		glBegin(GL_QUADS);

		glColor4f(1f, 1f, 1f, 1f);

		glEnd();
		*/
//		texture.draw(0, height);
//		texture.draw(0, 100, 100, 0, 0, 0, 100, 100);
		try {
			font.drawString("我らの父は、", 10, 580, 0);
			font.drawString("偉大なるその血を4つに分けた。", 10, 530, 0);
			font.drawString("長兄は責任感だけを受け継ぎ、", 10, 460, 0);
			font.drawString("次兄はのんきな性格だけを受け継ぎ、", 10, 410, 0);
			font.drawString("弟は純真さだけを受け継ぎ、", 10, 360, 0);
			font.drawString("私はあほうぶりだけを受け継いだ。", 10, 310, 0);
			font.drawString("てんでバラバラの兄弟をつなぎ止めている", 10, 240, 0);
			font.drawString("のは、海よりも深い母の愛と、偉大なる父", 10, 190, 0);
			font.drawString("との”さよなら”である。1つの大きな”さよ", 10, 140, 0);
			font.drawString("なら”が、残された者をつなぐこともある。", 10, 90, 0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
	public static void main(String[] args) {
		new LwjgfontExampleForBlog().start();
	}
}
