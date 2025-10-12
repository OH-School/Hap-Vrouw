package HapVrouw;

import HapVrouw.scenes.GameLevel;
import HapVrouw.scenes.TitleScene;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;

/**
 * Hello world!
 *
 */
//
public class Game extends YaegerGame {
    public static void main( String[] args ) {
        launch(args);
    }

    private int window = 3;

    @Override
    public void setupGame() {
        setGameTitle("HapVrouw");
        setSize(new Size(304 * window, 240 * window));
    }

    @Override
    public void setupScenes() {
        addScene(1, new GameLevel(this));
        addScene(0, new TitleScene(this));
    }
}
