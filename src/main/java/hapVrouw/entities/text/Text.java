package hapVrouw.entities.text;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Text extends DynamicTextEntity{

    public Text(Coordinate2D initialLocation) {
        super(initialLocation);
        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFill(Color.RED);
    }


}
