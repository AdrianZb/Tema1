package service.impl;

import model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.DocumentRepository;
import service.DocumentService;

import java.util.List;

/**
 * Created by azburatura on 8/4/2016.
 */
@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Transactional
    public void saveDocument(Document document) {
        documentRepository.saveDocument(document);
    }

    @Transactional
    public List<Document> gettAllDocuments() {
        return documentRepository.getAllDocuments();
    }

    @Transactional
    public Document findDocumentById(long id) {
        return documentRepository.getDocumentById(id);
    }

    @Transactional
    public boolean deleteDocument(Document document) {
        return documentRepository.deleteDocument(document);
    }
}
