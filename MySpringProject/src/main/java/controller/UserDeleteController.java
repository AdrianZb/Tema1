package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.UserService;

/**
 * Created by azburatura on 8/3/2016.
 */
@Controller
@RequestMapping("/delete")
public class UserDeleteController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public String deleteUser(@RequestParam(value = "id") long id) {
        User user = userService.findUser(id);
        userService.deleteUser(user);

        return "home";
    }

}
