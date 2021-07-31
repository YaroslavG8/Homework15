package task2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    private JButton submit;
    private JPanel rootPanel;
    private JLabel loginLabel;
    private JLabel passwordLabel;
    private JLabel confirmPasswordLabel;
    private JTextField login;
    private JTextField password;
    private JTextField confirmPassword;



    private void createLabels() {
        loginLabel = new JLabel("  Login:");
        passwordLabel = new JLabel("  Password:");
        confirmPasswordLabel = new JLabel("  Confirm password:");
    }

    private void createTextFields() {
        login = new JTextField(15);
        password = new JPasswordField(15);
        confirmPassword = new JPasswordField(15);

    }



    private void createPanel() {
        rootPanel = new JPanel(new GridLayout(3, 1));
        rootPanel.add(loginLabel);
        rootPanel.add(login);
        rootPanel.add(passwordLabel);
        rootPanel.add(password);
        rootPanel.add(confirmPasswordLabel);
        rootPanel.add(confirmPassword);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            checkLogInInfo(login.getText(), password.getText(), confirmPassword.getText(), "[\\w]{1,20}");
            JOptionPane.showMessageDialog(this, "Login and password are correct!",
                    "User login&password confirmation", JOptionPane.PLAIN_MESSAGE);
        } catch (WrongLoginException | WrongPasswordException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "UserException", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean checkLogInInfo(String login, String password, String confirmPassword, String regex)
            throws WrongLoginException, WrongPasswordException {
        if (!login.matches(regex)) {
            throw new WrongLoginException("Incorrect login");
        } else if (!password.matches(regex) ||
                !confirmPassword.matches(regex) ||
                !password.equals(confirmPassword)) {
            throw new WrongPasswordException("Incorrect password");
        }
        return true;
    }
}
