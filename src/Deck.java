import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Flashcard> cards = new ArrayList<>();
    private int currentIndex = 0;

    public Deck() {

    }

    public void add(Flashcard card) {
        cards.add(card);
    }

    public Flashcard getCurrentIndex() {
        return cards.get(currentIndex);
    }

    public void nextCard() {
        if(cards.isEmpty()) {
            return;
        }

        currentIndex++;
        if (currentIndex >= cards.size()) {
            currentIndex = 0;
        }
    }

    public void previousCard() {
        if(cards.isEmpty()) {
            return;
        }
        currentIndex--;

        if (currentIndex < 0) {
            currentIndex = cards.size() - 1;
        }
    }

}
