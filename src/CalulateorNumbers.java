import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalulateorNumbers extends JPanel {
    private JTextArea display;
    private CalculatorsVariable cv;

    public CalulateorNumbers(JTextArea display, CalculatorsVariable cv) {
        this.cv = cv;

        Dimension dimension = new Dimension();
        dimension.height = 100;
        dimension.width = 100;

        LayoutManager layoutManager = new GridBagLayout();
        setLayout(layoutManager);
        GridBagConstraints gc = new GridBagConstraints();
        for (int i = 0; i < 10; i++) {
            JButton button = new JButton("");
            if (i == 9) {
                button.setText("0");
                button.setName("0");
            } else {
                button.setText(String.valueOf(i + 1));
                button.setName(String.valueOf(i + 1));
            }
            button.setPreferredSize(dimension);
            int x = i % 3;
            int y = i / 3;
            gc.gridx = x;
            gc.gridy = y;
            if (i < 9) {
                button.setName(String.valueOf(i + 1));
            }
            add(button, gc);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (cv.isFirst() == false) {

                        String number = cv.getNumber1();
                        if (number == "0") {
                            number = button.getText();
                        } else {
                            number += button.getText();
                        }
                        display.setText(number);
                        cv.setNumber1(number);
                        //System.out.println("TestNumber1: "+cv.getNumber1());
                    } else {
                        String number = cv.getNumber2();
                        if (number == "0") {
                            number = button.getText();
                        } else {
                            number += button.getText();
                        }
                        display.setText(number);
                        cv.setNumber2(number);
                        //System.out.println("TestNumber2: "+cv.getNumber2());
                    }
                }
            });
        }
    }

}
