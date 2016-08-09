package controller;

import model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.DocumentService;

/**
 * Created by azburatura on 8/9/2016.
 */
@Controller
public class FileDeleteController {

    @Autowired
    private DocumentService documentService;

    @RequestMapping(value = "/deleteDoc", method = RequestMethod.POST)
    @ResponseBody
    public String handleDelete(@RequestParam("id") long id) {

        Document document = documentService.findDocumentById(id);
        boolean bool = documentService.deleteDocument(document);

        if (bool) {
            return "Fisierul a fost sters!";
        } else {
            return "Fisierul nu s-a sters, a fost o eroare...";
        }
    }


}
