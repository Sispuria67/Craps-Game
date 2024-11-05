/**
 * A package for panels in view.
 */
package view;

import model.CrapsModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


/**
 * CurrentRollPanel is a class that holds a panel for the necessary
 * information for what happens when the dice are rolled.
 * @author Sado Iman
 * @version 10/13/23
 */
public class CurrentRollPanel extends JPanel {
    /** A private field for dice 1 text field */
    private final JTextField myDie1;
    /** A private field for dice 2 text field */
    private final JTextField myDie2;
    /** A private field for dice total text field */
    private final JTextField myTotal;
    /** A private field for dice point text field */
    private final JTextField myPoint;

    /** A private field for dice rolling button */
    private final JButton myRoll;
    /** A private field for controller instance */
    private CrapsModel myCurrentRoll;

    /**
     * CurrentRollPanel is constructor method that sets craps model instance,
     * creates text fields, and calls the layout for the panel.
     *
     * @param theCurrentRoll is the craps model instance.
     */
    public CurrentRollPanel(final CrapsModel theCurrentRoll) {
        this.myCurrentRoll = theCurrentRoll;
        this.myDie1 = new JTextField(5);
        this.myDie2 = new JTextField(5);
        this.myTotal = new JTextField(5);
        this.myPoint = new JTextField(5);
        this.myRoll = new JButton("Roll Dice");
        myTotal.setEditable(false);
        myDie1.setEditable(false);
        myDie2.setEditable(false);
        layoutComponents();
        myRoll.setEnabled(false);
    }
    /**
     * layoutComponents is a method that sets up the
     * formatting of the panel to be put on frame.
     *
     */
    public void layoutComponents() {
        this.add(myDie1);
        this.add(myDie2);
        this.add(myTotal);
        this.setLayout(new BorderLayout());
        JPanel topCenterPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel dice1Label = new JLabel(new ImageIcon());
        JLabel dice2Label = new JLabel(new ImageIcon());
        dice1Label.setIcon(new ImageIcon(myCurrentRoll.getMyDice1() + ".jpg"));
        dice2Label.setIcon(new ImageIcon( myCurrentRoll.getMyDice2() + ".jpg"));
        topCenterPanel.setBorder(BorderFactory.createTitledBorder("Current Roll"));
        topCenterPanel.add(new JLabel(("Dice 1:")));
        topCenterPanel.add(myDie1);
        topCenterPanel.add(new JLabel(("Dice 2:")));
        topCenterPanel.add(myDie2);
        topCenterPanel.add(new JLabel(("Total:")));
        topCenterPanel.add(myTotal);
        topCenterPanel.add(myRoll);
        topCenterPanel.add(new JLabel(("Point:")));
        topCenterPanel.add(myPoint);
        this.add(topCenterPanel, BorderLayout.WEST);
        this.add(dice1Label, BorderLayout.NORTH);
        this.add(dice2Label, BorderLayout.SOUTH);
    }
    /**
     * reset is a method that resets
     * all text fields back to empty and
     * resets their values to 0 and enables button.
     *
     */
    public void reset(){
        myDie1.setText("");
        myDie2.setText("");
        myTotal.setText("");
        myPoint.setText("");
        myRoll.setEnabled(true);
    }
    /**
     * getRoll is a getter method that returns
     * roll button.
     *
     * @return the button
     */
    public JButton getRoll(){
        return myRoll;
    }

    /**
     * setMyPoint is a setter method that sets
     * the point to the new theValue.
     *
     * @param theValue is the updated point value.
     */
    public void setMyPoint(final int theValue){
        myPoint.setText((String.valueOf(theValue)));
    }

    /**
     * setDice1 is a setter method that sets
     * the dice 1 to the new theValue.
     *
     * @param theDice1 is the updated dice 1 value.
     */
    public void setDice1(final int theDice1){
        myDie1.setText(String.valueOf(theDice1));

    }
    /**
     * setDice2 is a setter method that sets
     * the dice 2 to the new theValue.
     *
     * @param theDice2 is the updated dice 2 value.
     */
    public void setDice2(final int theDice2) {
        myDie2.setText(String.valueOf(theDice2));

    }
    /**
     * setDiceTotal is a setter method that sets
     * the text field to the new theValue.
     *
     * @param theTotal is the updated dice total value.
     */
    public void setDiceTotal(final int theTotal) {
        myTotal.setText(String.valueOf(theTotal));

    }

    /**
     * addRollListener is a method that add listeners
     * to the button to be handled in controller.
     *
     * @param theListener is the listener to be added to the button
     */
    public void addRollListener(final ActionListener theListener) {
        getRoll().addActionListener(theListener);
    }
    /**
     * setEnabled is a method that either enables
     * or disables the button.
     *
     * @param theValue is the true or false to enable button.
     */
    public void setEnabled(final boolean theValue){
        getRoll().setEnabled( theValue);
    }



}