import javax.swing.*;
import java.awt.*;


public class Calculate extends JFrame {
    private JTextArea display;


    public Calculate() {
        super("Calculator by Stanislav Kvashchuk");

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screen = toolkit.getScreenSize();
        int x = screen.width;
        int y = screen.height;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize((int) Math.round(x * 0.2), (int) Math.round(y * 0.2));
        setLocationRelativeTo(null);
        setVisible(true);

        LayoutManager layoutManager = new BorderLayout(5, 5);

        display = new JTextArea();
        Dimension textAreaSize = display.getPreferredSize();

        textAreaSize.width = 100;
        textAreaSize.height = 25;

        display.setPreferredSize(textAreaSize);
        CalculatorsVariable cv = new  CalculatorsVariable();
        CalulateorNumbers cn = new CalulateorNumbers(display,cv);
        CalculatorOperation co = new CalculatorOperation(display,cv);
        add(cn, BorderLayout.CENTER);
        add(display, BorderLayout.NORTH);
        add(co, BorderLayout.SOUTH);

    }
}
