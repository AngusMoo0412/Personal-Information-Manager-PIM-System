package src.main.java.pim.Records;

public class Note extends Record {
    private String text;

    private static final long serialVersionUID = 4L;

    public Note(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Note {" +
                "'" + text + '\'' +
                '}';
    }
}
