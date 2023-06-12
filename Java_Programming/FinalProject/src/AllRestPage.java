import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AllRestPage extends JFrame {

    private JPanel mainPanel;
    private JButton kFoodButton;
    private JButton chFoodButton;
    private JButton jFoodButton;
    private JButton cafeButton;
    private JButton wFoodButton;
    private JButton barButton;
    private JButton backToHomeButton;
    private JPanel buttonPanel;

    public AllRestPage() {
        // initialize frame of ALLRESTPAGE()
        super("Restaurant List");
        super.setContentPane(mainPanel);
        setSize(500, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // add button handler for showing Home page
        backToHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new HomePage();
            }
        });
        // add button handler for showing Korean food list page
        kFoodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new KFoodList();
            }
        });
        // add button handler for showing Chinese food list page
        chFoodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new CHFoodList();
            }
        });
        // add button handler for showing Japanese food list page
        jFoodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new JFoodList();
            }
        });
        // add button handler for showing Western food list page
        wFoodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new WFoodList();
            }
        });
        // add button handler for showing Cafe list page
        cafeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new CAFEList();
            }
        });
        // add button handler for showing Bar list page
        barButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new BARList();
            }
        });
    }

}
