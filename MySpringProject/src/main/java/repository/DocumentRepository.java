package repository;

import model.Document;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by azburatura on 8/4/2016.
 */
@Repository
public class DocumentRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public void saveDocument(Document document) {
        entityManager.persist(document);
    }

    public List<Document> getAllDocuments() {
        return entityManager.createQuery("SELECT d FROM Document d").getResultList();
    }

    public Document getDocumentById(long id) {
        return entityManager.find(Document.class, id);
    }

    public boolean deleteDocument(Document document) {
        entityManager.remove(entityManager.merge(document));

        Path path = Paths.get(document.getFilePath());
        try {
            Files.delete(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
