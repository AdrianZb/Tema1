import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by azburatura on 7/27/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ComentList {

    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }
}
