//Lab One 9/4/24
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel
{
    private final Register register = new Register();//was not really able to find a way to make this work for me
    private final JTextField input = new JTextField(10);//user input
    private final PursePanel changePanel = new PursePanel();//i put the images on here

    public RegisterPanel()
    {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();//holds JTextField for user input
        inputPanel.add(new JLabel("Enter amount:"));
        inputPanel.add(input);
        add(inputPanel, BorderLayout.NORTH);

        add(changePanel, BorderLayout.CENTER);

        input.addActionListener(new InputListener());
    }

    private class InputListener implements ActionListener//listens to when input is changed
    {
        @Override
        public void actionPerformed(ActionEvent e)//if input changes this happens
        {
            try
            {
                double amount = Double.parseDouble(input.getText());
                if (amount < 0)
                {
                    changePanel.setPurse(new Purse());
                } else
                {
                    Purse purse = Register.makeChange(amount);
                    changePanel.setPurse(purse);
                }
            } catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(RegisterPanel.this, "Invalid amount", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

