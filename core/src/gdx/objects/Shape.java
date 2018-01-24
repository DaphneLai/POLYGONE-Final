package gdx.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Shape extends Sprite {

    float fX, fY, fStartY, fYSpeed, fGravity;
    int nWShp, nHShp;
    boolean isDown = false;
    public static boolean ifEnd = false;

    public Shape(float _fY, String sFile) {
        super(new Texture(Gdx.files.internal(sFile)));
        fX = Gdx.graphics.getWidth() / 2 - 100;
        fY = _fY;
        fYSpeed = 0;
        fGravity = -0.5f;
        nWShp = 200;
        nHShp = 200;
        fStartY = Gdx.graphics.getHeight() / 2 - 100;
        setPosition(fX, fStartY);
        setFlip(false, false);
        setSize(nWShp, nHShp);
    }

    public void goDown() {
        if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
            isDown = true;
        }
        if (isDown == true) {
            fY -= fYSpeed;
            fYSpeed -= fGravity;
            setY(fY);
        }
    }

}
