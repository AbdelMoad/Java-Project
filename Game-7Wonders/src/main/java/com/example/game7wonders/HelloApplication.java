package example.game7wonders;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    private Parent createContent(){
        VBox root = new VBox();
        root.setPrefSize(1280, 720+100);

        var tilePane = new Pane();

        Random random = new Random();

        for (int i=1; i<=9; i++){
           var tile = new Tileview(Integer.toString(i));
           tile.setTranslateX(random.nextInt(1280/80)*80);
           tile.setTranslateY(random.nextInt(720/80)*80);
           tilePane.getChildren().add(tile);
        }
        root.getChildren().add(tilePane);

        return root;
    }
    private static class Tileview extends StackPane{
        Tileview(String content){
            var border = new Rectangle();
            border.setStroke(Color.BLACK);
            border.setStrokeWidth(4);
            border.setStrokeType(StrokeType.INSIDE);

            var text = new Text(content);
            text.setFont(Font.font(64));

            getChildren().addAll(border, text);

        }

    }
    public static void main(String[] args) {
        launch(args);
    }
}