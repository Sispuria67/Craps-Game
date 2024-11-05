/**
 * A package for panels in view.
 */
package view;

import model.CrapsModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class BetPanel extends JPanel  {
    /** A private field for $1 button */
    private final JButton my1Button;
    /** A private field for $5 button */
    private final JButton my5Button;
    /** A private field for $10 button */
    private final JButton my10Button;
    /** A private field for $50 button */
    private final JButton my50Button;
    /** A private field for $100 button */
    private final JButton my100Button;
    /** A private field for $500 button */
    private final JButton my500Button;
    /** A private field for bet text field */
    private final JTextField myTextField;
    /** A private field for craps model instance */
    private final CrapsModel myBet;

    /**
     * BetPanel is constructor method that sets craps model instance,
     * creates text fields, buttons, and calls the layout for the panel.
     *
     * @param theBet is the craps model instance
     */
    public BetPanel(final CrapsModel theBet) {
        this.myBet = theBet;
        this.myTextField = new JTextField(5);
        this.my1Button = new JButton();
        this.my5Button = new JButton();
        this.my10Button = new JButton();
        this.my50Button = new JButton();
        this.my100Button = new JButton();
        this.my500Button = new JButton();
        my1Button.setText("+$1");
        my5Button.setText("+$5");
        my10Button.setText("+$10");
        my50Button.setText("+$50");
        my100Button.setText("+$100");
        my500Button.setText("+$500");
        myTextField.setEditable(false);
        disableAll();
        layoutComponents();
    }

    /**
     * layoutComponents is a method that sets up the
     * formatting of the panel to be put on frame.
     *
     */
    private void layoutComponents() {
        this.setLayout(new GridLayout(1, 1));
        JPanel myTopCenterPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        myTopCenterPanel.setPreferredSize(new Dimension(150, 150));
        myTopCenterPanel.add(new JLabel("$"));
        myTopCenterPanel.add(myTextField);
        myTopCenterPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
        myTopCenterPanel.setBorder(BorderFactory.createTitledBorder("Bet"));
        this.add(myTopCenterPanel, BorderLayout.NORTH);
        JPanel  myBottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        myBottomPanel.add(my1Button);
        myBottomPanel.add(my5Button);
        myBottomPanel.add(my10Button);
        myBottomPanel.add(my50Button);
        myBottomPanel.add(my100Button);
        myBottomPanel.add(my500Button);
        this.add( myBottomPanel, BorderLayout.CENTER);
        myTopCenterPanel.add( myBottomPanel);


    }
    /**
     * reset is a method that resets
     * all text fields back to empty and
     * resets their values to 0.
     *
     */
    public void reset() {
        myTextField.setText("");
        myBet.getMyCrapsInstance().setMyBet(0);
    }

    /**
     * setMyTextField is a setter method that sets
     * the text field to the new theValue.
     *
     * @param theValue is the updated theValue of house wins text field.
     */
    public void setMyTextField(String theValue) {
        myTextField.setText(theValue);
    }

    /**
     * disableAll is a method that disables
     * all buttons.
     */

    public void disableAll() {
        my1Button.setEnabled(false);
        my5Button.setEnabled(false);
        my10Button.setEnabled(false);
        my50Button.setEnabled(false);
        my100Button.setEnabled(false);
        my500Button.setEnabled(false);
    }
    /**
     * setEnabled is a method that either enables
     * or disables the buttons and text fields.
     *
     * @param theValue is the true or false to enable button or text field.
     */

    public void setEnabled(final boolean theValue) {
        my1Button.setEnabled(theValue);
        my5Button.setEnabled(theValue);
        my10Button.setEnabled(theValue);
        my50Button.setEnabled(theValue);
        my100Button.setEnabled(theValue);
        my500Button.setEnabled(theValue);
        myTextField.setEditable(theValue);
    }

    /**
     * addBetListener is a method that add listeners
     * to the buttons and text fields to be handled in controller
     *
     * @param theActionListener is the listener to be added to the button or text field.
     */
    public void addBetListener(final ActionListener theActionListener) {
        myTextField.addActionListener(theActionListener);
        my1Button.addActionListener(theActionListener);
        my5Button.addActionListener(theActionListener);
        my10Button.addActionListener(theActionListener);
        my50Button.addActionListener(theActionListener);
        my100Button.addActionListener(theActionListener);
        my500Button.addActionListener(theActionListener);
    }
    /**
     * getMyButton1 is a getter method that returns
     * button for $1.
     *
     * @return the button
     */
    public JButton getMyButton1() {
        return my1Button;
    }
    /**
     * getMyButton5 is a getter method that returns
     * button for $5.
     *
     * @return the button
     */
    public JButton getMyButton5() {
        return my5Button;
    }
    /**
     * getMyButton10 is a getter method that returns
     * button for $10.
     *
     * @return the button
     */
    public JButton getMyButton10() {
        return my10Button;
    }
    /**
     * getMyButton50 is a getter method that returns
     * button for $50.
     * @return the button
     */
    public JButton getMyButton50() {
        return my50Button;
    }
    /**
     * getMyButton100 is a getter method that returns
     * button for $100.
     *
     * @return the button
     */
    public JButton getMyButton100() {
        return my100Button;
    }
    /**
     * getMyButton500 is a getter method that returns
     * button for $500.
     *
     * @return the button
     */
    public JButton getMyButton500() {
        return my500Button;
    }
}





