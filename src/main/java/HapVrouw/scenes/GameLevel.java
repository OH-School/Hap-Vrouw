package HapVrouw.scenes;

import HapVrouw.Game;
import HapVrouw.entities.tileMap.MuurTileMap;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import javafx.scene.paint.Color;

public class GameLevel extends DynamicScene implements TileMapContainer {

    private Game game;

    public GameLevel(Game game) {
        this.game = game;
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.BLACK);
    }

    @Override
    public void setupEntities() {

    }

    @Override
    public void setupTileMaps() {
        addTileMap(new MuurTileMap());
    }
}
