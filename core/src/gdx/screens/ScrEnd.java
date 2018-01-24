package gdx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import gdx.menu.GamMenu;
import gdx.objects.Button;
import gdx.objects.Tune;
import gdx.objects.Score;

public class ScrEnd implements Screen, InputProcessor {

    GamMenu game;
    Score score;
    Tune tune;
    SpriteBatch batch;
    Button btnReplay, btnHome, btnSound, btnMute;
    Texture txtBG, txtTitle, txtScore;
    BitmapFont font;
    int nW;

    public ScrEnd(GamMenu _game) {
        game = _game;

        tune = new Tune();
        batch = new SpriteBatch();
        nW = Gdx.graphics.getWidth();
        btnReplay = new Button(nW - 490, 380, "Retry.png");
        btnHome = new Button(nW - 490, 260, "Home.png");
        btnSound = new Button(nW - 450, 20, "Volume.png");
        btnMute = new Button(nW - 250, 20, "Mute.png");
        txtBG = new Texture("MainBG.jpg");
        txtScore = new Texture("Score2.png");
        txtTitle = new Texture("Title.png");
        font = new BitmapFont(Gdx.files.internal("font2.fnt"));
        font.getData().setScale(3f, 3f);

    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        HandleInput();
        batch.begin();
        batch.draw(txtBG, - Gdx.graphics.getWidth() / 2, 0);
        batch.draw(txtTitle, nW - txtTitle.getWidth() - 20, 580);
        batch.draw(txtScore, nW / 4 - txtScore.getWidth() / 2, 220);
        font.draw(batch, Integer.toString(score.Points), txtScore.getWidth() / 2 - 10, 380);
        btnReplay.draw(batch);
        btnHome.draw(batch);
        btnSound.draw(batch);
        btnMute.draw(batch);
        batch.end();
    }

    public void HandleInput() { //Brain's (Joel and Alex) code (modified)
        if (Gdx.input.justTouched()) {
            if (btnReplay.isMousedOver()) {
                ScrMain.sdClick.play();
                score.Points = 0;
                ScrGame.nTime = 30;
                game.updateState(1);
            } else if (btnHome.isMousedOver()) {
                ScrMain.sdClick.play();
                game.updateState(0);
                System.out.println("HOME");
            } else if (btnSound.isMousedOver()) {
                ScrMain.sdClick.play();
                Tune.music.play();
                System.out.println("SOUND");
            } else if (btnMute.isMousedOver()) {
                Tune.music.pause();
                System.out.println("MUTE");
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
        txtBG.dispose();
        txtTitle.dispose();
        txtScore.dispose();
        font.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        return true;

    }

    @Override
    public boolean keyTyped(char character) {
        return true;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return true;
    }

    @Override
    public boolean scrolled(int amount) {
        return true;
    }
}
