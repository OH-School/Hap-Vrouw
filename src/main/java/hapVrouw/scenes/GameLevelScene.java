package hapVrouw.scenes;


import hapVrouw.Game;
import hapVrouw.entities.dots.DotsSpawner;
import hapVrouw.entities.effectTiles.EffectTileSpawner;
import hapVrouw.entities.ghosts.Ghosts;
import hapVrouw.entities.ghosts.Sprites.GhostOranjeSprite;
import hapVrouw.entities.ghosts.Sprites.GhostsSprite;
import hapVrouw.entities.hapVrouw.HapVrouw;
import hapVrouw.entities.text.*;
import hapVrouw.entities.tileMap.MuurTileMap;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import javafx.scene.paint.Color;


public class GameLevelScene extends DynamicScene implements TileMapContainer, EntitySpawnerContainer, TimerContainer {

    private Game game;
    private TimerDisplay timerDisplay;
    private Time gameTime;
    private int x = 48;
    private int y = 45;
    private MuurTileMap muurTileMap;

    public GameLevelScene(Game game) {
        this.game = game;
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.BLACK);
    }

    @Override
    public void setupEntities() {
        
        Ghosts ghosts = new Ghosts(new Coordinate2D(getWidth() / 2, getHeight() / 2), 2) {
        };
        addEntity(ghosts);
        ScoreText scoreText = new ScoreText(new Coordinate2D(getWidth() / 2,20));
        addEntity(scoreText);
        HealthText health = new HealthText(new Coordinate2D(100,20));
        addEntity(health);
        timerDisplay = new TimerDisplay(new Coordinate2D(708, 20), game);
        addEntity(timerDisplay);
        HapVrouw hapVrouw = new HapVrouw(new Coordinate2D(x * 9, y * 12 + 5), health, scoreText, ghosts);
        addEntity(hapVrouw);
    }

    @Override
    public void setupTileMaps() {
        muurTileMap = new MuurTileMap();
        addTileMap(muurTileMap);
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new EffectTileSpawner(5000, x, y, muurTileMap, gameTime));
        addEntitySpawner(new DotsSpawner(0, x, y, muurTileMap));
    }

    @Override
    public void setupTimers() {
        gameTime = new Time(timerDisplay, 200); // create a shared Time object
        addTimer(gameTime);
    }
}
