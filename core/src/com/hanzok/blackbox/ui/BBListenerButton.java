package com.hanzok.blackbox.ui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Align;
import com.hanzok.blackbox.ui.gamescreen.GameMenu;

public class BBListenerButton extends BBButton
{
    private BBListener ffListener;

    private int id;

    public BBListenerButton(int id, int x, int y, String text, BitmapFont font, BBListener ffListener) {
        super(x, y, text, font, Align.left);
        this.id = id;
        this.ffListener = ffListener;
    }

    public BBListenerButton(int id, int x, int y, String text, BitmapFont font, BBListener ffListener, int align) {
        super(x, y, text, font, align);
        this.id = id;
        this.ffListener = ffListener;
    }

    @Override
    protected void action()
    {
        ffListener.onClick(this);
    }

    public int getId() {
        return id;
    }
}
