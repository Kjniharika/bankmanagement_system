import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;

import javax.swing.*;

public class LoginWindow extends JFrame implements ActionListener {
	JPasswordField passF = new JPasswordField("", 20);
	JTextField accountNoT = new JTextField("", 20);
	JButton loginB = new JButton("Login"), signUpB = new JButton("Create a New Account"),
			userDetailsB = new JButton("User Details");
	JLabel imgLabel = new JLabel(new ImageIcon("bank.png"));
	JPanel jp = new JPanel();
	JPanel jp2 = new JPanel();
	JPanel jp3 = new JPanel();
	Database db = Database.getInstance();

	public LoginWindow() {

		Database.getInstance().loadData();

		// this.addWindowListener(new WindowAdapter() {
		// public void windowClosing(WindowEvent we) {
		// db.saveData();
		// System.exit(0);
		// }
		// });

		db.printAccounts();

		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(1, 2));

		loginB.addActionListener(this);
		signUpB.addActionListener(this);
		userDetailsB.addActionListener(this);

		this.add(imgLabel);
		this.add(jp);

		jp.setLayout(new GridLayout(3, 1));
		jp.add(new JLabel());
		jp.add(jp2);
		jp.add(jp3);

		jp2.add(new JLabel("Account Number: "));
		jp2.add(accountNoT);
		jp2.add(new JLabel("Password "));
		jp2.add(passF);
		jp2.add(loginB);
		jp2.add(new JLabel("OR"));
		jp2.add(signUpB);

		jp3.setLayout(new GridLayout(3, 3));

		jp3.add(new JLabel());
		jp3.add(new JLabel());
		jp3.add(new JLabel());
		jp3.add(new JLabel());
		jp3.add(userDetailsB);
		jp3.add(new JLabel());
		jp3.add(new JLabel());
		jp3.add(new JLabel());
		jp3.add(new JLabel());

		this.revalidate();
	}

	public static void main(String args[]) {

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Login")) {
			Account ac;
			if ((ac = db.getAccount(accountNoT.getText(), passF.getText())) != null) {
				this.dispose();
				new AccountDashboard(ac);
			} else {
				JOptionPane.showMessageDialog(this, "Account Number & Password didn't Match!", "Login Failed",
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getActionCommand().equals("Create a New Account")) {
			this.dispose();
			new SignUpWindow();
		} else if (e.getActionCommand().equals("User Details")) {
			this.dispose();
			try {
				new UserDetails();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
