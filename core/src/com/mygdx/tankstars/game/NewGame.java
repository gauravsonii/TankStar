package com.mygdx.tankstars.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import java.util.ArrayList;
import static com.mygdx.tankstars.game.ChooseATank_Player1.whichTankP1;
import static com.mygdx.tankstars.game.ChooseATank_Player2.whichTankP2;

public class NewGame extends ScreenAbstract{
    private Texture Background;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    Sprite tankSprite1;
    private Sprite tankSprite2;
    private  Sprite healthBar1;
    private  Sprite healthBar2;
    private ArrayList<Bullet> bulletList1;
    private ArrayList<Bullet> bulletList2;

    int tank1Health = 100;
    int tank2Health = 100;

    String[] AllTanks_LeftSide = {"RedTank_LeftSide.png", "GreenTank_LeftSide.png","BrownTank_LeftSide.png"};
    String[] AllTanks_RightSide = {"RedTank_RightSide.png","GreenTank_RightSide.png", "BrownTank_RightSide.png"};

    public NewGame(StatesLibrary sl) {
        super(sl);


        Background = new Texture("Background.png");
        map = new TmxMapLoader().load("NewTerrain.tmx");

        tankSprite1 = new Sprite(new Texture(AllTanks_LeftSide[whichTankP1]));
        tankSprite1.setPosition(50, 120);

        tankSprite2 = new Sprite(new Texture(AllTanks_RightSide[whichTankP2]));
        tankSprite2.setPosition(1000, 120);

        bulletList1 = new ArrayList<>();
        bulletList2 = new ArrayList<>();

        tankSprite2.setPosition(1100, 120);
        renderer = new OrthogonalTiledMapRenderer(map);
        camera = new OrthographicCamera();
        camera.viewportHeight = 720;
        camera.viewportWidth = 1280;
        camera.position.set(640,360,0);
        camera.update();

        healthBar1 = new Sprite(new Texture("healthbar.png"));
        healthBar1.setPosition(57, 643);

        healthBar2 = new Sprite(new Texture("healthbar.png"));
        healthBar2.setPosition(858, 643);

    }

    public static int decreaseTankHealth(int currentHealth, int damage) {
        return Math.max(currentHealth - damage, 0);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            sl.set(new PauseGame(sl));
            dispose();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            tankSprite1.setPosition(tankSprite1.getX() - 2, tankSprite1.getY());
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            tankSprite1.setPosition(tankSprite1.getX() + 2, tankSprite1.getY());
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            tankSprite2.setPosition(tankSprite2.getX() - 2, tankSprite2.getY());
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            tankSprite2.setPosition(tankSprite2.getX() + 2, tankSprite2.getY());
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SHIFT_LEFT)) {
            Texture bulletTexture = new Texture("Bomb.png");
            float angle1 = 45;
            float speed = 120.0f;
            if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                angle1 = angle1-30;
            }
            else{
                angle1 = angle1+5;
            }
            float xVelocity = (float) (speed * Math.cos(Math.toRadians(angle1)));
            float yVelocity = (float) (speed * Math.sin(Math.toRadians(angle1)));
            Bullet bullet = new Bullet(bulletTexture, tankSprite1.getX() + tankSprite1.getWidth() / 2, tankSprite1.getY() + tankSprite1.getHeight() / 2,xVelocity, yVelocity);
            bulletList1.add(bullet);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SHIFT_RIGHT)) {
            Texture bulletTexture1 = new Texture("Bomb.png");
            float angle2 = 135;
            float speed = 120.0f;

            if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                angle2 = angle2+30;
            }
            else{
                angle2 = angle2-5;
            }
            float xVelocity = (float) (speed * Math.cos(Math.toRadians(angle2)));
            float yVelocity = (float) (speed * Math.sin(Math.toRadians(angle2)));
            Bullet bullet1 = new Bullet(bulletTexture1, tankSprite2.getX() + tankSprite2.getWidth() / 2, tankSprite2.getY() + tankSprite2.getHeight() / 2,xVelocity, yVelocity);
            bulletList2.add(bullet1);

        }
    }
    @Override
    public void update(float dt) {
        handleInput();
        if (tankSprite1.getX() < 0) {
            tankSprite1.setPosition(0, tankSprite1.getY());
        }
        if (tankSprite2.getX() > 1280 - tankSprite2.getWidth()) {
            tankSprite2.setPosition(1280 - tankSprite2.getWidth(), tankSprite2.getY());
        }
        Rectangle tank1BoundingBox = new Rectangle((int) tankSprite1.getX(), (int) tankSprite1.getY(), tankSprite1.getWidth(), tankSprite1.getHeight());
        Rectangle tank2BoundingBox = new Rectangle((int) tankSprite2.getX(), (int) tankSprite2.getY(), tankSprite2.getWidth(), tankSprite2.getHeight());

        Rectangle ground = new Rectangle(0, 0, 1280, 110);

        for (int i = 0; i < bulletList1.size(); i++) {
            Bullet bullet = bulletList1.get(i);
            bullet.update(dt);
            if (bullet.getBoundingBox().overlaps(tank2BoundingBox)) {
                bulletList1.remove(bullet);
                if(tank2Health > 0){
                    tank2Health = decreaseTankHealth(tank2Health, 5);
                }

                if (tank2Health == 0) {
                    sl.set(new GameLose(sl));
                    dispose();
                }
            }
            if((bullet.getBoundingBox().overlaps(ground))){
                bulletList1.remove(bullet);
            }
        }
        for (Bullet bullet : bulletList1) {
            bullet.update(dt);


        }

        for (int i = 0; i < bulletList2.size(); i++) {
            Bullet bullet1 = bulletList2.get(i);
            bullet1.update(dt);
            if (bullet1.getBoundingBox().overlaps(tank1BoundingBox)) {
                bulletList2.remove(bullet1);
                if(tank1Health > 0){
                    tank1Health = decreaseTankHealth(tank1Health, 5);
                }

                if(tank1Health == 0){
                    sl.set(new GameWin(sl));
                    dispose();
                }
            }
            if((bullet1.getBoundingBox().overlaps(ground))){
                bulletList2.remove(bullet1);
            }
        }
        for (Bullet bullet1 : bulletList2) {
            bullet1.update(dt);
        }
    }


    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(Background, 0, 0, 1280, 720);
        renderer.setView(camera);
        renderer.render();
        tankSprite2.draw(sb);
        tankSprite1.draw(sb);

        for (Bullet bullet : bulletList1) {
            bullet.render(sb);}
        for (Bullet bullet1 : bulletList2) {
            bullet1.render(sb);}


        healthBar1.setSize(320/100.0f * tank1Health, 48);
        healthBar1.draw(sb);

        healthBar2.setSize(320/100.0f * tank2Health, 48);
        healthBar2.draw(sb);
        sb.end();
    }
    @Override
    public void dispose() {}
}

