package com.mygdx.tankstars.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;

public class ChooseATank_Player1 extends ScreenAbstract{

    private Texture ChooseATank1bg;
    private Texture RedTank;
    private Texture GreenTank;
    private Texture BrownTank;

    private Rectangle contraintRedTank;
    private Rectangle contraintGreenTank;
    private Rectangle contraintBrownTank;

    public static int whichTankP1;



    protected ChooseATank_Player1(StatesLibrary sl) {
        super(sl);
        ChooseATank1bg = new Texture("ChooseATank1.png");
        RedTank = new Texture("RedFrmTank.png");
        GreenTank = new Texture("GreenFrmTank.png");
        BrownTank = new Texture("BrownFrmTank.png");

        contraintRedTank = new Rectangle(98,210,306,277);
        contraintGreenTank = new Rectangle(448,210,306,277);
        contraintBrownTank = new Rectangle(872,210,306,277);

    }


    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            if (contraintRedTank.contains(Gdx.input.getX(),720-Gdx.input.getY())) { //Height of window = 720p
                sl.set(new ChooseATank_Player2(sl));
                whichTankP1 = 0;
                dispose();
            }
        }
        if (Gdx.input.justTouched()) {
            if (contraintGreenTank.contains(Gdx.input.getX(),720-Gdx.input.getY())) { //Height of window = 720p
                sl.set(new ChooseATank_Player2(sl));
                whichTankP1 = 1;
                dispose();
            }
        }
        if (Gdx.input.justTouched()) {
            if (contraintBrownTank.contains(Gdx.input.getX(),720-Gdx.input.getY())) { //Height of window = 720p
                sl.set(new ChooseATank_Player2(sl));
                whichTankP1 = 2;
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
        sb.draw(ChooseATank1bg, 0, 0, 1280, 720);
        sb.draw(RedTank, 76, 173, RedTank.getWidth(), RedTank.getHeight());
        sb.draw(GreenTank, 463, 173, GreenTank.getWidth(), GreenTank.getHeight());
        sb.draw(BrownTank, 850, 173, BrownTank.getWidth(), BrownTank.getHeight());
        sb.end();
    }

    @Override
    public void dispose() {}

}
