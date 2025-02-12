package lk.acpt.demofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController {


String operation;

    @FXML
    private TextField txtNumber1;

    @FXML
    private TextField txtNumber2;


    double answer = 0;
    double firstNumber = Double.parseDouble(txtNumber1.getText());
    double secondNumber =Double.parseDouble(txtNumber2.getText());


    @FXML
    void addition(ActionEvent event) {
        double firstNumber = Double.parseDouble(txtNumber1.getText());
        double secondNumber =Double.parseDouble(txtNumber2.getText());

        answer=( firstNumber + secondNumber);
        operation = "addition";
    }

    @FXML
    void division(ActionEvent event) {
        double firstNumber = Double.parseDouble(txtNumber1.getText());
        double secondNumber =Double.parseDouble(txtNumber2.getText());
        answer=(firstNumber/secondNumber);
        operation = "division";
    }

    @FXML
    void multiplication(ActionEvent event) {
        double firstNumber = Double.parseDouble(txtNumber1.getText());
        double secondNumber =Double.parseDouble(txtNumber2.getText());
        answer=(firstNumber*secondNumber);
        operation = "multiplication";
    }

    @FXML
    void subtraction(ActionEvent event) {
        double firstNumber = Double.parseDouble(txtNumber1.getText());
        double secondNumber =Double.parseDouble(txtNumber2.getText());
        answer=(firstNumber-secondNumber) ;
        operation = "subtraction";
    }

    @FXML
    private Label lblAnswer;


    @FXML
    void answer(ActionEvent event) {
        lblAnswer.setText(String.valueOf(answer));
//        System.out.println("Answer is "+answer);
    }




//Add switch method to get calculation



    public void getAnswer(){

    }


}
