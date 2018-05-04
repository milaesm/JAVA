# JAVA
JAVA projects (Net Beans IDE 8.2)
public class Bet
{
    private int bet;
    public Bet() // default constructor sets bet to 0
    {
        bet = 0;
    }

    public Bet(int n) // one-argument constructor, sets bet to n
    {
        bet = n;
    }

    public void setBet(int n) // setter
    {
        bet = n;
    }

    public int getBet() // getter
    {
        return bet;
    }
}


public class Card {
    private int suit; // 1  Hearts, 2  Diamonds, 3  Clubs, 4  Spades
    private int value; // 1  Ace…11  Jack, 12  Queen, 13  King

    public Card() // Ace of Hearts, by default
    {
        suit = 1;
        value = 1;
    }

    public Card(int s, int v) {
        suit = s;
        value = v;
    }

    public int getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public void setSuit(int s) {
        suit = s;
    }

    public void setValue(int v) {
        value = v;
    }

    public String getName() // returns string, e.g., "Ace of Hearts"
    {
        String name = " ";
        if (value == 1)
            name = "Ace of";
        else if (value == 11)
            name = "Jack of";
        else if (value == 12)
            name = "Queen of";
        else if (value == 13)
            name = "King of";
        else // use the numerical value
            name = value + " of";
        // Add on the suit

        if (suit == 1)
            name += " Hearts";
        else if (suit == 2)
            name += " Diamonds";
        else if (suit == 3)
            name += " Clubs";
        else
            name += " Spades";
        return name;
    }
}


public class Bankroll
{
    private int bankroll;
    public Bankroll()
{
    bankroll = 0;
}
public Bankroll (int n)
{
    bankroll = n;
}
    public int getBankroll()
    {
    return bankroll;
    }
    public void setBankroll(int n)
    {
    bankroll = n;
    }

    public void alterBankroll(int n) // n can be negative
    {
        bankroll += n;
    }

}


import java.util.Random;

public class Deck {
    private Card deck[];
    private int next; // holds position of next card to be dealt

    public Deck() {
        deck = new Card[53]; // does not use position 0, uses 1…52

        for (int rank = 1; rank <=13 ; rank++)


    { // place cards in order in deck

        deck[rank] = new Card(1, rank); // rank of first suit e.g., 3 of hearts
        deck[rank + 13] = new Card(2, rank); // rank of second suit e.g., 3 of diamonds
        deck[rank + 26] = new Card(3, rank); // rank of third suit e.g., 3 of clubs
        deck[rank + 39] = new Card(4, rank); // rank of fourth suit e.g., 3 of spades
    }

    next =1; // first card dealt is deck[next]
    }
        public void shuffle()
        {
        Random randomNumber = new Random();
        for (int card = 1; card <= 52; card++ )
        {
            // find a random place in the deck

        int rand = randomNumber.nextInt(52) + 1;

        //swap deck[card] with deck[rand]

        Card temp=deck[card];
        deck[card]=deck[rand];
        deck[rand]=temp;
        }
        next = 1; // top card of the deck
        }
        public Card deal()
        {
        if (next > 52) // if deck is depleted
        shuffle();
        Card c = deck[next];
        next++;
            return c;

        }

        }


public class Hand
{
    private static Card[] cards;
    private Deck deck;
    private int suits[];    // holds the number of each suit in a hand
    private int values[];    // holds the number of each type card (A,2,3,4,...,K)

    public Hand()
    {
        cards = new Card[5];
        suits = new int[5];     // uses indices 1..4
        values = new int[14];   // uses indices 1..13
        deck = new Deck();
    }
    public void newHand()
    {
        deck.shuffle();
        for (int i = 0; i < 5; i++)
        {
            cards[i] = deck.deal();
            suits[cards[i].getSuit()]++;
            values[cards[i].getValue()]++;
        }
        sort();
    }
    public void updateHand(boolean[] x) {
        for (int i = 0; i < 5; i++)
            if (!x[i]) {
                // remove card data for card i
                suits[cards[i].getSuit()]--;
                values[cards[i].getValue()]--;

                // get a new card
                cards[i] = deck.deal();
                // update data for card i

                suits[cards[i].getSuit()]++;
                values[cards[i].getValue()]++;
            }
        sort();
    }
        public static String[] getHand()
        {
            String[] cardsInHand = new String[5];
            for (int i = 0; i < 5; i++)
            cardsInHand[i] = cards[i].getName();
            return cardsInHand;
        }
    private void sort() // orders cards by value field; a helper function
    {
        int max; // holds the position of the highest valued card
        for (int place = 4; place > 0; place--)
        {
        max = 0;
            // find the position of the highest valued card between 0 and place
            // the position of the high card is stored in max

        for (int i = 1; i <= place; i++)

        if (cards[i].getValue() > cards[max].getValue())

        max = i;

        // swap the highest valued card with the card in position place

        Card temp =cards[place];
            cards[place] = cards[max];
            cards[max] = temp;
        }

    }
    public int evaluateHand() {

        if (royalFlush()) return 250;
        else if (straightFlush())

            return 50;
        else if (fourOfAKind())

            return 25;
        else if (fullHouse())

            return 9;
        else if (flush())

            return 6;
        else if (straight())

            return 4;
        else if (threeOfAKind())

            return 3;
        else if (twoPair())

            return 2;
        else if (pair())

            return 1;
        return -1;
    }

