/**
 * A package for model.
 */
package model;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

/**
 * The CrapsModel class is model class for the
 * craps game, it holds getter and setters for
 * fields used in other classes and creates the logic
 * for rolling the dice and the states that are changed
 * as a result.
 * @author Sado Iman
 * @version 10/13/23
 */
public class CrapsModel {
    /** A private field for the random object used for dice*/
    private Random myRandom = new Random();

    /** A private field for property change support */
    private final PropertyChangeSupport myPcs;

    /** A private field for craps model instance */
    private static CrapsModel myCrapsInstance;

    /** A private field for dice 1 */
    private int myDice1;
    /** A private field for dice 2 */
    private int myDice2;

    /** A private field for state of the game, over or not over */
    private String gameState;
    /** A private field for bank amount */
    private int myBank;
    /** A private field for bet amount */
    private int myBet;
    /** A private field for dice total */
    private int myDiceTotal;
    /** A private field for player wins*/
    private int myPlayerWins;
    /** A private field for house wins*/
    private int myHouseWins;
    /** A private field for whether game was won*/
    private boolean myGameWon;

    /** A private field for dice point */
    private int myPoint;
    /**
     * CrapsModel is private constructor method that sets up
     * a property change support.
     *
     */
    private CrapsModel(){
        myPcs = new PropertyChangeSupport(this);

    }
    /**
     * startGame is method that sets up the games state,
     * point and round over value when it is started.
     *
     */
    public void startGame(){
        setGameOver(false);
        setMyPoint(0);
        this.gameState = "";
    }
    /**
     * getMyCrapsInstance is method that creates one
     * instance of the craps model to be used outside of class.
     *
     * @return the craps instance
     */
    public static CrapsModel getMyCrapsInstance(){
        if (myCrapsInstance == null){
            myCrapsInstance = new CrapsModel();
        }
        return myCrapsInstance;
    }


    /**
     * setGameOver is a setter method that sets up the value for whether
     * the game has been won and fires a property change.
     *
     * @param theGameWon is whether game is over or not
     */
    public void setGameOver(final boolean theGameWon) {
        myGameWon = theGameWon;
        myPcs.firePropertyChange("gameWon", false, myGameWon);
    }
    /**
     * getMyDice1 is a getter method that returns
     * the value for dice 1
     *
     * @return the dice 1.
     */
    public int getMyDice1(){
        return myDice1;
    }
    /**
     * getGameOver is a getter method that returns
     * the value for whether game was won or not.
     *
     * @return the gameWon value.
     */
    public boolean getGameOver(){
        return myGameWon;
    }

    /**
     * getMyDice2 is a getter method that returns
     * the value for dice 2
     *
     * @return the dice 2.
     */
    public int getMyDice2(){
        return myDice2;
    }
    /**
     * getMyBank is a getter method that returns
     * the value for bank amount.
     *
     * @return the bank amount.
     */
    public int getMyBank(){
        return myBank;
    }
    /**
     * getMyDiceTotal is a getter method that returns
     * the value for dice total
     *
     * @return the dice total.
     */
    public int getMyDiceTotal(){
        return myDiceTotal;
    }
    /**
     * getMyPlayerWins is a getter method that returns
     * the number of player wins.
     *
     * @return the player wins.
     */
    public int getMyPlayerWins(){
        return myPlayerWins;
    }
    /**
     * getMyHouseWins is a getter method that returns
     * the number of house wins.
     *
     * @return the house wins.
     */
    public int getMyHouseWins(){
        return myHouseWins;
    }
    /**
     * getMyBet is a getter method that returns
     * the value for bet amount.
     *
     * @return the bet amount.
     */
    public int getMyBet(){
        return myBet;
    }
    /**
     * getMyPoint is a getter method that returns
     * the value for the dices point.
     *
     * @return the dice point.
     */

    public int getMyPoint(){
        return myPoint;
    }

    /**
     * setMyDice1 is a method that sets the old dice 1 to
     * the new value and fires a property change.
     *
     * @param theDice is the value of the new dice 1.
     */
    public void setMyDice1(final int theDice){
        int old = myDice1;
        myDice1 = theDice;
        this.myPcs.firePropertyChange("dice1", old, myDice1);
    }

