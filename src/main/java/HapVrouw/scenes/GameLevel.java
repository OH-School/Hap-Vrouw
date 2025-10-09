package HapVrouw.scenes;

import HapVrouw.Game;
import HapVrouw.entities.hapVrouw.HapVrouw;
import HapVrouw.entities.tileMap.MuurTileMap;
import com.github.hanyaeger.api.Coordinate2D;
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
        HapVrouw hapVrouw = new HapVrouw(new Coordinate2D(getWidth() / 2 - 16, getHeight() / 2  + 48));
        addEntity(hapVrouw);

    }

    @Override
    public void setupTileMaps() {
        addTileMap(new MuurTileMap());
    }
}
