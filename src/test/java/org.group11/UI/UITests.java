package org.group11.UI;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.group11.App;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UITests extends App{

    private String tab = "primary";

//    @Override
//    public void start(Stage stage) throws IOException {
//        Scene scene = new Scene(loadFXML(tab));
//        stage.setScene(scene);
//        stage.setResizable(false); //Resizable feature turned off
//        stage.show();
//    }
//
    @Test
    public void test()  {
        App app = new App();
        app.launch();
    }
//    @Before
//    public void setup(){
//         launch();
//     }


}
