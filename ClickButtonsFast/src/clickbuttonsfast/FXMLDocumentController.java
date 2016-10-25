/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clickbuttonsfast;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.Date;
import javafx.scene.text.Font;

/**
 *
 * @author Bruger
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Button btn9;
    @FXML
    private Button btn10;
    @FXML
    private Button btn11;
    @FXML
    private Button btn12;
    
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    
    private Logic logic = new Logic();
    private long timeStart;
    private long timeEnd;
    private int COUNT_AMOUNT = 30;
    private int count = COUNT_AMOUNT;
    
    //Button[] btnArray = {btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12};
    Button[] btnArray = new Button[12];
    Font myFontSmall = new Font("System", 16);
    Font myFontLarge = new Font("System", 48);
    
    @FXML
    private void handleButtonAction(ActionEvent event) 
    {
        Object source = event.getSource();
        Button clickedBtn = btn1;
        
        String btnString = source.toString();
        String subString = btnString.substring(btnString.indexOf("1") + 1, btnString.indexOf("1") +2);
        
        switch(subString)
        {
            case "0": clickedBtn = btn10; break;
            case "1": clickedBtn = btn11; break;
            case "2": clickedBtn = btn12; break;          
        }
        clickedBtn.setText("Button");
        
        if (logic.checkForRightButton(Integer.parseInt(subString))) 
        {
            if(count <= 1)
            {
                gameOver("1");
            }
            else
            {
               count--;
               label2.setText(count + "");
               logic.moveRowsDown();
               writeVisuals(); 
            }
            
        }
        else
        {
            gameOver("YOU LOST");
        }

      
    }
    @FXML
    private void newGame()
    {
        for (int i = 0; i < btnArray.length; i++) 
        {
            btnArray[i].setFont(myFontLarge);
        }
        
        label1.setText("");
        logic.fillArray();
        
        Date date = new Date();
        timeStart =  date.getTime();
        writeVisuals();
        btn10.setDisable(false);
        btn11.setDisable(false);
        btn12.setDisable(false);
        
        count = COUNT_AMOUNT;
        label2.setText(count + "");
    }
    private void gameOver(String gameOverMessage)
    {
        Date date = new Date();
        timeEnd = date.getTime();
        
        long timePassed = timeEnd-timeStart;
        double timePassedSeconds = (double)timePassed/1000;
        label1.setText("" + timePassedSeconds + " Seconds (" + gameOverMessage + ")");
        
        btn10.setDisable(true);
        btn11.setDisable(true);
        btn12.setDisable(true);
        
        for (int i = 0; i < btnArray.length; i++) 
        {
           btnArray[i].setFont(myFontSmall);
           if(gameOverMessage.equals("1"))
           {
               
               btnArray[i].setText(timePassedSeconds + "s");
           }
           else
           {
               
               btnArray[i].setText("YOU LOST");
           }
           
        }
    }
    
    private void writeVisuals()
    {
        int[][] array = logic.getArray();
        int k = 0;
        for (int i = 0; i < 4; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {               
                if (array[i][j] == 0) 
                {
                    btnArray[k].setText("");
                }
                else
                {
                    btnArray[k].setText("O");
                }
                k++;
            }
    
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        btn10.setDisable(true);
        btn11.setDisable(true);
        btn12.setDisable(true);
        btnArray[0] = btn1;
        btnArray[1] = btn2;
        btnArray[2] = btn3;
        btnArray[3] = btn4;
        btnArray[4] = btn5;
        btnArray[5] = btn6;
        btnArray[6] = btn7;
        btnArray[7] = btn8;
        btnArray[8] = btn9;
        btnArray[9] = btn10;
        btnArray[10] = btn11;
        btnArray[11] = btn12;
        
        count = COUNT_AMOUNT;
        //label2.setText("Count: " + count);
        label2.setText(count + "");
    }    
    
}
