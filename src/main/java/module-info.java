module Hap.Vrouw {
    requires hanyaeger;
    requires org.checkerframework.checker.qual;
    requires java.desktop;

    exports HapVrouw;
    exports HapVrouw.entities.tileMap;

    //opens audio;
    opens backgrounds;
    opens sprites.hapvrouw;
    opens sprites.action;
    exports HapVrouw.entities.buttons;
    exports HapVrouw.scenes;
}