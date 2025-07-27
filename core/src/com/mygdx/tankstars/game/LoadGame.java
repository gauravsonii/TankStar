package com.mygdx.tankstars.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LoadGame extends ScreenAbstract{
    private Texture GameBg;
    private Texture Player1Tank;
    private Texture Player2Tank;
    private Texture Player1Health;
    private Texture Player2Health;
    protected LoadGame(StatesLibrary sl) {
        super(sl);
         GameBg = new Texture("MainGameBackground.png");
         Player1Tank = new Texture("GreenTankRight.png");
         Player2Tank = new Texture("REDTankLeft.png");
         Player1Health = new Texture("GreenTankLowHP.png");
         Player2Health = new Texture("RedTankLowHP.png");
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            sl.set(new PauseGame(sl));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(GameBg, 0, 0, 1280, 720);
        sb.draw(Player1Tank, 33, 131, Player1Tank.getWidth(), Player1Tank.getHeight());
        sb.draw(Player2Tank, 1017, 92, Player2Tank.getWidth(), Player2Tank.getHeight());
        sb.draw(Player1Health, 29, 582, Player1Health.getWidth(), Player1Health.getHeight());
        sb.draw(Player2Health, 862, 582,Player2Health.getWidth(), Player2Health.getHeight());
        sb.end();
    }

    @Override
    public void dispose() {

    }


}
