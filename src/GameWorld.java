import  javafx.application.Application;
import  javafx.scene.canvas.Canvas;
import  javafx.scene.canvas.GraphicsContext;
import  javafx.scene.paint.Color;
import  javafx.scene.Scene;
import  javafx.scene.Group;
import  javafx.scene.image.Image;
import  javafx.scene.control.Button;
import  javafx.scene.text.Font;
import  javafx.stage.Stage;


public class GameWorld extends Application
{

    private final int       WIDTH   = 640, 
                            HEIGHT  = 480;

    int frame;

    private void init(Stage stage, Group gp, Canvas canvas)
    {
        // Set the title of th Application Window
        stage.setTitle("Game World"); 
        stage.setScene(new Scene(gp));
        gp.getChildren().add(canvas);
    }

    private void reset(Canvas cv)
    {
        GraphicsContext gc = cv.getGraphicsContext2D();
        gc.setFill(Color.BLUE);
        gc.fillRect(0,0,cv.getWidth(),cv.getHeight());

        Image im = new Image("res/img/puppy.png", 120, 120, false, false);

        gc.drawImage(im,100 + frame*10, 100 + frame * 5);

        frame = (frame + 1) % 30;

        gc.setFont(new Font("Times New Roman", 20));
        gc.strokeText("Game World!", 10, 250, 100);


    }

    @Override
    public void start(Stage stage)
    {

        Group root = new Group();
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        
        frame = 0;

        init(stage,root, canvas);

        stage.show();
        //while(true)
        //{
            reset(canvas);
        //}
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
