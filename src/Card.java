import java.util.ArrayList;

public class Card
{
    //data fields
    public enum Suit { CLUBS, HEARTS, DIAMONDS, SPADES }
    public enum Value { ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING }
    protected Suit suit;
    protected Value value;

    //constuctors
    public Card(Suit suit, Value value)
    {
        this.suit = suit;
        this.value = value;
    }

    //accessors
    public Suit getSuit() { return suit; }
    public Value getValue() { return value; }

    //mutators
    public void setSuit(Suit suit) { this.suit = suit; }
    public void setValue(Value value) { this.value = value; }

    //computes the value of the suit
    public ArrayList<Integer> getNumericalValue()
    {
        ArrayList<Integer> numericalValue = new ArrayList<>(); //output list

        switch (getValue())
        {
            case ACE:
                numericalValue.add(1);
                numericalValue.add(11);
                break;

            case TWO:
                numericalValue.add(2);
                break;

            case THREE:
                numericalValue.add(3);
                break;

            case FOUR:
                numericalValue.add(4);
                break;

            case FIVE:
                numericalValue.add(5);
                break;

            case SIX:
                numericalValue.add(6);
                break;

            case SEVEN:
                numericalValue.add(7);
                break;

            case EIGHT:
                numericalValue.add(8);
                break;

            case NINE:
                numericalValue.add(9);
                break;

            case TEN:
            case JACK:
            case QUEEN:
            case KING:
                numericalValue.add(10);
                break;
        }
        return numericalValue;
    }
}
