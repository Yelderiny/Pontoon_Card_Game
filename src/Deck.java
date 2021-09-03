import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
    protected ArrayList<Card> deck = new ArrayList<>();

    //contructor
    public Deck()
    {
        reset();
        shuffle();
    }

    //accessors
    public Card getCard(int i) { return deck.get(i); }
    public int size() { return deck.size(); }

    //re-creates a full deck of cards in an existing deck
    public void reset()
    {
        deck.clear(); //accounts for empty set and full set

        for (Card.Suit suit : Card.Suit.values())
        {
            for (Card.Value value : Card.Value.values()) { deck.add(new Card(suit, value)); }
        }
    }


    //shuffles the deck
    public void shuffle() { Collections.shuffle(deck); }

    //deals a random card
    public Card dealRandomCard()
    {
        //immplementation one
        Card toDeal = deck.get(deck.size() - 1);
        deck.remove(deck.size() -1);

        return toDeal;
    }

    /* Implementation two
     * Random index = new Random();
     *
     * int something = index.nextInt(deck.size());
     * Card toDeal = deck.get(something);
     * deck.remove(something);
     *
     */
}