package com.mygdx.tankstars.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;

public class SaveGameMsgDisplay extends ScreenAbstract{

    private Texture SaveGameMsg;
    private Texture BackButton;
    private Rectangle constraintBackBtn;

    public SaveGameMsgDisplay(StatesLibrary sl) {
        super(sl);
        SaveGameMsg = new Texture("SaveStateMsg.png");
        BackButton = new Texture("BackButton.png");
        constraintBackBtn = new Rectangle(490,293,300,67);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            if (constraintBackBtn.contains(Gdx.input.getX(),720-Gdx.input.getY())) { //Height of window = 720p
                sl.set(new LoadGame(sl));
                dispose();
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(SaveGameMsg, 0, 0, 1280, 720);
        sb.draw(BackButton, 490, 293, BackButton.getWidth(), BackButton.getHeight());
        sb.end();

    }

    @Override
    public void dispose() {

    }

}