    private boolean royalFlush()
    {
        //10, J,Q,K,A of the same suit
        boolean sameSuit = false;   // true if all same suit
        boolean isRoyalty = false;  // true if cards are 10,J,K,Q,A
        for (int i = 1; i <= 4; i++)

            if (suits[i] == 5)   // all five cards of one suit?
                sameSuit = true;

        isRoyalty = (values[1] == 1 &&
                    values[10] == 1 &&
                    values[11] == 1 &&
                    values[12] == 1 &&
                    values[13] == 1); // one Ace && one 10 && one J &&one Q&&one K
        return (sameSuit && isRoyalty);  // true if both conditions are true
    }

    private boolean straightFlush()
    {
        boolean sameSuit = false;
        boolean ranksInOrder = false;
        for (int i = 1; i<= 4; i++)   // same suit
         if (suits[i] == 5)
             sameSuit = true;
        // cards in sequence?

        ranksInOrder =
        cards[1].getValue() == (cards[0].getValue() + 1) &&
        cards[2].getValue() == (cards[0].getValue() + 2) &&
        cards[3].getValue() == (cards[0].getValue() + 3) &&
        cards[4].getValue() == (cards[0].getValue() + 4);
        return (sameSuit && ranksInOrder);

    }

    private boolean flush()
    {

        for (int i = 1; i <= 4; i++)
            if (suits[i] == 5)  // all the same suit?
                return true;
        return false;
    }
    private boolean fourOfAKind()
    {
        for (int i = 1 ; i<= 13; i++)
            if (values[i]== 4)
                return true;
        return false;
    }

    private boolean fullHouse() {
        boolean three = false;
        boolean two = false;
        for (int i = 1; i <= 13; i++)
            if (values[i] == 3)     // three of one kind
                three = true;
            else if (values[i] == 2)        // two of another kind
                two = true;
        return two && three;    // both conditions
    }

    private boolean straight()
    {
        // cards in sequence?
        return
        // Ace precedes 2
        (cards[1].getValue() == (cards[0].getValue() + 1) &&
         cards[2].getValue() == (cards[0].getValue() + 2) &&
         cards[3].getValue() == (cards[0].getValue() + 3) &&
         cards[4].getValue() == (cards[0].getValue() + 4)) ||
        //Ace follows King
        (values[1]==1 && // Ace
        values[10]==1 && // Ten
        values[11]==1 && // Jack
        values[12]==1 && // Queen
        values[13]==1);  // King
        }

private boolean threeOfAKind()
{
    for (int i = 1 ; i <=13; i++)
        if (values[i]== 3)
            return true;
    return false;
}

private boolean twoPair() {
    int count = 0;
    for (int i = 1; i <= 13; i++)
        if (values[i] == 2) // count the number of pairs
            count++;
    return (count == 2);
}

