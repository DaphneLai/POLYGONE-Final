package gdx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
import gdx.menu.GamMenu;
import gdx.objects.Shape;
import gdx.objects.Score;
import java.util.Random;

public class ScrGame implements Screen, InputProcessor {

    GamMenu game;
    Score score;
    BitmapFont bfFont;
    Random rand = new Random();
    SpriteBatch batch;
    String sClr[], _sClr, sSide[], _sSide;
    Shape arshpShapes[][] = new Shape[11][4], shpDisplay; //short for arsprShapes[nShp][nClr]
    Timer timer = new Timer();
    Texture txtBG, txtAnswer, txtTimer, txtScore;
    int nW, nH, nClr;
    public static int nTime = 30, nShp;
    float fY;
    boolean isOn = false;

    public ScrGame(GamMenu _game) {
        game = _game;

        bfFont = new BitmapFont(Gdx.files.internal("font2.fnt")); //also: font.fnt, font3.fnt, Arial.fnt
        bfFont.setColor(Color.BLACK);
        bfFont.getData().setScale(3f, 3f);
        batch = new SpriteBatch();
        txtBG = new Texture("GameBG.jpg");
        txtAnswer = new Texture("Answer.png");
        txtTimer = new Texture("Time.png");
        txtScore = new Texture("Score1.png");
        fY = Gdx.graphics.getHeight() / 2 - 100;
        nShp = rand.nextInt(10); //nShp = nShape
        nClr = rand.nextInt(2); //nClr = nColour
        nW = Gdx.graphics.getWidth();
        nH = Gdx.graphics.getHeight();
        score = new gdx.objects.Score();

        //(Grondin's idea)2D ARRAY  https://stackoverflow.com/questions/12231453/syntax-for-creating-a-two-dimensional-array 
        String sClr[] = new String[]{"B", "O", "P", "G"};
        String sSide[] = new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11"};
        for (int i = 0; i < 11; i++) {
            _sSide = sSide[i];
            for (int l = 0; l < 4; l++) {
                _sClr = sClr[l];
                arshpShapes[i][l] = new Shape(fY, "Polygone" + _sClr + "-" + _sSide + ".png");
            }
        }
    }

    @Override
    public void show() {
        return;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        //TEXTURE
        batch.draw(txtBG, 0, 0, nW, nH); //Background
        batch.draw(txtTimer, 10, 660);
        batch.draw(txtAnswer, 10, 100);
        batch.draw(txtScore, 750, 660);

        //SHAPE
        shpDisplay = arshpShapes[nShp][nClr];
        if (shpDisplay.getY() <= -400) {
            nShp = rand.nextInt(11); //Randomly picks a shape
            nClr = rand.nextInt(4); //Randomly picks a colour
            arshpShapes[nShp][nClr].setY(fY);
            System.out.println("Shape: " + nShp);
            System.out.println("Colour: " + nClr);
        }
        shpDisplay.goDown();
        shpDisplay.draw(batch);

        //TIMER
        bfFont.draw(batch, Integer.toString(nTime), 60, 650); // Location
        if (nTime <= 0) {
            nTime = 30;
            game.updateState(2); // once timer is done, screen closes
        }
        if (!isOn) {
            isOn = true; // while isOn is true, countdown the time 
            timer.scheduleTask(new Timer.Task() {
                @Override
                public void run() {
                    nTime--;
                }
            }, 0, 1);
        }

        //SCORE
        score.checkInputs();
        bfFont.draw(batch, Integer.toString(score.Points), 850, 650);

        //ANSWER
        bfFont.draw(batch, Integer.toString(score.nNum), 40, 90);

        batch.end();
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
        bfFont.dispose();
        batch.dispose();
        txtBG.dispose();
        txtAnswer.dispose();
        txtTimer.dispose();
        txtScore.dispose();
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
