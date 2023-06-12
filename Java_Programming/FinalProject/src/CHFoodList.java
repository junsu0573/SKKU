import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CHFoodList extends JFrame {
    private JPanel mainPanel;
    private JButton detailButton;
    private JButton detailButton1;
    private JButton detailButton2;
    private JButton detailButton3;
    private JButton detailButton4;
    private JButton detailButton5;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label1;
    private JButton backButton;

    // inner class for button event handling
    public class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            // case of pushing 1st detail button
            if(e.getSource() == detailButton) {
                JOptionPane.showMessageDialog(null,
                        "양꼬치"+System.lineSeparator()+"위치: 경기 수원시 장안구 서부로2105번길 21"+System.lineSeparator()+"https://naver.me/xryjrTtM",
                        "명가양꼬치", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 2nd detail button
            if(e.getSource() == detailButton1) {
                JOptionPane.showMessageDialog(null,
                        "짜장면"+System.lineSeparator()+"위치: 경기 수원시 장안구 서부로 2132 2층"+System.lineSeparator()+"https://naver.me/FcIDU46O",
                        "보배반점", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 3rd detail button
            if(e.getSource() == detailButton2) {
                JOptionPane.showMessageDialog(null,
                        "마라탕"+System.lineSeparator()+"위치: 경기 수원시 장안구 서부로2105번길 7 1층"+System.lineSeparator()+"https://naver.me/5mYgKhiS",
                        "수해복마라탕", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 4th detail button
            if(e.getSource() == detailButton3) {
                JOptionPane.showMessageDialog(null,
                        "마라탕"+System.lineSeparator()+"위치: 경기 수원시 장안구 서부로2106번길 10"+System.lineSeparator()+"https://naver.me/GUvDss8V",
                        "중경마라탕", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 5th detail button
            if(e.getSource() == detailButton4) {
                JOptionPane.showMessageDialog(null,
                        "짜장면"+System.lineSeparator()+"위치: 경기 수원시 장안구 서부로2126번길 17"+System.lineSeparator()+"https://naver.me/FgiTR2Ud",
                        "화원루", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 6th detail button
            if(e.getSource() == detailButton5) {
                JOptionPane.showMessageDialog(null,
                        "우육면"+System.lineSeparator()+"위치: 경기 수원시 장안구 서부로2126번길 18 에이동 1층 102호"+System.lineSeparator()+"https://naver.me/5bdE393I",
                        "훠훠우육면", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public CHFoodList() {

        // Initialize the frame of CHFoodList
        super("중식");
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

    }
}
