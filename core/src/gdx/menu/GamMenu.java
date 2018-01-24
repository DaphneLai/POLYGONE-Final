//Kieran's code (modified)
package gdx.menu;

import com.badlogic.gdx.Game;
import gdx.screens.ScrMain;
import gdx.screens.ScrGame;
import gdx.screens.ScrEnd;
import gdx.scratch.NumInput;
import gdx.screens.ScrTutorial;
import gdx.scratch.Countdown;

public class GamMenu extends Game {

    ScrMain scrMain;
    public ScrGame scrGame;
    ScrEnd scrEnd;
    ScrTutorial scrTutorial;
    NumInput numInput;
    Countdown countdown;
    int nNum = 0;
    int nScreen; // 0 for menu, 1 for play, 2 for gameover, 3 for options

    public void updateState(int _nScreen) {
        nScreen = _nScreen;
        switch (nScreen) {
            case 0:
                setScreen(scrMain);
                break;
            case 1:
                setScreen(scrGame);
                break;
            case 2:
                setScreen(scrEnd);
                break;
            case 3:
                setScreen(scrTutorial);
                break;
            case 10:
                setScreen(numInput);
                break;
            case 20:
                setScreen(countdown);
                break;
            default:
                break;
        }
    }

    @Override
    public void create() {
        nScreen = 0;
        // notice that "this" is passed to each screen. Each screen now has access to methods within the "game" master program
        scrMain = new ScrMain(this);
        scrGame = new ScrGame(this);
        scrEnd = new ScrEnd(this);
        scrTutorial = new ScrTutorial(this);
        numInput = new NumInput(this);
        countdown = new Countdown(this);
        updateState(0);
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
