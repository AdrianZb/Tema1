package controller;

import model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.DocumentService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by azburatura on 8/5/2016.
 */
@Controller
@RequestMapping("/download")
public class FileDownloadController {

    @Autowired
    ServletContext servletContext;

    @Autowired
    private DocumentService documentService;

    @RequestMapping(method = RequestMethod.GET)
    public void downloadDocument(HttpServletResponse response, @RequestParam("docId") long id) {

        Document document = documentService.findDocumentById(id);
        String filePath = document.getFilePath();

        File downloadFile = new File(filePath);
        try (FileInputStream inStream = new FileInputStream(downloadFile)) {

            String mimeType = servletContext.getMimeType(filePath);

            if (mimeType == null) {
                mimeType = "application/octet-stream";
            }

            response.setContentType(mimeType);
            response.setContentLength((int) downloadFile.length());

            String headerKey = "Content-Dispossition";
            String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
            response.setHeader(headerKey, headerValue);

            try (OutputStream outputStream = response.getOutputStream()) {
                byte[] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = inStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
