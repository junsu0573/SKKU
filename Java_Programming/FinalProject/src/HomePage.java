import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame{
    private JPanel contentPanel;
    private JLabel background;
    private JButton randomRecommendationButton;
    private JButton seeAllRecommendedRestaurantButton;

    public HomePage() {
        // Initialize the frame of HomePage()
        super("Home");
        setSize(500, 800);
        add(contentPanel);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



        // add button handler for showing Random page
        randomRecommendationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new RandomPage();
            }
        });

        // add button handler for showing All restaurant list page
        seeAllRecommendedRestaurantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new AllRestPage();
            }
        });
    }

    public static void main(String[] args) {
        new HomePage();
    }
}
