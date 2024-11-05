/**
 * A package for panels in view.
 */
package view;

import controller.CrapsController;
import model.CrapsModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


/**
 * The BankPanel is a class that holds the necessary
 * information for the bank panel
 * @author Sado Iman
 * @version 10/13/23
 */
public class BankPanel extends JPanel {
    /** A private field for bank amount text field */
    private final JTextField myTextField;

    /** A private field for set bank button */
    private final JButton myButton;
    /** A private field for craps model instance */
    private final CrapsModel myBank;
    /** A private field for controller instance */
    private final CrapsController myController;

    /**
     * BankPanel is constructor method that sets craps model instance,
     * controller instance, creates text fields, and calls the layout for the panel.
     *
     * @param theBank is the craps model instance
     * @param theController is the controller model instance
     */
    public BankPanel(final CrapsModel theBank, final CrapsController theController) {
        this.myBank = theBank;
        myController = theController;
        this.myTextField = new JTextField(5);
        this.myButton = new JButton("Set Bank");
        myButton.setEnabled(false);
        layoutComponents();
    }
    /**
     * reset is a method that resets
     * all text fields back to empty and
     * resets their values to 0 and enables button.
     *
     */
    public void reset() {
        myTextField.setText("");
        myBank.getMyCrapsInstance().setMyBank(0);
        myButton.setEnabled(true);
    }
    /**
     * layoutComponents is a method that sets up the
     * formatting of the panel to be put on frame.
     *
     */
    public void layoutComponents() {
        JPanel myTopCenterPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.setLayout(new BorderLayout());
        myTextField.setEditable(true);
        myTopCenterPanel.setBorder(BorderFactory.createTitledBorder("Bank"));
        myTopCenterPanel.add(new JLabel("$"));
        myTopCenterPanel.add(myTextField);
        myTopCenterPanel.add(myButton);
        this.add(myTopCenterPanel, BorderLayout.CENTER);
    }

    /**
     * setEnabled is a method that either enables
     * or disables the button.
     *
     * @param theValue is the true or false to enable button.
     */
    public void setEnabled(final boolean theValue) {
        myButton.setEnabled(theValue);
        myTextField.setEditable(theValue);
    }
    /**
     * setBank is a setter method that sets
     * the text field to the new theValue.
     *
     * @param theTotal is the updated theValue of bank text field.
     */
    public void setBank(final int theTotal) {
        try {
                myBank.setMyBank(theTotal);
                myTextField.setText(String.valueOf(theTotal));
            } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(myController.getFrame(), "Please enter a valid number!");
        }
    }

    /**
     * isNumber is a method that checks if user
     * inputted values for bank are numbers and valid.
     *
     * @return the boolesn value
     */
    public boolean isNumber() {
        String userInput = myTextField.getText().trim();
        if (userInput.matches("\\d+")) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * addBankListener is a method that add listeners
     * to the buttons and text fields to be handled in controller
     *
     * @param theListener is the listener to be added to the button or text field.
     */
    public void addBankListener(final ActionListener theListener) {
        this.myButton.addActionListener(theListener);
        myTextField.addActionListener(theListener);
    }

    /**
     * getMyButton is a getter method that returns
     * button for set bank.
     *
     * @return the button
     */
    public JButton getMyButton() {
        return myButton;
    }
    /**
     * getMyTextField is a getter method that returns
     * text field for bank value.
     *
     * @return the text field
     */
    public JTextField getMyTextField() {
        return myTextField;
    }

}