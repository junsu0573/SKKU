import javax.management.remote.JMXConnectorFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BARList extends JFrame {
    private JButton detailButton;
    private JButton detailButton1;
    private JButton detailButton2;
    private JButton detailButton3;
    private JButton detailButton4;
    private JButton detailButton5;
    private JButton detailButton6;
    private JButton detailButton7;
    private JButton detailButton8;
    private JButton detailButton9;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label1;
    private JButton backButton;
    private JPanel mainPanel;

    // inner class for button event handling
    public class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // case of pushing 1st detail button
            if(e.getSource() == detailButton) {
                JOptionPane.showMessageDialog(null,
                        "포장마차"+System.lineSeparator()+"위치: 경기 수원시 장안구 서부로2105번길 11 2층 1972재개발구역"+System.lineSeparator()+"https://naver.me/FOv9Th5n",
                        "1972재개발구역", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 2nd button
            if(e.getSource() == detailButton1) {
                JOptionPane.showMessageDialog(null,
                        "요리주점"+System.lineSeparator()+"위치: 경기 수원시 장안구 율전로108번길 15"+System.lineSeparator()+"https://naver.me/5uxiHW6a",
                        "대동집", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 3rd detail button
            if(e.getSource() == detailButton2) {
                JOptionPane.showMessageDialog(null,
                        "맥주"+System.lineSeparator()+"위치: 경기 수원시 장안구 서부로2105번길 12 2층 맥주호텔"+System.lineSeparator()+"https://naver.me/Gw5ffyQy",
                        "맥주호텔", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 4th detail button
            if(e.getSource() == detailButton3) {
                JOptionPane.showMessageDialog(null,
                        "요리주점"+System.lineSeparator()+"위치: 경기 수원시 장안구 화산로233번길 61 1층"+System.lineSeparator()+"https://naver.me/FIpdKrCW",
                        "백사 104", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 5th detail button
            if(e.getSource() == detailButton4) {
                JOptionPane.showMessageDialog(null,
                        "요리주점"+System.lineSeparator()+"위치: 경기 수원시 장안구 서부로2136번길 10 2층"+System.lineSeparator()+"https://m.place.naver.com/place/1198543332",
                        "술톤", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 6th detail button
            if(e.getSource() == detailButton5) {
                JOptionPane.showMessageDialog(null,
                        "요리주점"+System.lineSeparator()+"위치: 경기 수원시 장안구 화산로233번길 17 2층"+System.lineSeparator()+"https://naver.me/FeOC48K1",
                        "옛날사람", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 7th detail button
            if(e.getSource() == detailButton6) {
                JOptionPane.showMessageDialog(null,
                        "맥주"+System.lineSeparator()+"위치: 경기 수원시 장안구 화산로233번길 38 2층"+System.lineSeparator()+"https://naver.me/GgeW7pNp",
                        "옥상", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 8th detail button
            if(e.getSource() == detailButton7) {
                JOptionPane.showMessageDialog(null,
                        "요리주점"+System.lineSeparator()+"위치: 경기 수원시 장안구 화산로233번길 25 1층"+System.lineSeparator()+"https://naver.me/IgTN4hxo",
                        "옥집", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 9th detail button
            if(e.getSource() == detailButton8) {
                JOptionPane.showMessageDialog(null,
                        "요리주점"+System.lineSeparator()+"위치: 경기 수원시 장안구 서부로2105번길 26-8 101호"+System.lineSeparator()+"https://naver.me/F0cDbgai",
                        "주량", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 10th detail button
            if(e.getSource() == detailButton9) {
                JOptionPane.showMessageDialog(null,
                        "요리주점"+System.lineSeparator()+"위치: 경기 수원시 장안구 서부로2135번길 30 1층 주야"+System.lineSeparator()+"https://naver.me/xHilrTsC",
                        "주야", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public BARList() {

        // Initialize frame of BARList()
        super("술집");
        super.setContentPane(mainPanel);
        setSize(500, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // create the font of label
        Font labelFont = new Font(label1.getFont().getFontName(), Font.BOLD, 30);

        // set font of all labels
        label1.setFont(labelFont);
        label2.setFont(labelFont);
        label3.setFont(labelFont);
        label4.setFont(labelFont);
        label5.setFont(labelFont);
        label6.setFont(labelFont);
        label7.setFont(labelFont);
        label8.setFont(labelFont);
        label9.setFont(labelFont);
        label10.setFont(labelFont);

        // add button handler for showing All restaurant list page
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new AllRestPage();
            }
        });

        // create new ButtonHandler for button event handling
        ButtonHandler handler = new ButtonHandler();
        detailButton.addActionListener(handler);
        detailButton1.addActionListener(handler);
        detailButton2.addActionListener(handler);
        detailButton3.addActionListener(handler);
        detailButton4.addActionListener(handler);
        detailButton5.addActionListener(handler);
        detailButton6.addActionListener(handler);
        detailButton7.addActionListener(handler);
        detailButton8.addActionListener(handler);
        detailButton9.addActionListener(handler);

    }

}
