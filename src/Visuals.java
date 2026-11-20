import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Visuals {
    private JFrame frame;
    private JPanel panel;

    private JButton showAnswerButton;
    private JButton nextCardButton;
    private JButton previousCardButton;

    private JLabel word;
    private JLabel pronunciation;
    private JLabel translation;
    private JLabel romaji;

    private final JMenuBar menuBar = new JMenuBar();
    private final JMenu fileMenu = new JMenu("File");
    private final JMenuItem aboutItem = new JMenuItem("About");
    private final JMenuItem exitItem = new JMenuItem("Exit");

    public Visuals( ) {
        createWindow();
        setVisuals();
    }

    private void createWindow() {
        frame = new JFrame("Anki!");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        panel = new JPanel(new BorderLayout(10, 20));

        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        initLabels();
        initButtons();
        initMenu();

        frame.add(panel);

        frame.setVisible(true);
    }

    private void initLabels() {
        JPanel centerPanel = new JPanel(new GridLayout(4,1,5,5));

        word = new JLabel("", SwingConstants.CENTER);
        pronunciation = new JLabel("", SwingConstants.CENTER);
        translation = new JLabel("", SwingConstants.CENTER);
        romaji = new JLabel("", SwingConstants.CENTER);

        centerPanel.add(word);
        centerPanel.add(pronunciation);
        centerPanel.add(romaji);
        centerPanel.add(translation);

        panel.add(centerPanel, BorderLayout.CENTER);
    }

    private void initButtons() {
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));

        showAnswerButton= new JButton("Show Answer");
        nextCardButton = new JButton("Next card");
        previousCardButton = new JButton("Previous card");

        bottomPanel.add(showAnswerButton);
        bottomPanel.add(nextCardButton);
        bottomPanel.add(previousCardButton);

        panel.add(bottomPanel, BorderLayout.SOUTH);
    }

    private void setVisuals() {
        word.setFont(new Font("SansSerif", Font.BOLD, 36));
        pronunciation.setFont(new Font("SansSerif", Font.PLAIN, 20));
        romaji.setFont(new Font("SansSerif", Font.PLAIN, 20));
        translation.setFont(new Font("SansSerif", Font.PLAIN, 20));
    }

    public void updateVisuals(Flashcard card) {
        word.setText(card.getWord());

        pronunciation.setText(card.getReading());

        romaji.setText(card.getRomaji());

        translation.setText("");
    }

    public void setNextAction(ActionListener action) {
        nextCardButton.addActionListener(action);
    }

    public void setPreviousAction(ActionListener action) { previousCardButton.addActionListener(action); }

    public void setShowAnswerButton(ActionListener action)  { showAnswerButton.addActionListener(action); }

    private void initMenu() {
        fileMenu.add(aboutItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
    }

    public void showInformationMessage(String message) {
        JOptionPane.showMessageDialog(
                frame,
                message,
                "Information",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public void showTranslation(String text) {
        translation.setText(text);
        showAnswerButton.setText("Hide");
    }

    public void hideTranslation() {
        translation.setText("");
        showAnswerButton.setText("Show Answer");
    }

    public JMenuItem getAboutItem() { return aboutItem; }

    public JMenuItem getExitItem() { return exitItem; }

    public JLabel getWord() {
        return word;
    }

    public JLabel getPronunciation() {
        return pronunciation;
    }

    public JLabel getTranslation() {
        return translation;
    }

    public JLabel getRomaji() {
        return romaji;
    }

    public JButton getShowAnswerButton() {
        return showAnswerButton;
    }
}
