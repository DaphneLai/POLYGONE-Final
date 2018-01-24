package gdx.one;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class GdxOne extends Game {

    @Override
    public void create() {
        setScreen(new scrGame(this));
    }

    @Override
    public void render() {
        super.render(); //super = everything
    }
}
