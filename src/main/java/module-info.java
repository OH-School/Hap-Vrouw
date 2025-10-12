module Hap.Vrouw {
    requires hanyaeger;
    requires org.checkerframework.checker.qual;
    requires java.desktop;



    exports HapVrouw;
    exports HapVrouw.entities.tileMap;
    exports HapVrouw.entities.ghosts;



    //opens audio;
    opens backgrounds;
    opens sprites.hapvrouw;
    opens sprites.ghosts;
    exports HapVrouw.entities.buttons;
    exports HapVrouw.scenes;
}