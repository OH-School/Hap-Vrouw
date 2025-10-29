module Hap.Vrouw {
    requires hanyaeger;
    requires org.checkerframework.checker.qual;
    requires java.desktop;
    requires java.sql;

    exports hapVrouw;
    exports hapVrouw.entities.tileMap;

    opens backgrounds;
    opens sprites.hapvrouw;
    opens sprites.action;
    opens sprites.ghosts;
    opens sprites.dots;
    exports hapVrouw.entities.buttons;
    exports hapVrouw.scenes;
    exports hapVrouw.entities.dots;
    exports hapVrouw.entities.dots.dots;
}