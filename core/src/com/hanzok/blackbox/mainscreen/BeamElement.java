package com.hanzok.blackbox.mainscreen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.hanzok.blackbox.Resources;
import com.hanzok.blackbox.ui.Element;

public class BeamElement implements Element {

    private int width = 0;
    int targetWidth;
    int ypos;
    float delay;
    Color color;
    boolean vertical;

    public BeamElement(int targetWidth, float delay, int ypos, Color color, boolean vertical) {
        this.targetWidth = targetWidth;
        this.delay = delay;
        this.ypos = ypos;
        this.color = color;
        this.vertical = vertical;
    }

    public void update(float delta) {
        if (width < targetWidth)
            width += targetWidth*delta/delay;
    }

    public void render() {
        if (vertical) {
            Resources.shapeRenderer.setColor(color.cpy().mul(0.7f));
            Resources.shapeRenderer.rect(ypos+5, 0, 50, width+10);
            Resources.shapeRenderer.setColor(color);
            Resources.shapeRenderer.rect(ypos, 0, 50, width);
        } else {
            Resources.shapeRenderer.setColor(color.cpy().mul(0.7f));
            Resources.shapeRenderer.rect(0, ypos-5, width+10, 50);
            Resources.shapeRenderer.setColor(color);
            Resources.shapeRenderer.rect(0, ypos, width, 50);
        }


    }

    public int getWidth() {
        return width;
    }

}
