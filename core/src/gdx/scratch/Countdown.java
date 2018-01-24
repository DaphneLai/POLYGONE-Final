//Ameer's code (modified)
package gdx.scratch;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
import gdx.menu.GamMenu;
import gdx.objects.Button;

public class Countdown implements Screen {

    GamMenu game;
    BitmapFont font;
    Button btnBack;
    SpriteBatch batch;
    Timer timer;
    int nTime = 60;
    boolean isOn;

    public Countdown(GamMenu _game) {
        game = _game;
        batch = new SpriteBatch();
        btnBack = new Button(900, 20, "Back.png");
        btnBack.setSize(200, 200);
        timer = new Timer();
        isOn = false;
        font = new BitmapFont(Gdx.files.internal("font2.fnt")); //also: font.fnt, font3.fnt, Arial.fnt
        font.setColor(Color.BLACK);
        font.getData().setScale(3f, 3f);

    }

    @Override
    public void render(float delta) {
        HandleInput();
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        font.draw(batch, Integer.toString(nTime), 40, 700); // where on screen it will appear
        btnBack.draw(batch);
        batch.end();
        if (nTime <= 0) {
            Gdx.app.exit(); // once timer is done, screen closes
        }
        if (!isOn) {
            isOn = true; // while isOn is true, count down the time 
            timer.scheduleTask(new Timer.Task() {
                @Override
                public void run() {
                    nTime--;
                }
            }, 0, 1);
        }
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
    public void dispose() {
    }

    @Override
    public void show() {
        return;
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
}
