import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by azburatura on 7/27/2016.
 */
public class Main {

    private static CommentWebServiceClientImpl commentWebServiceClient = new CommentWebServiceClientImpl();

    public static void main(String[] args) {
        Comment comment = new Comment("ion", "gigi@mail.net", "este un comment23", new Date());
        commentWebServiceClient.save(comment);
        commentWebServiceClient.delete(4L);
        commentWebServiceClient.update(2L);
        findAllComments();
        commentWebServiceClient.findById(1L);

    }

    public static void findAllComments() {
        List<?> commentList = null;
        Map<String, ?> mapa = (Map<String, ?>) commentWebServiceClient.findALl().get(0);
        for (Map.Entry<String, ?> entry : mapa.entrySet()) {
            Map<String, ?> mapa2 = (Map<String, ?>) entry.getValue();
            for (Map.Entry<String, ?> entry2 : mapa2.entrySet()) {
                if (entry2.getKey().equalsIgnoreCase("comment")) {
                    commentList = (ArrayList) entry2.getValue();
                }
            }
        }
        for (Object c : commentList) {
            System.out.println(c);
        }
    }

}
