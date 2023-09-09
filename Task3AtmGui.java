import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public String deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return "Deposit of $" + amount + " successful.";
        } else {
            return "Invalid deposit amount.";
        }
    }

    public String withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return "Withdrawal of $" + amount + " successful.";
        } else {
            return "Insufficient Balance.";
        }
    }
}

class ATM extends JFrame {
    private BankAccount userAccount;
    private Font labelFont;
    private JLabel messageLabel;

    public ATM(BankAccount account) {
        userAccount = account;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        JButton checkBalanceButton = new JButton("Check Balance");
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton exitButton = new JButton("Exit");
        this.messageLabel = new JLabel("Initial Balance: " + account.getBalance());
        this.labelFont = new Font("Arial", Font.BOLD, 24);
        this.messageLabel.setFont(this.labelFont);
        checkBalanceButton.setFont(this.labelFont);
        depositButton.setFont(this.labelFont);
        withdrawButton.setFont(this.labelFont);
        exitButton.setFont(this.labelFont);

        checkBalanceButton.setBounds(130, 40, 220, 40);
        depositButton.setBounds(130, 100, 220, 40);
        withdrawButton.setBounds(130, 160, 220, 40);
        exitButton.setBounds(130, 210, 220, 40);
        this.messageLabel.setBounds(20, 280, 400, 40);

        this.add(checkBalanceButton);
        this.add(depositButton);
        this.add(withdrawButton);
        this.add(exitButton);
        this.add(messageLabel);

        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ATM.this.messageLabel.setText("Current Balance:" + ATM.this.userAccount.getBalance());
            }
        });

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Deposit Entry");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(300, 150);
                JPanel panel = new JPanel();
                panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
                JTextField nameTextField = new JTextField(20);
                nameTextField.setFont(new Font("Arial", Font.PLAIN, 16));
                JButton submitButton = new JButton("Deposit");
                submitButton.setFont(new Font("Arial", Font.BOLD, 16));
                submitButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String name = nameTextField.getText();
                        if (name.equals("")) {
                            JOptionPane.showMessageDialog(frame, "mandatory field!!!", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            double d = Double.valueOf(name);
                            String msg = ATM.this.userAccount.deposit(d);
                            frame.dispose();
                            ATM.this.messageLabel.setText(msg);
                        }
                    }
                });
                panel.add(nameTextField);
                panel.add(submitButton);
                frame.add(panel);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Withdraw Entry");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(300, 150);
                JPanel panel = new JPanel();
                panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
                JTextField nameTextField = new JTextField(20);
                nameTextField.setFont(new Font("Arial", Font.PLAIN, 16));
                JButton submitButton = new JButton("Withdraw");
                submitButton.setFont(new Font("Arial", Font.BOLD, 16));
                submitButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String name = nameTextField.getText();
                        if (name.equals("")) {
                            JOptionPane.showMessageDialog(frame, "mandatory field!!!", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            double d = Double.valueOf(name);
                            String msg = ATM.this.userAccount.withdraw(d);
                            frame.dispose();
                            ATM.this.messageLabel.setText(msg);
                        }
                    }
                });
                panel.add(nameTextField);
                panel.add(submitButton);
                frame.add(panel);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ATM.this.dispose();
                System.exit(0);
            }
        });
        this.setVisible(true);
    }
}

public class Task3AtmGui {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);
    }
}
