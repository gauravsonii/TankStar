package com.mygdx.tankstars.game;

import com.badlogic.gdx.Gdx;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JunitTest {
    @Test
    public void testConstructorInitializesTankSprite1() {
        // Set up the test environment
        StatesLibrary sl = new StatesLibrary();
        ChooseATank_Player1.whichTankP1 = 1;  // Set whichTankP1 to a specific value for the test
        NewGame game = new NewGame(sl);

        // Verify that the tankSprite1 sprite was initialized with the correct texture
        assertEquals("GreenTank_LeftSide.png", game.tankSprite1.getTexture().toString());
    }
}
