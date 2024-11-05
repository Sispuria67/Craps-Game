/**
 * A package for controller.
 */
package controller;

import model.CrapsModel;
import view.*;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import static model.CrapsModel.getMyCrapsInstance;
/**
 * CrapsController is a class that acts as the controller
 * for the craps game and deals with the action listeners for
 * the view panels.
 * @author Sado Iman
 * @version 10/13/23
 */

public class CrapsController extends JPanel {
    /** A private field for controller instance */
    private final CrapsModel myModel;

    /** A private field for frame for controller*/
    private JFrame frame = new JFrame();;
    /** A private field for menu item*/
    private JMenu myMenu;

    /** A private field for menu item*/
    private JMenu myMenu2;
    /** A private field for menu bar*/
    private static JMenuBar myBar;

    /** A private field for audio clip */
    private Clip clip;
    /** A private field for reset menu item*/
    private static JMenuItem myReset;

    /** A private field for about menu item*/
    private static JMenuItem myAbout;
    /** A private field for rules menu item*/
    private static JMenuItem myRules;
    /** A private field for shortcut menu item*/
    private static JMenuItem myShort;

    /** A private field for start menu item*/
    private static JMenuItem myStart;
    /** A private field for exit menu item*/
    private static JMenuItem myExit;

    /** A private field for play again button*/
    private final JButton myPlayAgainButton;

    /** A private field for bank panel instance*/
    private final BankPanel myBankPanel;

    /** A private field for bet panel instance*/
    private final BetPanel myBetPanel;

    /** A private field for wins total panel instance*/
    private final WinTotalsPanel myWinsPanel;
    /** A private field for current roll panel instance*/
    private final CurrentRollPanel myCurrentRoll;

    /**
     * CrapsController is constructor method that sets craps panels instance,
     * creates text fields, and calls the layout for the frame.
     *
     * @param theModel is the craps model instance.
     */
    public CrapsController(final CrapsModel theModel) {
        super(new GridLayout(2, 1));
        myBankPanel = new BankPanel(theModel, this);
        myWinsPanel = new WinTotalsPanel(theModel);
        myCurrentRoll = new CurrentRollPanel(theModel);
        myBetPanel = new BetPanel(theModel);
        myPlayAgainButton = new JButton("Play Again");
        myPlayAgainButton.setMnemonic(KeyEvent.VK_P);
        myPlayAgainButton.setEnabled(false);
        this.myModel = theModel;
        this.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        layoutComponents();
        createMenuBar();
        createAndShowGUI();
        myBankPanel.setEnabled(true);
        JOptionPane.showMessageDialog(frame, "Please set a bank amount to start");
        addListeners();
    }

