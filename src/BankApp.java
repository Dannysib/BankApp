import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankApp {
    public static void main(String[] args) {
        JLabel balanceLabel;
        JTextField balanceField;
        JButton depositButton;
        JButton withdrawButton;
        JButton viewBalanceButton;
        final double[] balance = {0.0};

        JFrame frame = new JFrame("Bank App");
        balanceLabel = new JLabel("Balance");
        balanceField = new JTextField(10);
        balanceField.setEditable(false);

        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        viewBalanceButton = new JButton("View Balance");

        JPanel panel = new JPanel();
        panel.add(balanceLabel);
        panel.add(balanceField);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(viewBalanceButton);

        frame.add(panel);
        Dimension minWidth = frame.getSize();
        minWidth.width = 300;
        frame.setMinimumSize(minWidth);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String input = JOptionPane.showInputDialog(frame, "Enter deposit amount:");
                try {

                    double amount = Double.parseDouble(input);
                    balance[0] += amount;
                    JOptionPane.showMessageDialog(frame, "Deposit successful!");
                    balanceField.setText(Double.toString(balance[0]));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input! Please enter a valid number.");
                }
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(frame, "Enter withdrawal amount:");
                try {
                    double amount = Double.parseDouble(input);
                    if (amount <= balance[0]) {
                        balance[0] -= amount;
                        JOptionPane.showMessageDialog(frame, "Withdrawal successful!");
                        balanceField.setText(Double.toString(balance[0]));
                    } else {
                        JOptionPane.showMessageDialog(frame, "Insufficient funds!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input! Please enter a valid number.");
                }
            }
        });

        viewBalanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Your balance is: " + balance[0]);
            }
        });
    }
}
