import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WFoodList extends JFrame {
    private JButton detailButton;
    private JButton detailButton1;
    private JButton detailButton2;
    private JButton detailButton3;
    private JButton detailButton4;
    private JButton detailButton5;
    private JButton detailButton6;
    private JButton detailButton7;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
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
                        "파스타"+System.lineSeparator()+"위치: 경기 수원시 장안구 서부로2106번길 26-15 101호"+System.lineSeparator()+"https://naver.me/GPrF6ZO5",
                        "도레미파스타", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 2nd detail button
            if(e.getSource() == detailButton1) {
                JOptionPane.showMessageDialog(null,
                        "양식"+System.lineSeparator()+"위치: 경기 수원시 장안구 화산로233번길 47 2층"+System.lineSeparator()+"https://naver.me/5SWaP5wC",
                        "블랙스미스", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 3rd detail button
            if(e.getSource() == detailButton2) {
                JOptionPane.showMessageDialog(null,
                        "스테이크"+System.lineSeparator()+"위치: 경기 수원시 장안구 화산로233번길 10"+System.lineSeparator()+"https://naver.me/GJrFuo0N",
                        "심야스테이크", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 4th detail button
            if(e.getSource() == detailButton3) {
                JOptionPane.showMessageDialog(null,
                        "이탈리아음식"+System.lineSeparator()+"위치: 경기 수원시 장안구 서부로2106번길 36-4 1층"+System.lineSeparator()+"https://naver.me/xgGii2j3",
                        "아늑", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 5th detail button
            if(e.getSource() == detailButton4) {
                JOptionPane.showMessageDialog(null,
                        "이탈리아음식"+System.lineSeparator()+"위치: 경기 수원시 장안구 서부로 2139 SK허브블루 5001호"+System.lineSeparator()+"https://naver.me/xqf5ZuY9",
                        "아보체레스토랑", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 6th detail button
            if(e.getSource() == detailButton5) {
                JOptionPane.showMessageDialog(null,
                        "파스타"+System.lineSeparator()+"위치: 경기 수원시 장안구 율전로98번길 7 102호"+System.lineSeparator()+"https://naver.me/5IFoTRie",
                        "오스테리아우노", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 7th detail button
            if(e.getSource() == detailButton6) {
                JOptionPane.showMessageDialog(null,
                        "이탈리아음식"+System.lineSeparator()+"위치: 경기 수원시 장안구 서부로2136번길 9 1층 정성식탁"+System.lineSeparator()+"https://naver.me/FdsGQm7o",
                        "정성식탁", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 8th detail button
            if(e.getSource() == detailButton7) {
                JOptionPane.showMessageDialog(null,
                        "파스타"+System.lineSeparator()+"위치: 경기 수원시 장안구 서부로 2136 지하 1층"+System.lineSeparator()+"https://naver.me/FYACQBz3",
                        "파치", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }


    public WFoodList() {
        // Initialize the frame of WFoodList()
        super("양식");
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

    }

}
