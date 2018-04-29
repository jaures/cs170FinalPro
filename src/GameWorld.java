import  javafx.application.Application;
import  javafx.scene.canvas.Canvas;
import  javafx.scene.canvas.GraphicsContext;
import  javafx.scene.paint.Color;
import  javafx.stage.Stage;


public class GameWorld extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        stage.setTitle("GameWorld"); 
        stage.show();
    }
}
