package gdx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import gdx.menu.GamMenu;
import gdx.objects.Button;
import gdx.objects.Tune;

public class ScrMain implements Screen, InputProcessor { //libgdx intersector class

    SpriteBatch batch;
    public static Sound sdClick;
    GamMenu game;
    Texture txtBG, txtPlay, txtTitle, txtTutorial, txtSound, txtMute;
    Button btnPlay, btnTut, btnSound, btnMute, btnScratch1, btnScratch2;
    boolean isMute = false;

    public ScrMain(GamMenu _game) {
        game = _game;

        sdClick = Gdx.audio.newSound(Gdx.files.internal("Click.mp3"));
        sdClick.setVolume(0, 0.5f);
        txtBG = new Texture("MainBG.jpg");
        txtTitle = new Texture("Title.png");
        txtSound = new Texture("Volume.png");
        txtMute = new Texture("Mute.png");
        btnPlay = new Button(20, 380, "Start.png");
        btnTut = new Button(20, 260, "Tutorial.png");
        btnSound = new Button(90, 20, "Volume.png");
        btnMute = new Button(250, 20, "Mute.png");
        btnScratch1 = new Button(950, 190, "Scratch-1.png");
        btnScratch1.setSize(100, 100);
        btnScratch2 = new Button(950, 100, "Scratch-2.png");
        btnScratch2.setSize(100, 100);
        batch = new SpriteBatch();

    }

    public void createShape() {
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        HandleInput();
        Tune.music.play();
        batch.begin();
        batch.draw(txtBG, 0, 0);
        batch.draw(txtTitle, 20, 580);
        btnPlay.draw(batch);
        btnTut.draw(batch);
        btnSound.draw(batch);
        btnMute.draw(batch);
        btnScratch1.draw(batch);
        btnScratch2.draw(batch);
        batch.end();

        if (isMute) {
            Tune.music.pause();
        } else {
            Tune.music.play();
        }
    }

    public void HandleInput() {
        if (Gdx.input.justTouched()) {
            if (btnPlay.isMousedOver()) {
                sdClick.play();
                game.updateState(1);
            } else if (btnTut.isMousedOver()) {
                sdClick.play();
                game.updateState(3);
                System.out.println("TUTORIAL");
            } else if (btnSound.isMousedOver()) {
                sdClick.play();
                isMute = false;
                System.out.println("SOUND");
            } else if (btnMute.isMousedOver()) {
                isMute = true;
                System.out.println("MUTE");
            } else if (btnScratch1.isMousedOver()) {
                game.updateState(10);
                System.out.println("NUMINPUT");
            } else if (btnScratch2.isMousedOver()) {
                game.updateState(20);
                System.out.println("COUNTDOWN");
            }
        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        batch.dispose();
        sdClick.dispose();
        txtBG.dispose();
        txtPlay.dispose();
        txtTitle.dispose();
        txtTutorial.dispose();
        txtSound.dispose();
        txtMute.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean keyUp(int keycode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean keyTyped(char character) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean scrolled(int amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
