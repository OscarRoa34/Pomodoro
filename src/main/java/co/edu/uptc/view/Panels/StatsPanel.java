package co.edu.uptc.view.Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import co.edu.uptc.view.Global;

public class StatsPanel extends JPanel {

    public StatsPanel(CardLayout cardLayout, JPanel mainPanel) {
        this.setBackground(Global.BACKGROUND);
        this.add(new JLabel("Estadísticas"));
        this.setLayout(null);
        addBackButton(cardLayout, mainPanel);
        addTitle();
    }

    private void addBackButton(CardLayout cardLayout, JPanel mainPanel) {
        ImageIcon backIcon = new ImageIcon(getClass().getResource("/back.png"));
        JLabel backButton = new JLabel(backIcon);
        backButton.setBounds(16, 16, backIcon.getIconWidth(), backIcon.getIconHeight());
        backButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                backButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(mainPanel, "Home");
            }
        });
        this.add(backButton);
    }

    private void addTitle() {
        JLabel title = new JLabel("Estadísticas");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.WHITE);
        title.setBounds(81, 10, 289, 60);
        this.add(title);
    }

}