    /**
     * getFrame is a method that returns
     * the frame of controller.
     * @return the frame.
     */
    public JFrame getFrame() {
        return frame;
    }
    /**
     * layoutComponents is a method that sets up the
     * formatting of the panel to be put on frame.
     *
     */
    private void layoutComponents() {
        JPanel myTopPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        myTopPanel.add(myBankPanel, BorderLayout.CENTER);
        myTopPanel.add(myBetPanel, BorderLayout.CENTER);
        myTopPanel.add(myCurrentRoll, BorderLayout.CENTER);
        myTopPanel.add(myWinsPanel, BorderLayout.CENTER);
        JPanel playAgainPanel = new JPanel();
        playAgainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        playAgainPanel.add(myPlayAgainButton);
        myPlayAgainButton.setPreferredSize(new Dimension(100, 50));
        myTopPanel.add(playAgainPanel, BorderLayout.CENTER);
        add( myTopPanel, BorderLayout.NORTH);
        this.setBackground(Color.LIGHT_GRAY);
    }
    /**
     *  createAndShowGUI is a method that sets up the
     * formatting of the frame and sets it to be visible.
     *
     */
    public void createAndShowGUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(this);
        frame.requestFocusInWindow();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(1000, 1000);
        frame.setTitle("Craps Game");
        SwingUtilities.invokeLater(() -> {
            frame.setVisible(true);
        });

    }
    /**
     * createMenuBar is a method that sets up the
     * formatting of the menu bar for the frame.
     *
     */
    private void createMenuBar() {
        myBar = new JMenuBar();
        myMenu = new JMenu("Menu");
        myMenu2 = new JMenu("Help");
        myStart = new JMenuItem("Start");
        myReset = new JMenuItem("Reset");
        myExit = new JMenuItem("Exit");
        myAbout = new JMenuItem("About");
        myRules = new JMenuItem("Rules");
        myShort = new JMenuItem("Shortcuts");
        myMenu.add(myStart);
        myMenu.add(myReset);
        myMenu.add(myExit);
        myMenu2.add(myAbout);
        myMenu2.add(myRules);
        myMenu2.add(myShort);
        myBar.setPreferredSize(new Dimension(20, 25));
        myBar.add(myMenu);
        myBar.add(myMenu2);
        frame.setJMenuBar(myBar);
        myStart.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        myAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        myRules.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        myReset.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        myExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        myShort.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        myShort.addActionListener(e -> JOptionPane.showMessageDialog(frame, "CTRL + S = Start\nCTRL + R = Reset\nCTRL + E = Exit" +
                "\nCTRL + Z = About\nCTRL + Q = Rules\nCTRL + X = Shortcuts", "Shortcuts", JOptionPane.ERROR_MESSAGE));
        myAbout.addActionListener(e -> JOptionPane.showMessageDialog(frame, "This is a game of craps\nJava Version: 21.0\nAuthor: Sado Iman", "About", JOptionPane.ERROR_MESSAGE));

        myRules.addActionListener(e -> JOptionPane.showMessageDialog(frame,
                "1. Enter bank amount.\n2. Touch start to start game." +
                        "\n3. Set a bet amount, cannot be negative or zero and must not exceed bank account value."+
                        "\n4. Roll dice.\n5. If dice sum is 7 or 11 on first turn, player wins, bet amount is doubled."+
                        "\n6. If dice sum is 2, 3, 0r 12 on first turn, house win." +
                        "\n7. If dice sum is anything else this becomes your point value."+
                        "\n8. You must roll your point value before a 7 for player to win, otherwise house wins." +
                        "\n9. You can continue playing until bank account reaches 0 in which the game ends."+
                        "\n10. Press reset then start again to start a new game.",
                "Rules", JOptionPane.ERROR_MESSAGE));
    }
    /**
     * addListeners is a method that adds all the listeners
     * from the panels and creates action listeners for some
     * menu buttons.
     *
     */
    private void addListeners() {
        addBankPanelListeners();
        addCurrentRollListeners();
        addBetPanelListeners();
        addAllPropertiesListeners();

        myPlayAgainButton.addActionListener(e -> {
            if (e.getSource().equals(myPlayAgainButton)) {
                myModel.setMyDice1(0);
                myModel.setMyDice2(0);
                myModel.setMyDiceTotal(0);
                myModel.setMyPoint(0);
                myCurrentRoll.reset();
                myModel.setGameOver(false);
                myCurrentRoll.getRoll().setEnabled(true);
                myBetPanel.setEnabled(true);
                myPlayAgainButton.setEnabled(false);

            }
        });


        myReset.addActionListener(e -> {
            if (e.getSource().equals(myReset)) {
                resetAll();
                myBankPanel.setEnabled(true);
                myStart.setEnabled(true);
                myBetPanel.setEnabled(false);
                myCurrentRoll.getRoll().setEnabled(false);
                myPlayAgainButton.setEnabled(false);

            }

        });

        myStart.addActionListener(e -> {
            if (e.getSource().equals(myStart)) {
                myStart.setEnabled(false);
                getMyCrapsInstance().startGame();
                myCurrentRoll.getRoll().setEnabled(true);
                myBetPanel.setEnabled(true);


            }

        });

        myExit.addActionListener(e -> {

            if (e.getSource().equals(myExit)) {
                int result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {

                    frame.dispose();

                }
            }
        });



    }

    /**
     * resetAll is a method that resets
     * all the panels text fields and buttons.
     *
     */
    private void resetAll() {
        myBankPanel.reset();
        myWinsPanel.reset();
        myCurrentRoll.reset();
        myBetPanel.reset();

    }

    /**
     * setWinSound is a method that sets the
     * sound when the player wins.
     *
     */
    private void setWinSound() {
        try {
           String fileName = "sounds/applause10.wav";
            File file = new File(fileName);
           AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(inputStream);
            clip.setFramePosition(0);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    /**
     * setRollSound is a method that sets the
     * sound for each roll.
     *
     */
    private void setRollSound() {
        try {
            String fileName = "sounds/dice-142528.wav";
            File file = new File(fileName);
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(inputStream);
            clip.setFramePosition(0);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    /**
     * setLoseSound is a method that sets the
     * sound when the player loses.
     *
     */
    private void setLoseSound() {
        try {
            String fileName = "sounds/boohiss.wav";
            File file = new File(fileName);
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(inputStream);
            clip.setFramePosition(0);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    /**
     * addCurrentRollListeners is a method that creates
     * actions listeners for the roll button and handles
     * logic for winning and losing game.
     *
     */
    private void addCurrentRollListeners() {
        myCurrentRoll.addRollListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent theEvent) {

                if (theEvent.getSource().equals(myCurrentRoll.getRoll())) {
                    setRollSound();
                    myModel.rollLogic();

                    if (myModel.getGameOver()) {
                        myCurrentRoll.getRoll().setEnabled(false);
                        if (myModel.getGameState().equals("playerWins")) {
                            myWinsPanel.setTextPlayer(String.valueOf(myModel.getMyPlayerWins()));
                            JOptionPane.showMessageDialog(frame, "Wow You won!", "Round Over", JOptionPane.INFORMATION_MESSAGE);
                            myPlayAgainButton.setEnabled(true);
                            setWinSound();
                           if(myModel.getMyBank() == 0){
                               JOptionPane.showMessageDialog(frame, "You ran out of money! Please reset.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                               myPlayAgainButton.setEnabled(false);
                               myBetPanel.setEnabled(false);
                            }

                        } else if (myModel.getGameState().equals("houseWins")) {
                            myWinsPanel.setTextHouse(String.valueOf(myModel.getMyHouseWins()));
                            JOptionPane.showMessageDialog(frame, "Wow You Lost!", "Round Over", JOptionPane.INFORMATION_MESSAGE);
                            myPlayAgainButton.setEnabled(true);
                            setLoseSound();
                              if(myModel.getMyBank() == 0){
                                JOptionPane.showMessageDialog(frame, "You ran out of money! Please reset.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                                  myPlayAgainButton.setEnabled(false);
                                  myBetPanel.setEnabled(false);
                            }
                        }


                    }
                }
            }
            });
        }

    /**
     * addAllPropertiesListeners is a method that creates
     * actions listeners for all the property changes in the model.
     *
     */
    private void addAllPropertiesListeners() {
        myModel.addPropertyChangeListener(theEvent -> {
            if ("dice1".equals(theEvent.getPropertyName())) {
                myCurrentRoll.setDice1(myModel.getMyDice1());
            } else if ("dice2".equals(theEvent.getPropertyName())) {
                myCurrentRoll.setDice2(myModel.getMyDice2());
            } else if ("total".equals(theEvent.getPropertyName())) {
                myCurrentRoll.setDiceTotal(myModel.getMyDiceTotal());
            } else if ("pointChange".equals(theEvent.getPropertyName())) {
                myCurrentRoll.setMyPoint(myModel.getMyPoint());
            } else if ("bankChange".equals(theEvent.getPropertyName())) {
                myBankPanel.setBank(myModel.getMyBank());
            } else if ("betChange".equals(theEvent.getPropertyName())) {
                myBetPanel.setMyTextField(String.valueOf(myModel.getMyBet()));
            } else if ("gameWon".equals(theEvent.getPropertyName())) {
                if (myModel.getGameOver()) {
                    myBetPanel.reset();
                    myBetPanel.setEnabled(true);
                }
            }
        });
    }

    /**
     * addBetPanelListeners is a method that creates
     * actions listeners for the bet panel buttons.
     *
     */
    private void addBetPanelListeners() {
        myBetPanel.addBetListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(myBetPanel.getMyButton1())) {
                    myModel.setMyBet(1);
                } else if (e.getSource().equals(myBetPanel.getMyButton5())) {
                    myModel.setMyBet(5);
                } else if (e.getSource().equals(myBetPanel.getMyButton10())) {
                    myModel.setMyBet(10);
                } else if (e.getSource().equals(myBetPanel.getMyButton50())) {
                    myModel.setMyBet(50);
                } else if (e.getSource().equals(myBetPanel.getMyButton100())) {
                    myModel.setMyBet(100);
                } else if (e.getSource().equals(myBetPanel.getMyButton500())) {
                    myModel.setMyBet(500);
                }

                if (checkOver()) {
                    myModel.setMyBank(myModel.getMyBank() - (myModel.getMyBet()));

                    myBetPanel.disableAll();
                } else {
                    JOptionPane.showMessageDialog(frame, "Bet cannot be more than bank.");
                }
            }
        });
    }

    /**
     * checkOver is a method that checks if the
     * bet amount is less than or equal to bank amount.
     *
     * @return boolean for if the bank value can be set or not given bet.
     */
    private boolean checkOver() {
        if( myModel.getMyBank() < myModel.getMyBet()){
            return false;
        }else {
            return true;
        }
    }
    /**
     * addBankPanelListeners is a method that creates
     * actions listeners for the bank panel button.
     *
     */
    private void addBankPanelListeners() {

            myBankPanel.addBankListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent theEvent) {

                    if (theEvent.getSource().equals(myBankPanel.getMyButton())) {

                        if (myBankPanel.getMyTextField().getText().equals("") || !myBankPanel.isNumber()) {
                            JOptionPane.showMessageDialog(frame, "Must input a numerical value!");

                        } else if (Integer.parseInt(myBankPanel.getMyTextField().getText()) > 0) {
                            myModel.setMyBank(Integer.parseInt(myBankPanel.getMyTextField().getText()));
                            myBankPanel.setEnabled(false);

                        } else {
                            JOptionPane.showMessageDialog(frame, "The bank cannot be 0 or less than 0!");
                            myBankPanel.setEnabled(false);
                            myBetPanel.setEnabled(true);

                        }

                    }
                }

    });
}

    public static void main(String[] theArgs){

        SwingUtilities.invokeLater(() -> {
            new CrapsController(getMyCrapsInstance());


        });

    }

    }



