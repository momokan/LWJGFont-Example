package lwjgfont.example.demo;


import net.chocolapod.lwjgfont.myfont.Migu1pRegularH28Font;
import net.chocolapod.lwjgfont.myfont.Migu1pRegularH45Font;
import net.chocolapod.lwjgfont.texture.Texture;
import net.chocolapod.lwjgfont.texture.TextureLoader;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class DemoMonologue {

	public void start() {
		Texture		background;
		
		try {
			//  ウインドウを生成する
			Display.setDisplayMode(new DisplayMode(800, 640));
			Display.create();

			background = TextureLoader.loadTexture(DemoMonologue.class, "monologue.png");
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
			Migu1pRegularH28Font	font = new Migu1pRegularH28Font();
			
			while (!Display.isCloseRequested()) {
				GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

				background.draw(0, 640);
				
				//	LWJGFont で文字列を表示する
				font.drawString("長きにわたって続いた戦乱の時代も、\n先の獅子王の活躍により終止符が打たれた。\n戦いで荒れ果てた大地も癒え始めたかに見えていた。", 20, 100, 0);

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
		new DemoMonologue().start();
	}
}
