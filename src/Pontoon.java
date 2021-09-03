public class Pontoon extends CardGame
{

    public Pontoon(int nplayers) { super(nplayers); }

    //deals the number of initial cards to each player in the game
    @Override
    public void dealInitialCards()
    {
        for (Player player : gamePlayers)
        {
            player.dealToPlayer(gameDeck.dealRandomCard());
            player.dealToPlayer(gameDeck.dealRandomCard());
        }
    }

    //compares the hands of the two players
    @Override
    public int compareHands(Player hand1, Player hand2)
    {
        //busts
        if (isBust(hand1) && isBust(hand2)) return 0;
        if (isBust(hand1)) return 1;
        if (isBust(hand2)) return -1;
        
        //pontoons
        if (isPontoon(hand1) && isPontoon(hand2)) return 0;
        if (isPontoon(hand1)) return -1;
        if (isPontoon(hand2)) return 1;

        //five card tricks
        if (isFiveCardTrick(hand1) && isFiveCardTrick(hand2)) return Integer.compare(hand2.getBestNumericalHandValue(), hand1.getBestNumericalHandValue());
        if (isFiveCardTrick(hand1)) return -1;
        if (isFiveCardTrick(hand2)) return 1;

        //three or four cards totaling 21
        if (isThreeOrFour(hand1) && isThreeOrFour(hand2)) return 0;
        if (isThreeOrFour(hand1)) return -1;
        if (isThreeOrFour(hand2)) return 1;

        //otherwise
        return Integer.compare(hand2.getBestNumericalHandValue(), hand1.getBestNumericalHandValue());
    }

    public boolean isBust(Player player) { return player.getBestNumericalHandValue() > 21; }
    public boolean isPontoon(Player player) { return (player.getHandSize() == 2 && player.getBestNumericalHandValue() == 21); }
    public boolean isFiveCardTrick(Player player) { return player.getHandSize() == 5 && player.getBestNumericalHandValue() <= 21; }
    public boolean isThreeOrFour(Player player) { return player.getHandSize() == 3 || player.getHandSize() == 4 && player.getBestNumericalHandValue() == 21; }


}
