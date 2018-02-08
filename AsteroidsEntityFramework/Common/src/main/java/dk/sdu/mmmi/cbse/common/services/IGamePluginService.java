package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

/**
 * Interface that new plugin components must implement
 */
public interface IGamePluginService {

    /** Create entities and add entities to world
     * @param gameData current game state variables
     * @param world all entities currently in the game
     */
    void start(GameData gameData, World world);

    /** Clean up when plugin is unloaded
     * @param gameData current game state variables
     * @param world all entities currently in the gam
     */
    void stop(GameData gameData, World world);
}
