package gdx.one;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class scrGame implements Screen, InputProcessor {

    Game game;
    SpriteBatch batch;
    Texture txt;
    ShapeRenderer SR;
    Sprite sprBob;
    float[] fPoints ;

    public scrGame(Game game) {
        game = game;
        txt = new Texture("badlogic.jpg");
        batch = new SpriteBatch();
        SR = new ShapeRenderer();
        sprBob = new Sprite(txt);
//        fPoints = new float[10];
//        Gdx.input.setInputProcessor(this);
//        for(int i = 0; i < 10; i++){
//            fPoints[i] = i;
//        }
        fPoints =  new float[]{0, 200, 200, 600, 300, 1000, 400, 1400};
    }

    @Override
    public void show() {
        return;

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        SR.begin(ShapeType.Line);
                SR.setColor(0.21f, 0.91f, 0.95f, 1);
        SR.polygon(fPoints);
        SR.end();

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
        batch.dispose();
        txt.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {

        if (keycode == Input.Keys.UP) {
            sprBob.setY(sprBob.getY() + 10);
            System.out.println("UP");
        } else if (keycode == Input.Keys.DOWN) {
            sprBob.setY(sprBob.getY() - 10);
        } else if (keycode == Input.Keys.LEFT) {
            sprBob.setX(sprBob.getX() - 10);
        } else if (keycode == Input.Keys.RIGHT) {
            sprBob.setX(sprBob.getX() + 10);
        } else {
            System.out.println("Zappa for President");
        }
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
