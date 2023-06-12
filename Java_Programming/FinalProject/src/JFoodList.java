import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFoodList extends JFrame {
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
                        "카레"+System.lineSeparator()+"위치: 경기 수원시 장안구 서부로2105번길 21 2층"+System.lineSeparator()+"https://naver.me/FdJgoYzn",
                        "고씨네", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 2nd detail button
            if(e.getSource() == detailButton1) {
                JOptionPane.showMessageDialog(null,
                        "초밥"+System.lineSeparator()+"위치: 경기 수원시 장안구 서부로 2125 2층바른스시"+System.lineSeparator()+"https://naver.me/5Z0j4Fok",
                        "바른스시", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 3rd detail button
            if(e.getSource() == detailButton2) {
                JOptionPane.showMessageDialog(null,
                        "돈까스"+System.lineSeparator()+"위치: 경기 수원시 장안구 서부로2106번길 22"+System.lineSeparator()+"https://naver.me/5zJ5x8N2",
                        "본찌돈까스", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 4th detail button
            if(e.getSource() == detailButton3) {
                JOptionPane.showMessageDialog(null,
                        "이자카야"+System.lineSeparator()+"위치: 경기 수원시 장안구 서부로2105번길 26-2"+System.lineSeparator()+"https://naver.me/FfMsuBAN",
                        "이까야", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 5th detail button
            if(e.getSource() == detailButton4) {
                JOptionPane.showMessageDialog(null,
                        "이자카야"+System.lineSeparator()+"위치: 경기 수원시 장안구 서부로 2135 제일성모의원"+System.lineSeparator()+"https://naver.me/5KZqrqhB",
                        "이라부", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 6th detail button
            if(e.getSource() == detailButton5) {
                JOptionPane.showMessageDialog(null,
                        "이자카야"+System.lineSeparator()+"위치: 경기 수원시 장안구 율전로 92 1층 105호"+System.lineSeparator()+"https://naver.me/FCBO2MkH",
                        "일성", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 7th detail button
            if(e.getSource() == detailButton6) {
                JOptionPane.showMessageDialog(null,
                        "타코야끼"+System.lineSeparator()+"위치: 경기 수원시 장안구 서부로2126번길 38 38  103호"+System.lineSeparator()+"https://naver.me/59jXqC8Q",
                        "쪼코야끼", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 8th detail button
            if(e.getSource() == detailButton7) {
                JOptionPane.showMessageDialog(null,
                        "돈까스"+System.lineSeparator()+"위치: 경기 수원시 장안구 정자천로13번길 36 1층 103호"+System.lineSeparator()+"https://naver.me/GlmKVV32",
                        "카츠요이", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 9th detail button
            if(e.getSource() == detailButton8) {
                JOptionPane.showMessageDialog(null,
                        "초밥"+System.lineSeparator()+"위치: 경기 수원시 장안구 율전로98번길 6-2"+System.lineSeparator()+"https://naver.me/Fn2i6hWe",
                        "포동이네", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 10th detail button
            if(e.getSource() == detailButton9) {
                JOptionPane.showMessageDialog(null,
                        "라멘"+System.lineSeparator()+"위치: 경기 수원시 장안구 서부로2126번길 10"+System.lineSeparator()+"https://naver.me/5tj4Y0PY",
                        "힌카쿠", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public JFoodList() {
        //Initialize the frame of JFoodList()
        super("일식");
        super.setContentPane(mainPanel);
        setSize(500, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // create the font of label
        Font labelFont = new Font(label1.getFont().getFontName(), Font.BOLD, 30);

        // set the font of all labels
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

        // add button handler of showing All restaurant list page
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
