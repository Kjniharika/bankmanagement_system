
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.BlockingQueue;

import javax.swing.*;

class AdminLogin extends JFrame implements ActionListener {

    JFrame frame = new JFrame();

    JPasswordField password = new JPasswordField("", 20);
    JTextField username = new JTextField("", 20);
    JButton myButton = new JButton("Login");

    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();

    AdminLogin() {

        myButton.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setLayout(new GridLayout(1, 2));

        JLabel imgLabel = new JLabel(new ImageIcon("admin.png"));
        frame.add(imgLabel);

        panel.setLayout(new GridLayout(3, 1));
        panel.add(new JLabel());
        panel.add(panel3);
        panel.add(new JLabel());
        panel2.setLayout(new GridLayout(2, 2));
        panel2.add(new JLabel("Admin Username: "));
        panel2.add(username);
        panel2.add(new JLabel("Password: "));
        panel2.add(password);

        panel3.setLayout(new GridLayout(2, 1));
        panel3.add(panel2);

        panel4.setLayout(new GridLayout(3, 3));
        panel4.add(new JLabel());
        panel4.add(new JLabel());
        panel4.add(new JLabel());
        panel4.add(new JLabel());
        panel4.add(myButton);
        panel4.add(new JLabel());
        panel4.add(new JLabel());
        panel4.add(new JLabel());
        panel4.add(new JLabel());

        panel3.add(panel4);
        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == myButton && isFormFilled()) {
            frame.dispose();
            new LoginWindow();
        } else {
            JOptionPane.showMessageDialog(null, "Please fill up all the fields", "Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    boolean isFormFilled() {
        if (username.getText().isEmpty() || password.getText().isEmpty()) {
            return false;
        }
        return true;
    }
}

public class AdminLoginPage {
    public static void main(String[] args) {
        new AdminLogin();
    }

}
