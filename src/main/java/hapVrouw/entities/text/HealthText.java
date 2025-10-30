package hapVrouw.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import hapVrouw.Game;

public class HealthText extends Text {

    private final Game game;

    public HealthText(Coordinate2D initialLocation, Game game) {
        super(initialLocation);
        this.game = game;
    }

    public void setHealthText(int health){
        setText("health: " + health);
        if (health == 0){
            game.setActiveScene(2);
        }
    }
}
