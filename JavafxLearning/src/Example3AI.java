import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.*;


// Animation of Earth rotating around the sun.
public class Example3AI extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage theStage) {
        theStage.setTitle("AnimatedImage Example");

        Group root  = new Group();
        Scene scene = new Scene(root);
        theStage.setScene(scene);

        Canvas canvas = new Canvas(512, 512);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Image earth = new Image( "file:earth.png" );
        Image sun   = new Image( "file:sun.png" );
        Image space = new Image( "file:space.png" );

        AnimatedImage ufo = new AnimatedImage();
        Image[] imageArray = new Image[6];
        for (int i = 0; i < 6; i++) {
            imageArray[i] = new Image("file:ufo_" + i +".png");
        }
        ufo.frames = imageArray;
        ufo.duration = 0.100;

        final long startNanoTime = System.nanoTime();

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;

                double x = 232 + 128 * Math.cos(t);
                double y = 232 + 128 * Math.sin(t);

                gc.drawImage( space, 0, 0 );
                gc.drawImage( earth, x, y );
                gc.drawImage( sun, 196, 196 );
                gc.drawImage(ufo.getFrame(t), 450, 25);
            }
        }.start();

        theStage.show();
    }
}
