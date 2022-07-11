package com.hanzok.blackbox.ui.mainscreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Align;
import com.hanzok.blackbox.BlackBox;
import com.hanzok.blackbox.GameScreen;
import com.hanzok.blackbox.Resources;
import com.hanzok.blackbox.ui.BBButton;
import com.hanzok.blackbox.ui.BBListener;
import com.hanzok.blackbox.ui.BBListenerButton;
import com.hanzok.blackbox.ui.Element;

import java.util.ArrayList;
import java.util.List;

public class MainMenu implements Element, BBListener, InputProcessor {


    final BlackBox game;
    List<BBButton> buttons;
    public static final int START_BUTTON = 0;
    public static final int STATS_BUTTON = 1;
    public static final int ABOUT_BUTTON = 2;


    public MainMenu(final BlackBox game, int offset) {
        this.game = game;
        buttons = new ArrayList<BBButton>();
        BBButton startButton = new BBListenerButton(START_BUTTON, Gdx.graphics.getWidth() / 2 - offset - 60, 3*Gdx.graphics.getHeight() / 5, "START", Resources.menuFont, this, Align.right);
        BBButton statsButton = new BBListenerButton(STATS_BUTTON, Gdx.graphics.getWidth() / 2 - offset - 60, 3*Gdx.graphics.getHeight() / 5 + (int)(3*startButton.height()/2), "STATS", Resources.textFont, this, Align.right);
        BBButton exitButton = new BBListenerButton(ABOUT_BUTTON, Gdx.graphics.getWidth() / 2 - offset - 60, 3*Gdx.graphics.getHeight() / 5 + (int)(3*startButton.height()/2) + (int)(3*statsButton.height()/2), "ABOUT", Resources.textFont, this, Align.right);

        buttons.add(startButton);
        buttons.add(statsButton);
        buttons.add(exitButton);
    }

    @Override
    public void onClick(BBListenerButton flb) {

        switch (flb.getId()) {
            case START_BUTTON:
                game.setScreen(new GameScreen(6));
                break;
            case STATS_BUTTON:

                break;
            case ABOUT_BUTTON:

                break;
        }

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
            }
        }
        return true;
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
        return true;
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
