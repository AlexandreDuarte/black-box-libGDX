package com.hanzok.blackbox;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.ScreenUtils;
import com.hanzok.blackbox.gamescreen.GameBoard;
import com.hanzok.blackbox.ui.gamescreen.GameMenu;

public class GameScreen implements Screen {


    GameMenu gameMenu;
    GameBoard gameBoard;
    InputMultiplexer inputMultiplexer;

    public GameScreen(int boardSize) {
        gameBoard = new GameBoard(boardSize);
        gameMenu = new GameMenu(gameBoard);
        inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(gameBoard);
        inputMultiplexer.addProcessor(gameMenu);
    }


    @Override
    public void show() {

        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    @Override
    public void render(float delta) {

        gameBoard.update(delta);

        ScreenUtils.clear(Resources.background);

        gameMenu.render();
        gameBoard.render();

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
