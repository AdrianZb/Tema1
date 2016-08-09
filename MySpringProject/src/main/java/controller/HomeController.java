package controller;

import model.Document;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import repository.UserRepository;
import service.DocumentService;
import service.UserService;
import service.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by azburatura on 8/2/2016.
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private DocumentService documentService;

    @RequestMapping(method = RequestMethod.GET)
    public String showHome() {
        return "home";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String saveUser(@ModelAttribute User user){

        System.out.println(user);
        userService.saveUser(user);
        return "home";
    }


    @RequestMapping(value = "/uploadFile",method = RequestMethod.GET)
    public String showSingleFileUpload(){
        return "uploadFile";
    }

    @RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.GET)
    public String showMultipleFileUpload(){
        return "uploadMultipleFile";
    }

    @RequestMapping(value = "/documents", method = RequestMethod.GET)
    public String showAllDocuments(Model model){
        List<Document> documentList = documentService.gettAllDocuments();
        model.addAttribute("documentList", documentList);

        return "documents";
    }


}
