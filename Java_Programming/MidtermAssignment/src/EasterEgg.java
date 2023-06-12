import javax.swing.*;
import java.awt.*;

class ImagePanel extends JPanel {

    private Image img;

    public ImagePanel(Image img) {
        this.img = img;
        setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
        setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
        setLayout(null);
    }
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

}

public class EasterEgg {

    EasterEgg() {
        JFrame frame = new JFrame("Easter Egg");
        frame.setSize(620, 475);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        ImagePanel panel = new ImagePanel(new ImageIcon("src/icons/easterEgg.png").getImage());
        frame.add(panel);
        frame.pack();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
