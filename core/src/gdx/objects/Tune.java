//https://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/audio/Music.html > used for music
package gdx.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class Tune {

    public static Music music;

    public Tune() {
        music = Gdx.audio.newMusic(Gdx.files.internal("Cappuccino.mp3"));
        music.setLooping(true);
        music.setVolume(0.5f);
    }
}
