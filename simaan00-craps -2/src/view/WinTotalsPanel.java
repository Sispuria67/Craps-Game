/**
 * A package for panels in view.
 */
package view;

import model.CrapsModel;

import javax.swing.*;
import java.awt.*;

/**
 * The WinTotalsPanel is a class that holds the necessary
 * information for when the game is won in the panel.
 * @author Sado Iman
 * @version 10/13/23
 */
public class WinTotalsPanel extends JPanel  {
    /** A private field for player text field */
    private final JTextField myTextPlayer;

    /** A private field for house text field */
    private final JTextField myTextHouse;

    /** A private field for craps model instance */
    private final CrapsModel myWins;


    /**
     * WinTotalsPanel is constructor method that sets craps model instance,
     * creates text fields, and calls the layout for the panel.
     *
     * @param theWins is the craps model instance
     */
    public WinTotalsPanel(final CrapsModel theWins) {
        this.myWins = theWins;
        myTextHouse = new JTextField(5);
        myTextPlayer = new JTextField(5);
        layoutComponents();
    }
    /**
     * layoutComponents is a method that sets up the
     * formatting of the panel to be put on frame.
     *
     */
    public void layoutComponents() {
       JPanel myWinTotalsPanelsPanel = new JPanel(new FlowLayout());
        myWinTotalsPanelsPanel.setBorder((BorderFactory.createTitledBorder("Wins")));
        myWinTotalsPanelsPanel.add(new JLabel("House Win Total:"));
        myWinTotalsPanelsPanel.add(myTextHouse);
        myWinTotalsPanelsPanel.add(new JLabel("Player Win Total:"));
        myWinTotalsPanelsPanel.add(myTextPlayer);
        this.add(myWinTotalsPanelsPanel, BorderLayout.SOUTH);
        myTextHouse.setEditable(false);
        myTextPlayer.setEditable(false);
    }

    /**
     * setTextHouse is a setter method that sets
     * the text field to the new theValue.
     *
     * @param theValue is the updated theValue of house wins text field.
     */
    public void setTextHouse(String theValue) {
        myTextHouse.setText(theValue);
    }
    /**
     * setTextPlayer is a setter method that sets
     * the text field to the new theValue.
     *
     * @param theValue is the updated theValue of house wins text field.
     */
    public void setTextPlayer(String theValue) {
        myTextPlayer.setText(theValue);
    }
    /**
     * reset is a method that resets
     * all text fields back to empty and
     * resets their values to 0.
     *
     */
    public void reset() {
        myTextHouse.setText("");
        myTextPlayer.setText("");
        myWins.getMyCrapsInstance().setMyPlayerWins(0);
        myWins.getMyCrapsInstance().setMyHouseWins(0);
    }

}