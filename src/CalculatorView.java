/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package mvc;

/**
 * @author AsmaPC
 */


// Le seul travail de la vue est d'afficher ce que l'utilisateur voit
// La vue n'effectue pas d'opérations

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;

public class CalculatorView extends JFrame {

    private static int BSC_VIEW = 1, BIN_VIEW = 2, SCI_VIEW = 3;

    JMenuBar menuBar;
    JMenu file;
    JMenuItem binaire, basic, scientifique;

    JPanel panel;
    JTextField textField;
    int currentMode;
    DecimalFormat format = new DecimalFormat("0.###############");
    private String data;

    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, comma, plus, minus,
            divide, multiple, cos, sin, tan, sqrt, clear, back, equal,
            parentesesLeft, parentesesRight, power, factoriel, exponential, pi;

    Font font1 = new Font("Arial", Font.BOLD, 17);
    Font font2 = new Font("Arial", Font.BOLD, 9);
    Font font3 = new Font("Arial", Font.BOLD, 12);

    CalculatorView(int type,String data) {

        this.data = data;
        createAndShowGUI(type);
        currentMode = type;
    }

    CalculatorView() {

        //default calculatrice standard
        createAndShowGUI(BSC_VIEW);
        currentMode = BSC_VIEW;


		/*this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("calculatrice");
        this.setResizable(false);
		this.setSize(300, 300);
        // Ajouter une icone à la fenetre
		ImageIcon imgicon = new ImageIcon(
		new ImageIcon("IconCalculatrice.png").getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
		this.setIconImage(imgicon.getImage());*/

    }



    private void createAndShowGUI(int type) {

        currentMode = type;
        this.repaint();
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ignored) {
        }


        menuBar = new JMenuBar();
        file = new JMenu(" file ");
        binaire = new JMenuItem("Calculatrice binaire");
        basic = new JMenuItem("Calculatrice standard");
        scientifique = new JMenuItem("Calculatrice scientifique");

        menuBar.add(file);
        file.add(basic);
        file.add(binaire);
        file.add(scientifique);


        panel = new JPanel(null);
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        comma = new JButton(".");
        plus = new JButton("+");
        minus = new JButton("-");
        multiple = new JButton("×");
        divide = new JButton("÷");
        cos = new JButton("cos");
        sin = new JButton("sin");
        tan = new JButton("tan");
        sqrt = new JButton("\u221a");
        power = new JButton("^");
        factoriel = new JButton("!");
        exponential = new JButton("e");
        pi = new JButton("\u03c0");
        parentesesLeft = new JButton("(");
        parentesesRight = new JButton(")");
        equal = new JButton("=");
        clear = new JButton("C");
        back = new JButton("\u2190");
        textField = new JTextField(data);


        if (type == SCI_VIEW) {
            panel.setBounds(0, 0, 256, 358);
            textField.setBounds(11, 11, 234, 60);
            cos.setBounds(10, 80, 45, 38);
            sin.setBounds(58, 80, 45, 38);
            tan.setBounds(106, 80, 45, 38);
            back.setBounds(154, 80, 45, 38);
            clear.setBounds(202, 80, 45, 38);
            pi.setBounds(10, 121, 45, 38);
            exponential.setBounds(58, 121, 45, 38);
            factoriel.setBounds(106, 121, 45, 38);
            parentesesLeft.setBounds(154, 121, 45, 38);
            parentesesRight.setBounds(202, 121, 45, 38);
            b7.setBounds(10, 161, 45, 38);
            b8.setBounds(58, 161, 45, 38);
            b9.setBounds(106, 161, 45, 38);
            plus.setBounds(154, 161, 45, 38);
            power.setBounds(202, 161, 45, 38);
            b4.setBounds(10, 201, 45, 38);
            b5.setBounds(58, 201, 45, 38);
            b6.setBounds(106, 201, 45, 38);
            minus.setBounds(154, 201, 45, 38);
            sqrt.setBounds(202, 201, 45, 38);
            b1.setBounds(10, 241, 45, 38);
            b2.setBounds(58, 241, 45, 38);
            b3.setBounds(106, 241, 45, 38);
            multiple.setBounds(154, 241, 45, 38);
            equal.setBounds(202, 241, 45, 78);
            b0.setBounds(10, 281, 93, 38);
            comma.setBounds(106, 281, 45, 38);
            divide.setBounds(154, 281, 45, 38);

        } else {
            panel.setBounds(0, 0, 256, 300);
            textField.setBounds(11, 11, 234, 60);
            b7.setBounds(10, 80, 45, 38);
            b8.setBounds(58, 80, 45, 38);
            b9.setBounds(106, 80, 45, 38);
            plus.setBounds(154, 80, 45, 38);
            clear.setBounds(202, 80, 45, 38);
            b4.setBounds(10, 121, 45, 38);
            b5.setBounds(58, 121, 45, 38);
            b6.setBounds(106, 121, 45, 38);
            minus.setBounds(154, 121, 45, 38);
            back.setBounds(202, 121, 45, 38);
            b1.setBounds(10, 161, 45, 38);
            b2.setBounds(58, 161, 45, 38);
            b3.setBounds(106, 161, 45, 38);
            multiple.setBounds(154, 161, 45, 38);
            equal.setBounds(202, 161, 45, 78);
            b0.setBounds(10, 201, 93, 38);
            comma.setBounds(106, 201, 45, 38);
            divide.setBounds(154, 201, 45, 38);


        }

