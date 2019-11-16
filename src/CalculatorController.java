/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package mvc;

/**
 * @author AsmaPC
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

// Le Controlleur fait la coordination des interactions entre la vue et le modèle

public class CalculatorController {

    private CalculatorView theView;
    private CalculatorModel theModel;

    CalculatorController(CalculatorView theView, CalculatorModel theModel) {
        this.theView = theView;
        this.theModel = theModel;

        this.theView.addListener(new CalculateListener());
    }


    public void switchUI(int type,String data) {
        this.theView.dispose();
        this.theView = new CalculatorView(type,data);
        new CalculatorController(theView, theModel);
    }

    private void b0_isClicked() {
        theView.autoAddOrRemove("number");
        theView.textField.setText(theView.textField.getText() + "0");
    }


    private void b1_isClicked() {
        theView.autoAddOrRemove("number");
        theView.textField.setText(theView.textField.getText() + "1");
    }


    private void b2_isClicked() {
        theView.autoAddOrRemove("number");
        theView.textField.setText(theView.textField.getText() + "2");
    }


    private void b3_isClicked() {
        theView.autoAddOrRemove("number");
        theView.textField.setText(theView.textField.getText() + "3");
    }


    private void b4_isClicked() {
        theView.autoAddOrRemove("number");
        theView.textField.setText(theView.textField.getText() + "4");
    }


    private void b5_isClicked() {
        theView.autoAddOrRemove("number");
        theView.textField.setText(theView.textField.getText() + "5");
    }


    private void b6_isClicked() {
        theView.autoAddOrRemove("number");
        theView.textField.setText(theView.textField.getText() + "6");
    }


    private void b7_isClicked() {
        theView.autoAddOrRemove("number");
        theView.textField.setText(theView.textField.getText() + "7");
    }


    private void b8_isClicked() {
        theView.autoAddOrRemove("number");
        theView.textField.setText(theView.textField.getText() + "8");
    }


    private void b9_isClicked() {
        theView.autoAddOrRemove("number");
        theView.textField.setText(theView.textField.getText() + "9");
    }


    private void sin_isClicked() {
        theView.autoAddOrRemove("symbol");
        theView.textField.setText(theView.textField.getText() + "sin");
    }


    private void cos_isClicked() {
        theView.autoAddOrRemove("symbol");
        theView.textField.setText(theView.textField.getText() + "cos");
    }


    private void tan_isClicked() {
        theView.autoAddOrRemove("symbol");
        theView.textField.setText(theView.textField.getText() + "tan");
    }


    private void sqrt_isClicked() {
        theView.autoAddOrRemove("symbol");
        theView.textField.setText(theView.textField.getText() + "\u221a");
    }


    private void exponential_isClicked() {
        theView.autoAddOrRemove("symbol");
        theView.textField.setText(theView.textField.getText() + "e");
    }


    private void pi_isClicked() {
        theView.autoAddOrRemove("symbol");
        theView.textField.setText(theView.textField.getText() + "\u03c0");
    }


    private void plus_isClicked() {
        theView.autoAddOrRemove("operand");
        theView.textField.setText(theView.textField.getText() + "+");
    }


    private void minus_isClicked() {
        theView.autoAddOrRemove("operand");
        theView.textField.setText(theView.textField.getText() + "-");
    }


    private void multiple_isClicked() {
        if (!theView.textField.getText().isEmpty()) {
            theView.autoAddOrRemove("operand");
            theView.textField.setText(theView.textField.getText() + "×");
        }
    }


    private void divide_isClicked() {
        if (!theView.textField.getText().isEmpty()) {
            theView.autoAddOrRemove("operand");
            theView.textField.setText(theView.textField.getText() + "÷");
        }
    }


    private void factoriel_isClicked() {
        if (!theView.textField.getText().isEmpty()) {
            theView.autoAddOrRemove("operand");
            theView.textField.setText(theView.textField.getText() + "!");
        }
    }


    private void power_isClicked() {
        if (theView.textField.getText().matches(".*[0-9e?)]$"))
            theView.textField.setText(theView.textField.getText() + "^");
    }


    private void parentesesRight_isClicked() {
        if (theView.textField.getText().matches(".*[^ns?(]$")) {
            int leftParentesesCounter = 0, rightParentesesCounter = 0;
            for (char c : theView.textField.getText().toCharArray()) {
                if (c == '(')
                    leftParentesesCounter++;
                else if (c == ')')
                    rightParentesesCounter++;
            }
            if (leftParentesesCounter > rightParentesesCounter)
                theView.textField.setText(theView.textField.getText() + ")");
        }
    }


    private void parentesesLeft_isClicked() {
        theView.autoAddOrRemove("symbol");
        theView.textField.setText(theView.textField.getText() + "(");
    }


    private void comma_isClicked() {
        String str = theView.textField.getText();
        if (theView.textField.getText().isEmpty()) {
            theView.textField.setText("0.");
        } else {
            int lastPointIndex = str.lastIndexOf(".");
            int lastPlusIndex = str.lastIndexOf("+");
            int lastMinusIndex = str.lastIndexOf("-");
            int lastMultipleIndex = str.lastIndexOf("×");
            int lastDivideIndex = str.lastIndexOf("÷");
            int lastModuloIndex = str.lastIndexOf("!");

            if (lastPointIndex <= lastPlusIndex ||
                    lastPointIndex <= lastMinusIndex ||
                    lastPointIndex <= lastMultipleIndex ||
                    lastPointIndex <= lastDivideIndex ||
                    lastPointIndex <= lastModuloIndex) {
                theView.autoAddOrRemove("point");
                theView.textField.setText(theView.textField.getText() + ".");
            }
        }
    }


    private void equal_isClicked() {
        if (!theView.textField.getText().isEmpty()) {
            if (theView.currentMode == 2) {
                ArrayList<String> values = new ArrayList<>();
                ArrayList<String> operat = new ArrayList<>();

                String str = theView.textField.getText();
                String tmp = "";
                for (int i = 0; i <= str.length(); i++) {
                    if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '×' || str.charAt(i) == '÷' ||
                            i == str.length() - 1) {
                        if (i == str.length() - 1) {
                            tmp += String.valueOf(str.charAt(i));
                            values.add(tmp);
                            break;
                        } else {
                            values.add(tmp);
                            operat.add(String.valueOf(str.charAt(i)));
                            tmp = "";
                            continue;
                        }

                    }
                    tmp += String.valueOf(str.charAt(i));
                }

                String result = values.get(0);
                values.remove(0);
                int i = 0;
                for (String s : values) {
                    String op = "";
                    switch (operat.get(i)) {
                        case "+":
                            op = "add";
                            break;
                        case "-":
                            op = "subtract";
                            break;
                        case "×":
                            op = "multiply";
                            break;
                        case "÷":
                            op = "divide";
                            break;
                    }


                    result = BinaryCalculator.calculate(result, s, op);
                    i++;
                    if (values.size() == i) {
                        if (result == "-1") {
                            theView.textField.setText("Error");
                        } else {
                            theView.textField.setText(result);
                        }
                    }
                }
            } else {
                try {
                    Double answer = theModel.calculate(theView.textField.getText());
                    if (answer.isInfinite()) {
                        theView.textField.setText("cannot divide by 0");
                    } else if (answer.isNaN()) {
                        theView.textField.setText("Error");
                    } else {
                        theView.textField.setText(theView.format.format(answer));
                    }
                } catch (Exception ex) {
                    theView.textField.setText("Error");
                }
            }
        }
    }


    private void back_isClicked() {
        String temp = theView.textField.getText();
        if (temp.equals("Error") || temp.equals("cannot divide by 0")) {
            theView.textField.setText("");
        } else if (!temp.isEmpty()) {
            temp = theView.textField.getText().substring(0, theView.textField.getText().length() - 1);
            if (temp.length() >= 2) {
                switch (temp.substring(temp.length() - 2)) {
                    case "co":
                    case "si":
                    case "ta":
                        temp = temp.substring(0, temp.length() - 2);
                        break;
                }
            }
            theView.textField.setText(temp);
        }
    }


    private void clear_isClicked() {
        theView.textField.setText("0");
    }



    class CalculateListener implements ActionListener, KeyListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == theView.b0)
                b0_isClicked();

            else if (e.getSource() == theView.b1)
                b1_isClicked();

            else if (e.getSource() == theView.b2)
                b2_isClicked();

            else if (e.getSource() == theView.b3)
                b3_isClicked();

            else if (e.getSource() == theView.b4)
                b4_isClicked();

            else if (e.getSource() == theView.b5)
                b5_isClicked();

            else if (e.getSource() == theView.b6)
                b6_isClicked();

            else if (e.getSource() == theView.b7)
                b7_isClicked();

            else if (e.getSource() == theView.b8)
                b8_isClicked();

            else if (e.getSource() == theView.b9)
                b9_isClicked();

            else if (e.getSource() == theView.sin)
                sin_isClicked();

            else if (e.getSource() == theView.cos)
                cos_isClicked();

            else if (e.getSource() == theView.tan)
                tan_isClicked();

            else if (e.getSource() == theView.sqrt)
                sqrt_isClicked();

            else if (e.getSource() == theView.exponential)
                exponential_isClicked();

            else if (e.getSource() == theView.pi)
                pi_isClicked();

            else if (e.getSource() == theView.plus)
                plus_isClicked();

            else if (e.getSource() == theView.minus)
                minus_isClicked();

            else if (e.getSource() == theView.multiple)
                multiple_isClicked();

            else if (e.getSource() == theView.divide)
                divide_isClicked();

            else if (e.getSource() == theView.factoriel)
                factoriel_isClicked();

            else if (e.getSource() == theView.power)
                power_isClicked();

            else if (e.getSource() == theView.parentesesRight)
                parentesesRight_isClicked();

            else if (e.getSource() == theView.parentesesLeft)
                parentesesLeft_isClicked();

            else if (e.getSource() == theView.comma)
                comma_isClicked();

            else if (e.getSource() == theView.equal)
                equal_isClicked();

            else if (e.getSource() == theView.back)
                back_isClicked();

            else if (e.getSource() == theView.clear)
                clear_isClicked();
            else if (e.getSource() == theView.basic) {
                String data = theView.textField.getText();
                if (theView.currentMode == 2) {
                    data=BinaryCalculator.getDec(data);
                }
                switchUI(1,data);
            } else if (e.getSource() == theView.binaire) {
                String data = "0";
                if (theView.currentMode==1)
                    data = BinaryCalculator.getBin(theView.textField.getText());
                switchUI(2,data);
            } else if (e.getSource() == theView.scientifique) {
                String data = "0";
                if (theView.currentMode==1)
                    data = theView.textField.getText();
                switchUI(3,data);
            }
        }


        @Override
        public void keyPressed(KeyEvent e) {
            if (theView.currentMode == 2) {
                switch (e.getKeyChar()) {
                    case '0':
                    case '\u0660':
                        b0_isClicked();
                        break;

                    case '1':
                    case '\u0661':
                        b1_isClicked();
                        break;


                    case '+':
                        plus_isClicked();
                        break;

                    case '-':
                        minus_isClicked();
                        break;

                    case '*':
                    case '×':
                        multiple_isClicked();
                        break;

                    case '/':
                    case '÷':
                        divide_isClicked();
                        break;


                    case '=':
                    case '\n':
                        equal_isClicked();
                        break;

                }

                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
                    back_isClicked();

                else if (e.getKeyCode() == KeyEvent.VK_DELETE)
                    clear_isClicked();

            } else {
                switch (e.getKeyChar()) {
                    case '0':
                    case '\u0660':
                        b0_isClicked();
                        break;

                    case '1':
                    case '\u0661':
                        b1_isClicked();
                        break;

                    case '2':
                    case '\u0662':
                        b2_isClicked();
                        break;

                    case '3':
                    case '\u0663':
                        b3_isClicked();
                        break;

                    case '4':
                    case '\u0664':
                        b4_isClicked();
                        break;

                    case '5':
                    case '\u0665':
                        b5_isClicked();
                        break;

                    case '6':
                    case '\u0666':
                        b6_isClicked();
                        break;

                    case '7':
                    case '\u0667':
                        b7_isClicked();
                        break;

                    case '8':
                    case '\u0668':
                        b8_isClicked();
                        break;

                    case '9':
                    case '\u0669':
                        b9_isClicked();
                        break;


                    case '+':
                        plus_isClicked();
                        break;

                    case '-':
                        minus_isClicked();
                        break;

                    case '*':
                    case '×':
                        multiple_isClicked();
                        break;

                    case '/':
                    case '÷':
                        divide_isClicked();
                        break;

                    case '!':
                        factoriel_isClicked();
                        break;

                    case '^':
                        power_isClicked();
                        break;

                    case ')':
                        parentesesRight_isClicked();
                        break;

                    case '(':
                        parentesesLeft_isClicked();
                        break;

                    case '.':
                        comma_isClicked();
                        break;

                    case '=':
                    case '\n':
                        equal_isClicked();
                        break;

                }

                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
                    back_isClicked();

                else if (e.getKeyCode() == KeyEvent.VK_DELETE)
                    clear_isClicked();

            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void keyTyped(KeyEvent e) {

        }
    }

}