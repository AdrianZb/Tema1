import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

/**
 * Created by azburatura on 7/27/2016.
 */
public class CommentWebServiceClientImpl implements CommentWebServiceClient {

    URL url;
    HttpURLConnection conn;
    ObjectMapper mapper = new ObjectMapper();

    public Comment save(Comment comment) {
        try {
            url = new URL("http://localhost:8080/restful/comment");
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            String jsonString = mapper.writeValueAsString(comment);
            OutputStream os = conn.getOutputStream();
            os.write(jsonString.getBytes());

            if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                throw new RuntimeException("Failed: HTTP error code: " + conn.getResponseCode());
            }

            conn.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return comment;
    }

    public void update(Long commentId) {
        try {
            url = new URL("http://localhost:8080/restful/comment/" + commentId);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            Comment comment = mapper.readValue(url, Comment.class);
            comment.setName("maria");
            String jsonString = mapper.writeValueAsString(comment);
            OutputStream os = conn.getOutputStream();
            os.write(jsonString.getBytes());

            conn.getResponseCode();

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        conn.disconnect();

    }

    public Comment findById(Long commentId) {
        Comment comment = null;
        try {
            url = new URL("http://localhost:8080/restful/comment/" + commentId);

            comment = mapper.readValue(url, Comment.class);

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return comment;
    }

    public List<Comment> findALl() {
        List<Comment> comments = null;
        try {
            url = new URL("http://localhost:8080/restful/comment/");
            mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            comments = mapper.readValue(url, mapper.getTypeFactory().constructType(List.class, Comment.class));

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return comments;
    }

    public void delete(Long commentId) {
        try {
            url = new URL("http://localhost:8080/restful/comment/" + commentId);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("DELETE");
            conn.getResponseCode();

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
