import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    private JTextArea textArea1;
    private JTextField inputField;
    private JButton getSumOfFebonacciButton;
    private JButton cancelButton;
    private JPanel barPanel;
    private JPanel contentPanel;
    private JProgressBar progressBar1;
    private JLabel sumLabel;
    private JPanel bottomBar;
    private boolean isRunning = false; // for storing whether the program is running
    private long sum; // for storing sum of fibonacci values

    // inner class for button event handling
    public class ButtonHandler implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == getSumOfFebonacciButton) { // case of pushing the getsum button
                // initialize textarea and label
                textArea1.setText("");
                sumLabel.setText("");
                sum = 0;

                if(inputField.getText().isEmpty()) { // field empty
                    JOptionPane.showMessageDialog(null, "Enter valid input!", "Warning", JOptionPane.INFORMATION_MESSAGE);
                }
                else { // not empty
                    String userInput = inputField.getText();
                    try {
                        int number = Integer.parseInt(userInput);
                        ArrayList<String> result = new ArrayList<String>();

                        isRunning = true;
                        cancelButton.setEnabled(true);

                        // make progress bar using SwingWorker for asynchronous working
                        final SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                            int a = 0; // first variable for calculating fibonacci value
                            int b = 1; // first variable for calculating fibonacci value
                            int temp; // for storing fibonacci value

                            @Override
                            protected Void doInBackground() throws Exception {

                                // iterating for calcluating the fibonacci values
                                for (int i = 1; i <= number && isRunning; i++) {
                                    if(i == 1) {
                                        textArea1.append(String.valueOf(0)+System.lineSeparator());
                                        result.add("0");
                                    }
                                    else if(i == 2) {
                                        textArea1.append(String.valueOf(1)+System.lineSeparator());
                                        sum += 1;
                                        result.add("1");
                                    }
                                    else {
                                        temp = a+b;
                                        textArea1.append(String.valueOf(temp)+System.lineSeparator());
                                        result.add(String.valueOf(temp));
                                        sum += temp;
                                        a = b;
                                        b = temp;
                                    }
                                    progressBar1.setValue((int)((double)i/number*100));
                                    try {
                                        Thread.sleep(20);
                                    } catch (InterruptedException ex) {}
                                }
                                // write result array on text file
                                PrintWriter pw = new PrintWriter("data.txt");
                                pw.print(result);
                                pw.close();

                                sumLabel.setText("Sum = "+sum);
                                cancelButton.setEnabled(false);
                                return null;
                            }
                        };
                        worker.execute();
                    }
                    catch (NumberFormatException exception) { // the case of wrong input format
                        JOptionPane.showMessageDialog(null, "Enter valid input!", "Warning", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
            if(e.getSource() == cancelButton) { // the case of push cancel button
                isRunning = false;
            }
        }
    }

    public App() {

        // size setting
        progressBar1.setPreferredSize(new Dimension(600, 20));
        sumLabel.setPreferredSize(new Dimension(300,20));

        // initialize the text area
        textArea1.setText("");
        textArea1.setEditable(false);

        // create new ButtonHandler for button event handling
        ButtonHandler handler = new ButtonHandler();
        getSumOfFebonacciButton.addActionListener(handler);
        cancelButton.addActionListener(handler);

        progressBar1.setStringPainted(true); // show percentage on progress bar
        cancelButton.setEnabled(false);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Finding Fibonacci series sum");
        frame.setContentPane(new App().contentPanel);
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
