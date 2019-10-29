import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(createContentPanel());
        frame.pack();
        frame.setVisible(true);
    }

    public static JPanel createContentPanel(){
        JPanel panel = new JPanel();
        panel.add(new JLabel("TEST"));
        return panel;
    }
}
