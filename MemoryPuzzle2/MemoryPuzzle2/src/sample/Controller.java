package sample;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.net.URL;
import java.util.*;
import java.util.List;

public class Controller implements Initializable {
    @FXML
    Button button1, button2, button3, button4,button5, button6, button7, button8,
            button9, button10, button11, button12,button13, button14, button15, button16;

    List<String> listNumbers = new ArrayList();
    int move = 1;
    Button helpButton;
    ImageView [] images1 = new ImageView[16];
    ImageView [] images2 = new ImageView[16];
    Button [] buttons = new Button[16];
    int indHelp = 0;


    public void myButtonClick(Button but, int ind){
        if(move == 1){
            but.setGraphic(images2[ind]);
            helpButton = but;
            indHelp = ind;
            move = 2;
        }
        else
            if(move == 2 && helpButton != but){
                move = 3;
                //but.setText(listNumbers.get(ind));
                but.setGraphic(images2[ind]);
                if(listNumbers.get(indHelp).equals(listNumbers.get(ind))){
                    helpButton.setDisable(true);
                    but.setDisable(true);
                    move = 1;
                }
                else
                {
                    PauseTransition pause = new PauseTransition(Duration.seconds(1));
                    pause.setOnFinished(event -> {
                                helpButton.setGraphic(images1[indHelp]);
                                but.setGraphic(images1[ind]);
                                move = 1;
                            });
                    pause.play();

                }

            }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttons[0] = button1;
        buttons[1] = button2;
        buttons[2] = button3;
        buttons[3] = button4;
        buttons[4] = button5;
        buttons[5] = button6;
        buttons[6] = button7;
        buttons[7] = button8;
        buttons[8] = button9;
        buttons[9] = button10;
        buttons[10] = button11;
        buttons[11] = button12;
        buttons[12] = button13;
        buttons[13] = button14;
        buttons[14] = button15;
        buttons[15] = button16;



        String [] arr = {"myImages/img1.jpg","myImages/img1.jpg","myImages/img2.jpg","myImages/img2.jpg","myImages/img3.png","myImages/img3.png","myImages/img4.jpg","myImages/img4.jpg","myImages/img5.jpg","myImages/img5.jpg","myImages/img6.jpg","myImages/img6.jpg","myImages/img7.jpg","myImages/img7.jpg","myImages/img8.jpg","myImages/img8.jpg"};
        listNumbers = Arrays.asList(arr);
        for(int i=0; i<images1.length; i++) {
            images1[i] = new ImageView(new Image("myImages/img0.png"));
            images1[i].setFitWidth(100);
            images1[i].setFitHeight(100);
            buttons[i].setPadding(Insets.EMPTY);
            buttons[i].setGraphic(images1[i]);
        }

        Collections.shuffle(listNumbers);

        for(int i=0; i<images2.length; i++) {
            images2[i] = new ImageView(new Image(listNumbers.get(i)));
            images2[i].setFitWidth(100);
            images2[i].setFitHeight(100);
        }




        button1.setOnAction(event -> myButtonClick(button1, 0));
        button2.setOnAction(event -> myButtonClick(button2, 1));
        button3.setOnAction(event -> myButtonClick(button3, 2));
        button4.setOnAction(event -> myButtonClick(button4, 3));
        button5.setOnAction(event -> myButtonClick(button5, 4));
        button6.setOnAction(event -> myButtonClick(button6, 5));
        button7.setOnAction(event -> myButtonClick(button7, 6));
        button8.setOnAction(event -> myButtonClick(button8, 7));
        button9.setOnAction(event -> myButtonClick(button9, 8));
        button10.setOnAction(event -> myButtonClick(button10, 9));
        button11.setOnAction(event -> myButtonClick(button11, 10));
        button12.setOnAction(event -> myButtonClick(button12, 11));
        button13.setOnAction(event -> myButtonClick(button13, 12));
        button14.setOnAction(event -> myButtonClick(button14, 13));
        button15.setOnAction(event -> myButtonClick(button15, 14));
        button16.setOnAction(event -> myButtonClick(button16, 15));
    }
}
