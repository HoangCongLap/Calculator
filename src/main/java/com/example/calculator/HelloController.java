package com.example.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label lblResult;
    private double x,y;
    private double num1=0;
    private String Operator= "+";

    @FXML
    protected void onNumberClicked(MouseEvent event) {
        int value=Integer.parseInt(((Button)event.getSource()).getId().replace("nb",""));
        String text;
       if(Double.parseDouble(lblResult.getText())==0){
           text=String.valueOf((double) value);
       }else{
           Double sum =Double.parseDouble(lblResult.getText())*10+value;
           text=String.valueOf(sum);

       }
        lblResult.setText(text);
    }
    @FXML
    void onSymbolClicked(MouseEvent event){
        String symol= ((Button)event.getSource()).getId().replace("nb","");
        if(symol.equals("Equals")){
            double num2=Double.parseDouble(lblResult.getText());
            switch (Operator){
                case "+" -> lblResult.setText((num1+num2)+"");
                case "-" -> lblResult.setText((num1-num2)+"");
                case "*" -> lblResult.setText((num1*num2)+"");
                case "/" -> lblResult.setText((num1/num2)+"");
            }
            Operator=".";
        }
        else if (symol.equals("clear")){
            lblResult.setText(String.valueOf(0.0));
            Operator=".";
        }
        else{
            switch (symol){
                case "Plus" ->Operator="+";
                case "Minus" ->Operator="-";
                case "Multiply" ->Operator="*";
                case "Divide" ->Operator="/";
            }
            num1=Double.parseDouble(lblResult.getText());
            lblResult.setText(String.valueOf(0.0));
        }
    }
}
