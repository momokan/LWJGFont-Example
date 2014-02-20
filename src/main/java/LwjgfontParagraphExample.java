

import net.chocolapod.lwjgfont.myfont.Migu1pRegularH28Font;
import net.chocolapod.lwjgfont.myfont.Migu1pRegularH45Font;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class LwjgfontParagraphExample {

	public void start() {
		try {
			//  ウインドウを生成する
			Display.setDisplayMode(new DisplayMode(550, 300));
			Display.create();
		} catch(LWJGLException e) {
			e.printStackTrace();
			return;
		}

		try {
			//  OpenGL の初期設定

			//  テクスチャーを有効化する
			GL11.glEnable(GL11.GL_TEXTURE_2D);

			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glLoadIdentity();
			GL11.glOrtho(0, 550, 0, 300, 0, 100);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);

			//	LWJGFont でフォントを読み込む
			Migu1pRegularH28Font	font = new Migu1pRegularH28Font();
			
			//	フォントの色を設定する
			font.setColor(0f, 1f, 0f);

			while (!Display.isCloseRequested()) {
				GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

				//	LWJGFont で文字列を表示する
				font.drawParagraph(
						"LWJGFont は、日本語などの英語以外の言語をビットマップフォントとして\r画面表示する際の課題を解決するために開発されました。\nあらかじめ任意のフォントで任意のサイズの文字を PNG 画像としてマッピングし、プログラム実行時には表示したい文章をその PNG 画像から自動で構築・画面表示することができます。",
						500,
						10, 250, 0);

				Display.update();
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			Display.destroy();
		}
	}

	public static void main(String[] args) {
		new LwjgfontParagraphExample().start();
	}
}
