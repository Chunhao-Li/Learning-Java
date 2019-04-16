import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Example4K extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage theStage) {
        theStage.setTitle("Keyboard Example");

        Group root = new Group();
        Scene scene = new Scene(root);
        theStage.setScene(scene);

        Canvas canvas = new Canvas(512-64, 256);
        root.getChildren().add(canvas);

        ArrayList<String> input = new ArrayList<>();

        scene.setOnKeyPressed(
                new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent keyEvent) {
                        String code = keyEvent.getCode().toString();

                        // only add once... prevent duplicates
                        if (!input.contains(code)) {
                            input.add(code);
                        }
                    }
                }
        );

//        scene.setOnKeyReleased(
//                new EventHandler<KeyEvent>() {
//                    @Override
//                    public void handle(KeyEvent keyEvent) {
//                        String code = keyEvent.getCode().toString();
//                        input.remove(code);
//                    }
//                }
//        );
        scene.setOnKeyReleased(k->input.remove(k.getCode().toString()));

        GraphicsContext gc = canvas.getGraphicsContext2D();
        Image left = new Image("file:left.png");
        Image leftG = new Image("file:leftG.png");

        Image right = new Image("file:right.png");
        Image rightG = new Image("file:rightG.png");

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                // Clear the canvas
                gc.clearRect(0, 0, 512, 512);

                if (input.contains("LEFT")) {
                    gc.drawImage(leftG, 64, 64);
                }
                else {
                    gc.drawImage(left, 64, 64);
                }
                if (input.contains("RIGHT")) {
                    gc.drawImage(rightG, 256, 64);
                }
                else {
                    gc.drawImage(right, 256, 64);
                }
            }
        }.start();

        theStage.show();
    }
}
