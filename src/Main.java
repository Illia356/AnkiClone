import java.util.ArrayList;
import java.util.List;

public class Main {

    static Visuals visuals = new Visuals();
    static Deck deck = new Deck();
    static Controller controller = new Controller(deck, visuals);

    public static void main(String[] args) {

        Flashcard card = new Flashcard("食べる", "たべる", "taberu", "to eat");
        Flashcard cardTwo = new Flashcard("PLACEHOLDER", "NULL", "NULL", "NULL");
        Flashcard cardThree = new Flashcard("PLACEHOLDER2", "NULL", "NULL", "NULL");

        deck.add(card);
        deck.add(cardTwo);
        deck.add(cardThree);

        visuals.updateVisuals(deck.getCurrentIndex());

        visuals.getShowAnswerButton().addActionListener(e -> {
            if (visuals.getTranslation().getText().isEmpty()) {
                visuals.getTranslation().setText(deck.getCurrentIndex().getTranslation());
                visuals.getShowAnswerButton().setText("Hide");
                visuals.getShowAnswerButton().setEnabled(true);
            } else {
                visuals.getTranslation().setText("");
                visuals.getShowAnswerButton().setText("Show Answer");
            }
        });
        controller.initialize();
    }
}