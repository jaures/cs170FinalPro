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
import  javafx.animation.Timeline;
import  javafx.geometry.*;
import  javafx.util.Duration;
import  javafx.scene.canvas.Canvas;
import  javafx.scene.canvas.GraphicsContext;
import  javafx.scene.image.Image;
import  javafx.scene.text.Font;
import  javafx.scene.text.FontWeight;
import  javafx.scene.paint.Paint;
import  javafx.scene.paint.Color;
import  javafx.scene.Node;


public class GameWorld extends Application
{
    private final int   MN_WIDTH    = 640,
                        MN_HEIGHT   = 640,
                        HS_WIDTH    = 320,
                        HS_HEIGHT   = 480,
                        GM_WIDTH    = 640,
                        GM_HEIGHT   = 640,
                        VD_WIDTH    = 480,
                        VD_HEIGHT   = 480;

    private final String title = "Joey's Java Math Game";

    private Stage window;
    private Scene menuScene, videoScene, gameScene, hScoreScene;
    private Canvas cv, gmap;
    private int fNum;

    public static void main(String[] args)
    {
        launch(args);
    }
    
    @Override
    public void init()
    {
        initMenuScene();
        initVideoScene();
        initGameScene();
        initHScoreScene();
    }

    public void initMenuScene()
    {
        Button playGameBtn  = new Button("Start");
        Button hScoreBtn    = new Button("High Scores");

        playGameBtn.setOnAction(e->
                {
                    window.setScene(gameScene);
                });

        StackPane sp = new StackPane();
        cv = new Canvas(MN_WIDTH, MN_HEIGHT);
        VBox vb = new VBox(10);

        vb.setAlignment(Pos.CENTER);

        
        vb.getChildren().add(playGameBtn);
        
        vb.getChildren().add(hScoreBtn);

        sp.getChildren().addAll(cv,vb);
        fNum = 0;

        Timeline tm = new Timeline(new KeyFrame(Duration.millis(100),
                    new EventHandler<ActionEvent>()
                    { 
                        public void handle(ActionEvent e){
                            GraphicsContext gc = cv.getGraphicsContext2D();
                            Image frame = new Image(
                            String.format("img/dogFood/dogFood%02d.png",fNum),
                            cv.getWidth(), cv.getHeight(), true, true);

                            gc.setFont(Font.font("Calibri",
                                        FontWeight.EXTRA_BOLD, 64));

                            gc.drawImage(frame,0,0);
                            gc.setFill(Color.WHITE);
                            
                            gc.fillText(title, cv.getWidth()/2 - 100,
                                    cv.getHeight()/2 - 80, 200);
                            fNum = (fNum + 1) % 48;
                            System.out.println(
                                    String.format("img/dogFood/dogFood%02d.png",fNum));
                        }
                    }));

       
        tm.setCycleCount(Timeline.INDEFINITE);
        tm.play(); 

        menuScene = new Scene(sp);

    }
    public void initVideoScene()
    {
    
    }
    public void initGameScene()
    {
        StackPane sp = new StackPane();
        Canvas canvas = new Canvas(GM_WIDTH, GM_HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        GridPane gp = new GridPane();

        for(int i = 0; i < 10; i++)
        {
            for(int j = 0; j < 10; j++)
            {
                Button btn = new Button(String.format("%02d",i*10 + j));
                btn.setOnAction(
                    new EventHandler<ActionEvent>()
                    {
                        @Override public void handle(ActionEvent e)
                        {
                            Button b = (Button)e.getSource();
                            System.out.println(b.getText());
                        }
                    }
                );
                
                gp.getChildren().add(btn);
                gp.setConstraints(btn,i,j);
            }
        }

        sp.getChildren().addAll(cv,gp);


        gameScene = new Scene(sp, GM_WIDTH, GM_HEIGHT);
    }

    public void initHScoreScene()
    {
         
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // Initialize Everything
        // Set window to the state
        window = primaryStage;

        /*
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
        */
      
        //initGameScene();
        window.setScene(menuScene);

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
