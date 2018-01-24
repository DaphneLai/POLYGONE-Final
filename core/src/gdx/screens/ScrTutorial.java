package gdx.screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import gdx.objects.Button;
import gdx.menu.GamMenu;
public class ScrTutorial implements Screen, InputProcessor {
    GamMenu game;
    BitmapFont bfFont;
    SpriteBatch batch;
    String sTxt;
    Texture txtBG, txtInstruct;
    Button btnBack;
    int nW, nH;
    public ScrTutorial(GamMenu _game) {
        game = _game;
        FileHandle fileHandle = Gdx.files.internal("Tutorial.txt");
        sTxt = new String(fileHandle.readString());
        txtBG = new Texture("TutorialBG.png");
        batch = new SpriteBatch();
        bfFont = new BitmapFont(Gdx.files.internal("font.fnt"));
        bfFont.setColor(Color.BLACK);
        bfFont.getData().setScale(1f, 1f);
        nW = Gdx.graphics.getWidth();
        nH = Gdx.graphics.getHeight();
        btnBack = new Button(900, 20, "Back.png");
        btnBack.setSize(200, 200);
    }
    @Override
    public void show() {
        return;
    }
    @Override
    public void render(float delta) {
        HandleInput();
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        // bfFont.draw(batch, sTxt, 200, 720);
        
//        batch.draw(txtInstruct, nW / 2 - txtInstruct.getWidth() / 2, nH / 2 - txtInstruct.getHeight() / 2);
        batch.draw(txtBG, 0, 0, nW, nH); //Background
        bfFont.draw(batch, sTxt, 50, nH);
        btnBack.draw(batch);
        batch.end();
    }
    public void HandleInput() {
        if (Gdx.input.justTouched()) {
            if (btnBack.isMousedOver()) {
                game.updateState(0);
                System.out.println("WOOT");
            }
        }
    }
    @Override
    public void resize(int width, int height) {
        return;
    }
    @Override
    public void pause() {
        return;
    }
    @Override
    public void resume() {
        return;
    }
    @Override
    public void hide() {
        return;
    }
    @Override
    public void dispose() {
        return;
    }
    @Override
    public boolean keyDown(int keycode) {
        return true;
    }
    @Override
    public boolean keyUp(int keycode) {
        return false;
    }
    @Override
    public boolean keyTyped(char character) {
        return false;
    }
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }
    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }
    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
