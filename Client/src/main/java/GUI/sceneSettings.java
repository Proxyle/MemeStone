package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;

public class sceneSettings {

    ObservableList<String> resolutions = FXCollections.observableArrayList("1920x1080","1280x720","640x480");
    ComboBox<String> resolution = new ComboBox<String>();
    Slider audio = new Slider();
    Button btnBack = new Button("Back");

}
