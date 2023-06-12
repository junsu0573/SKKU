import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KFoodList extends JFrame {

    private JPanel mainPanel;
    private JButton backButton;
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
    private JButton detailButton11;
    private JButton detailButton12;
    private JButton detailButton13;
    private JButton detailButton14;
    private JLabel label1;
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
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    private JLabel label15;

    // inner class for button event handling
    public class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            // case of pushing 1st detail button
            if(e.getSource() == detailButton) {
                JOptionPane.showMessageDialog(null,
                        "삼겹살"+System.lineSeparator()+"위치: 경기 수원시 장안구 화산로213번길 29-6 기똥찬고기"+System.lineSeparator()+"https://naver.me/5Wc1R0CB",
                        "기똥찬고기", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 2nd detail button
            if(e.getSource() == detailButton1) {
                JOptionPane.showMessageDialog(null,
                        "샤브칼국수"+System.lineSeparator()+"위치: 경기 수원시 장안구 화산로233번길 60 mbc당구클럽"+System.lineSeparator()+"https://naver.me/GvkWWWnm",
                        "담은샤브칼국수", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 3rd detail button
            if(e.getSource() == detailButton2) {
                JOptionPane.showMessageDialog(null,
                        "닭갈비"+System.lineSeparator()+"위치: 경기 수원시 장안구 율전로108번길 9"+System.lineSeparator()+"https://naver.me/F4NtIKcZ",
                        "드럼통돌구이", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 4th detail button
            if(e.getSource() == detailButton3) {
                JOptionPane.showMessageDialog(null,
                        "덮밥"+System.lineSeparator()+"위치: 경기 수원시 장안구 서부로2105번길 16-6"+System.lineSeparator()+"https://naver.me/xFpLuzkM",
                        "만다", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 5th detail button
            if(e.getSource() == detailButton4) {
                JOptionPane.showMessageDialog(null,
                        "삼겹살"+System.lineSeparator()+"위치: 경기 수원시 장안구 율전로98번길 6-9"+System.lineSeparator()+"https://naver.me/FeOCvjIR",
                        "보리네주먹고기", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 6th detail button
            if(e.getSource() == detailButton5) {
                JOptionPane.showMessageDialog(null,
                        "순대국"+System.lineSeparator()+"위치: 경기 수원시 장안구 서부로2126번길 38"+System.lineSeparator()+"https://naver.me/5axAt5JM",
                        "생순", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 7th detail button
            if(e.getSource() == detailButton6) {
                JOptionPane.showMessageDialog(null,
                        "곱창"+System.lineSeparator()+"위치: 경기 수원시 장안구 율전로 96 1층 성대곱창"+System.lineSeparator()+"https://naver.me/F4N55rVB",
                        "성대곱창", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 8th detail button
            if(e.getSource() == detailButton7) {
                JOptionPane.showMessageDialog(null,
                        "김치찌개"+System.lineSeparator()+"위치: 경기 수원시 장안구 정자천로13번길 25"+System.lineSeparator()+"https://naver.me/xpPLZiOL",
                        "원조명동찌개마을", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 9th detail button
            if(e.getSource() == detailButton8) {
                JOptionPane.showMessageDialog(null,
                        "막걸리"+System.lineSeparator()+"위치: 경기 수원시 장안구 율전로98번길 18-12"+System.lineSeparator()+"https://naver.me/5jAGOCVv",
                        "율전방앗간", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 10th detail button
            if(e.getSource() == detailButton9) {
                JOptionPane.showMessageDialog(null,
                        "육회비빔밥"+System.lineSeparator()+"위치: 경기 수원시 장안구 서부로2126번길 24 율천회관"+System.lineSeparator()+"https://naver.me/FmOys7ZP",
                        "율천회관", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 11th detail button
            if(e.getSource() == detailButton10) {
                JOptionPane.showMessageDialog(null,
                        "닭갈비"+System.lineSeparator()+"위치: 경기 수원시 장안구 서부로2106번길 26-3"+System.lineSeparator()+"https://naver.me/xbwAhcpk",
                        "일미닭갈비", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 12th detail button
            if(e.getSource() == detailButton11) {
                JOptionPane.showMessageDialog(null,
                        "찜닭"+System.lineSeparator()+"위치: 경기 수원시 장안구 서부로2126번길 26 1층"+System.lineSeparator()+"https://naver.me/FlJxZ1lx",
                        "일미리금계찜닭", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 13th detail button
            if(e.getSource() == detailButton12) {
                JOptionPane.showMessageDialog(null,
                        "쌈밥"+System.lineSeparator()+"위치: 경기 수원시 장안구 서부로2136번길 10 1층"+System.lineSeparator()+"https://naver.me/FMA6DkWW",
                        "청년밥상", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 14th detail button
            if(e.getSource() == detailButton13) {
                JOptionPane.showMessageDialog(null,
                        "수구레"+System.lineSeparator()+"위치: 경기 수원시 장안구 서부로 2107 1층 최고집 원조 수구레"+System.lineSeparator()+"https://naver.me/GFpYVmXh",
                        "최고집 원조 수구레", JOptionPane.INFORMATION_MESSAGE);
            }

            // case of pushing 15th detail button
            if(e.getSource() == detailButton14) {
                JOptionPane.showMessageDialog(null,
                        "쭈꾸미"+System.lineSeparator()+"위치: 경기 수원시 장안구 일월로76번길 22"+System.lineSeparator()+"https://naver.me/FFvayS7I",
                        "해담", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public KFoodList() {

        // Initialize the frame of KFoodList()
        super("한식");
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
        label11.setFont(labelFont);
        label12.setFont(labelFont);
        label13.setFont(labelFont);
        label14.setFont(labelFont);
        label15.setFont(labelFont);

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
        detailButton11.addActionListener(handler);
        detailButton12.addActionListener(handler);
        detailButton13.addActionListener(handler);
        detailButton14.addActionListener(handler);

    }

}
