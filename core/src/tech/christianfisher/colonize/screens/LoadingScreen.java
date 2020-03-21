package tech.christianfisher.colonize.screens;

import com.badlogic.gdx.Screen;
import tech.christianfisher.colonize.ColonizeGameClass;

public class LoadingScreen implements Screen {

    private ColonizeGameClass parent;

    public LoadingScreen(ColonizeGameClass game){
        parent = game;
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        parent.changeScreen(ColonizeGameClass.MENU);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
