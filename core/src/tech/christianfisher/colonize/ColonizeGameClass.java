package tech.christianfisher.colonize;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import tech.christianfisher.colonize.screens.*;


/**
 * This is an Oxygen Not Included style 2d, colony building/management game.
 *
 * This is the tutorial I'm following, so I don't loose it:
 * https://www.gamedevelopment.blog/full-libgdx-game-tutorial-project-setup/
 *
 * @author Christian Fisher
 */

public class ColonizeGameClass extends Game {
	SpriteBatch batch;
	Texture img;

	private LoadingScreen loadingScreen;
	private PreferencesScreen preferencesScreen;
	private MenuScreen menuScreen;
	private MainScreen mainScreen;
	private EndScreen endScreen;

	private AppPreferences preferences;

	public final static int MENU = 0;
	public final static int PREFERENCES = 1;
	public final static int APPLICATION = 2;
	public final static int ENDGAME = 3;

	public AppPreferences getPreferences(){
		return this.preferences;
	}

	@Override
	public void create () {
		preferences = new AppPreferences();
		loadingScreen = new LoadingScreen(this);
		this.setScreen(loadingScreen);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
	}
	
	@Override
	public void dispose () {

	}

	public void changeScreen(int screen) {
		switch(screen) {
			case MENU:
				if(menuScreen == null) menuScreen = new MenuScreen(this);
					this.setScreen(menuScreen);
				break;
			case PREFERENCES:
				if(preferencesScreen == null) preferencesScreen = new PreferencesScreen(this);
					this.setScreen(menuScreen);
				break;
			case APPLICATION:
				if (mainScreen == null) mainScreen = new MainScreen(this);
					this.setScreen(mainScreen);
				break;
			case ENDGAME:
				if (endScreen == null) endScreen = new EndScreen(this);
					this.setScreen(endScreen);
				break;
		}
	}
}
