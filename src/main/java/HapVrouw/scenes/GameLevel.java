package HapVrouw.scenes;

import HapVrouw.Game;
import HapVrouw.entities.effectTiles.EffectTile;
import HapVrouw.entities.effectTiles.EffectTiles.SlowTile;
import HapVrouw.entities.effectTiles.EffectTiles.SpeedTile;
import HapVrouw.entities.ghosts.GhostOranje;
import HapVrouw.entities.ghosts.GhostPaars;
import HapVrouw.entities.ghosts.GhostRood;
import HapVrouw.entities.hapVrouw.HapVrouw;
import HapVrouw.entities.tileMap.MuurTileMap;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
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
        HapVrouw hapVrouw = new HapVrouw(new Coordinate2D(getWidth() / 2, getHeight() / 2  + 96));
        addEntity(hapVrouw);
        GhostPaars ghostPaars = new GhostPaars(new Coordinate2D(getWidth() / 2 , getHeight() / 2 -40 ));
        addEntity(ghostPaars);
        GhostRood ghostrood = new GhostRood(new Coordinate2D(getWidth() / 2 +40 , getHeight() / 2 -40 ));
        addEntity(ghostrood);
        GhostOranje ghostOranje = new GhostOranje(new Coordinate2D(getWidth() / 2 +40 , getHeight() / 2 -40 ));
        addEntity(ghostOranje);
        GhostOranje ghostOranj = new GhostOranje(new Coordinate2D(getWidth() / 2 +40 , getHeight() / 2 -40 ));
        addEntity(ghostOranj);
        GhostOranje ghostOran = new GhostOranje(new Coordinate2D(getWidth() / 2 -20 , getHeight() / 2 -40 ));
        addEntity(ghostOran);
        GhostOranje ghostOra = new GhostOranje(new Coordinate2D(getWidth() / 2 +40 , getHeight() / 2 -40 ));
        addEntity(ghostOra);
        GhostOranje ghostOr = new GhostOranje(new Coordinate2D(getWidth() / 2 +40 , getHeight() / 2 -40 ));
        addEntity(ghostOr);
        EffectTile speed = new SpeedTile(new Coordinate2D(49, 46), new Size(40));
        addEntity(speed);
        EffectTile slow = new SlowTile(new Coordinate2D(145, 137), new Size(40));
        addEntity(slow);



    }

    @Override
    public void setupTileMaps() {

        addTileMap(new MuurTileMap());
//        addTileMap(new wijspuntenTileMap());
    }
}
