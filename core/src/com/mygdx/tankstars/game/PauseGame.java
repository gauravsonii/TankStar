package com.mygdx.tankstars.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;

public class PauseGame extends ScreenAbstract{

    private Texture PauseMenuBg;
    private Texture ResumeButton;
    private Texture SaveStateButton;
    private Texture MainMenuButton;
    private Rectangle constraintResumeBtn;
    private Rectangle constraintSaveBtn;
    private Rectangle constraintMainMenuBtn;


    protected PauseGame(StatesLibrary sl) {
        super(sl);
        PauseMenuBg = new Texture("PauseMenuBG.png");
        ResumeButton = new Texture("ResumeButton.png");
        SaveStateButton = new Texture("SaveStateButton.png");
        MainMenuButton = new Texture("MainMenuButton.png");
        constraintResumeBtn = new Rectangle(490,436,300,67);
        constraintSaveBtn = new Rectangle(490, 327, 300, 67);
        constraintMainMenuBtn = new Rectangle(490, 218, 300, 67);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            if (constraintResumeBtn.contains(Gdx.input.getX(),720-Gdx.input.getY())) { //Height of window = 720p
                sl.set(new NewGame(sl));
                dispose();
            }
        }
        if (Gdx.input.justTouched()) {
            if (constraintSaveBtn.contains(Gdx.input.getX(),720-Gdx.input.getY())) { //Height of window = 720p
                sl.set(new SaveGameMsgDisplay(sl));
                dispose();
            }
        }
        if (Gdx.input.justTouched()) {
            if (constraintMainMenuBtn.contains(Gdx.input.getX(), 720 - Gdx.input.getY())) { //Height of window = 720p
                sl.set(new MainMenu(sl));
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
        sb.draw(PauseMenuBg, 0, 0, 1280, 720);
        sb.draw(ResumeButton, 490, 435.6f, ResumeButton.getWidth(), ResumeButton.getHeight());
        sb.draw(SaveStateButton, 490, 326.6f, SaveStateButton.getWidth(), SaveStateButton.getHeight());
        sb.draw(MainMenuButton, 490, 217.6f, MainMenuButton.getWidth(), MainMenuButton.getHeight());
        sb.end();

    }

    @Override
    public void dispose() {

    }
}
