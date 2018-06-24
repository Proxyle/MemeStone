package Models;

import Models.Cards.Minion;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    private Board board;
    private Field leftField;
    private Field rightField;
    private int START_HEALTH = 20;
    private Minion minion;

    @Before
    public void TestInitialize() {
        leftField = new Field();
        rightField = new Field();
        board = new Board(leftField, rightField, START_HEALTH, START_HEALTH);

        minion = new Minion("Wilrekt", "You just got wilrekt", 4, 9, 9);
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
        assertEquals(true, board.attackOpponentHero(2));
    }
}