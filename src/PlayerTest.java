import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest
{

    @Test
    void getName()
    {
        Player reem = new Player("Reem");
        assertEquals("Reem", reem.getName());
    }

    @Test
    void getCards()
    {
        Player reem = new Player("Reem");
        Card c = new Card(Card.Suit.CLUBS, Card.Value.THREE);
        Card q = new Card(Card.Suit.DIAMONDS, Card.Value.QUEEN);
        reem.dealToPlayer(c);
        reem.dealToPlayer(q);
        ArrayList<Card> reemsHand = new ArrayList<>();
        reemsHand.add(c);
        reemsHand.add(q);
        assertEquals(reemsHand, reem.getCards());
    }

    @Test
    void getHandSize()
    {
        Player reem = new Player("Reem");
        Card c = new Card(Card.Suit.CLUBS, Card.Value.THREE);
        Card q = new Card(Card.Suit.DIAMONDS, Card.Value.QUEEN);
        reem.dealToPlayer(c);
        reem.dealToPlayer(q);
        assertEquals(2, reem.getHandSize());
    }

    @Test
    void removeCard()
    {
        Player reem = new Player("Reem");
        Card c = new Card(Card.Suit.CLUBS, Card.Value.THREE);
        Card q = new Card(Card.Suit.DIAMONDS, Card.Value.QUEEN);
        reem.dealToPlayer(c);
        reem.dealToPlayer(q);
        ArrayList<Card> reemsHand = new ArrayList<>();
        reemsHand.add(c);
        reem.removeCard(q);
        assertEquals(reemsHand, reem.getCards());
    }

    @Test
    void getNumericalHandValue()
    {
        Player reem = new Player("Reem");
        Card c = new Card(Card.Suit.CLUBS, Card.Value.SIX);
        Card e = new Card(Card.Suit.SPADES, Card.Value.EIGHT);
        reem.dealToPlayer(c);
        reem.dealToPlayer(e);
        ArrayList<Integer> reemsHandValue = new ArrayList<>();
        reemsHandValue.add(14);
        assertEquals(reemsHandValue, reem.getNumericalHandValue());

    }

    @Test
    void getBestNumericalHandValue()
    {
        Player reem = new Player("Reem");
        Card c = new Card(Card.Suit.CLUBS, Card.Value.ACE);
        Card q = new Card(Card.Suit.DIAMONDS, Card.Value.JACK);

        reem.dealToPlayer(c);
        reem.dealToPlayer(q);

        assertEquals(21, reem.getBestNumericalHandValue());

    }
}