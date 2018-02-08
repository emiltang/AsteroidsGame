package dk.sdu.mmmi.cbse.playersystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import static com.badlogic.gdx.math.MathUtils.*;
import static dk.sdu.mmmi.cbse.common.data.GameKeys.*;

/**
 * @author jcs
 */
public class PlayerControlSystem implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {

        for (Entity player : world.getEntities(Player.class)) {
            PositionPart positionPart = player.getPart(PositionPart.class);
            MovingPart movingPart = player.getPart(MovingPart.class);

            movingPart.setLeft(gameData.getKeys().isDown(LEFT));
            movingPart.setRight(gameData.getKeys().isDown(RIGHT));
            movingPart.setUp(gameData.getKeys().isDown(UP));

            movingPart.process(gameData, player);
            positionPart.process(gameData, player);

            updateShape(player);
        }
    }

    private void updateShape(Entity entity) {

        PositionPart positionPart = entity.getPart(PositionPart.class);

        float[] shapex = entity.getShapeX();
        float[] shapey = entity.getShapeY();
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        shapex[0] = x + cos(radians) * 8;
        shapey[0] = y + sin(radians) * 8;

        shapex[1] = x + cos(radians - 4 * PI / 5) * 8;
        shapey[1] = y + sin(radians - 4 * PI / 5) * 8;

        shapex[2] = x + cos(radians + PI) * 5;
        shapey[2] = y + sin(radians + PI) * 5;

        shapex[3] = x + cos(radians + 4 * PI / 5) * 8;
        shapey[3] = y + sin(radians + 4 * PI / 5) * 8;

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }

}
