import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main extends JFrame{
    private JPanel contentpane;
    private JLabel wooriLabel;
    private JTextArea textArea1;
    private JButton ENGLISHButton;
    private JButton KOREANButton;
    private JButton OPTION1Button;
    private JButton OPTION2Button;
    private JButton OPTION3Button;
    private JButton OPTION4Button;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button0;
    private JButton CANCELButton;
    private JButton CLEARButton;
    private JButton ENTERButton;
    private int flag = 0; // the flag for each situation of button operation
    private int i, j; // for storing idx of ArrayList
    ArrayList<BankAccount> bankAccount;
    private int easterEggCount = 0; // for storing the count for easterEgg


    // inner class for button event handling
    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {

            int pin; // storing for the pin user inserts
            boolean isCorrect; // storing the boolean that user insert right value
            double withdrawalAmount, depositAmount, transferringAmount; // storing for the option operation


            // number pad operation
            if(event.getSource() == button1) textArea1.append("1");
            if(event.getSource() == button2) textArea1.append("2");
            if(event.getSource() == button3) textArea1.append("3");
            if(event.getSource() == button4) textArea1.append("4");
            if(event.getSource() == button5) textArea1.append("5");
            if(event.getSource() == button6) textArea1.append("6");
            if(event.getSource() == button7) textArea1.append("7");
            if(event.getSource() == button8) textArea1.append("8");
            if(event.getSource() == button9) textArea1.append("9");
            if(event.getSource() == button0) textArea1.append("0");

            if(event.getSource() == ENTERButton) { // Press ENTER
                if(flag == 0) {
                    textArea1.setText("PIN: ");
                    flag = 1;
                }
                else if(flag == 1 || flag == 2) { // Pin Insertion
                    if(textArea1.getText().equals("Wrong pin! Try Again:" + System.lineSeparator() + "PIN: ") || textArea1.getText().equals("PIN: ")) {
                        easterEggCount++;
                        if(easterEggCount == 5) {
                            setVisible(false);
                            new EasterEgg();
                        }
                    }
                    else {
                        easterEggCount = 0;
                        pin = Integer.parseInt(textArea1.getText().replaceAll("[^0-9]", ""));
                        isCorrect = false;
                        for(i = 0; i < bankAccount.size(); i++) {
                            if(bankAccount.get(i).getPinCode() == pin) {
                                isCorrect = true;
                                break;
                            }
                        }
                        if(isCorrect) { // Pin Correct
                            textArea1.setText("Welcome " + bankAccount.get(i).user.getName() + System.lineSeparator() + "Please choose options:" + System.lineSeparator() + "OPTION1: Balance Checking" + System.lineSeparator() + "OPTION2: Withdrawing money" + System.lineSeparator() + "OPTION3: Deposit" + System.lineSeparator() + "OPTION4: Transfer");
                            flag = 3;
                        }
                        else { // Pin Wrong
                            textArea1.setText("Wrong pin! Try Again:" + System.lineSeparator() + "PIN: ");
                            flag = 2;
                        }
                    }
                }
                else if (flag == 4) { // Option2 result
                    withdrawalAmount = Double.parseDouble(textArea1.getText().replaceAll("[^0-9]", ""));
                    if(withdrawalAmount > bankAccount.get(i).getBalance()) { // exceed balance
                        textArea1.setText("Not enough money!" + System.lineSeparator() + "Press ENTER ...");
                    }
                    else { // do not exceed balance
                        bankAccount.get(i).setBalance(bankAccount.get(i).getBalance()-withdrawalAmount);
                        textArea1.setText("Success:)" + System.lineSeparator() + "User: " + bankAccount.get(i).user.getName() + System.lineSeparator() + "Withdrawal Amount: " + withdrawalAmount + System.lineSeparator() + "Current Balance: " + bankAccount.get(i).getBalance() + System.lineSeparator() + "Press ENTER ...");
                    }
                    flag = 8;
                }
                else if(flag == 5) { // Option3 result
                    depositAmount = Double.parseDouble(textArea1.getText().replaceAll("[^0-9]", ""));
                    bankAccount.get(i).setBalance(bankAccount.get(i).getBalance()+depositAmount);
                    textArea1.setText("Success:)" + System.lineSeparator() + "User: " + bankAccount.get(i).user.getName() + System.lineSeparator() + "Deposit Amount: " + depositAmount + System.lineSeparator() + "Current Balance: " + bankAccount.get(i).getBalance() + System.lineSeparator() + "Press ENTER ...");
                    flag = 8;
                }
                else if(flag == 6) { // Option4 result
                    isCorrect = false;
                    for(j = 0; j < bankAccount.size(); j++) {
                        if((bankAccount.get(j).getBankNumber()).equals(textArea1.getText().substring(33))) {
                            isCorrect = true;
                            break;
                        }
                    }
                    if(isCorrect) {
                        textArea1.setText("Transfer Account: " + bankAccount.get(j).user.getName() + System.lineSeparator() + "Enter Transfer Amount: ");
                        flag = 7;
                    }
                    else {
                        textArea1.setText("You entered the wrong account number!" + System.lineSeparator() + "Press ENTER ...");
                        flag = 8;
                    }
                }
                else if(flag == 7) { // Option4 result2
                    transferringAmount = Double.parseDouble(textArea1.getText().replaceAll("[^0-9]", ""));
                    if(transferringAmount > bankAccount.get(i).getBalance()) {
                        textArea1.setText("Not enough money" + System.lineSeparator() + "Press Enter ...");
                    }
                    else {
                        bankAccount.get(i).setBalance(bankAccount.get(i).getBalance()-transferringAmount);
                        bankAccount.get(j).setBalance(bankAccount.get(j).getBalance()+transferringAmount);
                        textArea1.setText("Transfer Amount: " + transferringAmount + System.lineSeparator() + "Current Balance: " + bankAccount.get(i).getBalance() + System.lineSeparator() + "Press ENTER ...");
                    }
                    flag = 8;
                }
                else if(flag == 8) { // the end of option operation
                    textArea1.setText("Thank you for banking with us!" + System.lineSeparator() + "press ENTER ...");
                    flag = 0;
                }
            }
            else if(event.getSource() == CLEARButton) { // Press CLEAR
                if(flag == 1) {
                    textArea1.setText("PIN: ");
                }
                else if(flag == 2) { // Wrong Pin at least once
                    textArea1.setText("Wrong pin! Try Again:" + System.lineSeparator() + "PIN: ");
                }
                else if(flag == 4) {
                    textArea1.setText("Enter Withdrawal Amount: ");
                }
                else if(flag == 5) {
                    textArea1.setText("Enter Deposit Amount: ");
                }
                else if(flag == 6) {
                    textArea1.setText("Enter Account Number (Receiver): ");
                }
            }
            else if(event.getSource() == OPTION1Button) { // Press OPTION1
                if(flag == 3) {
                    textArea1.setText("User: " + bankAccount.get(i).user.getName() + System.lineSeparator() + "Balance: " + bankAccount.get(i).getBalance() + System.lineSeparator() + "Press ENTER ...");
                    flag = 8;
                }
            }
            else if(event.getSource() == OPTION2Button) { // Press OPTION2
                if(flag == 3) {
                    textArea1.setText("Enter Withdrawal Amount: ");
                    flag = 4;
                }
            }
            else if(event.getSource() == OPTION3Button) { // Press OPTION3
                if(flag == 3) {
                    textArea1.setText("Enter Deposit Amount: ");
                    flag = 5;
                }
            }
            else if(event.getSource() == OPTION4Button) { // Press OPTION4
                if(flag == 3) {
                    textArea1.setText("Enter Account Number (Receiver): ");
                    flag = 6;
                }
            }
            else if(event.getSource() == CANCELButton) {
                textArea1.setText("Process is canceled by user! Please press ENTER ...");
                flag = 0;
            }
        }
    }

    // Main adds JButtons to JFrame
    // one-argument constructor
    public Main(ArrayList<BankAccount> bankAccountList) {

        // make a new bankAccount storing bank info in bankAccountList
        bankAccount = bankAccountList;

        // create new ButtonHandler for button event handling
        ButtonHandler handler = new ButtonHandler();
        OPTION1Button.addActionListener(handler);
        OPTION2Button.addActionListener(handler);
        OPTION3Button.addActionListener(handler);
        OPTION4Button.addActionListener(handler);
        CANCELButton.addActionListener(handler);
        CLEARButton.addActionListener(handler);
        ENTERButton.addActionListener(handler);
        button1.addActionListener(handler);
        button2.addActionListener(handler);
        button3.addActionListener(handler);
        button4.addActionListener(handler);
        button5.addActionListener(handler);
        button6.addActionListener(handler);
        button7.addActionListener(handler);
        button8.addActionListener(handler);
        button9.addActionListener(handler);
        button0.addActionListener(handler);

        // initial setting of text area
        textArea1.setText("Please, insert your card and press ENTER...");
        textArea1.setEditable(false);
    }



    public static void main(String[] args) {

        ArrayList<BankAccount> bankAccounts = new ArrayList<>();
        User user1 = new User("Firuz");
        User user2 = new User("John");
        User user3 = new User("Eldor");

        bankAccounts.add(new BankAccount("200100237898", 1234, 500000.0,user1));
        bankAccounts.add(new BankAccount("110000022033", 4321, 700000.0, user2));
        bankAccounts.add(new BankAccount("111111111111", 2222, 900000.0, user3));

        //Show the window
        JFrame frame = new JFrame("ATM");
        frame.setContentPane(new Main(bankAccounts).contentpane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
