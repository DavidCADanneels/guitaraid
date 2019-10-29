import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.JTable
import javax.swing.WindowConstants
import java.awt.BorderLayout

class Main {
    static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation WindowConstants.EXIT_ON_CLOSE
        frame.setContentPane createContentPanel()
        frame.pack()
        frame.setVisible true
    }

    static JPanel createContentPanel(){
        JPanel panel = new JPanel(new BorderLayout());
        panel.add createTable(), BorderLayout.NORTH
        panel.add createFilterPanel(), BorderLayout.CENTER
        panel
    }

    static JPanel createFilterPanel(){
        JPanel panel = new JPanel()

        panel
    }

    static JTable createTable(){
        GuitarStrings guitarStrings = new GuitarStrings()
        GuitarStringsDataModel dataModel = new GuitarStringsDataModel(guitarStrings)
        new JTable(dataModel)
    }
}