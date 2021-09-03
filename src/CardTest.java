import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CardTest
{

    @org.junit.jupiter.api.Test
    void getSuit()
    {
        Card c = new Card(Card.Suit.CLUBS, Card.Value.THREE);
        assertEquals(Card.Suit.CLUBS, c.getSuit());
    }

    @org.junit.jupiter.api.Test
    void getValue()
    {
        Card c = new Card(Card.Suit.CLUBS, Card.Value.THREE);
        assertEquals(Card.Value.THREE, c.getValue());

    }

    @org.junit.jupiter.api.Test
    void setSuit()
    {
        Card c = new Card(Card.Suit.CLUBS, Card.Value.THREE);
        c.setSuit(Card.Suit.DIAMONDS);
        assertEquals(Card.Suit.DIAMONDS, c.getSuit());
    }

    @org.junit.jupiter.api.Test
    void setValue()
    {
        Card c = new Card(Card.Suit.CLUBS, Card.Value.THREE);
        c.setValue(Card.Value.ACE);
        assertEquals(Card.Value.ACE, c.getValue());
    }

    @org.junit.jupiter.api.Test
    void getNumericalValue()
    {
        Card c = new Card(Card.Suit.CLUBS, Card.Value.ACE);
        ArrayList<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(11);
        assertEquals(test, c.getNumericalValue());
    }
}