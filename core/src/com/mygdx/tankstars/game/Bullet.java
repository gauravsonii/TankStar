package com.mygdx.tankstars.game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Bullet {
    private Sprite sprite;
    private Rectangle boundingBox;
    private float xVelocity;
    private float yVelocity;

    public Bullet(Texture texture, float x, float y, float xVelocity, float yVelocity) {
        sprite = new Sprite(texture);
        sprite.setPosition(x, y);
        boundingBox = new Rectangle(x, y, sprite.getWidth(), sprite.getHeight());
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
    }

    public void update(float dt) {
        sprite.setPosition(sprite.getX() + xVelocity * dt, sprite.getY() + yVelocity * dt);
        boundingBox.setPosition(boundingBox.getX() + xVelocity * dt, boundingBox.getY() + yVelocity * dt);
        yVelocity -= 9.8f * dt;
    }

    public void render(SpriteBatch sb) {
        sprite.draw(sb);
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }


}
