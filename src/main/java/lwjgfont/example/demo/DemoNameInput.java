package lwjgfont.example.demo;


import net.chocolapod.lwjgfont.AbstractFont;
import net.chocolapod.lwjgfont.example_demo.DragonquestfcH28Font;
import net.chocolapod.lwjgfont.myfont.Migu1pRegularH28Font;
import net.chocolapod.lwjgfont.texture.Texture;
import net.chocolapod.lwjgfont.texture.TextureLoader;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class DemoNameInput {

	public void start() {
		final String[]	characters = {
			"ア　イ　ウ　エ　オ　　ハ　ヒ　フ　ヘ　ホ　　”　゜",
			"カ　キ　ク　ケ　コ　　マ　ミ　ム　メ　モ　　ー",
			"サ　シ　ス　セ　ソ　　ラ　リ　ル　レ　ロ　　かな",
			"タ　チ　ツ　テ　ト　　ヤ　　　ユ　　　ヨ　　もどる",
			"ナ　ニ　ヌ　ネ　ノ　　ワ　　　ヲ　　　ン　　おわり",
		};
		
		Texture		background;
		Texture		hero;
		Texture		cursor;
		
		try {
			//  ウインドウを生成する
			Display.setDisplayMode(new DisplayMode(800, 640));
			Display.create();

			background = TextureLoader.loadTexture(DemoNameInput.class, "name_window.png");
			hero = TextureLoader.loadTexture(DemoNameInput.class, "hero.png");
			cursor = TextureLoader.loadTexture(DemoNameInput.class, "cursor.png");
		} catch(Exception e) {
			e.printStackTrace();
			return;
		}

		try {
			//  OpenGL の初期設定

			//  テクスチャーを有効化する
			GL11.glEnable(GL11.GL_TEXTURE_2D);

			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glLoadIdentity();
			GL11.glOrtho(0, 800, 0, 640, 0, 100);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);

			//	LWJGFont でフォントを読み込む
			AbstractFont	font = new Migu1pRegularH28Font();
			
			while (!Display.isCloseRequested()) {
				GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

				background.draw(0, 670);
				hero.draw(340, 595);
				cursor.draw(580, 100);
				
				//	LWJGFont で文字列を表示する
				int		dstY = 300;
				
				for (String line: characters) {
					font.drawString(line, 65, dstY, 0);
					dstY -= font.getLineHeight();
					dstY -= 16;
				}

//				font.drawString("なまえを　いれてください", 240, 450, 0);
				font.drawString("なまえを　いれてください", 240, 390, 0);
//				font.drawString("モモカ＊", 340, 520, 0);
				font.drawString("モモカ＊", 340, 460, 0);

				Display.update();
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			background.dispose();
			Display.destroy();
		}
	}

	public static void main(String[] args) {
		new DemoNameInput().start();
	}
}