    /**
     * setMyDice2 is a method that sets the old dice 2 to
     * the new value and fires a property change.
     *
     * @param theDice is the value of the new dice 2.
     */
    public void setMyDice2(final int theDice){
        int old = myDice2;
        myDice2 = theDice;
        this.myPcs.firePropertyChange("dice2", old, myDice2);

    }
    /**
     * setMyPoint is a method that sets the old point to
     * the new value and fires a property change.
     *
     * @param thePoint is the value of the new point.
     */
    public void setMyPoint(final int thePoint){
        int old = myPoint;
        myPoint = thePoint;
        this.myPcs.firePropertyChange("pointChange", old, myPoint);
    }
    /**
     * setMyBet is a method that sets the old bet to
     * the new value and fires a property change.
     *
     * @param theBet is the value of the new bet.
     */
    public void setMyBet(final int theBet){
        int old = myBet;
        myBet = theBet;
        this.myPcs.firePropertyChange("betChange", old, myBet);
    }

    /**
     * setMyDiceTotal is a method that sets the dice total to
     * the new value and fires a property change.
     *
     * @param theDiceTotal is the new value for the sum of both dices.
     */

    public void setMyDiceTotal(final int theDiceTotal){
        int old = myDiceTotal;
        myDiceTotal = theDiceTotal;
        this.myPcs.firePropertyChange("total", old, myDiceTotal);

    }

    /**
     * setMyPlayerWins is a method that sets the player wins to
     * the new value and fires a property change.
     *
     * @param theWins is the number of wins for player.
     */
    public void setMyPlayerWins(final int theWins){
        int old = myPlayerWins;
        myPlayerWins = theWins;
        this.myPcs.firePropertyChange("playerWins", old, myPlayerWins);
    }

    /**
     * setMyHouseWins is a method that sets the house wins to
     * the new value and fires a property change.
     *
     * @param theWins is the number of wins for house.
     */

    public void setMyHouseWins(final int theWins){
        int old = myHouseWins;
        myHouseWins = theWins;
        this.myPcs.firePropertyChange("houseWins", old, myHouseWins);
    }

    /**
     * setMyBank is a method that sets the bank amount to
     * the new value and fires a property change.
     *
     * @param theBank is the value for the new bank amount.
     */
    public void setMyBank(final int theBank) {
            int old = myBank;
            myBank = theBank;
            this.myPcs.firePropertyChange("bankChange", old, myBank);
        }

    /**
     * getGameState is a getter method that returns
     * the current game state value, which is either house or player
     * depending on who won.
     *
     * @return the game state.
     */
    public String getGameState() {
        return gameState;
    }

    /**
     * setGameState is a method that sets the game state to
     * the new value and fires a property change.
     *
     * @param theState is value for the games state.
     */
    private void setGameState(final String theState) {
        String oldState = gameState;
        gameState = theState;
        this.myPcs.firePropertyChange("gameState", oldState, gameState);
    }

    /**
     * rollLogic is a method that does the craps game logic
     * regarding what happens when certain dice are rolled.
     *
     */

      public void rollLogic() {
           rollDice();
            if (myPoint == 0) {
            if (getMyDiceTotal() == 7 || getMyDiceTotal() == 11) {
                setMyPlayerWins(getMyPlayerWins() + 1);
                setMyBank(getMyBet() * 2 + getMyBank());
                setGameOver(true);
               setGameState("playerWins");

            } else if (getMyDiceTotal() == 2 || getMyDiceTotal() == 3 || getMyDiceTotal() == 12) {
                setMyHouseWins(getMyHouseWins() + 1);
                setGameOver(true);
                setGameState("houseWins");

            } else {
                setMyPoint(getMyDiceTotal());
            }
        } else {
            if (getMyDiceTotal() == getMyPoint()) {
                setMyPlayerWins(getMyPlayerWins() + 1);
                setMyBank(getMyBet() * 2 + getMyBank());
                setGameOver(true);
                setGameState("playerWins");


            } else if (getMyDiceTotal() == 7) {
                setMyHouseWins(getMyHouseWins() + 1);
                setGameOver(true);
                setGameState("houseWins");

            }
        }
    }


    /**
     * rollDice() is a  method that randomly
     * choose two value for dice 1 and 2 and sets
     * their values and their total.
     *
     */
  public void rollDice(){
        int roll1 = myRandom.nextInt(6) + 1;;
        int roll2 = myRandom.nextInt(6) + 1;
        setMyDice1(roll1);
        setMyDice2(roll2);
       setMyDiceTotal(roll1 + roll2);
   }

    /**
     *  addPropertyChangeListener is a method for adding
     * any property change listeners
     *
     * @param theListener is the listener being added.
     */
    public void addPropertyChangeListener(final PropertyChangeListener theListener) {
        myPcs.addPropertyChangeListener(theListener);
    }


    /**
     * addPropertyChangeListener is a method for removing
     * any property change listeners
     *
     * @param theListener is the listener being removed.
     */
    public void removePropertyChangeListener(final PropertyChangeListener theListener) {
        this.myPcs.removePropertyChangeListener(theListener);
    }


}
