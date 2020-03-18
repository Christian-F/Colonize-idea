package tech.christianfisher.colonize;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


/**
 * This is an Oxygen Not Included style 2d, colony building/management game.
 *
 * This is the tutorial I'm following, so I don't loose yet:
 * https://www.gamedevelopment.blog/full-libgdx-game-tutorial-project-setup/
 *
 * @author Christian Fisher
 */

public class ColonizeGameClass extends Game {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	public void changeScreen(int screen) {
		switch(screen) {
			case MENU:
				if(menuScreen == null) menuScreen  new MenuScreen();
					this.setScreen(menuScreen);
				break;
			case PREFERENCES:

		}
	}
}
