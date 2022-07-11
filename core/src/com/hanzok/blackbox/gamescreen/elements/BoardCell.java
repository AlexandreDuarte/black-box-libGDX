package com.hanzok.blackbox.gamescreen.elements;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.hanzok.blackbox.Resources;
import com.hanzok.blackbox.ui.Element;

public abstract class BoardCell implements Element {

    Rectangle bounds;
    boolean active = false;

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    @Override
    public void render() {

    }

    @Override
    public void update(float delta) {

    }

    public abstract void execute();

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }
}
