import java.util.List;

/**
 * Created by azburatura on 7/27/2016.
 */
public interface CommentWebServiceClient {

    Comment save(Comment comment);

    void update(Long comment);

    Comment findById(Long commentId);

    List<Comment> findALl();

    void delete(Long commentId);

}
