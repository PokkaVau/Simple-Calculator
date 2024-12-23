import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Calculator");
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        // Create text fields
        JTextField num1Field = new JTextField();
        JTextField num2Field = new JTextField();
        JLabel resultLabel = new JLabel("Result: ");

        // Add text fields and result label to the panel
        panel.add(new JLabel("Enter First Number:"));
        panel.add(num1Field);
        panel.add(new JLabel("Enter Second Number:"));
        panel.add(num2Field);

        // Create buttons for operations
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4));

        JButton addButton = new JButton("+");
        JButton subtractButton = new JButton("-");
        JButton multiplyButton = new JButton("*");
        JButton divideButton = new JButton("/");

        // Add buttons to the panel
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);

        panel.add(buttonPanel);
        panel.add(resultLabel);

        // Add action listeners to buttons
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    double result;

                    if (e.getSource() == addButton) {
                        result = num1 + num2;
                        resultLabel.setText("Result: " + result);
                    } else if (e.getSource() == subtractButton) {
                        result = num1 - num2;
                        resultLabel.setText("Result: " + result);
                    } else if (e.getSource() == multiplyButton) {
                        result = num1 * num2;
                        resultLabel.setText("Result: " + result);
                    } else if (e.getSource() == divideButton) {
                        if (num2 != 0) {
                            result = num1 / num2;
                            resultLabel.setText("Result: " + result);
                        } else {
                            resultLabel.setText("Error: Division by zero");
                        }
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Error: Invalid input");
                }
            }
        };

        // Attach the same listener to all buttons
        addButton.addActionListener(listener);
        subtractButton.addActionListener(listener);
        divideButton.addActionListener(listener);

        // Add the panel to the frame
        frame.add(panel);
        frame.setVisible(true);
    }
}
