import javax.swing.*;

public class MainCalculator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Calculate();
            }
        });
    }
}
