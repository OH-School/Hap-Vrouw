package HapVrouw.entities.text;

import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TimerDisplay extends DynamicTextEntity {

    public TimerDisplay(Coordinate2D initialLocation) {
        super(initialLocation, "Timer: 0");
        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.RED);
    }

    public void updateTimer(int seconds) {
        setText("Timer: " + seconds);
    }
}