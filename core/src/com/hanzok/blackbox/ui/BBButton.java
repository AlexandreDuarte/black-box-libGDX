package com.hanzok.blackbox.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Align;
import com.hanzok.blackbox.Resources;

public abstract class BBButton {

    private BitmapFont font;
    private Rectangle bounds;
    private CharSequence text;
    private GlyphLayout unselectedText;
    private GlyphLayout selectedText;
    private boolean selected;
    private boolean hidden;
    private boolean active;
    private boolean disabled;

    private float text_x, text_y;

    private int offsetx, offsety;

    public BBButton(int x, int y, CharSequence text, BitmapFont font, int align) {
        this.text = text;
        this.hidden = false;
        this.active = false;
        this.disabled = false;

        this.font = font;


        unselectedText = new GlyphLayout(font, text, 0, text.length(), font.getColor(), 0, align,
                false, null);
        selectedText = new GlyphLayout(font, text, 0, text.length(), Resources.beamColor1, 0, align,
                false, null);



        this.offsetx = -10;
        this.offsety = (int)unselectedText.height + 10;

        text_x = x+offsetx;
        text_y = Gdx.graphics.getHeight() - (y +offsety);

        switch (align) {
            case Align.center:
                this.offsetx -= unselectedText.width/2;
                break;
            case Align.right:
                this.offsetx -= unselectedText.width;
                break;
        }

        this.bounds = new Rectangle(x+offsetx, Gdx.graphics.getHeight() - (y +offsety), unselectedText.width+20, unselectedText.height+20);
    }

    protected abstract void action();

    public void execute()
    {
        if(!disabled)
        {
            action();
        }
    }


    public boolean contains(float x, float y)
    {
        return bounds.contains(x, y);
    }

    public float x()
    {
        return bounds.x;
    }

    public float y()
    {
        return bounds.y;
    }

    public float width()
    {
        return bounds.width;
    }

    public float height()
    {
        return bounds.height;
    }

    public void drawBounds(ShapeRenderer shapeRenderer)
    {

    }

    public void drawText(SpriteBatch batch)
    {
        if(hidden != true)
        {
            if (selected) {
                font.draw(batch, selectedText, text_x+10, text_y+offsety-10);

            } else {
                font.draw(batch, unselectedText, text_x+10, text_y+offsety);
            }

        }
    }

    public boolean getSelected()
    {
        return selected;
    }

    public BBButton setSelected(boolean selected)
    {
        this.selected = selected;
        return this;
    }

    public boolean isActive()
    {
        return active;
    }

    public BBButton setActive(boolean active)
    {
        this.active = active;
        return this;
    }

    public boolean isHidden()
    {
        return hidden;
    }

    public BBButton setHidden(boolean hidden)
    {
        this.hidden = hidden;
        return this;
    }

    public Rectangle getBounds()
    {
        return bounds;
    }

    public boolean isDisabled()
    {
        return disabled;
    }

    public void setDisabled(boolean disabled)
    {
        this.disabled = disabled;
    }
}
