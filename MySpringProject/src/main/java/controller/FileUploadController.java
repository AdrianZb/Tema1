package controller;

import model.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import service.DocumentService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by azburatura on 8/4/2016.
 */
@Controller
public class FileUploadController {

    private static final Logger logger = LoggerFactory
            .getLogger(FileUploadController.class);

    @Autowired
    private DocumentService documentService;

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFileHandler(@RequestParam("file") MultipartFile file) {

        if (!file.isEmpty()) {
            try {
                Document document = new Document();
                byte[] bytes = file.getBytes();
                String roothPath = "D:\\uploadFiles";

                File dir = new File(roothPath /*+ File.separator + "tmpFiles"*/);

                if (!dir.exists()) {
                    dir.mkdirs();
                }

                File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                document.setDenumire(file.getOriginalFilename());
                document.setFilePath(serverFile.toString());
                documentService.saveDocument(document);

                logger.info("Server File Location="
                        + serverFile.getAbsolutePath());

                return "You successfully uploaded file=" + file.getOriginalFilename();

            } catch (Exception e) {
                return "You failed to upload " + file.getName() + " => " + e.getMessage();
            }

        } else {
            return "You failed to upload " + file.getName() + " because the file was empty.";
        }
    }

    /**
     * Upload multiple file using Spring Controller
     */
    @RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
    @ResponseBody
    public String uploadMultipleFileHandler(@RequestParam("file") MultipartFile[] files) {

        String message = "You successfully uploaded files:";

        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            Document document = new Document();
            try {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                String rootPath = "D:\\uploadFiles";
                File dir = new File(rootPath);
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath() + File.separator
                        + file.getOriginalFilename());
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                document.setDenumire(file.getOriginalFilename());
                document.setFilePath(serverFile.toString());
                documentService.saveDocument(document);

                logger.info("Server File Location="
                        + serverFile.getAbsolutePath());

                message += " " + file.getOriginalFilename() + ", ";
            } catch (Exception e) {
                return "You failed to upload " + file.getOriginalFilename() + " => " + e.getMessage();
            }
        }
        return message;
    }

}
