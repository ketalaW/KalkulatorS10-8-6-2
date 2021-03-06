package com.mycompany.kalkulator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLController implements Initializable {

    @FXML
    private TextField fi;
    @FXML
    private Label labelWynik1;

    Button button = new Button();
    private double num1, num2;
    private String sign;

    @FXML
    private Label labelWynik2;
    @FXML
    private Label labelWynik3;

    @FXML
    private void clickButton9(ActionEvent event) {
        setText("9");
    }

    @FXML
    private void clickButton8(ActionEvent event) {
        setText("8");
    }

    @FXML
    private void clickButton7(ActionEvent event) {
        setText("7");
    }

    @FXML
    private void clickButton6(ActionEvent event) {
        setText("6");
    }

    @FXML
    private void clickButton5(ActionEvent event) {
        setText("5");
    }

    @FXML
    private void clickButton4(ActionEvent event) {
        setText("4");
    }

    @FXML
    private void clickButton3(ActionEvent event) {
        setText("3");
    }

    @FXML
    private void clickButton2(ActionEvent event) {
        setText("2");
    }

    @FXML
    private void clickButton1(ActionEvent event) {
        setText("1");
    }

    @FXML
    private void clickButton0(ActionEvent event) {
        setText("0");
    }

    @FXML
    private void clickButtonComma(ActionEvent event) {
        if (checkCanAddComma()) {
            setText(".");
        }
    }

    @FXML
    private void clickButtonSub(ActionEvent event) {
        operation("-");
    }

    @FXML
    private void clickButtonAdd(ActionEvent event) {
        operation("+");
    }

    @FXML
    private void clickButtonDiv(ActionEvent event) {
        operation("/");
    }

    @FXML
    private void clickButtonMulti(ActionEvent event) {
        operation("*");
    }

    @FXML
    private void clickButtonEgual(ActionEvent event) {
        equal();
        convertAndShow();
    }

    @FXML
    private void clickButtonC(ActionEvent event) {
        fi.clear();
    }

    private void setText(String val) {
        fi.setText(fi.getText() + val);
    }

    private void equal() {
        num2 = Double.parseDouble(fi.getText());
       
        if ("-".equals(sign)) {
            fi.setText(String.valueOf(num1 - num2));
        }
        if ("+".equals(sign)) {
            fi.setText(String.valueOf(num1 + num2));
        }
        if ("*".equals(sign)) {
            fi.setText(String.valueOf(num1 * num2));
        }
        if ("/".equals(sign)) {
            if (checkCanDiv()) {
                fi.setText(String.valueOf(num1 / num2));
            }
        }
        num1 = Double.parseDouble(fi.getText());
        num2 = 0;
    }

    private void operation(String _sign) {
        SetZeroIfIsEmpty();

        num1 = Double.valueOf(fi.getText());
        sign = _sign;
        convertAndShow();
        fi.clear();

    }

    private void SetZeroIfIsEmpty() {
        if (fi.getText().isEmpty()) {
            setText("0");
        }
    }

    private void convertAndShow() {
        double y = Double.valueOf(fi.getText());
        int var = (int) y;
        System.out.print(var);
        labelWynik1.setText(Integer.toString(var, 2));
        labelWynik2.setText(Integer.toString(var, 6));
        labelWynik3.setText(Integer.toString(var, 8));
    }

    private Boolean checkCanAddComma() {
        if (fi.getText().isEmpty() || fi.getText().indexOf(".") != -1) {
            return false;
        }
        return true;
    }

    private Boolean checkCanDiv() {
        if ("0".equals(fi.getText())) {
            return false;
        }
        return true;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
