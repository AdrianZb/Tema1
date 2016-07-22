package visitor;

/**
 * Created by azburatura on 7/22/2016.
 */
public class DocumentCharVisitor implements Visitor {
    @Override
    public int visit(Document document) {
        int i = document.numberOfChars();
        System.out.println("Number of characters from document is " + i);
        return i;
    }
}
