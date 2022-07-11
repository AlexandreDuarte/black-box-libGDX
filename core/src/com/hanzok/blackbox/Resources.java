package com.hanzok.blackbox;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.hanzok.blackbox.ui.mainscreen.MainMenu;

public class Resources {

    public static BitmapFont titleFont;
    public static BitmapFont menuFont;
    public static BitmapFont textFont;
    public static OrthographicCamera camera;
    public static ShapeRenderer shapeRenderer;
    public static SpriteBatch batch;

    public static MainMenuScreen mainMenuScreen;

    public static BlackBox game;

    public static Color titleColor = new Color(0xF5F5F5FF);
    public static Color beamColor1 = new Color(0xF05454FF);
    public static Color beamColor2 = new Color(0x30475EFF);
    public static Color pastelBlueOutline = new Color(0xC3DBD9FF);
    public static Color background = new Color(0x121214FF);
    public static Color board = new Color(0x222125FF);

}
