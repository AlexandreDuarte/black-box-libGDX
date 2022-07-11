package com.hanzok.blackbox.ui.gameoverscreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Align;
import com.hanzok.blackbox.Resources;
import com.hanzok.blackbox.ui.BBButton;
import com.hanzok.blackbox.ui.BBListener;
import com.hanzok.blackbox.ui.BBListenerButton;
import com.hanzok.blackbox.ui.Element;

import java.util.ArrayList;
import java.util.List;

public class GameOver implements Element, BBListener, InputProcessor {


    List<BBButton> buttons;

    public static final int BACK_BUTTON = 0;


    public GameOver() {
        buttons = new ArrayList<BBButton>();
        BBButton backButton = new BBListenerButton(BACK_BUTTON, Gdx.graphics.getWidth()/2, 2*Gdx.graphics.getHeight()/3, "BACK", Resources.textFont, this, Align.center);
        buttons.add(backButton);
    }

    @Override
    public void onClick(BBListenerButton flb) {
        Resources.game.setScreen(Resources.mainMenuScreen);
    }

    @Override
    public void render() {
        Resources.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        for(int i = 0; i < buttons.size(); i++)
        {
            BBButton b = buttons.get(i);
            if(!b.isHidden())
            {
                b.drawBounds(Resources.shapeRenderer);
            }
        }
        Resources.shapeRenderer.end();



        Resources.batch.begin();
        for(int i = 0; i < buttons.size(); i++)
        {
            BBButton b = buttons.get(i);
            if(!b.isHidden())
            {
                b.drawText(Resources.batch);
            }
        }
        Resources.batch.end();
    }

    @Override
    public void update(float delta) {



    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
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
    public boolean touchDown(int screenX, int screenY, int pointer, int button)
    {

        float pointerX = screenX;
        float pointerY = Gdx.graphics.getHeight() - screenY;
        for(int i = 0; i < buttons.size(); i++)
        {
            if(buttons.get(i).contains(pointerX, pointerY))
            {
                if(!buttons.get(i).isHidden())
                {
                    buttons.get(i).setSelected(true);
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        float pointerX = screenX;
        float pointerY = Gdx.graphics.getHeight() - screenY;
        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).contains(pointerX, pointerY) && buttons.get(i).getSelected()) {
                buttons.get(i).execute();
            }
            buttons.get(i).setSelected(false);
        }
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
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}

