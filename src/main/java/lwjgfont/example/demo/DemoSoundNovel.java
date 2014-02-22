package lwjgfont.example.demo;


import net.chocolapod.lwjgfont.AbstractFont;
import net.chocolapod.lwjgfont.example_demo.TkaishoGt01H32Font;
import net.chocolapod.lwjgfont.myfont.Migu1pRegularH28Font;
import net.chocolapod.lwjgfont.myfont.Migu1pRegularH45Font;
import net.chocolapod.lwjgfont.texture.Texture;
import net.chocolapod.lwjgfont.texture.TextureLoader;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class DemoSoundNovel {

	public void start() {
		Texture		background;
		
		try {
			//  ウインドウを生成する
			Display.setDisplayMode(new DisplayMode(800, 640));
			Display.create();

			background = TextureLoader.loadTexture(DemoSoundNovel.class, "shrine.png");
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
			AbstractFont	font = new TkaishoGt01H32Font();
			
			font.setColor(0f, 0f, 0f);
			
			while (!Display.isCloseRequested()) {
				GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

				background.draw(0, 640);
				
				//	LWJGFont で文字列を表示する
				font.drawParagraph(
						new String[] {
							"都の北",
							"人里離れた 雪深き山々の中に",
							"その地の人々の他には忘れ去られた",
							"古き時代よりの社があった",
							"\n",
							"白き雪に包まれ",
							"昼は陽の光で水面のごとく輝き",
							"夜は月の灯りに絹のようにきらめいていた",
							"\n",
							"そこには年老いた宮司と",
							"三人の巫女が暮らしていた"
						},
						50, 600, 0, 700, AbstractFont.ALIGN.RIGHT);

				Display.update();
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
//			background.dispose();
			Display.destroy();
		}
	}

	public static void main(String[] args) {
		new DemoSoundNovel().start();
	}
}
