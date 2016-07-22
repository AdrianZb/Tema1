package visitor;

/**
 * Created by azburatura on 7/22/2016.
 */
public class DocumentWordsVisitor implements Visitor {
    @Override
    public int visit(Document document) {
        int i = document.numberOfWords();
        System.out.println("Number of words from document is " + i);
        return i;
    }
}
