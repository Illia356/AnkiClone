public class Flashcard {
    private String word;
    private String reading;
    private String romaji;
    private String translation;

    public Flashcard(
            String word,
            String reading,
            String romaji,
            String translation
    ) {
        this.word = word;
        this.reading = reading;
        this.romaji = romaji;
        this.translation = translation;
    }

    public String getWord() {
        return word;
    }

    public String getReading() {
        return reading;
    }

    public String getRomaji() {
        return romaji;
    }

    public String getTranslation() {
        return translation;
    }

    private void setWord(String word) {
        this.word = word;
    }

    private void setReading(String reading) {
        this.reading = reading;
    }

    private void setRomaji(String romaji) {
        this.romaji = romaji;
    }

    private void setTranslation(String translation) {
        this.translation = translation;
    }
}
