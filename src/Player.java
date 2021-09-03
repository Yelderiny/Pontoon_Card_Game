import java.util.ArrayList;

public class Player
{
    protected String name;
    protected ArrayList<Card> hand = new ArrayList<>();

    //constructor
    public Player(String name) { this.name = name; }

    //accessors
    public String getName() { return name; }
    public ArrayList<Card> getCards() { return hand; }
    public int getHandSize() { return hand.size(); }

    //deals a card to a player, i.e. it adds a card to a players hand
    public void dealToPlayer(Card card) { hand.add(card); }

    //removes a card from a player's hand
    public void removeCard(Card card) { hand.remove(card); }

    //returns all possible numerical values of  hand
    //if there is one ace, 1,11. if there is two aces, 2, 12, 22, if there are three aces, 3, 13, 23, 33. if there are four, 4, 14, 24, 34, 44
    public ArrayList<Integer> getNumericalHandValue()
    {
        ArrayList<Integer> numericalHandValue = new ArrayList<>();
        numericalHandValue.add(0);

        for (Card card : hand)
        {
            //ace
            if (card.getValue() == Card.Value.ACE)
            {
                numericalHandValue.add(numericalHandValue.get(numericalHandValue.size() - 1)); //add another value possibility and initialize it with the value of the entry before it

                //add 1 to all previous values before the newly added entry
                for (int i = 0; i < numericalHandValue.size() - 1; i++)
                {
                    numericalHandValue.set(i, numericalHandValue.get(i) + card.getNumericalValue().get(0));
                }
                numericalHandValue.set(numericalHandValue.size()-1, numericalHandValue.get(numericalHandValue.size() - 1) + card.getNumericalValue().get(1)); //add 11 to the newly added entry
            }

            //other cards
            else { for (int i = 0; i < numericalHandValue.size(); i++) { numericalHandValue.set(i, numericalHandValue.get(i) + card.getNumericalValue().get(0)); } } //add the value of the card to all entries
        }

        return numericalHandValue;
    }

    //returns the maximum numerical value of the player's hand of cards
    public int getBestNumericalHandValue()
    {
        ArrayList<Integer> numericalHandValue = getNumericalHandValue();
        int bestHand = 0;

        if (numericalHandValue.get(0) <= 21)
        {
            for (int i : numericalHandValue)
            {
                if (i <= 21)
                {
                    if (i > bestHand) bestHand = i;
                }
            }
        }
        else if (numericalHandValue.get(0) > 21) bestHand = numericalHandValue.get(0);

        return bestHand;
    }
}
