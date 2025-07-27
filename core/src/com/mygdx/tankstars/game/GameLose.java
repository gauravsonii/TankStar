package com.mygdx.tankstars.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;

public class GameLose extends ScreenAbstract{
    private Texture LoseBg;
    private  Texture ExitBtn;
    private Rectangle contraintExitBtn;

    protected GameLose(StatesLibrary sl) {
        super(sl);

        LoseBg = new Texture("Win2.png");
        ExitBtn = new Texture("Exitbutton.png");
        contraintExitBtn = new Rectangle(490,218,ExitBtn.getWidth(),ExitBtn.getHeight());
}
    @Override
    protected void handleInput() {

        if(Gdx.input.justTouched()){
            if(contraintExitBtn.contains(Gdx.input.getX(),720-Gdx.input.getY())){ //Height of window = 720p
                Gdx.app.exit();
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
        sb.draw(LoseBg,0,0,1280,720);
        sb.draw(ExitBtn,490,218,ExitBtn.getWidth(),ExitBtn.getHeight());
        sb.end();
    }

    @Override
    public void dispose() {
    }
}

