package be.dafke.GuitarAid.Application

import javax.swing.JFrame
import javax.swing.JPanel
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
        JPanel panel = new JPanel(new BorderLayout())
        def guitarStringsPanel = new GuitarStringsPanel()
        panel.add guitarStringsPanel, BorderLayout.NORTH
        def filterPanel = new FilterPanel(guitarStringsPanel)
        def displayPanel = new DisplayPanel(guitarStringsPanel)
        JPanel center = new JPanel()
        center.add filterPanel
        center.add displayPanel
        panel.add center, BorderLayout.CENTER
        panel
    }
}