import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RandomPage extends JFrame {

    private JPanel mainPanel;
    private JProgressBar progressBar1;
    private JButton getRecommendationButton;
    private JPanel showPanel;
    private JTextField koreanFood;
    private JTextField chineseFood;
    private JTextField japaneseFood;
    private JTextField westernFood;
    private JTextField cafe;
    private JTextField bar;
    private JButton backToHomeButton;
    private JButton tryTheOtherWayButton;

    // a list of Korean food restaurant name list
    ArrayList<String> kFood = new ArrayList<>(Arrays.asList(
            "기똥찬고기",
            "담은샤브칼국수",
            "드럼통돌구이",
            "만다",
            "보리네주먹고기",
            "생순",
            "성대곱창",
            "원조명동찌개마을",
            "율전방앗간",
            "율천회관",
            "일미닭갈비",
            "일미리금계찜닭",
            "청년밥상",
            "최고집 원조 수구레",
            "해담"
    ));

    // a list of Chinese food restaurant name list
    ArrayList<String> chFood = new ArrayList<>(Arrays.asList(
            "명가양꼬치",
            "보배반점",
            "수해복마라탕",
            "중경마라탕",
            "화원루",
            "훠훠우육면"
    ));

    // a list of Japanese food restaurant name list
    ArrayList<String> jFood = new ArrayList<>(Arrays.asList(
            "고씨네",
            "바른스시",
            "본찌돈까스",
            "이까야",
            "이라부",
            "일성",
            "쪼코야끼",
            "카츠요이",
            "포동이네",
            "힌카쿠"
    ));

    // a list of Western food restaurant name list
    ArrayList<String> wFood = new ArrayList<>(Arrays.asList(
            "도레미파스타",
            "블랙스미스",
            "심야스테이크",
            "아늑",
            "아보체레스토랑",
            "오스테리아우노",
            "정성식탁",
            "파치"
    ));

    // a list of cafe name list
    ArrayList<String> cafeList = new ArrayList<>(Arrays.asList(
            "디저트39",
            "매머드익스프레스",
            "보드라미",
            "섬세한남자",
            "수원숭이",
            "아이엠바리스타",
            "언더그라운드 카페",
            "카페나노",
            "카페로디",
            "커피 93.0",
            "하우짓블랙"
    ));

    // a list of bar name list
    ArrayList<String> barList = new ArrayList<>(Arrays.asList(
            "1972재개발구역",
            "대동집",
            "맥주호텔",
            "백사 104",
            "술톤",
            "옛날사람",
            "옥상",
            "옥집",
            "주량",
            "주야"
    ));

    // for getting random value for getting random recommendation
    Random random = new Random();

    // inner class for button event handling
    public class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            // case of pushing get recommendation button
            if(e.getSource() == getRecommendationButton) {

                // swing worker for multi-thread
                final SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {

                        // iterating 10 times for getting random recommendation
                        for(int i = 1; i <= 10; i ++) {
                            koreanFood.setText(kFood.get(random.nextInt(15)));
                            chineseFood.setText(chFood.get(random.nextInt(6)));
                            japaneseFood.setText(jFood.get(random.nextInt(10)));
                            westernFood.setText(wFood.get(random.nextInt(8)));
                            cafe.setText(cafeList.get(random.nextInt(11)));
                            bar.setText(barList.get(random.nextInt(10)));

                            // progress bar setting
                            progressBar1.setValue(i*10);
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException ex) {}
                        }

                        return null;
                    }
                };
                worker.execute();
            }
        }
    }
    public RandomPage() {

        // initialize the frame of RandomPage()
        super("Random Recommendation");
        super.setContentPane(mainPanel);
        setSize(500, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // set the labels initial state
        koreanFood.setEditable(false);
        chineseFood.setEditable(false);
        japaneseFood.setEditable(false);
        westernFood.setEditable(false);
        cafe.setEditable(false);
        bar.setEditable(false);

        koreanFood.setText("");
        chineseFood.setText("");
        japaneseFood.setText("");
        westernFood.setText("");
        cafe.setText("");
        bar.setText("");

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

        // add button handler for showing other random recommendation page
        tryTheOtherWayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new OtherRandom();
            }
        });

    }
}
