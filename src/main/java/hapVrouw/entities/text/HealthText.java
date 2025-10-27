package hapVrouw.entities.text;

import com.github.hanyaeger.api.Coordinate2D;

public class HealthText extends Text {

    public HealthText(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    public void setHealthText(int health){
        setText("health: " + health);

    }

}
