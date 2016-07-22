package visitor;

/**
 * Created by azburatura on 7/22/2016.
 */
public interface Element {

    int accept(Visitor visitor);

}
