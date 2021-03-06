package tech.christianfisher.colonize.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import tech.christianfisher.colonize.ColonizeGameClass;

public class MenuScreen implements Screen {

    private ColonizeGameClass parent;
    private Stage stage;

    public MenuScreen(ColonizeGameClass game){
        this.parent = game;

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
        //table is used to configure the layout of objects
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(false);
        stage.addActor(table);

        Skin skin = new Skin(Gdx.files.internal("glassy/skin/glassy-ui.json"));

        TextButton newGameTBtn = new TextButton("New Game", skin);
        TextButton preferencesTBtn = new TextButton("Preferences", skin);
        TextButton exitTBtn = new TextButton("Exit", skin);

        table.add(newGameTBtn).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(preferencesTBtn).fillX().uniformX();
        table.row();
        table.add(exitTBtn).fillX().uniformX();

        exitTBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });

        preferencesTBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //parent.changeScreen(ColonizeGameClass.PREFERENCES);
                parent.setScreen(new PreferencesScreen(parent));
                System.out.println("Pref button clicked");
            }
        });

        newGameTBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //parent.changeScreen(ColonizeGameClass.APPLICATION);
                parent.setScreen(new MainScreen(parent));
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1/30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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
        stage.clear();
        stage.dispose();
    }
}
