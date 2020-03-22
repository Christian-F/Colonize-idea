package tech.christianfisher.colonize.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import tech.christianfisher.colonize.B2dModel;
import tech.christianfisher.colonize.ColonizeGameClass;

public class MainScreen implements Screen{

    private ColonizeGameClass parent;
    private B2dModel model;
    private OrthographicCamera camera;
    private Box2DDebugRenderer debugRenderer;

    public MainScreen(ColonizeGameClass game){
        parent = game;
        model = new B2dModel();
        camera = new OrthographicCamera(32, 24);
        debugRenderer = new Box2DDebugRenderer(true,
                                                true,
                                               true,
                                         true,
                                             true,
                                             true);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        model.logicStep(delta);
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        debugRenderer.render(model.world, camera.combined);
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
