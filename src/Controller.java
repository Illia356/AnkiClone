
public class Controller {
    private final Deck deck;
    private final Visuals visuals;

    public Controller(Deck deck, Visuals visuals) {
        this.deck = deck;
        this.visuals = visuals;
    }

    private void nextCard() {
        deck.nextCard();
        visuals.updateVisuals(deck.getCurrentIndex());
    }

    private void previousCard() {
        deck.previousCard();
        visuals.updateVisuals(deck.getCurrentIndex());
    }

    public void initialize() {
        visuals.setNextAction(e -> nextCard());
        visuals.setPreviousAction(e -> previousCard());

        visuals.getAboutItem().addActionListener(e -> visuals.showInformationMessage("Mini Anki clone! Build 20.11.2026"));
        visuals.getExitItem().addActionListener(e -> System.exit(1));
    }
}
