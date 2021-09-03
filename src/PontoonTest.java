import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PontoonTest
{
    Pontoon game = new Pontoon(2);
    Deck gameDeck = new Deck();
    Player reem = new Player("Reem");
    Player aly = new Player("Aly");


    @Test
    void dealInitialCards()
    {
        game.dealInitialCards();

        System.out.println(game.gamePlayers[0].getName());
        for (Card card :
                game.gamePlayers[0].hand)
        {
            System.out.println(card.getSuit() + " " + card.getValue());
        }
        System.out.println();

        System.out.println(game.gamePlayers[1].getName());
        for (Card card :
                game.gamePlayers[1].hand)
        {
            System.out.println(card.getSuit() + " " + card.getValue());
        }
    }

    @Test
    void compareHands()
    {
        reem.dealToPlayer(gameDeck.dealRandomCard());
        reem.dealToPlayer(gameDeck.dealRandomCard());
        reem.dealToPlayer(gameDeck.dealRandomCard());

        System.out.println("Reem's Hand");
        for (Card card : reem.hand)
        {
            System.out.println(card.getSuit() + " " + card.getValue());
        }
        System.out.println();

        aly.dealToPlayer(gameDeck.dealRandomCard());
        aly.dealToPlayer(gameDeck.dealRandomCard());

        System.out.println("Aly's Hand");
        for (Card card : aly.hand)
        {
            System.out.println(card.getSuit() + " " + card.getValue());
        }

        assertEquals(-1, game.compareHands(reem, aly));

    }

    @Test
    void isPontoon()
    {
        Card a = new Card(Card.Suit.SPADES, Card.Value.ACE);
        Card b = new Card(Card.Suit.HEARTS, Card.Value.QUEEN);

        reem.dealToPlayer(a);
        reem.dealToPlayer(b);
        assertTrue(game.isPontoon(reem));
    }

    @Test
    void isFiveCardTrick()
    {
        Card a = new Card(Card.Suit.SPADES, Card.Value.TWO);
        Card b = new Card(Card.Suit.HEARTS, Card.Value.FIVE);
        Card c = new Card(Card.Suit.DIAMONDS, Card.Value.ACE);
        Card d = new Card(Card.Suit.HEARTS, Card.Value.FIVE);
        Card e = new Card(Card.Suit.CLUBS, Card.Value.ACE);

        reem.dealToPlayer(a);
        reem.dealToPlayer(b);
        reem.dealToPlayer(c);
        reem.dealToPlayer(d);
        reem.dealToPlayer(e);
        assertTrue(game.isFiveCardTrick(reem));

    }

    @Test
    void isThreeOrFour()
    {
        Card a = new Card(Card.Suit.SPADES, Card.Value.TWO);
        Card b = new Card(Card.Suit.HEARTS, Card.Value.FIVE);
        Card c = new Card(Card.Suit.DIAMONDS, Card.Value.ACE);
        Card d = new Card(Card.Suit.HEARTS, Card.Value.THREE);

        reem.dealToPlayer(a);
        reem.dealToPlayer(b);
        reem.dealToPlayer(c);
        reem.dealToPlayer(d);
        assertTrue(game.isThreeOrFour(reem));
    }
}