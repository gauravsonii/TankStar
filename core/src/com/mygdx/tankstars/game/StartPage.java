package com.mygdx.tankstars.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.awt.*;

public class StartPage extends ScreenAbstract {
    private Texture background;
    private Texture playButton;
    private Texture pressedPlayButton;
    private Rectangle constraint;
    public StartPage(StatesLibrary sl) {
        super(sl);
        background = new Texture("PlayScreen.png");
        playButton = new Texture("Playbutton.png");
        constraint = new Rectangle(490,182,300,67);
    }

    @Override
    protected void handleInput() {
//        if (Gdx.input.)
        if(Gdx.input.justTouched()){
            if(constraint.contains(Gdx.input.getX(),720-Gdx.input.getY())){ //Height of window = 720p
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
        sb.draw(background,0, 0,1280,720);
        sb.draw(playButton,490,181.6f,playButton.getWidth(),playButton.getHeight());
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playButton.dispose();
    }
}