    private boolean pair()  // Jacks or Higher
    {
        if (values[1] == 2) // pair of aces
            return true;
        for (int i=11; i<= 13;i++)    // pair of Jacks or higher
        if (values[i] == 2)
            return true;
        return false;
    }
}


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Player extends JFrame {
    private JLabel resultLabel;          // label displays the type of hand and the payout
    private JLabel[] cardLabel;          // an array of 5 labels that display card images
    private JButton[] holdButton;        // click to keep a particular card
    private JButton add1Button;          // add 1 coin
    private JButton add5Button;          // clicking adds 5 coins
    private JLabel bankrollLabel;        // label that displays the current number of coins
    private JButton quitButton;          // exit the application
    private JButton dealButton;          // click to display the updated hand
    private JButton[] betAndPlayButton;  // clicking any of these buttons makes a bet and begins play
    private Bankroll bankroll;
    private PokerGame pokerGame;
    private Bet bet;
    private Hand hand;

    public Player()     //  constructor
    {
        super(" Video Poker");
        bet = new Bet();
        bankroll = new Bankroll();
        setBounds(0, 0, 400, 500);

        // the label at the top of the frame
        resultLabel = new JLabel();
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));
        resultLabel.setText(" Video poker");

        // Display five card images; the initial image is " Back.gif," which is a dummy card
        cardLabel = new JLabel[5];
        for (int i = 0; i < 5; i++)
            cardLabel[i] = new JLabel(new ImageIcon("Cards/Back.gif"));
        // the five hold/discard buttons
        holdButton = new JButton[5];
        for (int i = 0; i < 5; i++) {
            holdButton[i] = new JButton(" " + (i + 1));     // initially display numbers 1 - 5
            holdButton[i].setFont(new Font("Arial", Font.BOLD, 18));
            holdButton[i].setEnabled(false);            // initially turned off
        }
        // the five bet and play buttons
        betAndPlayButton = new JButton[5];
        for (int i = 0; i < 5; i++) {
            betAndPlayButton[i] = new JButton(" Bet " + (i + 1));  // display Bet 1, Bet 2,…Bet 5
            betAndPlayButton[i].setEnabled(false); // initially turned off
            betAndPlayButton[i].setFont(new Font("Arial", Font.BOLD, 15));
        }
        // the deal button, initially turned off
        dealButton = (new JButton(" Deal"));
        dealButton.setFont(new Font("Arial", Font.BOLD, 18));
        dealButton.setEnabled(false);

        // the quit button
        quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Arial", Font.BOLD, 15));

        // label that displays current number of coins, the bankroll
        bankrollLabel = new JLabel();
        bankrollLabel.setFont(new Font("Arial", Font.BOLD, 24));
        bankrollLabel.setText("Coins remaining: " + 0);     // initially no coins

        // two buttons that add 1 or 5 coins to the machine
        add1Button = new JButton("Add 1");
        add5Button = new JButton("Add 5");
        add1Button.setFont(new Font("Arial", Font.BOLD, 15));
        add5Button.setFont(new Font("Arial", Font.BOLD, 15));

        // panel that holds play buttons, card labels, hold buttons, deposit buttons, deal and quit
        JPanel centerPanel = new JPanel(new GridLayout(4, 5));
        // add the five bet buttons
        for (int i = 0; i < 5; i++)
            centerPanel.add(betAndPlayButton[i]);
        // add the five labels that display the card images
        for (int i = 0; i < 5; i++)
            centerPanel.add(cardLabel[i]);
        // add the five hold buttons
        for (int i = 0; i < 5; i++)
            centerPanel.add(holdButton[i]);

        // add the two deposit buttons, a blank button, the deal and quit buttons
        centerPanel.add(add1Button);
        centerPanel.add(add5Button);
        centerPanel.add(new JButton());     // a blank button as a separator
        centerPanel.add(dealButton);
        centerPanel.add(quitButton);

        // add the label that displays the results to the NORTH section of the frame
        add(resultLabel, BorderLayout.NORTH);

        // add the label that displays the coin count to the SOUTH section of the frame
        add(bankrollLabel, BorderLayout.SOUTH);

        // add the panel with the buttons and card labels to the CENTER section of the frame
        add(centerPanel, BorderLayout.CENTER);

