import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorOperation extends JPanel {

    private JButton buttonPlas = new JButton("+");
    private JButton buttonMinus = new JButton("-");
    private JButton buttonMultipy = new JButton("*");
    private JButton buttonDivide = new JButton("/");
    private JButton buttonEqual = new JButton("=");
    private JButton buttonAc = new JButton("Ac");
    private JTextArea display;
    CalculatorsVariable cv;


    public CalculatorOperation(JTextArea display, CalculatorsVariable cv) {
        this.display = display;
        this.cv = cv;

        LayoutManager layoutManager = new FlowLayout((FlowLayout.CENTER));
        setLayout(layoutManager);
        add(buttonPlas, layoutManager);
        add(buttonMinus, layoutManager);
        add(buttonMultipy, layoutManager);
        add(buttonDivide, layoutManager);
        add(buttonEqual, layoutManager);
        add(buttonAc, layoutManager);

        buttonAc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("");
                cv.setNumber1("");
                cv.setNumber2("");
                cv.setFirst(false);


            }
        });
        buttonEqual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float result=0;
                try {
                    result = forButtonEquals();
                } catch (DivisionBy0 divisionBy0) {
                    System.out.println(divisionBy0.getMessage());
                    JOptionPane.showMessageDialog(null, divisionBy0.getMessage());
                }
                display.setText(String.valueOf(result));
            }
        });

        buttonPlas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cv.setFirst(true);
                cv.setSymbol('+');
            }
        });
        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cv.setFirst(true);
                cv.setSymbol('-');
            }
        });
        buttonMultipy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cv.setFirst(true);
                cv.setSymbol('*');
            }
        });
        buttonDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cv.setFirst(true);
                cv.setSymbol('/');
            }
        });
    }

    private float forButtonEquals() throws DivisionBy0 {
        System.out.println("TestNum1: " + cv.getNumber1() + " TestNum2:" + cv.getNumber2());
        System.out.println("TestChar: " + cv.getSymbol());
        int num1 = Integer.valueOf(cv.getNumber1());
        int num2 = Integer.valueOf(cv.getNumber2());
        float result = 0;
        switch (cv.getSymbol()) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    //display.setText(String.valueOf(result));
                    throw new DivisionBy0("Divide by 0");
                }
                result = (float) num1 / (float) num2;
                break;
        }
        //display.setText(String.valueOf(result));
        return result;
    }
}
