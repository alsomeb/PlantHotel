package frontend.alternateVersion;

import javax.swing.*;
import java.awt.*;

public class Header extends JPanel {

    public Header() {
        this.setPreferredSize(new Dimension(1000, 100));
        this.setBackground(new Color(0xB7354E33, true));

        JLabel title = new JLabel("Greenest Plant Hotel");
        title.setFont(new Font("Sans-serif", Font.BOLD, 25));
        title.setForeground(new Color(0xE9E9E9));

        this.add(Box.createVerticalStrut(80)); // Margin Top
        this.add(title);
    }
}
