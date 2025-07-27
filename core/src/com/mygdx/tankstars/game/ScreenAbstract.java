package com.mygdx.tankstars.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
public abstract class ScreenAbstract {
//    protected Vector3 mouse;
    protected StatesLibrary sl;
    protected ScreenAbstract(StatesLibrary sl) {
        this.sl = sl;
    }
    protected abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();

}
