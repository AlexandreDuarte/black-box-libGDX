package com.hanzok.blackbox.gamescreen.elements;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.hanzok.blackbox.Resources;

public class HiddenBoardCell extends BoardCell {


    public HiddenBoardCell(Rectangle bounds) {
        setBounds(bounds);
    }

    @Override
    public void execute() {
        setActive(!isActive());
    }

    @Override
    public void render() {
        if (active) {
            Resources.shapeRenderer.rect(bounds.x, bounds.y, bounds.width, bounds.height);
        } else {
            Resources.shapeRenderer.end();
            Resources.shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
            Resources.shapeRenderer.setColor(Resources.board);
            Resources.shapeRenderer.rect(bounds.x, bounds.y, bounds.width, bounds.height);
            Resources.shapeRenderer.end();
            Resources.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            Resources.shapeRenderer.setColor(Resources.board);
        }
    }
}
