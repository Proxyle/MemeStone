package Models;

import Models.Cards.Minion;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    private Board board;
    private int START_HEALTH = 20;
    private Minion minion;

    @Before
    public void TestInitialize() {
        board = new Board(START_HEALTH);

        minion = new Minion(new Long(1), "Wilrekt", "You just got wilrekt", 0, 9, 9);
    }

    @Test
    public void TestIncorrectMinionPlacement()
    {
        assertEquals(false, board.placeMinion(minion, 12));
    }

    @Test
    public void TestCorrectMinionPlacement()
    {
        assertEquals(true, board.placeMinion(minion, 4));
    }

    @Test
    public void TestAttackOpponentHero()
    {
        board.placeMinion(minion, 2);
        board.attackOpponentHero(2);
        assertNotEquals(20, board.upperHero);
    }
}