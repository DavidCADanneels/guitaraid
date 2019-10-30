package be.dafke.GuitarAid.Application

import javax.swing.JCheckBox
import javax.swing.JPanel
import javax.swing.border.TitledBorder
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class DisplayPanel extends JPanel implements ActionListener {
    GuitarStringsPanel guitarStringsPanel
    JCheckBox showOctave

    DisplayPanel(GuitarStringsPanel guitarStringsPanel) {
        this.guitarStringsPanel = guitarStringsPanel

        showOctave = new JCheckBox('show Octave')
        showOctave.addActionListener(this)
        add showOctave
        showOctave.setSelected true


        setBorder(new TitledBorder('Display Options'))
    }

    void actionPerformed(ActionEvent e) {
        if (e.source == showOctave){
            guitarStringsPanel.setShowOctave(showOctave.isSelected())
        }
    }
}
