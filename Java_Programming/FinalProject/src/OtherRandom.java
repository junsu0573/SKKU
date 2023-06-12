import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class OtherRandom extends JFrame {


    private JPanel contentPanel;
    private JPanel mainPanel;
    private JButton backToHomeButton;
    private JButton tryTheOtherWayButton;
    private JButton button1;
    private JButton button2;
    private JButton button4;
    private JButton button6;
    private JButton button3;
    private JButton button5;
    private JButton getRecommendationButton;
    private JProgressBar progressBar1;

    // a list storing images of all restaurant
    ImageIcon[] images = {
            new ImageIcon("src/images/술집1.png"),
            new ImageIcon("src/images/술집2.png"),
            new ImageIcon("src/images/술집3.png"),
            new ImageIcon("src/images/술집4.png"),
            new ImageIcon("src/images/술집5.png"),
            new ImageIcon("src/images/술집6.png"),
            new ImageIcon("src/images/술집7.png"),
            new ImageIcon("src/images/술집8.png"),
            new ImageIcon("src/images/술집9.png"),
            new ImageIcon("src/images/술집10.png"),
            new ImageIcon("src/images/양식1.png"),
            new ImageIcon("src/images/양식2.png"),
            new ImageIcon("src/images/양식3.png"),
            new ImageIcon("src/images/양식4.png"),
            new ImageIcon("src/images/양식5.png"),
            new ImageIcon("src/images/양식6.png"),
            new ImageIcon("src/images/양식7.png"),
            new ImageIcon("src/images/양식8.png"),
            new ImageIcon("src/images/일식1.png"),
            new ImageIcon("src/images/일식2.png"),
            new ImageIcon("src/images/일식3.png"),
            new ImageIcon("src/images/일식4.png"),
            new ImageIcon("src/images/일식5.png"),
            new ImageIcon("src/images/일식6.png"),
            new ImageIcon("src/images/일식7.png"),
            new ImageIcon("src/images/일식8.png"),
            new ImageIcon("src/images/일식9.png"),
            new ImageIcon("src/images/일식10.png"),
            new ImageIcon("src/images/중식1.png"),
            new ImageIcon("src/images/중식2.png"),
            new ImageIcon("src/images/중식3.png"),
            new ImageIcon("src/images/중식4.png"),
            new ImageIcon("src/images/중식5.png"),
            new ImageIcon("src/images/중식6.png"),
            new ImageIcon("src/images/카페1.png"),
            new ImageIcon("src/images/카페2.png"),
            new ImageIcon("src/images/카페3.png"),
            new ImageIcon("src/images/카페4.png"),
            new ImageIcon("src/images/카페5.png"),
            new ImageIcon("src/images/카페6.png"),
            new ImageIcon("src/images/카페7.png"),
            new ImageIcon("src/images/카페8.png"),
            new ImageIcon("src/images/카페9.png"),
            new ImageIcon("src/images/카페10.png"),
            new ImageIcon("src/images/카페11.png"),
            new ImageIcon("src/images/한식1.png"),
            new ImageIcon("src/images/한식2.png"),
            new ImageIcon("src/images/한식3.png"),
            new ImageIcon("src/images/한식4.png"),
            new ImageIcon("src/images/한식5.png"),
            new ImageIcon("src/images/한식6.png"),
            new ImageIcon("src/images/한식7.png"),
            new ImageIcon("src/images/한식8.png"),
            new ImageIcon("src/images/한식9.png"),
            new ImageIcon("src/images/한식10.png"),
            new ImageIcon("src/images/한식11.png"),
            new ImageIcon("src/images/한식12.png"),
            new ImageIcon("src/images/한식13.png"),
            new ImageIcon("src/images/한식14.png"),
            new ImageIcon("src/images/한식15.png"),
    };

    // for getting random number
    Random rand = new Random();


    // inner class for button event handling
    public class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            // case of pushing get recommendation button
            if(e.getSource() == getRecommendationButton) {

                // create new Thread
                new Thread() {
                    @Override
                    public void run() {

                        // create list for storing six random integer
                        int random_num[] = new int[6];

                        // iterating 10 times for get random value
                        for (int i = 0; i < 10; i++) {

                            // iterating for storing 6 random number(0~59) in random_num list
                            for (int j = 0; j < 6; j++) {
                                random_num[j] = rand.nextInt(60);
                                for (int k = 0; k < j; k++) {
                                    if (random_num[j] == random_num[k]) {
                                        j--;
                                    }
                                }
                            }

                            // set icon of button by random images
                            button1.setIcon(images[random_num[0]]);
                            button2.setIcon(images[random_num[1]]);
                            button3.setIcon(images[random_num[2]]);
                            button4.setIcon(images[random_num[3]]);
                            button5.setIcon(images[random_num[4]]);
                            button6.setIcon(images[random_num[5]]);
                            try {
                                Thread.sleep(250);
                            } catch(InterruptedException exception) {}
                        }
                    }
                }.start();

                // create new Thread
                new Thread() {

                    @Override
                    public void run() {
                        int n; // for storing random number

                        // iterating 10 times for get random value
                        for(int i = 0; i < 10; i++) {

                            // set n as random integer
                            n = rand.nextInt(6)+1;

                            // set buttons border invisible
                            button1.setBorderPainted(false);
                            button2.setBorderPainted(false);
                            button3.setBorderPainted(false);
                            button4.setBorderPainted(false);
                            button5.setBorderPainted(false);
                            button6.setBorderPainted(false);

                            // for setting a border style of random n-th button
                            switch (n) {
                                case 1:
                                    button1.setBorder(new LineBorder(Color.red,5));
                                    button1.setBorderPainted(true);
                                    break;
                                case 2:
                                    button2.setBorder(new LineBorder(Color.red,5));
                                    button2.setBorderPainted(true);
                                    break;
                                case 3:
                                    button3.setBorder(new LineBorder(Color.red,5));
                                    button3.setBorderPainted(true);
                                    break;
                                case 4:
                                    button4.setBorder(new LineBorder(Color.red,5));
                                    button4.setBorderPainted(true);
                                    break;
                                case 5:
                                    button5.setBorder(new LineBorder(Color.red,5));
                                    button5.setBorderPainted(true);
                                    break;
                                case 6:
                                    button6.setBorder(new LineBorder(Color.red,5));
                                    button6.setBorderPainted(true);
                                    break;
                                default:
                                    break;
                            }
                            try {
                                Thread.sleep(250);
                            } catch (InterruptedException exception) {}

                        }

                    }

                }.start();

                // for working progress bar
                final SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        for(int i = 1; i <= 100; i++) {
                            progressBar1.setValue(i);
                            try {
                                Thread.sleep(20);
                            } catch(InterruptedException ex) {}
                        }
                        return null;
                    }
                };
                worker.execute();
            }
        }
    }

    public OtherRandom() {

        // Initialize the frame of OhterRandom page
        super("Random Recommendation");
        super.setContentPane(contentPanel);
        setSize(500, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // create new ButtonHandler for button event handling
        ButtonHandler handler = new ButtonHandler();
        getRecommendationButton.addActionListener(handler);

        // add button handler for showing Home page
        backToHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new HomePage();
            }
        });

        // add button handler for showing Random recommendation page
        tryTheOtherWayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new RandomPage();
            }
        });
    }
}
