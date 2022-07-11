package com.hanzok.blackbox;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;
import com.hanzok.blackbox.ui.gameoverscreen.GameOver;

public class GameOverScreen implements Screen {

    GameOver gameOver;

    public GameOverScreen() {
        gameOver = new GameOver();
    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(gameOver);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Resources.background);
        gameOver.render();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
