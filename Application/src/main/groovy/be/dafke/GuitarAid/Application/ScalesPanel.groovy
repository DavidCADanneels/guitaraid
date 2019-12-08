package be.dafke.GuitarAid.Application

import be.dafke.GuitarAid.Elements.Scale
import be.dafke.GuitarAid.Elements.Scales

import javax.swing.BoxLayout
import javax.swing.JLabel
import javax.swing.JPanel

class ScalesPanel extends JPanel {

    ScalesPanel() {
        JPanel majorPanel = new JPanel()
        JPanel minorPanel = new JPanel()

        majorPanel.setLayout(new BoxLayout(majorPanel, BoxLayout.Y_AXIS))
        minorPanel.setLayout(new BoxLayout(minorPanel, BoxLayout.Y_AXIS))

        Scales.majorScales.each { String name, Scale scale ->
            majorPanel.add new JLabel("${scale}")
        }
        Scales.minorScales.each { String name, Scale scale ->
            minorPanel.add new JLabel("${scale}")
        }

        add majorPanel
        add minorPanel
    }

}
