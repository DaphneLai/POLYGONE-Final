package gdx.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;

public class Score {

    Sound sdCorrect, sdWrong;
    boolean oneWasPressed = false;
    public static int nNum, Points; //https://www.youtube.com/watch?v=cGqq59-Kd7Y creating score countdown

    public Score() {
        sdCorrect = Gdx.audio.newSound(Gdx.files.internal("Right.mp3")); //http://soundbible.com/free-sound-effects-1.html >finding sounds
        sdCorrect.setVolume(0, 0.5f);
        sdWrong = Gdx.audio.newSound(Gdx.files.internal("Wrong.mp3"));
        sdWrong.setVolume(0, 0.5f);
    }

    public static boolean isCorrect(int _nShp, int _nNum) {
        int nNum = _nNum;
        int nShp = _nShp;
        if (nNum == 3 && nShp == 0) {
            return true;
        } else if (nNum == 4 && nShp == 1) {
            return true;
        } else if (nNum == 5 && nShp == 2) {
            return true;
        } else if (nNum == 6 && nShp == 3) {
            return true;
        } else if (nNum == 7 && nShp == 4) {
            return true;
        } else if (nNum == 8 && nShp == 5) {
            return true;
        } else if (nNum == 9 && nShp == 6) {
            return true;
        } else if (nNum == 10 && nShp == 7) {
            return true;
        } else if (nNum == 11 && nShp == 8) {
            return true;
        } else if (nNum == 12 && nShp == 9) {
            return true;
        } else if (nNum == 13 && nShp == 10) {
            return true;
        }
        return false;
    }

    public void checkInputs() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_0)) {
            if (oneWasPressed) {
                nNum = 10;
                oneWasPressed = false;
            } else {
                nNum = 0;
            }
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_1)) {
            if (!oneWasPressed) {
                nNum = 1;
                oneWasPressed = true;
            } else {
                nNum = 11;
                oneWasPressed = false;
            }
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_2)) {
            if (oneWasPressed) {
                nNum = 12;
                oneWasPressed = false;
            } else {
                nNum = 2;
            }
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_3)) {
            if (oneWasPressed) {
                nNum = 13;
                oneWasPressed = false;
            } else {
                nNum = 3;
            }
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_4)) {
            nNum = 4;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_5)) {
            nNum = 5;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_6)) {
            nNum = 6;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_7)) {
            nNum = 7;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_8)) {
            nNum = 8;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_9)) {
            nNum = 9;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            oneWasPressed = false;
            System.out.println(nNum);
            if (isCorrect(gdx.screens.ScrGame.nShp, nNum) == true) {
                Points += 10;
                nNum = 0;
                sdCorrect.play();
                //Score.addScore(10);
                System.out.println("CORRECT");
            } else {
                //Score.subScore(5);
                Points -= 5;
                nNum = 0;
                sdWrong.play();
                System.out.println("INCORRECT");
            }
        }
    }

}
