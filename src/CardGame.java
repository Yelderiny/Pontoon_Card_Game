public abstract class CardGame
{
    protected Deck gameDeck = new Deck();
    protected Player[] gamePlayers;
    protected int nplayers;


    //constructors
    public CardGame(int nplayers)
    {
        this.nplayers = nplayers;
        gamePlayers = new Player[nplayers];
        for (int i = 0; i < gamePlayers.length; i++)
        {
            gamePlayers[i] = new Player("Player " + i);
        }
    }

    //abstract methods
    public abstract void dealInitialCards();
    public abstract int compareHands(Player hand1, Player hand2);

    //accessors
    public Deck getDeck() { return gameDeck; }
    public int getNumPlayers() { return nplayers; }
    public Player getPlayer(int i) { return gamePlayers[i]; }
}
