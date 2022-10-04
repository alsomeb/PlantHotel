package frontend.alternateVersion;

import javax.swing.*;
import java.awt.*;

public class Body extends JPanel {

    public Body() {
        GridLayout gridLayout = new GridLayout(10, 1);
        gridLayout.setVgap(10); // space mellan cols
        this.setLayout(gridLayout); // VI vill ha gridlayout för denna container
        this.setBackground(new Color(0xB7425F40, true));
    }
}
