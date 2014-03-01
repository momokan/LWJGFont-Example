package lwjgfont.example;



import net.chocolapod.lwjgfont.LWJGFont;
import net.chocolapod.lwjgfont.example_demo.Migu1pRegularH45Font;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class LwjgfontExample {

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
			LWJGFont	font = new Migu1pRegularH45Font();
			
			//	フォントの色を設定する
			font.setColor(0f, 1f, 0f);

			while (!Display.isCloseRequested()) {
				GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

				//	LWJGFont で文字列を表示する
				font.drawString("ハロー☆LWJGFont", 50, 200, 0);

				Display.update();
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			Display.destroy();
		}
	}

	public static void main(String[] args) {
		new LwjgfontExample().start();
	}
}