        file.setFont(font3);
        binaire.setFont(font3);
        basic.setFont(font3);
        scientifique.setFont(font3);
        b0.setFont(font1);
        b1.setFont(font1);
        b2.setFont(font1);
        b3.setFont(font1);
        b4.setFont(font1);
        b5.setFont(font1);
        b6.setFont(font1);
        b7.setFont(font1);
        b8.setFont(font1);
        b9.setFont(font1);
        comma.setFont(font1);
        equal.setFont(font1);
        plus.setFont(font1);
        minus.setFont(font1);
        multiple.setFont(font1);
        divide.setFont(font1);
        cos.setFont(font2);
        sin.setFont(font2);
        tan.setFont(font2);
        sqrt.setFont(font1);
        power.setFont(font1);
        factoriel.setFont(font1);
        exponential.setFont(font1);
        pi.setFont(font1);
        parentesesLeft.setFont(font1);
        parentesesRight.setFont(font1);
        clear.setFont(font1);
        back.setFont(font1);


        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setFont(new Font("Monospaced", Font.BOLD, 19));


        b0.setForeground(Color.white);
        b1.setForeground(Color.white);
        b2.setForeground(Color.white);
        b3.setForeground(Color.white);
        b4.setForeground(Color.white);
        b5.setForeground(Color.white);
        b6.setForeground(Color.white);
        b7.setForeground(Color.white);
        b8.setForeground(Color.white);
        b9.setForeground(Color.white);
        comma.setForeground(Color.white);
        equal.setForeground(Color.white);
        plus.setForeground(Color.white);
        minus.setForeground(Color.white);
        multiple.setForeground(Color.white);
        divide.setForeground(Color.white);
        cos.setForeground(Color.white);
        sin.setForeground(Color.white);
        tan.setForeground(Color.white);
        sqrt.setForeground(Color.white);
        power.setForeground(Color.white);
        factoriel.setForeground(Color.white);
        exponential.setForeground(Color.white);
        pi.setForeground(Color.white);
        parentesesLeft.setForeground(Color.white);
        parentesesRight.setForeground(Color.white);
        clear.setForeground(Color.white);
        back.setForeground(Color.white);


        textField.setBackground(Color.lightGray);
        b0.setBackground(Color.darkGray);
        b1.setBackground(Color.darkGray);
        b2.setBackground(Color.darkGray);
        b3.setBackground(Color.darkGray);
        b4.setBackground(Color.darkGray);
        b5.setBackground(Color.darkGray);
        b6.setBackground(Color.darkGray);
        b7.setBackground(Color.darkGray);
        b8.setBackground(Color.darkGray);
        b9.setBackground(Color.darkGray);
        comma.setBackground(Color.darkGray);
        plus.setBackground(Color.black);
        minus.setBackground(Color.black);
        multiple.setBackground(Color.black);
        divide.setBackground(Color.black);
        cos.setBackground(Color.black);
        sin.setBackground(Color.black);
        tan.setBackground(Color.black);
        sqrt.setBackground(Color.black);
        power.setBackground(Color.black);
        factoriel.setBackground(Color.black);
        exponential.setBackground(Color.black);
        pi.setBackground(Color.black);
        parentesesLeft.setBackground(Color.black);
        parentesesRight.setBackground(Color.black);
        equal.setBackground(Color.black);
        clear.setBackground(new Color(223, 1, 1));
        back.setBackground(new Color(255, 128, 0));
        panel.setBackground(Color.black);
        getContentPane().setBackground(Color.black);

        textField.setFocusable(false);
        b0.setFocusable(false);
        b1.setFocusable(false);
        b2.setFocusable(false);
        b3.setFocusable(false);
        b4.setFocusable(false);
        b5.setFocusable(false);
        b6.setFocusable(false);
        b7.setFocusable(false);
        b8.setFocusable(false);
        b9.setFocusable(false);
        comma.setFocusable(false);
        plus.setFocusable(false);
        minus.setFocusable(false);
        multiple.setFocusable(false);
        divide.setFocusable(false);
        cos.setFocusable(false);
        sin.setFocusable(false);
        tan.setFocusable(false);
        sqrt.setFocusable(false);
        power.setFocusable(false);
        factoriel.setFocusable(false);
        exponential.setFocusable(false);
        pi.setFocusable(false);
        parentesesLeft.setFocusable(false);
        parentesesRight.setFocusable(false);
        equal.setFocusable(false);
        clear.setFocusable(false);
        back.setFocusable(false);