// register listeners, one inner class does all listening
        add1Button.addActionListener(new ButtonListener());
        add5Button.addActionListener(new ButtonListener());
        dealButton.addActionListener(new ButtonListener());
        quitButton.addActionListener(new ButtonListener());

        for (int i = 0; i < 5; i++)
            betAndPlayButton[i].addActionListener(new ButtonListener());

        for (int i = 0; i < 5; i++)
            holdButton[i].addActionListener(new ButtonListener());
        setResizable(false);
        setVisible(true);
    }

    public void displayHand(String[] hand) // displays images of five cards
    {
        String[] handString = Hand.getHand();
        for (int i = 0; i < 5; i++) {
            String name = "Cards/" + handString[i] + ".gif"; // name is a file name.
            cardLabel[i].setIcon(new ImageIcon(name));
        }
    }

    public void getDiscard(boolean[] holdCards) // maintains hold/discard information
    {
        for (int i = 0; i < 5; i++) {
            if (holdButton[i].isEnabled())      // card is discarded

                holdCards[i] = false;
            else holdCards[i] = true;       // card is retained
        }
    }

    public void displayResults(int payoff, int winnings)    // displays the final outcome on a label

    {
        String nameOfHand = " Lose";
        if (payoff == 250)
            nameOfHand = " Royal Flush";
        else if (payoff == 50)
            nameOfHand = " Straight Flush";
        else if (payoff == 25)
            nameOfHand = " Four of a Kind";
        else if (payoff == 9)
            nameOfHand = " Full House";
        else if (payoff == 6)
            nameOfHand = " Flush";
        else if (payoff == 4)
            nameOfHand = "Straight ";
        else if (payoff == 3)
            nameOfHand = " Three of a Kind";
        else if (payoff == 2)
            nameOfHand = " Two Pair";
        else if (payoff == 1)
            nameOfHand = " Pair of Jacks or Better";

        if (winnings > 0) // display outcome on resultLabel
            resultLabel.setText(" Winner: " + nameOfHand + " - pays " + winnings);
        else
            resultLabel.setText(" You lost your bet of " + bet.getBet());

        bankrollLabel.setText("Coins remaining: " + bankroll.getBankroll());
    }

    private class ButtonListener implements ActionListener // respond to button events
    {
        public void actionPerformed(ActionEvent e) {
            if ((e.getSource() == add1Button) || (e.getSource() == add5Button))    // click Add 1/ Add 5
            {
                if (e.getSource() == add1Button)
                    bankroll.alterBankroll(1);
                else
                    bankroll.alterBankroll(5);

                int br = bankroll.getBankroll();
                bankrollLabel.setText("Coins remaining: " + br);
                for (int i = 0; i < 5; i++)
                    if (br >= (i + 1))
                        betAndPlayButton[i].setEnabled(true);
                return;

            }
            if (e.getSource() == quitButton)    // click the Quit button
                System.exit(0);


            for (int i = 0; i < 5; i++)   // click one of the five bet buttons

                if (e.getSource() == betAndPlayButton[i]) {
                    bet = new Bet();
                    bet.setBet(i + 1);
                    resultLabel.setText(" Bet is " + (i + 1));
                    pokerGame = new PokerGame(bet, bankroll, Player.this);
                    pokerGame.viewInitialHand();

                    for (int j = 0; j < 5; j++) // enable the hold buttons
                    {
                        holdButton[j].setText(" " + (j + 1));
                        holdButton[j].setEnabled(true);
                    }
                    // enable and disable other buttons
                    add1Button.setEnabled(false);
                    add5Button.setEnabled(false);
                    quitButton.setEnabled(false);
                    dealButton.setEnabled(true);
                    for (int j = 0; j < 5; j++)
                        betAndPlayButton[j].setEnabled(false);
                    return;
                }

            for (int i = 0; i < 5; i++)  // respond to a Hold button event
                if (e.getSource() == holdButton[i]) {
                    holdButton[i].setText(" Hold");
                    holdButton[i].setEnabled(false);
                    return;
                }

            if (e.getSource() == dealButton)    // respond to a Deal button event
            {
                pokerGame.discardOrHoldCards();
                dealButton.setEnabled(false);
                for (int j = 0; j < 5; j++)
                    holdButton[j].setEnabled(false);

                for (int i = 0; i < 5; i++)
                    if (bankroll.getBankroll() >= (i + 1)) // enough coins ?
                        betAndPlayButton[i].setEnabled(true);

                add1Button.setEnabled(true);
                add5Button.setEnabled(true);
                quitButton.setEnabled(true);

            }

        }

    }

    public static void main(String[] args) {
        Player pm = new Player();
    }
}





public class PokerGame

{
    private Bankroll bankroll;
    private Bet bet;
    private Hand hand;
    private Player player;
    private boolean[] holdCards;

    public PokerGame(Bet coinsBet, Bankroll br, Player pl) {

        bankroll = br;
        bet = coinsBet;
        player = pl;
        hand = new Hand();
        holdCards = new boolean[5];
    }

    int updateBankroll(int payoff) {

        int winnings = payoff * (bet.getBet()); // negative for a loss
        bankroll.alterBankroll(winnings);
        return winnings;
    }

    public void viewInitialHand() {
        hand.newHand();
        player.displayHand(hand.getHand());
    }

    public void discardOrHoldCards() {

        player.getDiscard(holdCards);
        hand.updateHand(holdCards);
        player.displayHand(hand.getHand());
        int payoff = hand.evaluateHand();
        int winnings = updateBankroll(payoff);
        player.displayResults(payoff, winnings); // the hand & the number of coins won(lost)
    }
}
