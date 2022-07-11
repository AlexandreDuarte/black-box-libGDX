package com.hanzok.blackbox.ui.mainscreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.hanzok.blackbox.Resources;
import com.hanzok.blackbox.ui.Element;

public class TitleElement implements Element {


    GlyphLayout title1, title2;

    int titleDelta;

    public TitleElement() {
        title1 = new GlyphLayout(Resources.titleFont, "BLACK");
        title2 = new GlyphLayout(Resources.titleFont, "BOX");

        titleDelta = (int)((title1.width+title2.width)/2 - title1.width);

    }

    @Override
    public void render() {
        Resources.titleFont.draw(Resources.batch, title1, Gdx.graphics.getWidth()/2.0f - (title1.width+title2.width)/2 - 40, 2.0f*Gdx.graphics.getHeight()/3);
        Resources.titleFont.draw(Resources.batch, title2, Gdx.graphics.getWidth()/2.0f - (title1.width+title2.width)/2 + title1.width + 40, 2.0f*Gdx.graphics.getHeight()/3);
    }

    @Override
    public void update(float delta) {

    }

    public int getTitleDelta() {
        return titleDelta;
    }

    public float getHeight() {
        return title1.height;
    }

}
