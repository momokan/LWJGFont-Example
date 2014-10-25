package lwjgfont.exmaple.slick2d;

import java.io.IOException;

import net.chocolapod.lwjgfont.LWJGFont;
import net.chocolapod.lwjgfont.example_demo.Migu1pRegularH45Font;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.renderer.Renderer;

public class LWJGFontOnSlick2D extends BasicGame{
	//フォントの読み込み
	private LWJGFont	font = new Migu1pRegularH45Font();
	
	public LWJGFontOnSlick2D(){
		super("タイトル");
	}

	//描画処理
	public void render(GameContainer arg0, Graphics g) throws SlickException {
		try {
//			drawStringWithLWJGFont(g, "はろー", 100, 100);
			font.drawString("はろー", 100, 100, 0);
		} catch (IOException e) { e.printStackTrace(); }
	}

	/**
	 *  Slick2D ではデフォルトで画面左上が原点となるが、
	 *  LWJGFont ver1.1 ではデフォルトで画面左下が原点となるよう glOrtho が呼ばれる。
	 *  なので、LWJGFont で文字列表示する際には X 軸を中心に 180 度回転させた上で表示を行う。
	 */
	public void drawStringWithLWJGFont(Graphics g, String text, int x, int y) throws IOException {
		// Slick2D の座標系設定は
		// org.newdawn.slick.opengl.renderer.ImmediateModeOGLRenderer.enterOrtho(int, int)
		// で行われている。
		
		// 移動・回転を行うため、行列スタックに現在の行列を退避させる
		g.pushTransform();

		// 原点（回転の中心点）を文字列の表示位置に移動する
		Renderer.get().glTranslatef(x, y + (font.getLineHeight() / 2), 0);
		// 原点を通る X 軸を中心に 180 度回転させ、Y 座標の方向を逆転させる
		Renderer.get().glRotatef(180, 1, 0, 0);
		
		// 原点に LWJGFont で文字列を表示する
		font.drawString(text, 0, 0, 0);
		
		// 行列スタックからもとの行列を取り出し、移動・回転前の状態に戻す
		g.popTransform();
	}

	//初期処理
	public void init(GameContainer arg0) throws SlickException {}

	//更新処理
	public void update(GameContainer arg0, int arg1) throws SlickException {}
	
	public static void main(String[] args) throws SlickException{
		AppGameContainer app = new AppGameContainer(new LWJGFontOnSlick2D());
		app.setTargetFrameRate(60);
		app.setDisplayMode(640,480,false);
		app.start();
	}
}