package co.edu.uptc.view.Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import co.edu.uptc.utils.RoundBorder;
import co.edu.uptc.utils.RoundedPanel;
import co.edu.uptc.view.Global;

public class PomodoroPanel extends JPanel {

    public PomodoroPanel(CardLayout cardLayout, JPanel mainPanel) {
        this.setBackground(Global.BACKGROUND);
        this.add(new JLabel("Pomodoro"));
        this.setLayout(null);
        createLabels(cardLayout, mainPanel);
        createTitle();
        createTimer();
        createStartButton();
        createPauseButton();
        createResetButton();
    }

    private void createTitle() {
        JLabel title = new JLabel("Pomodoro");
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 45));
        title.setForeground(Color.WHITE);
        title.setBounds(87, 20, 319, 61);
        this.add(title);
    }

    private void createLabels(CardLayout cardLayout, JPanel mainPanel) {
        JLabel statsLabel = new JLabel("Estadísticas   |");
        JLabel configLabel = new JLabel("Configuración");

        statsLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        configLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        statsLabel.setForeground(Color.white);
        configLabel.setForeground(Color.white);

        Font font = new Font(statsLabel.getFont().getName(), Font.PLAIN, 25);
        statsLabel.setFont(font);
        configLabel.setFont(font);

        statsLabel.setBounds(23, 370, 200, 30);
        configLabel.setBounds(213, 370, 200, 30);
        statsLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(mainPanel, "Estadísticas");
            }
        });

        configLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(mainPanel, "Configuración");
            }

        });

        this.add(statsLabel);
        this.add(configLabel);
    }

    private void createTimer() {
        JPanel timerPanel = new RoundedPanel(new Color(255, 149, 149, 222), 20, 20);
        timerPanel.setLayout(null);
        timerPanel.setBounds(50, 120, 295, 98);

        timerPanel.setBorder(new RoundBorder(new Color(224, 224, 224), 20, 20, 3));
        JLabel timerLabel = new JLabel("00:00", SwingConstants.CENTER);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 50));
        timerLabel.setForeground(Color.WHITE);
        timerLabel.setBounds(0, 0, 295, 98);

        timerPanel.add(timerLabel);
        this.add(timerPanel);
    }

    private void createButton(String text, int x, int y) {
        JPanel buttonPanel = new RoundedPanel(new Color(255, 149, 149, 222), 20, 20);
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(x, y, 95, 40);

        JLabel buttonLabel = new JLabel(text, SwingConstants.CENTER);
        buttonLabel.setFont(new Font("Arial", Font.BOLD, 20));
        buttonLabel.setForeground(Color.WHITE);
        buttonLabel.setBounds(0, 0, 95, 40);
        buttonLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttonPanel.add(buttonLabel);
        this.add(buttonPanel);
    }

    private void createStartButton() {
        createButton("Start", 50, 240);
    }

    private void createPauseButton() {
        createButton("Pause", 150, 240);
    }

    private void createResetButton() {
        createButton("Reset", 250, 240);
    }

}
