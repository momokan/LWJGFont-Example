package lwjgfont.example.blog.entry20140225;


import net.chocolapod.lwjgfont.LWJGFont;
import net.chocolapod.lwjgfont.example_demo.TkaishoGt01H32Font;
import net.chocolapod.lwjgfont.texture.FontTexture;
import net.chocolapod.lwjgfont.texture.FontTextureLoader;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Entry20140225 {

	public void start() {
		int			width = 650;
		int			height = 200;
		FontTexture		background;
		
		try {
			//  ウインドウを生成する
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.setTitle("LWJGFont Demo");
			Display.create();

			background = FontTextureLoader.loadTexture(Entry20140225.class, "washi.jpg");
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
			GL11.glOrtho(0, width, 0, height, 0, 100);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);

			//	LWJGFont でフォントを読み込む
			LWJGFont	font = new TkaishoGt01H32Font();
			
			font.setColor(0f, 0f, 0f);
			
			while (!Display.isCloseRequested()) {
				GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

				background.draw(0, 360);
				
				//	LWJGFont の描画色を設定する
//				font.setColor(0.75f, 0.3f, 0.3f);

				//	LWJGFont の透過色を設定する
//				font.setAlpha(0.4f);
				
				//	LWJGFont で文字列を表示する
//				font.drawString("いろはにほへと ちりぬるを", 100, 50, 0);
				
				//	LWJGFont で文字列を右詰めで折り返し表示する
				font.drawParagraph("いろはにほへと ちりぬるを わかよたれそ つねならむ\nうゐのおくやま けふこえて あさきゆめみし ゑひもせす", 100, 150, 0, 450, LWJGFont.ALIGN.RIGHT);
				
				//	文字列の表示幅を取得する
//				int		stringWidth = font.stringWidth("いろはにほへと ちりぬるを"); 
				
				/*
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
						20, height, 0, width - 40, AbstractFont.ALIGN.RIGHT);
				*/

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
		new Entry20140225().start();
	}
}
