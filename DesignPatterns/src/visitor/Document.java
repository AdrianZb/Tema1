package visitor;

/**
 * Created by azburatura on 7/22/2016.
 */
public class Document implements Element {

    private String content;

    public Document() {
    }

    public Document(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Document{" +
                "content='" + content + '\'' +
                '}';
    }

    public int numberOfChars() {
        int numberOfChar = 0;
        String charContent = content.trim();
        for (int i = 0; i < charContent.length(); i++) {
            if (charContent.charAt(i) != ' ') {
                numberOfChar++;
            }
        }
        return numberOfChar;
    }

    public int numberOfWords() {
        int numberOfWords = content.split(" ").length;

        return numberOfWords;
    }

}