        if (type == BIN_VIEW) {
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
            comma.setEnabled(false);
        }

        panel.add(b0);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        panel.add(comma);
        panel.add(equal);
        panel.add(plus);
        panel.add(multiple);
        panel.add(minus);
        panel.add(divide);
        panel.add(cos);
        panel.add(sin);
        panel.add(tan);
        panel.add(sqrt);
        panel.add(power);
        panel.add(factoriel);
        panel.add(exponential);
        panel.add(pi);
        panel.add(parentesesRight);
        panel.add(parentesesLeft);
        panel.add(clear);
        panel.add(back);
        panel.add(textField);

        add(panel);
        setJMenuBar(menuBar);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (type == SCI_VIEW) {
            this.setSize(262, 380);
            this.setTitle("Scientifique");

        } else if (type == BSC_VIEW) {
            this.setSize(262, 300);
            this.setTitle("Standard");

        } else {
            this.setSize(262, 300);
            this.setTitle("Binaire");
        }

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
        ImageIcon imgicon = new ImageIcon(
                new ImageIcon("IconCalculatrice.png").getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
        this.setIconImage(imgicon.getImage());
        this.validate();
        this.repaint();
    }


    void addListener(ActionListener listenForChange) {
        b0.addActionListener(listenForChange);
        b1.addActionListener(listenForChange);
        b2.addActionListener(listenForChange);
        b3.addActionListener(listenForChange);
        b4.addActionListener(listenForChange);
        b5.addActionListener(listenForChange);
        b6.addActionListener(listenForChange);
        b7.addActionListener(listenForChange);
        b8.addActionListener(listenForChange);
        b9.addActionListener(listenForChange);
        comma.addActionListener(listenForChange);
        exponential.addActionListener(listenForChange);
        pi.addActionListener(listenForChange);
        cos.addActionListener(listenForChange);
        sin.addActionListener(listenForChange);
        tan.addActionListener(listenForChange);
        sqrt.addActionListener(listenForChange);
        power.addActionListener(listenForChange);
        factoriel.addActionListener(listenForChange);
        parentesesLeft.addActionListener(listenForChange);
        parentesesRight.addActionListener(listenForChange);
        plus.addActionListener(listenForChange);
        multiple.addActionListener(listenForChange);
        divide.addActionListener(listenForChange);
        minus.addActionListener(listenForChange);
        equal.addActionListener(listenForChange);
        clear.addActionListener(listenForChange);
        back.addActionListener(listenForChange);
        basic.addActionListener(listenForChange);
        binaire.addActionListener(listenForChange);
        scientifique.addActionListener(listenForChange);

        addKeyListener((KeyListener) listenForChange);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    void autoAddOrRemove(String button) {


        if (!textField.getText().isEmpty()) {
            Character lastCharacter = textField.getText().charAt(textField.getText().length() - 1);

            switch (button) {


                case "symbol":
                    switch (lastCharacter) {
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                        case 'e':
                        case '\u03c0':
                            textField.setText(textField.getText() + "×");
                            break;
                        case '.':
                            textField.setText(textField.getText() + "0×");
                            break;
                    }
                    break;


                case "number":
                    switch (lastCharacter) {
                        case 'e':
                        case '\u03c0':
                            textField.setText(textField.getText() + "×");
                            break;
                        case '0':
                            String str = textField.getText();
                            if (str.equals("0") ||
                                    str.endsWith("+0") ||
                                    str.endsWith("-0") ||
                                    str.endsWith("×0") ||
                                    str.endsWith("÷0") ||
                                    str.endsWith("!0") ||
                                    str.endsWith("^0") ||
                                    str.endsWith("\u221a0") ||
                                    str.endsWith("(0") ||
                                    str.endsWith("cos0") ||
                                    str.endsWith("sin0") ||
                                    str.endsWith("tan0"))
                                textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
                            break;
                    }
                    break;


                case "operand":
                    switch (lastCharacter) {
                        case '+':
                        case '-':
                        case '×':
                        case '÷':
                        case '!':
                        case '.':
                            textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
                            break;
                    }
                    break;


                case "point":
                    switch (lastCharacter) {
                        case '+':
                        case '-':
                        case '×':
                        case '÷':
                        case '!':
                        case '(':
                        case '\u221a':
                        case '\u03c0':
                        case 's':
                        case 'n':
                        case '^':
                            textField.setText(textField.getText() + "0");
                            break;
                        case ')':
                            textField.setText(textField.getText() + "×0");
                            break;
                        case '.':
                            textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
                            break;
                    }
                    break;

            }
        }
    }




    void displayErrorMessage(String errorMessage) {

        JOptionPane.showMessageDialog(this, errorMessage);

    }


}
