package tech.christianfisher.colonize;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class B2dModel {
    public World world;

    private Body bodyd;
    private Body bodys;
    private Body bodyk;

    public B2dModel() {
            world = new World(new Vector2(0, -10f), true);
    }

    public void logicStep(float delta){
        world.step(delta, 3, 3);
    }

    private void createObject(){

        //create a new body definition (type and location)
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(0,0);

        //add it to the world
        bodyd = world.createBody(bodyDef);

        //set the shape (here we usea box 50 meters wide, 1 meter tall
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(1,1);

        //set the properties of the object(shape, weight, restitution(bouncynes)
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;

        //create the physical object in our body
        //otherwise the body would just be data
        bodyd.createFixture(shape, 0.0f);

        shape.dispose();
    }
}
