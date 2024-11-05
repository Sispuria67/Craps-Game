/*
 * TCSS 305 - Craps Game
 */
package tests;

import model.CrapsModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for class craps model.
 *
 * @author Sado Iman
 * @version Fall 2023
 */

class CrapsModelTest {
    /** private field for craps model instance. */
    private CrapsModel crapsModel;
    /** Set up method for class.*/
    @BeforeEach
    void setUp() {
        crapsModel = CrapsModel.getMyCrapsInstance();
    }
    /** Tear down method for class.*/
    @AfterEach
    void tearDown() {
        // This method not implemented, no use for clean up resources.
    }
    /** Test method for starting game. */
    @Test
    public void testStartGame() {
        crapsModel.setMyDice1(0);
        crapsModel.setMyDice2(0);
        crapsModel.setMyHouseWins(0);
        crapsModel.setMyBank(0);
        crapsModel.setMyBet(0);
        crapsModel.setGameOver(false);
        crapsModel.setMyPoint(0);
        crapsModel.setMyDiceTotal(0);
        crapsModel.startGame();
        assertEquals(0, crapsModel.getMyDice1());
        assertEquals(0, crapsModel.getMyDice2());
        assertEquals(0, crapsModel.getMyBank());
        assertEquals(0, crapsModel.getMyBet());
        assertEquals(0, crapsModel.getMyDiceTotal());
        assertEquals(0, crapsModel.getMyPlayerWins());
        assertEquals(0, crapsModel.getMyHouseWins());
        assertEquals(0, crapsModel.getMyPoint());
        assertFalse(crapsModel.getGameOver());
    }

    /** Test method for dice 1 setter. */
    @Test
    void setMyDice1() {
        crapsModel.setMyDice1(4);
        assertEquals(4, crapsModel.getMyDice1());

    }
    /** Test method for dice 2 setter. */
    @Test
    void setMyDice2() {
        crapsModel.setMyDice2(6);
        assertEquals(6, crapsModel.getMyDice2());
    }
    /** Test method for dice point setter. */
    @Test
    void setMyPoint() {
        crapsModel.setMyPoint(8);
        assertEquals(8, crapsModel.getMyPoint());
    }
    /** Test method for bet setter. */
    @Test
    void setMyBet() {
        crapsModel.setMyBet(50);
        assertEquals(50, crapsModel.getMyBet());
    }
    /** Test method for dice total setter. */
    @Test
    void setMyDiceTotal() {
        crapsModel.setMyDice1(4);
        crapsModel.setMyDice2(5);
        crapsModel.setMyDiceTotal(9);
        assertEquals(9, crapsModel.getMyDiceTotal());

    }
    /** Test method for wins setter, gameOver, gameState. */
    @Test
    void setMyWins() {
        crapsModel.setMyBank(100);
        crapsModel.setMyBet(50);
        crapsModel.rollLogic();

        if (crapsModel.getMyPoint() == 0) {
            if (crapsModel.getMyDiceTotal() == 12 || crapsModel.getMyDiceTotal() == 2
                    || crapsModel.getMyDiceTotal() == 3) {
                assertEquals(1, crapsModel.getMyHouseWins());
                assertTrue(crapsModel.getGameOver());
                assertEquals("houseWins", crapsModel.getGameState());


            } else if (crapsModel.getMyDiceTotal() == 7 || crapsModel.getMyDiceTotal() == 11) {
                assertEquals(1, crapsModel.getMyPlayerWins());
                assertTrue(crapsModel.getGameOver());
                assertEquals("playerWins", crapsModel.getGameState());
                assertEquals(200, crapsModel.getMyBank());

            } else {
                crapsModel.rollLogic();


            }
            if (crapsModel.getMyDiceTotal() == crapsModel.getMyPoint()) {
                assertEquals(1, crapsModel.getMyPlayerWins());
                assertEquals(200, crapsModel.getMyBank());
                assertTrue(crapsModel.getGameOver());
                assertEquals("playerWins", crapsModel.getGameState());


            } else if (crapsModel.getMyDiceTotal() == 7) {

                assertTrue(crapsModel.getGameOver());
                assertEquals("houseWins", crapsModel.getGameState());
                assertEquals(1, crapsModel.getMyHouseWins());

            } else {
                assertTrue(crapsModel.getGameOver());

            }
        }
    }

    /** Test method for bank amount setter. */
    @Test
    void setMyBank() {
        crapsModel.setMyBank(500);
        assertEquals(500, crapsModel.getMyBank());
    }

    /** Test method for rolling dice. */
    @Test
    void rollDice() {
        crapsModel.rollDice();
        int dice1 = crapsModel.getMyDice1();
        int dice2 = crapsModel.getMyDice2();
        int total = crapsModel.getMyDiceTotal();
         assertTrue(dice1 >= 1 && dice1 <= 6);
        assertTrue(dice2 >= 1 && dice2 <= 6);
        assertTrue(total >= 2 && total <= 12);
    }
}