package co.edu.uptc.view.Panels;

import javax.swing.*;
import java.awt.*;
import co.edu.uptc.view.Global;

public class PomodoroPanel extends JPanel {

    public PomodoroPanel(CardLayout cardLayout, JPanel mainPanel) {
        this.setBackground(Global.BACKGROUND);
        this.add(new JLabel("Pomodoro"));
        createButtons(cardLayout, mainPanel);
    }

    private void createButtons(CardLayout cardLayout, JPanel mainPanel) {
        JButton statsButton = new JButton("Estadísticas");
        JButton configButton = new JButton("Configuración");

        statsButton.addActionListener(e -> cardLayout.show(mainPanel, "Estadísticas"));
        configButton.addActionListener(e -> cardLayout.show(mainPanel, "Configuración"));

        this.add(statsButton);
        this.add(configButton);
    }
}
