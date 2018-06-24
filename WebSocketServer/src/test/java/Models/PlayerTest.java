package Models;

import Models.Cards.Minion;
import Models.Cards.Spells.DamageSpell;
import Models.Cards.Spells.DrawSpell;
import Models.Cards.Spells.HealSpell;
import Models.Cards.Spells.ResurrectSpell;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    private Player player1;
    private Player player2;
    private Minion minion;
    private DamageSpell damageSpell;
    private DrawSpell drawSpell;
    private HealSpell healSpell;
    private ResurrectSpell resurrectSpell;

    @Before
    public void TestInitialize()
    {
        // Initializing the cards and the player also indirectly tests their constructors
        minion = new Minion("Wilrekt", "You just got wilrekt", 4, 9, 9);
        damageSpell = new DamageSpell("Doge", "Good boi",3,  2);
        drawSpell = new DrawSpell("Test", "Just a test", 2, 2);
        healSpell = new HealSpell("Burn heal", "Cures your burn", 1, 1);
        resurrectSpell = new ResurrectSpell("Resurrect one minion", "Resucrrect one minion from the graveyard", 3, 4);

        ArrayList<Minion> minions = new ArrayList<>();
        ArrayList<DamageSpell> damageSpells = new ArrayList<>();
        ArrayList<DrawSpell> drawSpells = new ArrayList<>();
        ArrayList<HealSpell> healSpells = new ArrayList<>();
        ArrayList<ResurrectSpell> resurrectSpells = new ArrayList<>();

        minions.add( minion);

        Deck deck = new Deck(minions, damageSpells, drawSpells, healSpells, resurrectSpells);
        player1 = new Player(1, "1234", "Pleb", deck);
    }

    @Test
    public void TestHandSize() {
        player1.drawCard();
        assertEquals(1, player1.getHandSize());
    }

    @Test
    public void TestRemoveCard() {
        player1.drawCard();
        int previousHandSize = player1.getHandSize();
        player1.removeCard(new Minion("Wilrekt", "You just got wilrekt", 4, 9, 9));

        assertEquals(previousHandSize -1, player1.getHandSize());
    }

    @Test
    public void TestDrawCard() {
        int previousHandSize = player1.getHandSize();
        player1.drawCard();

        assertEquals(previousHandSize + 1, player1.getHandSize());
    }
}