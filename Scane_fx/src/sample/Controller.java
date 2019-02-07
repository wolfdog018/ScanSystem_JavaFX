package sample;

import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    double x,y;

    @FXML
    private ImageView b1,b2,b3,b4,b5,a1,a2,a3,a4,s1,s2,s3,s4,s5,c1,c2,c3,c4,c5;

    @FXML
    private Text txt1,txt5,txt2,txt3,txt4;

    @FXML
    private Label result;

    private RotateTransition rotateTransition1,rotateTransition2,rotateTransition3,rotateTransition4,rotateTransition5;

    @FXML
    private void close(MouseEvent event){
        System.exit(0);
    }

    @FXML
    void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();

    }

    @FXML
    void dragged(MouseEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);

    }


    @FXML
    private void scan(MouseEvent event){
        b1.setVisible(false);
        s1.setVisible(true);
        txt1.setText("Checking for update");
        //b1.setImage(new Image("img/reload.png"));
        rotateTransition1 = new RotateTransition(Duration.seconds(5),s1);
        rotateTransition2 = new RotateTransition(Duration.seconds(5),s2);
        rotateTransition3 = new RotateTransition(Duration.seconds(5),s3);
        rotateTransition4 = new RotateTransition(Duration.seconds(5),s4);
        rotateTransition5 = new RotateTransition(Duration.seconds(5),s5);
        RotateTransition transition[] = {rotateTransition1,rotateTransition2,
                rotateTransition3,rotateTransition4,rotateTransition5};
        for (RotateTransition rTransition : transition){
            rTransition.setCycleCount(1);
            rTransition.setFromAngle(720);
            rTransition.setToAngle(0);
            rTransition.setAutoReverse(false);
        }
        rotateTransition1.play();
        rotateTransition1.setOnFinished((e) -> {
            s1.setVisible(false);
            c1.setVisible(true);
            a1.setVisible(true);
            txt2.setText("Pre-Scane oparation");
            //s1.setImage(new Image("reload.png"));
            //b2.setImage(new Image("@img/reload"));
            b2.setVisible(false);
            s2.setVisible(true);
            rotateTransition2.play();

        });
       // rotateTransition2.play();
        rotateTransition2.setOnFinished((e) -> {
            s2.setVisible(false);
            c2.setVisible(true);
            a2.setVisible(true);
            txt3.setText("Scaning Memory");
            //s1.setImage(new Image("reload.png"));
            //b2.setImage(new Image("@img/reload"));
            b3.setVisible(false);
            s3.setVisible(true);
            rotateTransition3.play();

        });
        rotateTransition3.setOnFinished((e) -> {
            s3.setVisible(false);
            c3.setVisible(true);
            a3.setVisible(true);
            txt4.setText("Scaning Registry");
            //s1.setImage(new Image("reload.png"));
            //b2.setImage(new Image("@img/reload"));
            b4.setVisible(false);
            s4.setVisible(true);
            rotateTransition4.play();

        });
        rotateTransition4.setOnFinished((e) -> {
            s4.setVisible(false);
            c4.setVisible(true);
            a4.setVisible(true);
            txt5.setText("Completing");
            b5.setVisible(false);
            s5.setVisible(true);
            rotateTransition5.play();

        });
        rotateTransition5.setOnFinished((e) -> {
            s5.setVisible(false);
            c5.setVisible(true);
            result.setText("Safe ;-)");


        });


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
