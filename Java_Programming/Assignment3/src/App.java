import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {
    private JPanel panel1;
    private JPanel ImagePanel;
    private JLabel mainImage;
    private JPanel abovePanel;
    private JLabel logo;
    private JTextField nameField;
    private JTextField birthField;
    private JTextField mailField;
    private JTextField degreeField;
    private JTextField attendedField;
    private JTextField gpaField;
    private JTextArea textArea;
    private JTextField addressField;
    private JButton submitButton;
    private JTextField phoneNumberField;


    // inner class for button event handling
    public class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            boolean isBachelor = true; // checking if the degree is bachelor or graduates

            // Error messages
            String nameError = "You forgot to write your name or surname"+System.lineSeparator();
            String dateFormatError = "Birthdate must be in '06/06/1995' format"+System.lineSeparator();
            String emailFormatError = "Email must be in example@some.some"+System.lineSeparator();
            String phoneNumberFormatError = "Proper format for a phone number is ‘10 2158 0222’"+System.lineSeparator();
            String bachelorError = "For bachelor, the attended university and GPA should be empty"+System.lineSeparator();
            String graduateError = "For graduate, you have to enter previous university and GPA"+System.lineSeparator();
            String degreeError = "You must enter the right degree (Bachelor, Master, PhD)"+System.lineSeparator();
            String GPAError = "GPA must be between 0 and 4.5"+System.lineSeparator();
            String textAreaError = "Your Personal Statement must be at least 100 words"+System.lineSeparator();
            String addressError = "Your Personal Statement must be in 'number, street, district, city' format"+System.lineSeparator();

            StringBuffer errorMessage = new StringBuffer(); // string buffer for saving error messages

            // JOptionPane.showMessageDialog(null, errorMessage.toString(), "You have following problems:", JOptionPane.ERROR_MESSAGE);

            if(e.getSource() == submitButton) {
                int idx = 1; // storing for error numbering

                // nameField operation
                if(nameField.getText().isEmpty()) { // empty
                    errorMessage.append(idx+". "+"You forgot to fill the name text field, Please fill it"+System.lineSeparator());
                    idx++;
                }
                else { // not empty
                    String userName = nameField.getText();
                    userName.trim();
                    if(userName.split(" ").length == 2) { // right format
                        nameField.setForeground(Color.BLACK);
                    }
                    else { // wrong format
                        nameField.setForeground(Color.RED);
                        errorMessage.append(idx+". "+nameError);
                        idx++;
                    }
                }

                // birthField operation
                if(birthField.getText().isEmpty()) { // empty
                    errorMessage.append(idx+". "+"You forgot to fill the birth date field, Please fill it"+System.lineSeparator());
                    idx++;
                }
                else { // not empty
                    String userBirth = birthField.getText();
                    userBirth.trim();
                    if(userBirth.split("/").length == 3) { // partially right format
                        String [] userBirthArr = userBirth.split("/");
                        try {
                            int month = Integer.parseInt(userBirthArr[0]);
                            int day = Integer.parseInt(userBirthArr[1]);
                            int year = Integer.parseInt(userBirthArr[2]);

                            if(month >= 1 && month <= 12 && day >= 1 && day <= 31 && year >= 1000 && year <= 2023) { // right format
                                birthField.setForeground(Color.BLACK);
                            }
                            else { // wrong format
                                birthField.setForeground(Color.RED);
                                errorMessage.append(idx+". "+dateFormatError);
                                idx++;
                            }
                        }
                        catch (NumberFormatException ex) { // wrong format
                            birthField.setForeground(Color.RED);
                            errorMessage.append(idx+". "+dateFormatError);
                            idx++;
                        }
                    }
                    else { // wrong format
                        birthField.setForeground(Color.RED);
                        errorMessage.append(idx+". "+dateFormatError);
                        idx++;
                    }
                }

                // mailField operation
                if(mailField.getText().isEmpty()) { // empty
                    errorMessage.append(idx+". "+"You forgot to fill the email field, Please fill it"+System.lineSeparator());
                    idx++;
                }
                else { // not empty
                    String userMail = mailField.getText();
                    userMail.trim();
                    if(userMail.split("@").length == 2) { // partially right format
                        String [] userMailArr = userMail.split("@");
                        if(userMailArr[0].split("[.]").length == 1 && userMailArr[1].split("[.]").length == 2) { // right format
                            mailField.setForeground(Color.BLACK);
                        }
                        else { // wrong format
                            mailField.setForeground(Color.RED);
                            errorMessage.append(idx+". "+emailFormatError);
                            idx++;
                        }
                    }
                    else { // wrong format
                        mailField.setForeground(Color.RED);
                        errorMessage.append(idx+". "+emailFormatError);
                        idx++;
                    }
                }

                // phoneNumberField operation
                if(phoneNumberField.getText().isEmpty()) { // empty
                    errorMessage.append(idx+". "+"You forgot to fill the phone number field, Please fill it"+System.lineSeparator());
                }
                else { // not empty
                    String userPhoneNumber = phoneNumberField.getText();
                    userPhoneNumber.trim();
                    if(userPhoneNumber.split(" ").length == 3) { // partially right format
                        String phoneNumberArr [] = userPhoneNumber.split(" ");
                        try {
                            if(phoneNumberArr[0].length() == 2 && phoneNumberArr[1].length() == 4 && phoneNumberArr[2].length() == 4) { // right format
                                int number = Integer.parseInt(phoneNumberArr[0]);
                                number = Integer.parseInt(phoneNumberArr[1]);
                                number = Integer.parseInt(phoneNumberArr[2]);

                                phoneNumberField.setForeground(Color.BLACK);
                            }
                            else { // wrong format
                                phoneNumberField.setForeground(Color.RED);
                                errorMessage.append(idx+". "+phoneNumberFormatError);
                                idx++;
                            }
                        }
                        catch (NumberFormatException ex) { // wrong format
                            phoneNumberField.setForeground(Color.RED);
                            errorMessage.append(idx+". "+phoneNumberFormatError);
                            idx++;
                        }
                    }
                    else { // wrong format
                        phoneNumberField.setForeground(Color.RED);
                        errorMessage.append(idx+". "+phoneNumberFormatError);
                        idx++;
                    }
                }

                // degreeField operation
                if(degreeField.getText().isEmpty()) { // empty
                    errorMessage.append(idx+". "+"You forgot to fill the degree text field, Please fill it"+System.lineSeparator());
                    idx++;
                }
                else { // not empty
                    String userDegree = degreeField.getText();

                    // setting isBachelor value
                    if(userDegree.equals("Bachelor")) { // in case of bachelor
                        degreeField.setForeground(Color.BLACK);
                        isBachelor = true;
                    }
                    else if (userDegree.equals("Mater") || userDegree.equals("PhD")) { // in case of graduates
                        degreeField.setForeground(Color.BLACK);
                        isBachelor = false;
                    }
                    else { // in case of wrong input
                        degreeField.setForeground(Color.RED);
                        errorMessage.append(idx+". "+degreeError);
                        idx++;
                    }
                }

                // attendedField and gpaField operation
                if(attendedField.getText().isEmpty() && gpaField.getText().isEmpty()) { // empty either
                    if(isBachelor == false) { // in case of graduates
                        errorMessage.append(idx + ". " + graduateError);
                        idx++;
                    }
                }
                else if (attendedField.getText().isEmpty() || gpaField.getText().isEmpty()) { // one of two is empty
                    if(isBachelor == false) { // in case of graduates
                        attendedField.setForeground(Color.RED);
                        gpaField.setForeground(Color.RED);
                        errorMessage.append(idx + ". " + graduateError);
                        idx++;
                    }
                    else { // in case of bachelor
                        attendedField.setForeground(Color.RED);
                        gpaField.setForeground(Color.RED);
                        errorMessage.append(idx + ". " + bachelorError);
                        idx++;
                    }
                }
                else { // empty neither
                    if(isBachelor) { // in case of bachelor
                        attendedField.setForeground(Color.RED);
                        gpaField.setForeground(Color.RED);
                        errorMessage.append(idx + ". " + bachelorError);
                        idx++;
                    }
                    else { // in case of graduates
                        String userGPA = gpaField.getText();
                        userGPA.trim();
                        attendedField.setForeground(Color.BLACK);
                        try {
                            double doubleGPA = Double.parseDouble(userGPA);

                            if(doubleGPA >= 0 && doubleGPA <= 4.5) { // right format for GPA
                                gpaField.setForeground(Color.BLACK);
                            }
                            else { // wrong format for GPA
                                gpaField.setForeground(Color.RED);
                                errorMessage.append(idx+". "+GPAError);
                                idx++;
                            }
                        }
                        catch (NumberFormatException ex) { // wrong format for GPA
                            gpaField.setForeground(Color.RED);
                            errorMessage.append(idx+". "+GPAError);
                            idx++;
                        }

                    }
                }

                // textArea operation
                if(textArea.getText().isEmpty()) { // empty
                    textArea.setForeground(Color.RED);
                    errorMessage.append(idx+". "+textAreaError);
                    idx++;
                }
                else { // not empty
                    String userText = textArea.getText();
                    userText.trim();
                    if(userText.split(" ").length >= 100) { // right format
                        textArea.setForeground(Color.BLACK);
                    }
                    else { // wrong format
                        textArea.setForeground(Color.RED);
                        errorMessage.append(idx+". "+textAreaError);
                        idx++;
                    }
                }

                // addressField operation
                if(addressField.getText().isEmpty()) { // empty
                    errorMessage.append(idx+". "+"You forgot to fill the home address text field, Please fill it"+System.lineSeparator());
                    idx++;
                }
                else { // not empty
                    String userAddress = addressField.getText();
                    if(userAddress.split(",").length == 4) { // right format
                        addressField.setForeground(Color.BLACK);
                    }
                    else { // wrong format
                        addressField.setForeground(Color.RED);
                        errorMessage.append(idx+". "+addressError);
                        idx++;
                    }
                }

                if(idx == 1) { // no errors
                    JOptionPane.showMessageDialog(null, "Successfully Submitted", "Success Message", JOptionPane.INFORMATION_MESSAGE);
                }
                else { // exist errors
                    JOptionPane.showMessageDialog(null, errorMessage.toString(), "You have following problems:", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public App() {

        // create new ButtonHandler for button event handling
        ButtonHandler handler = new ButtonHandler();

        submitButton.addActionListener(handler); // for handling submit button

        // create the font of text area
        Font italicFont = new Font("Times New Roman", Font.ITALIC, textArea.getFont().getSize());

        // initial setting of text area
        textArea.setFont(italicFont);
        textArea.setText("At least 100 words...");
        textArea.setLineWrap(true);
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("SKKU new Students Enrollment");
        frame.setContentPane(new App().panel1);
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
