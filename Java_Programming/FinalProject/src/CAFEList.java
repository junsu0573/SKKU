import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CAFEList extends JFrame {
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
    private JButton detailButton10;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
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
                        "카페"+System.lineSeparator()+"위치: 경기 수원시 장안구 화산로213번길 23"+System.lineSeparator()+"https://naver.me/51nfziec",
                        "디저트39", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 2nd detail button
            if(e.getSource() == detailButton1) {
                JOptionPane.showMessageDialog(null,
                        "카페"+System.lineSeparator()+"위치: 경기 수원시 장안구 서부로 2139 1층 매머드 익스프레스"+System.lineSeparator()+"https://naver.me/GsTVvVYj",
                        "매머드익스프레스", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 3rd detail button
            if(e.getSource() == detailButton2) {
                JOptionPane.showMessageDialog(null,
                        "디저트"+System.lineSeparator()+"위치: 경기 수원시 장안구 화산로203번길 11"+System.lineSeparator()+"https://naver.me/FqSACRqy",
                        "보드라미", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 4th detail button
            if(e.getSource() == detailButton3) {
                JOptionPane.showMessageDialog(null,
                        "카페"+System.lineSeparator()+"위치: 경기 수원시 장안구 율전로 93 101호"+System.lineSeparator()+"https://naver.me/xxxoeNXx",
                        "섬세한남자", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 5th detail button
            if(e.getSource() == detailButton4) {
                JOptionPane.showMessageDialog(null,
                        "디저트"+System.lineSeparator()+"위치: 경기 수원시 장안구 일월로76번길 10-3"+System.lineSeparator()+"https://naver.me/Fv7BbIJR",
                        "수원숭이", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 6th detail button
            if(e.getSource() == detailButton5) {
                JOptionPane.showMessageDialog(null,
                        "카페"+System.lineSeparator()+"위치: 경기 수원시 장안구 서부로 2132"+System.lineSeparator()+"https://naver.me/GFpeeRvk",
                        "아이엠바리스타", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 7th detail button
            if(e.getSource() == detailButton6) {
                JOptionPane.showMessageDialog(null,
                        "디저트"+System.lineSeparator()+"위치: 경기 수원시 장안구 서부로2126번길 30 카페 언더그라운드"+System.lineSeparator()+"https://naver.me/F1LkUoR2",
                        "언더그라운드 카페", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 8th detail button
            if(e.getSource() == detailButton7) {
                JOptionPane.showMessageDialog(null,
                        "카페"+System.lineSeparator()+"위치: 경기 수원시 장안구 일월로90번길 42-2 성원주택"+System.lineSeparator()+"https://naver.me/5pNqfKUq",
                        "카페나노", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 9th detail button
            if(e.getSource() == detailButton8) {
                JOptionPane.showMessageDialog(null,
                        "디저트"+System.lineSeparator()+"위치: 경기 수원시 장안구 화산로213번길 11 2층"+System.lineSeparator()+"https://naver.me/GeFACFIS",
                        "카페로디", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 10th detail button
            if(e.getSource() == detailButton9) {
                JOptionPane.showMessageDialog(null,
                        "카페"+System.lineSeparator()+"위치: 경기 수원시 장안구 서부로2126번길 50-4 1, 2층"+System.lineSeparator()+"https://naver.me/xsUqwg4N",
                        "커피 93.0", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 11th detail button
            if(e.getSource() == detailButton10) {
                JOptionPane.showMessageDialog(null,
                        "카페"+System.lineSeparator()+"위치: 경기 수원시 장안구 화산로213번길 25 2층 하우짓 블랙"+System.lineSeparator()+"https://naver.me/5ObHghps",
                        "하우짓블랙", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public CAFEList() {

        // Initialize the frame of CAGEList()
        super("카페");
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
        label11.setFont(labelFont);

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
        detailButton10.addActionListener(handler);

    }

}
