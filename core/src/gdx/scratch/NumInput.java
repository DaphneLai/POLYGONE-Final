package gdx.scratch;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import gdx.menu.GamMenu;
import gdx.objects.Button;

public class NumInput implements Screen, InputProcessor { //https://github.com/libgdx/libgdx/wiki/Event-handling > used for Input Processor
    GamMenu game;
    String sNum;
    BitmapFont font;
    Button btnBack;
    SpriteBatch batch;

    public NumInput(GamMenu _game) {
        game = _game;
        sNum = "";
        batch = new SpriteBatch(); //http://www.angelcode.com/products/bmfont/ > creating font/ downloading font
        font = new BitmapFont(Gdx.files.internal("font2.fnt")); //https://www.youtube.com/watch?v=vZElAQUZLSg > used for finding fonts, https://stackoverflow.com/questions/28908629/android-java-libgdx-text-file used for importing file of fonts into code
        font.getData().setScale(3f, 3f);
 btnBack = new Button(900, 20, "Back.png");
        btnBack.setSize(200, 200);
    }

    @Override
    public void show() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return;
    }

    @Override
    public void render(float delta) {
        HandleInput();
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        btnBack.draw(batch);
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_0)) { //https://www.youtube.com/watch?v=IsYhkng3r1k > used for keycodes
            sNum += "0";
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_1)) {
            sNum += "1";
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_2)) {
            sNum += "2";
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_3)) {
            sNum += "3";
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_4)) {
            sNum += "4";
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_5)) {
            sNum += "5";
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_6)) {
            sNum += "6";
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_7)) {
            sNum += "7";
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_8)) {
            sNum += "8";
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_9)) {
            sNum += "9";
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            System.out.println(sNum);
            sNum = "";
        }
        font.draw(batch, sNum, 200, 200); //https://www.youtube.com/watch?v=vZElAQUZLSg > used for displaying fonts on screen
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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return;
    }

    @Override
    public void pause() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return;
    }

    @Override
    public void resume() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return;
    }

    @Override
    public void hide() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return;
    }

    @Override
    public void dispose() {
        // font.dispose();
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return;
    }

    @Override
    public boolean keyDown(int keycode) {
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return true;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return true;
    }

    @Override
    public boolean scrolled(int amount) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return true;
    }
}
