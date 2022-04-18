import java.util.ArrayList;

public class Cards implements Comparable<Cards> {

    // Declaring the data type here
    private Suit suit;
    private Value value;
    private int rank;
    private static ArrayList<Cards> cardsDeckOne = new ArrayList<Cards>();
    private static ArrayList<Cards> cardsDeckTwo = new ArrayList<Cards>();

    // arg constructor
    public Cards(Suit suit, Value value, int rank) {
        this.suit = suit;
        this.value = value;
        this.rank = rank;
    }

    // static method for creating stack one
    static ArrayList<Cards> createStackOne() {
        for (int i = 1; i < 15; i++) {
            switch (i) {
                case 1:
                    for (Value value : Value.values()) {
                        cardsDeckOne.add(new Cards(Suit.Hearts, value, i++));
                    }
                    i = 1;
                case 15:
                    for (Value value : Value.values()) {
                        cardsDeckOne.add(new Cards(Suit.Diamonds, value, i++));
                    }
                    i = 1;
                case 30:
                    for (Value value : Value.values()) {
                        cardsDeckOne.add(new Cards(Suit.Clubs, value, i++));
                    }
                    i = 1;
                case 45:
                    for (Value value : Value.values()) {
                        cardsDeckOne.add(new Cards(Suit.Spades, value, i++));
                    }
                    i = 1;

            }

        }
        return cardsDeckOne;

    }

    // stacic method for Creating stack two
    static ArrayList<Cards> createStackTwo() {
        for (int i = 1; i < 15; i++) {
            switch (i) {
                case 1:
                    for (Value value : Value.values()) {
                        cardsDeckTwo.add(new Cards(Suit.Hearts, value, i++));
                    }
                    i = 1;
                case 15:
                    for (Value value : Value.values()) {
                        cardsDeckTwo.add(new Cards(Suit.Diamonds, value, i++));
                    }
                    i = 1;
                case 30:
                    for (Value value : Value.values()) {
                        cardsDeckTwo.add(new Cards(Suit.Clubs, value, i++));
                    }
                    i = 1;
                case 45:
                    for (Value value : Value.values()) {
                        cardsDeckTwo.add(new Cards(Suit.Spades, value, i++));
                    }
                    i = 1;

            }

        }
        return cardsDeckTwo;

    }

    // overriding the to string method here
    @Override
    public String toString() {
        return "Cards{" +
                "suit=" + suit +
                ", value=" + value +
                ", rank=" + rank +
                '}';
    }

    // Overriding the compare to method here
    @Override
    public int compareTo(Cards opponentCardRank) {
        if (this.rank > opponentCardRank.rank) {
            return -1;
        }
        if (this.rank < opponentCardRank.rank) {
            return 1;
        } else {
            return 0;
        }
    }
}
