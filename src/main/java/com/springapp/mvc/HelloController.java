package com.springapp.mvc;

import com.springapp.mvc.Model.Comment;
import com.springapp.mvc.Model.Comments;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class HelloController {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ModelAndView printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        ModelAndView mov = new ModelAndView("hello");
        mov.addObject("message", "Hello World!");
        return mov;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add", headers = {"Content-type=application/json"})
    @ResponseBody
    public String addComment(@RequestBody Comment comment) {
        Comments.addComment(comment);
        return "OK";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/id={id}")
    public
    @ResponseBody
    ArrayList<Comment> getMyComments(@PathVariable String id) throws JSONException {
        return Comments.getMyComments(id.toString());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/all")
    public
    @ResponseBody
    ArrayList<Comment> getAllComments() throws JSONException {

        return Comments.getAll();
    }
}