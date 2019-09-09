package com.jkspad.tutorial;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * @author John Knight
 * Copyright http://www.jkspad.com
 *
 */
public class Sprite3 extends ApplicationAdapter {
	SpriteBatch batch;
	private TextureAtlas textureAtlas;
	private Animation<TextureRegion> animation;
	private float animationStateTime;
	private Array<AtlasRegion> frames;

	@Override
	public void create () {
		batch = new SpriteBatch();
		textureAtlas = new TextureAtlas("spritesheet.atlas");
		frames = textureAtlas.findRegions("invader1");
		animation = new Animation(1/15f, frames);
	}

	private void update(float delta){
		animationStateTime += delta;
	}

	@Override
	public void render () {
		update(Gdx.graphics.getDeltaTime());
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(animation.getKeyFrame(animationStateTime, true), 0, 0);
		batch.end();
	}

	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
		textureAtlas.dispose();
	}
}
