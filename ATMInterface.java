import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMInterface extends JFrame {
    private int balance = 1000; // Initial balance
    private String pin = "1234"; // PIN

    private JTextField pinField;
    private JTextField amountField;
    private JLabel balanceLabel;

    public ATMInterface() {
        setTitle("ATM Interface");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();

        setVisible(true);
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 1));

        JPanel pinPanel = new JPanel(new FlowLayout());
        JLabel pinLabel = new JLabel("Enter PIN:");
        pinField = new JTextField(4);
        pinPanel.add(pinLabel);
        pinPanel.add(pinField);

        JPanel actionPanel = new JPanel(new FlowLayout());
        JButton loginButton = new JButton("Login");
        JButton checkBalanceButton = new JButton("Check Balance");
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        actionPanel.add(loginButton);
        actionPanel.add(checkBalanceButton);
        actionPanel.add(depositButton);
        actionPanel.add(withdrawButton);

        JPanel amountPanel = new JPanel(new FlowLayout());
        JLabel amountLabel = new JLabel("Amount:");
        amountField = new JTextField(8);
        amountPanel.add(amountLabel);
        amountPanel.add(amountField);

        JPanel balancePanel = new JPanel(new FlowLayout());
        balanceLabel = new JLabel("Balance: $" + balance);
        balancePanel.add(balanceLabel);

        mainPanel.add(pinPanel);
        mainPanel.add(actionPanel);
        mainPanel.add(amountPanel);
        mainPanel.add(balancePanel);

        add(mainPanel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredPin = pinField.getText();
                if (enteredPin.equals(pin)) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid PIN! Try again.");
                }
            }
        });

        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Your balance is: $" + balance);
            }
        });

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int amount = Integer.parseInt(amountField.getText());
                    balance += amount;
                    balanceLabel.setText("Balance: $" + balance);
                    JOptionPane.showMessageDialog(null, "Deposit successful!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid amount! Please enter a valid number.");
                }
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int amount = Integer.parseInt(amountField.getText());
                    if (amount > balance) {
                        JOptionPane.showMessageDialog(null, "Insufficient balance!");
                    } else {
                        balance -= amount;
                        balanceLabel.setText("Balance: $" + balance);
                        JOptionPane.showMessageDialog(null, "Withdrawal successful!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid amount! Please enter a valid number.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ATMInterface();
            }
        });
    }
}
