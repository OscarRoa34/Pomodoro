package co.edu.uptc.view;

import javax.swing.*;
import java.awt.*;
import co.edu.uptc.utils.PropertiesService;
import co.edu.uptc.view.Panels.ConfigurationPanel;
import co.edu.uptc.view.Panels.PomodoroPanel;
import co.edu.uptc.view.Panels.StatsPanel;

public class MainView extends JFrame {

    private PropertiesService p = new PropertiesService();
    private PomodoroPanel pomodoroPanel;
    private StatsPanel statsPanel;
    private ConfigurationPanel configPanel;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public MainView() {
        begin();
    }

    private void begin() {
        this.setSize(413, 466);
        this.setLocationRelativeTo(null);
        this.setTitle("Pomodoro");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon(p.getProperties("pomodoroIconFrame")).getImage());
        cardChanger();
        this.setVisible(true);
    }

    private void cardChanger() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        pomodoroPanel = new PomodoroPanel(cardLayout, mainPanel);

        statsPanel = new StatsPanel(cardLayout, mainPanel);

        configPanel = new ConfigurationPanel(cardLayout, mainPanel);

        mainPanel.add(pomodoroPanel, "Home");
        mainPanel.add(statsPanel, "Estadísticas");
        mainPanel.add(configPanel, "Configuración");

        this.setLayout(new BorderLayout());
        this.add(mainPanel, BorderLayout.CENTER);

        cardLayout.show(mainPanel, "Home");
    }
}
