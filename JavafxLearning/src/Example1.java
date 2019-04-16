import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Example1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage theStage) {
//        theStage.setTitle("Hello, World!");
//        theStage.show();
        theStage.setTitle("Canvas Example");

//        StackPane root = new StackPane();
        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);

        Canvas canvas = new Canvas(400, 200);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.RED);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        Font theFont = Font.font("Times New Roman", FontWeight.BOLD, 48);
        gc.setFont(theFont);
        gc.fillText("Hello, World", 60, 50);
        gc.strokeText( "Hello, World!", 60, 50 );

        Image earth = new Image("file:earth.png");
//        ImageView image = new ImageView();
//        image.setImage(earth);
        gc.drawImage(earth, 180, 100);
//
//        root.getChildren().add(image);
//        image.setX(180);
//        image.setY(100);

        theStage.show();
    }
}
