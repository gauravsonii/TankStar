package com.mygdx.tankstars.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class GameWin extends ScreenAbstract{
    private Texture WinBg;
    private  Texture ExitBtn;
    private Rectangle contraintExitBtn;

    protected GameWin(StatesLibrary sl) {
        super(sl);

        WinBg = new Texture("Win1.png");
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
        sb.draw(WinBg,0,0,1280,720);
        sb.draw(ExitBtn,490,218,ExitBtn.getWidth(),ExitBtn.getHeight());
        sb.end();
    }

    @Override
    public void dispose() {
    }
}
