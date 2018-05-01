import  javafx.application.Application;
import  javafx.event.ActionEvent;
import  javafx.event.EventHandler;
import  javafx.scene.Scene;
import  javafx.scene.control.Button;
import  javafx.scene.control.Label;
import  javafx.scene.layout.*;
import  javafx.scene.text.Text;
import  javafx.stage.Stage;
import  javafx.animation.KeyFrame;
import  javafx.animation.KeyValue;
import  javafx.animation.AnimationTimer;

import  javafx.util.Duration;



public class GameWorld extends Application
{
    private final int   MN_WIDTH    = 360,
                        MN_HEIGHT   = 360,
                        HS_WIDTH    = 480,
                        HS_HEIGHT   = 480,
                        GM_WIDTH    = 640,
                        GM_HEIGHT   = 640,
                        VD_WIDTH    = 480,
                        VD_HEIGHT   = 480;

    private final String title = "Joey's Jave Math Game";

    private Stage window;
    private Scene menuScene, videoScene, gameScene, hScoreScene;

    public static void main(String[] args)
    {
        launch(args);
    }

    public void init()
    {
        initMenuScene();
        initVideoScene();
        initGameScene();
        initHScoreScene();
    }

    public void initMenuScene()
    {
        Label titleLbl      = new Label(title);
        Button playGameBtn  = new Button("Start");
        Button hScoreBtn    = new Button("High Scores");

        StackPane sp = new StackPane();
        VBox vb =   VBox();


        menuScene = new Scene(vb);

    }
    public void initVideoScene()
    {
    
    }
    public void initGameScene()
    {
    
    }
    public void initHScoreScene()
    {
    
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // Set window to the state
        window = primaryStage;

        Label lbl1 = new Label("Main Page");
        Button btn = new Button("High Scores");
        btn.setOnAction(e ->
                {
                    window.setScene(neutral);
                });

        VBox lay1 = new VBox(20);
        lay1.getChildren().addAll(lbl1,btn);
        menu = new Scene(lay1, 200, 200);

        Label lbl2 = new Label("Neutral Page");
        Button btn2 = new Button("Go Back");
        btn2.setOnAction(e -> 
            {window.setScene(menu);});
        StackPane lay2 = new StackPane();
        lay2.getChildren().addAll(lbl2,btn2);

        neutral = new Scene(lay2, 400,400);

        window.setScene(menu);

        window.show();

    }

    public class BtnEventHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent e)
        {
            System.out.println("iH!");
        }
    
    }
}
