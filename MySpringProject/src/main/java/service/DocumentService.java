package service;

import model.Document;

import java.util.List;

/**
 * Created by azburatura on 8/4/2016.
 */
public interface DocumentService {

    void saveDocument(Document document);

    List<Document> gettAllDocuments();

    Document findDocumentById(long id);

    boolean deleteDocument(Document document);

}
